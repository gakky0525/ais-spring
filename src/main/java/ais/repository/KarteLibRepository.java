package ais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ais.entity.KarteLib;

/**
 * カルテ貸出リポジトリ
 *
 * データベースアクセスを実行するインターフェース
 * 実体はSpring Bootが自動生成します。P.66参照。
 *
 * @author fhideaki
 *
 */
public interface KarteLibRepository extends JpaRepository<KarteLib, Integer>, KarteLibRepositoryCustom {

	/**
	 * カルテ貸出IDと患者名でカルテ貸出を検索します。
	 * @param karteLibId カルテ貸出ID
	 * @param patientName 患者名
	 * @return エンティティのリスト
	 */
	List<KarteLib> findKarteLibByKarteLibIdAndPatientName(Integer karteLibId, String patientName) ;

	/**
	 * 登録されている患者IDの最大値を検索します。
	 * @return エンティティ
	 */
	KarteLib findTopByOrderByPatientIdDesc() ;
}