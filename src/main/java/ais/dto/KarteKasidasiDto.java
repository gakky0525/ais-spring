package ais.dto;

/**
 * カルテ貸出状況を管理するクラス
 * @author fhideaki
 *
 */
public class KarteKasidasiDto {
	// 氏名
	private String name;
	// フリガナ
	private String kana;
	// ID
	private String id;
	// カルテ番号
	private String karteNo;
	// 診療科
	private String kaMei;
	// 入院日
	private String nyuinDate;
	// 退院日
	private String taiinDate;
	// 提出先
	private String teisyutu;
	// 貸出状況
	private String kasidasi;
	//生年月日
	private String birth;
	//年齢
	private String age;
	//性別
	private String gender;
	//返却日
	private String henkyakuDate;
	//搬入日
	private String hannyuDate;


	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKarteNo() {
		return karteNo;
	}
	public void setKarteNo(String karteNo) {
		this.karteNo = karteNo;
	}
	public String getKaMei() {
		return kaMei;
	}
	public void setKaMei(String kaMei) {
		this.kaMei = kaMei;
	}
	public String getNyuinDate() {
		return nyuinDate;
	}
	public void setNyuinDate(String nyuinDate) {
		this.nyuinDate = nyuinDate;
	}
	public String getTaiinDate() {
		return taiinDate;
	}
	public void setTaiinDate(String taiinDate) {
		this.taiinDate = taiinDate;
	}
	public String getTeisyutu() {
		return teisyutu;
	}
	public void setTeisyutu(String teisyutu) {
		this.teisyutu = teisyutu;
	}
	public String getKasidasi() {
		return kasidasi;
	}
	public void setKasidasi(String kasidasi) {
		this.kasidasi = kasidasi;
	}
	public String getHenkyakuDate() {
		return henkyakuDate;
	}
	public void setHenkyakuDate(String henkyakuDate) {
		this.henkyakuDate = henkyakuDate;
	}
	public String getHannyuDate() {
		return hannyuDate;
	}
	public void setHannyuDate(String hannyuDate) {
		this.hannyuDate = hannyuDate;
	}
}
