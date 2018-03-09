package ais.repository.impl;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import ais.entity.KarteLib;
import ais.repository.KarteLibRepository;
import ais.repository.KarteLibRepositoryCustom;

/**
 * {@link KarteLibRepository}の実装クラス
 *
 * @author fhideaki
 *
 */
public class KarteLibRepositoryImpl implements KarteLibRepositoryCustom {

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

		if(karteLib.getPatientId() != null) {
			// カルテ貸出の、カルテ番号が入力されているなら
			// 検索条件に追加します
			querySb.append("K.patientId = ");
			querySb.append(karteLib.getPatientId());
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

		if(karteLib.getPatientKana() != null) {
			// カナ名が入力されているなら
			// 検索条件に追加します
			//
			// 患者名は　前方一致（あいまい）　で検索しましょう
			// JPQL(SQLでも同じ)では　あいまい検索　には　LIKE　を使います
			querySb.append("K.patientKana LIKE '");
			querySb.append(karteLib.getPatientKana());
			// 「あいまい」な部分を「%」で表します
			querySb.append("%'");
			querySb.append(" and ");
		}

		if(karteLib.getBirthDate() != null) {
			// 生年月日が入力されているなら
			// 検索条件に追加します
			//findByAge(Is)NotNull

			// まず日付型の比較にはシングルクォーテーションが必要です。文字列と同じですね
			// 次にエンティティに入っている誕生日はJavaの日付型オブジェクトです
			// これを文字列に変換してJPQL文字列に条件として加えましょう
			querySb.append("K.birthDate = '");
			querySb.append(karteLib.getBirthDate().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			querySb.append("' and ");
		 }

		if(karteLib.getAge() != null) {
			// 年齢が入力されているなら
			// 検索条件に追加します
			//findByAge(Is)NotNull
			querySb.append("K.age = ");
			querySb.append(karteLib.getAge());
			querySb.append(" and ");
		 }
		if(karteLib.getSex() != null && karteLib.getSex().length() > 0) {
			// 性別が入力されているなら
			// 検索条件に追加します
			// 性別データは「男」「女」として登録されています
			// つまり文字列ですね・・・ということはシングルクォーテーションで括ってあげましょう
			querySb.append("K.sex = '");
			querySb.append(karteLib.getSex());
			querySb.append("' and ");
		 }

		// JPQLの末尾の不要な「 and 」を除去します
		querySb.replace(querySb.length() - 5, querySb.length(), "");

		// 検索を実行します
		return entityManager.createQuery(querySb.toString(), KarteLib.class).getResultList();
	}

}