package ais.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import ais.entity.KarteLib;
import ais.repository.KarteLibCustom;
import ais.repository.KarteLibRepository;

/**
 * {@link KarteLibRepository}の実装クラス
 *
 * @author fhideaki
 *
 */
public class KarteLibRepositoryImpl implements KarteLibCustom {

	@Autowired
	EntityManager entityManager;

	/**
	 * より複雑な検索条件を指定するためにカスタム検索メソッドをつくってみましょう
	 *
	 * 簡単な検索条件の場合はSpring Data JPAの命名規則に従ったメソッドを作成すればよいのでした
	 * しかしより複雑な検索をする場合はSpring Data JPAに任せるわけにはいきません
	 * 自分でJPQLを使って実装します
	 */
	@Override
	public List<KarteLib> findKarteLib(KarteLib karteLib) {

		// JPQLを使います
		// SQLに似た文法ですがJPQLの場合はJavaよりのオブジェクト指向で考えます
		//
		// 何を？(SELECT XXX )、どこから？(FROM XXX)、どんな条件で？(WHERE XXX)
		StringBuilder querySb = new StringBuilder("SELECT K FROM KarteLib as K WHERE ");

		if(karteLib.getKarteLibId() != null) {
			// カルテ貸出IDが入力されているなら
			// 検索条件に追加します
			querySb.append("K.karteLibId = ");
			querySb.append(karteLib.getKarteLibId());
			querySb.append(" and ");
		}

		if(karteLib.getPatientName() != null) {
			// 患者名が入力されているなら
			// 検索条件に追加します
			//
			// 患者名は　前方一致（あいまい）　で検索しましょう
			// JPQL(SQLでも同じ)では　あいまい検索　には　LIKE　を使います
			querySb.append("K.patientName LIKE '");
			querySb.append(karteLib.getPatientName());
			// 「あいまい」な部分を「%」で表します
			querySb.append("%'");
			querySb.append(" and ");
		}

		// JPQLの末尾の不要な「 and 」を除去します
		querySb.replace(querySb.length() - 5, querySb.length(), "");

		// 検索を実行します
		return entityManager.createQuery(querySb.toString(), KarteLib.class).getResultList();
	}

}