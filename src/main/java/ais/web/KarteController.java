package ais.web;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.entity.KarteLib;
import ais.form.KarteForm;
import ais.repository.KarteLibRepository;

@Controller
@RequestMapping("karte")

public class KarteController {
	@Autowired
	KarteLibRepository karteLibRepository;

	@ModelAttribute
	KarteForm setUpForm() {
		return new KarteForm();
	}

	@GetMapping
	public String index(Model model) {

		return "karte/index";
	}

	@GetMapping("{karteLibId}")
	public String karte(@PathVariable Integer karteLibId, KarteForm form, Model model) {
		KarteLib karteLib = karteLibRepository.findOne(karteLibId);

		if(karteLib != null) {
			form.setKarteLibId(karteLib.getKarteLibId());
			form.setPatientName(karteLib.getPatientName());
		//	karteLibRepository.save(karteLib);
		}

		return "karte/index";
	}

	@PostMapping("registKarte")
	public String registKarte(KarteForm form, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			return "karte/index";
		}

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
		karteLib.setKarteLibId(form.getKarteLibId());
		karteLib.setPatientKana(form.getPatientKana());
		karteLib.setBirthDate(Date.valueOf(form.getBirthDate()));
		karteLib.setSex(form.getSex());
		karteLib.setAge(form.getAge());
		karteLib.setAbo(form.getAbo());
	    //住所
		//電話番号


		// サンプルなのでダミーの値を設定しちゃいましょう
		//karteLib.setPatientKana("えーさん");
		//karteLib.setBirthDate(Date.valueOf(LocalDate.now()));
		//karteLib.setAge(1);
		//karteLib.setSex("男");
		karteLib.setDepartment("診療科");
		karteLib.setStatus("0");

		// ③Respository.saveでエンティティをデータベースに登録
		karteLibRepository.save(karteLib);

		return "karte/index";
	}
}
