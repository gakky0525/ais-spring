package ais.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.entity.KarteLib;
import ais.form.KasidasiForm;
import ais.repository.KarteLibRepository;

@Controller
@RequestMapping("kasidasi")
public class KarteKasidasiController {

	@ModelAttribute
	KasidasiForm setUpForm() {
		return new KasidasiForm();
	}

	@Autowired
	KarteLibRepository karteLibRepository;

	@GetMapping
	public String index(Model model) {
		List<KarteLib> karteLibList = karteLibRepository.findAll();
		model.addAttribute("dataList", karteLibList);

		return "kasidasi/index";
	}

	@PostMapping("search")
	public String karteSearch(KasidasiForm form, Model model) {
		KarteLib karteLib = new KarteLib();
		karteLib.setKarteLibId(form.getKarteLibId());
		karteLib.setPatientId(form.getPatientId());
		karteLib.setPatientName(form.getPatientName());
		karteLib.setPatientKana(form.getPatientKana());
	//	karteLib.setBirthDate(form.getBirthDate());
		karteLib.setAge(form.getAge());
		karteLib.setSex(form.getSex());

		List<KarteLib> karteLibList =
				karteLibRepository.findKarteLib(karteLib);
		model.addAttribute("dataList", karteLibList);

		return "kasidasi/index";
	}

}
