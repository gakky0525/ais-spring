package ais.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.entity.DepartmentMst;
import ais.entity.DoctorMst;
import ais.entity.KarteLib;
import ais.form.KarteForm;
import ais.repository.DepartmentMstRepository;
import ais.repository.DoctorMstRepository;
import ais.repository.KarteLibRepository;

/**
 * カルテ登録コントローラ
 *
 * カルテの登録／更新／削除を行う画面のコントローラクラスです。
 *
 * @author 長岐由岐
 *
 */
@Controller
@RequestMapping("karte")
public class KarteController {

	@Autowired
	KarteLibRepository karteLibRepository;

	@Autowired
	DepartmentMstRepository departmentMstRepository;

	@Autowired
	DoctorMstRepository doctorMstRepository;

	@ModelAttribute
	KarteForm setUpForm() {
		return new KarteForm();
	}

	/**
	 * 初期表示メソッド
	 * @param model 画面とデータをやり取りするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@GetMapping
	public String index(Model model) {
		// 診療科のプルダウンを表示するためにデータ取得
		model.addAttribute("departmentMstList", getDepartmentMstList());

		return "karte/index";
	}

	/**
	 * ID指定の初期表示メソッド
	 * @param karteLibId カルテ貸出ID
	 * @param form 画面入力を受け付けるフォームオブジェクト
	 * @param model 画面とデータをやり取りするためのオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@GetMapping("{karteLibId}")
	public String indexById(@PathVariable Integer karteLibId, KarteForm form, Model model) {
		KarteLib karteLib = karteLibRepository.findOne(karteLibId);

		if(karteLib != null) {
			form.setKarteLibId(karteLib.getKarteLibId());
			form.setPatientName(karteLib.getPatientName());
		}

		// 診療科のプルダウンを表示するためにデータ取得
		model.addAttribute("departmentMstList", getDepartmentMstList());

		return "karte/index";
	}

	/**
	 * カルテを登録します。
	 * @param form 画面入力を受け付けるフォームオブジェクト
	 * @param bindingResult バリデーション結果を受け取るオブジェクト
	 * @return 遷移先画面のテンプレートパス
	 */
	@PostMapping("registKarte")
	public String registKarte(KarteForm form, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "karte/index";
		}

		// ①エンティティの作成
		KarteLib karteLib = new KarteLib();

		// ②エンティティにデータを詰め込む
		karteLib.setPatientId(form.getPatientId());
		karteLib.setPatientName(form.getPatientName());
		karteLib.setKarteLibId(form.getKarteLibId());
		karteLib.setPatientKana(form.getPatientKana());
		karteLib.setBirthDate(Date.valueOf(form.getBirthDate()));
		karteLib.setSex(form.getSex());
		karteLib.setAge(form.getAge());
		karteLib.setAbo(form.getAbo());
		karteLib.setAddr(form.getAddr());
		karteLib.setTel(form.getTel());

	// 入院日// 貸出日// 返却日// 貸出状況

		//karteLib.setDepartment("診療科");
		karteLib.setStatus("0");

		// 診療科マスタと紐づけます
		DepartmentMst departmentMst = new DepartmentMst();
		departmentMst.setDepartmentMstId(form.getDepartmentMstId());
		karteLib.setDepartmentMst(departmentMst);

		// 退院科マスタと紐づけます
		DepartmentMst leaveDepartmentMst = new DepartmentMst();
		leaveDepartmentMst.setDepartmentMstId(form.getLeaveDepartmentMstId());
		karteLib.setLeaveDepartmentMst(leaveDepartmentMst);

		//主治医マスタと紐づけます??



		// ③Respository.saveでエンティティをデータベースに登録
		karteLibRepository.save(karteLib);

		// 診療科のプルダウンを表示するためにデータ取得
		model.addAttribute("departmentMstList", getDepartmentMstList());

		return "karte/index";
	}



	private List<DepartmentMst> getDepartmentMstList() {
		return departmentMstRepository.findAll();
	}

	private List<DoctorMst> getDoctorMstList() {
		return doctorMstRepository.findAll();
	}
}
