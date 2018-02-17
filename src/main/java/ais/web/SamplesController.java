package ais.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ais.entity.KarteLib;
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

}