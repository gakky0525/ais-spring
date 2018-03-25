package ais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ais.entity.DoctorMst;

/**
 * 医者リポジトリ
 *
 * データベースアクセスを実行するインターフェース
 * 実体はSpring Bootが自動生成します。P.66参照。
 *
 * @author fhideaki
 *
 */
public interface DoctorMstRepository extends JpaRepository<DoctorMst, Integer> {

}