package ais.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class KarteForm {
	@NotNull
	private String patientName;

	private Integer patientId;

	private Integer karteLibId;

	private String patientKana;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;

	private String sex;

	private Integer Age;

	//血液型
    //住所
	//電話番号
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