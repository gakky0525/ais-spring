package ais.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
	// 患者ID
	private Integer patientId;
	// 患者名
	private String patientName;
	// 患者誕生日
	// DateTimeFormatアノテーションを使ってJavaで日付を表現するオブジェクトに変換します
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;
	// 患者性別
	private String sex;
	// 血液型
	private String abo;
	//フリガナ
	private String patientKana;
}