package ais.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.dto.KarteKasidasiDto;
import ais.util.CsvUtil;

@Controller
@RequestMapping("kasidasi")
public class KarteKasidasiController {

	@GetMapping
	public String index(Model model) {
		List<KarteKasidasiDto>dataList = CsvUtil.importKasidasiCSV("F:\\work\\dev\\workspaces\\samurai_samples\\ais-spring\\src\\main\\resources\\data\\kasidasi.csv");
		model.addAttribute("datalList",dataList);
		return "kasidasi/index" ;
	}

	@GetMapping(path="search")
	public String search(Model model) {
		return "";
	}
}
