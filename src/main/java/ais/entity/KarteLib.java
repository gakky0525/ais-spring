package ais.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * カルテ貸出エンティティ
 *
 * データベースからデータを取り出す際に利用する入れ物クラスです。
 * 1データ分のデータを表現します。
 *
 * @author fhideaki
 *
 */
@Entity
@Table(name = "KARTE_LIB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KarteLib {

	// ---------------------------------
	// 以下はカルテを表すプロパティ

	// カルテ貸出ID
	@Id
	@GeneratedValue
	private Integer karteLibId;
	// 患者ID
	@Column
	private Integer patientId;
	// 患者名
	@Column
	private String patientName;
	// 患者カナ
	@Column
	private String patientKana;
	// 患者誕生日
	@Column
	private Date birthDate;
	// 患者年齢
	@Column
	private Integer age;
	// 患者性別
	@Column
	private String sex;
	// 患者血液型
	@Column
	private String abo;
	// 患者住所
	@Column
	private String addr;
	// 患者電話番号
	@Column
	private String tel;
	// 入院日
	@Column
	private Date entryDate;
	// 退院日
	@Column
	private Date leaveDate;
	// 死亡日
	@Column
	private Date dieDate;
	// 主治医 FIXME これは恐らく病院外のお医者さんの名前では？
	@Column
	private String familyDoctor;
	// 入院病棟
	@ManyToOne
	@JoinColumn(name="building_mst_id")
	private BuildingMst buildingMst;
	// 退院時病棟
	@ManyToOne
	@JoinColumn(name="leave_building_mst_id")
	private BuildingMst leaveBuildingMst;
	// 担当医1
	@ManyToOne
	@JoinColumn(name="doctor_mst_id1")
	private DoctorMst doctorMst1;
	// 担当医2
	@ManyToOne
	@JoinColumn(name="doctor_mst_id2")
	private DoctorMst doctorMst2;
	// 解剖フラグ
	@Column
	private String dissectionFlg;
	// 紹介状フラグ
	@Column
	private String letterFlg;
	// 救急車利用フラグ
	@Column
	private String ambulanceFlg;
	// 転帰
	private String outcome;



	// ---------------------------------
	// 以下はカルテ貸出状況を表すプロパティ

	// 貸出日
	@Column
	private Date takeDate;
	// 返却日
	@Column
	private Date returnDate;
	// 貸出状況
	@Column
	private String status;

	@ManyToOne
	@JoinColumn(name="department_mst_id")
	private DepartmentMst departmentMst;

	@ManyToOne
	@JoinColumn(name="leave_department_mst_id")
	private DepartmentMst leaveDepartmentMst;

	@ManyToOne
	@JoinColumn(name="take_to_mst_id")
	private TakeToMst takeToMst;
}