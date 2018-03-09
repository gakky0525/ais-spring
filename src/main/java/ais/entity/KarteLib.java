package ais.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	// 診療科
	@Column
	private String department;
	// 貸出日
	@Column
	private Date takeDate;
	// 返却日
	@Column
	private Date returnDate;
	// 貸出先
	@Column
	private String takeTo;
	// 貸出状況
	@Column
	private String status;
}