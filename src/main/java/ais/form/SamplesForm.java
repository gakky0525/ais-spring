package ais.form;

import lombok.Data;

/**
 * サンプルのカルテ一覧画面用の入力フォームクラス
 *
 * 画面入力した値を受け取るためのクラスです
 *
 * @author fhideaki
 *
 */
@Data
public class SamplesForm {

	// カルテ貸出ID
	private Integer karteLibId;
	// 患者名
	private String patientName;
}