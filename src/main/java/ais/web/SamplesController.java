package ais.web;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.entity.KarteLib;
import ais.form.SamplesForm;
import ais.repository.KarteLibRepository;

/**
 * データベースアクセスのサンプルコントローラ
 *
 * @author fhideaki
 *
 */
@Controller
@RequestMapping("samples")
public class SamplesController {

	@Autowired
	KarteLibRepository karteLibRepository;

	@ModelAttribute
	SamplesForm setUpForm() {
		return new SamplesForm();
	}

	/**
	 * samples/karteList でアクセスされるURLを処理するメソッド
	 * @param model 画面とデータを受け渡しするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@GetMapping("karteList")
	public String karteListIndex(SamplesForm form, Model model) {
		List<KarteLib> karteLibList = karteLibRepository.findAll();
		model.addAttribute("dataList", karteLibList);

		// 新規登録用にデータベースに登録されている患者IDの最大値を取得して次の患者IDを自動生成する
		KarteLib karteLib = karteLibRepository.findTopByOrderByPatientIdDesc();
		if(karteLib != null) {
			form.setPatientId(karteLib.getPatientId() + 1);
		}
		return "samples/karteList";
	}

		// 新規登録用にデータベースに登録されているカルテ貸出IDの最大値を取得して次の患者IDを自動生成する
		//KarteLib karteLib = karteLibRepository.findTopByOrderByKarteLibIdDesc();
		//if(karteLib != null) {
		//	form.setKarteLibId(karteLib.getKarteLibId() + 1);
	 	//}　同じように、自動生成したい…


	/**
	 * カルテ検索メソッド
	 * @param form 入力情報を受け取るフォームクラス
	 * @param model 画面とデータを受け渡しするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@PostMapping("searchKarte")
	public String searchKarte(SamplesForm form, Model model) {
		List<KarteLib> karteLibList =
			karteLibRepository.findKarteLibByKarteLibIdAndPatientName(form.getKarteLibId(), form.getPatientName());
		model.addAttribute("dataList", karteLibList);

		return "samples/karteList";
	}

	@GetMapping("karte/{karteLibId}")
	public String karte(@PathVariable Integer karteLibId, SamplesForm form, Model model) {
		KarteLib karteLib = karteLibRepository.findOne(karteLibId);

		if(karteLib != null) {
			form.setKarteLibId(karteLib.getKarteLibId());
			form.setPatientName(karteLib.getPatientName());
			karteLibRepository.save(karteLib);
		}

		return "samples/karte";
	}

	@PostMapping("updateKarte")
	public String updateKarte(SamplesForm form, Model model) {
		KarteLib karteLib = karteLibRepository.findOne(form.getKarteLibId());

		if(karteLib != null) {
			karteLib.setPatientName(form.getPatientName());

			// 画面再表示用に再度フォームに設定
			form.setKarteLibId(karteLib.getKarteLibId());
			form.setPatientName(karteLib.getPatientName());
		}

		return "samples/karte";
	}



	/**
	 * カルテカスタム検索メソッド
	 * @param form 入力情報を受け取るフォームクラス
	 * @param model 画面とデータを受け渡しするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@PostMapping("searchKarteCustom")
	public String searchKarteCustom(SamplesForm form, Model model) {

		KarteLib karteLib = new KarteLib();
		karteLib.setKarteLibId(form.getKarteLibId());
		karteLib.setPatientName(form.getPatientName());

		if(form.getBirthDate() != null) {
			// 日付型をデータベースで扱える特殊な日付型に変換します
			karteLib.setBirthDate(Date.valueOf(form.getBirthDate()));
		}

		karteLib.setSex(form.getSex());

		List<KarteLib> karteLibList =
				karteLibRepository.findKarteLib(karteLib);
		model.addAttribute("dataList", karteLibList);

		return "samples/karteList";
	}

	/**
	 * カルテの登録処理です
	 * @param form 入力情報を受け取るフォームクラス
	 * @param model 画面とデータを受け渡しするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@PostMapping("registKarte")
	public String registKarte(SamplesForm form, Model model) {

		/*
		 * ①エンティティの作成
		 * ②エンティティにデータを詰め込む
		 * ③Respository.saveでエンティティをデータベースに登録
		 */

		// ①エンティティの作成
		KarteLib karteLib = new KarteLib();

		// ②エンティティにデータを詰め込む
		karteLib.setPatientId(form.getPatientId());
		karteLib.setPatientName(form.getPatientName());
		karteLib.setPatientKana(form.getPatientKana());
		// サンプルなのでダミーの値を設定しちゃいましょう
		//karteLib.setPatientKana("えーさん");
		karteLib.setBirthDate(Date.valueOf(LocalDate.now()));
		karteLib.setAge(1);
		karteLib.setSex("男");
		karteLib.setDepartment("診療科");
		karteLib.setStatus("0");

		// ③Respository.saveでエンティティをデータベースに登録
		karteLibRepository.save(karteLib);

		return "samples/karteList";
	}
}