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

import ais.entity.BuildingMst;
import ais.entity.DepartmentMst;
import ais.entity.DoctorMst;
import ais.entity.KarteLib;
import ais.form.KarteForm;
import ais.repository.BuildingMstRepository;
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

	@Autowired
	BuildingMstRepository buildingMstRepository;

	@Autowired
	BuildingMstRepository buildingMstRepository1;

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
		model.addAttribute("doctorMstList", getDoctorMstList());
		model.addAttribute("buildingMstList", getBuildingMstList());
		//model.addAttribute("leavebuildingMstList", getBuildingMstList());
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
			form.setPatientKana(karteLib.getPatientKana());
			form.setBirthDate(karteLib.getBirthDate().toLocalDate());
			form.setAge(karteLib.getAge());
			form.setAbo(karteLib.getAbo());
			form.setSex(karteLib.getSex());
			form.setAddr(karteLib.getAddr());
			form.setTel(karteLib.getTel());
			form.setDepartmentMstList(karteLib.getDepartmentMstList());
		}

		// 診療科のプルダウンを表示するためにデータ取得
		model.addAttribute("departmentMstList", getDepartmentMstList());
		model.addAttribute("doctorMstList", getDoctorMstList());
		model.addAttribute("buildingMstList", getBuildingMstList());

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
		karteLib.setEntryDate(Date.valueOf(form.getEntryDate()));
		karteLib.setLeaveDate(Date.valueOf(form.getLeaveDate()));
		karteLib.setDieDate(Date.valueOf(form.getDieDate()));
	// 貸出日// 返却日// 貸出状況

		//karteLib.setDepartment("診療科");
		karteLib.setStatus("0");

		// 診療科マスタと紐づけます
		DepartmentMst departmentMst = new DepartmentMst();
		departmentMst.setDepartmentMstId(form.getDepartmentMstId());
		karteLib.setDepartmentMst(departmentMst);

		// 退院科マスタと紐づけます
/*		DepartmentMst leaveDepartmentMst = new DepartmentMst();
		leaveDepartmentMst.setDepartmentMstId(form.getLeaveDepartmentMstId());
		karteLib.setLeaveDepartmentMst(leaveDepartmentMst);
*/
		//主治医マスタと紐づけます
		DoctorMst familyDoctorMst = new DoctorMst();
		familyDoctorMst.setDoctorMstId(form.getFamilyDoctorMstId());
		karteLib.setDoctorMst1(familyDoctorMst);

		//担当医１マスタと紐づけます
		DoctorMst doctorMst1 = new DoctorMst();
		doctorMst1.setDoctorMstId(form.getDoctorMstId1());
		karteLib.setDoctorMst1(doctorMst1);

		//担当医２マスタと紐づけます
		DoctorMst doctorMst2 = new DoctorMst();
		doctorMst2.setDoctorMstId(form.getDoctorMstId2());
		karteLib.setDoctorMst2(doctorMst2);

		//入院病棟マスタと紐づけます
		BuildingMst buildingMst = new BuildingMst();
		buildingMst.setBuildingMstId(form.getBuildingMstId());
		karteLib.setBuildingMst(buildingMst);

		//退院時病棟マスタと紐づけます
		BuildingMst leavebuildingMst = new BuildingMst();
		leavebuildingMst.setBuildingMstId(form.getLeavebuildingMstId());
		karteLib.setLeaveBuildingMst(leavebuildingMst);
										//leavebuildingMstをsetBuildingMstにセットしてkarteLibに渡している??

/*class KarteLib {
		 private BuildingMsg buildingMst;
		 ・・・
		 public void setBuildingMst(BuildingMst buildingMsg) {
		  this.buildingMst = buildingMst;

*/


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

	private List<BuildingMst> getBuildingMstList() {
		return buildingMstRepository.findAll();
	}


}
