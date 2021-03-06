package ais.form;

import java.time.LocalDate;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class KasidasiForm {
	@Digits(fraction = 10, integer = 10 )
	// カルテ貸出ID
	public Integer karteLibId;
	@Digits(fraction = 10, integer = 10 )
	// 患者ID
	public Integer patientId;
	@NotEmpty
	// 患者名
	public String patientName;
	@NotEmpty
	// 患者カナ
	public String patientKana;
	@DateTimeFormat(pattern="yyyy-MM-dd")//誕生日から年齢を計算できるようにならないか…??
	// 患者誕生日
	private LocalDate birthDate;
	@Digits(fraction = 2, integer = 1 )
	// 患者年齢
	public Integer age;
	@NotEmpty
	// 患者性別　
	public String sex;//@NotEmpty又は@Pattern(regex="regexp", flag=)
	@NotEmpty
	// 患者住所
	private String addr;
	@Digits(fraction = 10, integer = 10 )
	// 患者電話番号
	private String tel;
}
