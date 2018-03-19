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
@Table(name = "TAKE_TO_MST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakeToMst {
	// 貸出先マスタID
	@Id
	@GeneratedValue
	private Integer takeToMstId;

	// 名前
	@Column
	private String name;

	@OneToMany(mappedBy = "takeToMst")
	private List<KarteLib> karteLibs;
}