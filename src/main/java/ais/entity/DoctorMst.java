package ais.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DOCTOR_MST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorMst {
	// 担当医マスタID
	@Id
	@GeneratedValue
	private Integer doctorMstId;

	// 名前
	@Column
	private String name;

	@OneToMany(mappedBy = "doctorMst1")
	private List<KarteLib> karteLibs1;

	@OneToMany(mappedBy = "doctorMst2")
	private List<KarteLib> karteLibs2;
}