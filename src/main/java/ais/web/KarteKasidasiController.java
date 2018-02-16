package ais.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.dto.KarteKasidasiDto;
import ais.form.KasidasiForm;
import ais.util.CsvUtil;

@Controller
@RequestMapping("kasidasi")
public class KarteKasidasiController {

	@GetMapping
	public String index(Model model) {
		List<KarteKasidasiDto>dataList = CsvUtil.importKasidasiCSV("C:\\Users\\yuki\\Desktop\\Java関係\\pleiades\\workspace\\ais2\\data\\kasidasi.csv");
		model.addAttribute("dataList",dataList);
		return "kasidasi/index" ;
	}

	@GetMapping(path="search")
	public String search(Model model) {
		return "kasidasi/search";
	}

	@ModelAttribute
	KasidasiForm setform() {
		return new KasidasiForm();
	}
}
