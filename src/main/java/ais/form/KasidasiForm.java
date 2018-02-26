package ais.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class KasidasiForm {
	@NotNull
	public Integer karteLibId;
	public Integer patientId;
	public String patientName;
	public String patientKana;
	//public birthDate birthDate;
	public Integer age;
	public String sex;
}
