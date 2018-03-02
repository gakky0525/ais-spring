package ais.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class KarteForm {
	@NotNull
	private String patientName;
	private Integer patientId;
}
