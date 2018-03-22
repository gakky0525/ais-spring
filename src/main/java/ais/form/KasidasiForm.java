package ais.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class KasidasiForm {
	@NotNull
	public Integer karteLibId;
	public Integer patientId;
	public String patientName;
	public String patientKana;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;
	public Integer age;
	public String sex;
	private String addr;
	private String tel;
}
