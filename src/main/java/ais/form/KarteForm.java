package ais.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class KarteForm {
	@NotNull
	// 患者名
	private String patientName;
	@NotNull
	// 患者ID
	private Integer patientId;
	@NotNull
	// カルテ貸出ID
	private Integer karteLibId;
	@NotEmpty
	// 患者カナ
	private String patientKana;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	// 患者誕生日
	private LocalDate birthDate;
	@NotEmpty
	// 患者性別　
	private String sex;//@NotEmpty又は@Pattern(regex="regexp", flag=)??
	@NotNull
	// 患者年齢
	private Integer Age;
	@NotEmpty
	// 患者血液型
	private String abo;
	@NotEmpty
	// 患者住所
	private String addr;
	@NotNull
	// 患者電話番号
	private String tel;


	// 診療科マスタID
	private Integer departmentMstId;

	// 退院科マスタID
	private Integer leaveDepartmentMstId;

	//主治医マスタID
	private Integer DoctorMstId;

	// 入院日// 退院日// 貸出日// 返却日// 貸出状況
}


/*★データ登録処理の実装
★①画面入力を受け取るフォームクラスを作る
★②コントローラとフォームをひもづける
★　これも検索と同じです　KarteControllerにsetUpFormメソッドを作りました
★③テンプレートとフォームを紐づける
★　テンプレートの各入力フィールドをフォームのプロパティに紐づけました
★④テンプレートとコントローラを紐づける
★　テンプレートのformタグのaction属性で　どのコントローラの　どのメソッド　を呼ぶのか？を指定するのですね
------------------------------------
<form action="/samples/registKarte" method="post" th:object="${samplesForm}"> <!-- ここで④テンプレートとコントローラを紐づける -->
・・・
		<input id="patientName" type="text" th:field="*{patientName}" /> <!-- ここで③テンプレートとフォームを紐づける -->
・・・
------------------------------------
★⑤リポジトリのsaveメソッドで登録
★　エンティティに画面入力値を設定してsaveメソッドに渡すと登録完了ですね
★*/