package ais.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.entity.KarteLib;
import ais.repository.KarteLibRepository;

@Controller
@RequestMapping("samples/karteList")
public class KarteKasidasiController {

	/*@GetMapping
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
	*/
	@Autowired
	KarteLibRepository karteLibRepository; //(3)作成済みのリポジトリをDIする

	@GetMapping("karteList")
	public String karteList(Model model) {
		List<KarteLib> karteLibList = karteLibRepository.findAll();
		model.addAttribute("dataList", karteLibList);

		return "samples/karteList";
	}

	@GetMapping(path = "{karteLibId}")
	KarteLib getkarteLibList(@PathVariable Integer karteLibId) {
		KarteLib karteLibList = karteLibRepository.findOne(karteLibId);

		return karteLibList;
	}
}
