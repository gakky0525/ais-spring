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
@Table(name = "BUILDING_MST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingMst {
	// 病棟マスタID
	@Id
	@GeneratedValue
	private Integer buildingMstId;

	// 名前
	@Column
	private String name;

	@OneToMany(mappedBy = "buildingMst")
	private List<KarteLib> karteLibs;

}