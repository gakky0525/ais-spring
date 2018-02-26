package ais.repository;

import java.util.List;

import ais.entity.KarteLib;

/**
 * カルテ貸出のカスタム検索メソッドを定義するインターフェース
 *
 * @author fhideaki
 *
 */
public interface KarteLibRepositoryCustom {

	/**
	 * カルテ貸出IDと患者名で検索します。
	 * @param karteLib 検索条件エンティティ
	 * @return エンティティのリスト
	 */
	public List<KarteLib> findKarteLib(KarteLib karteLib) ;

}
