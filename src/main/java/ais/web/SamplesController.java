package ais.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String karteList(Model model) {
		List<KarteLib> karteLibList = karteLibRepository.findAll();
		model.addAttribute("dataList", karteLibList);

		return "samples/karteList";
	}

	/**
	 * カルテ検索メソッド
	 * @param form 入力情報を受け取るフォームクラス
	 * @param model 画面とデータを受け渡しするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@PostMapping("karteSearch")
	public String karteSearch(SamplesForm form, Model model) {
		List<KarteLib> karteLibList =
			karteLibRepository.findKarteLibByKarteLibIdAndPatientName(form.getKarteLibId(), form.getPatientName());
		model.addAttribute("dataList", karteLibList);

		return "samples/karteList";
	}



	/**
	 * カルテカスタム検索メソッド
	 * @param form 入力情報を受け取るフォームクラス
	 * @param model 画面とデータを受け渡しするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@PostMapping("karteSearchCustom")
	public String karteSearchCustom(SamplesForm form, Model model) {

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

}