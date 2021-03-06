package ais.form;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
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
	@Digits(fraction = 10, integer = 10)
	// 患者ID
	private Integer patientId;
	@Digits(fraction = 10, integer = 10)
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
	private String sex;
	@Digits(fraction = 2, integer = 2)
	// 患者年齢
	private Integer age;
	@NotEmpty
	// 患者血液型
	private String abo;
	@NotEmpty
	// 患者住所
	private String addr;
	@Digits(fraction = 2, integer = 1 )
	// 患者電話番号
	private String tel;


	// 診療科マスタID
	private Integer departmentMstId;

	// 退院科マスタID
	private Integer leaveDepartmentMstId;

	//主治医マスタID
	private Integer familyDoctorMstId;

	//担当医１ID
	private Integer doctorMstId1;

	//担当医１ID
	private Integer doctorMstId2;

	//入院病棟
	private Integer buildingMstId;

	//退院時病棟
	private Integer leavebuildingMstId;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	// 入院日
	private LocalDate entryDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	// 退院日
	private LocalDate leaveDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	//死亡日
	private LocalDate dieDate;

	// 救急車利用
	private String ambulanceFlg;

	//転帰
	private String outcome;

	//紹介状フラグ
	private String letterFlg;

	// 解剖フラグ
	private String dissectionFlg;
}

// 貸出日// 返却日// 貸出状況
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