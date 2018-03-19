package ais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ais.entity.DepartmentMst;

/**
 * 診療科マスタリポジトリ
 *
 * データベースアクセスを実行するインターフェース
 * 実体はSpring Bootが自動生成します。P.66参照。
 *
 * @author fhideaki
 *
 */
public interface DepartmentMstRepository extends JpaRepository<DepartmentMst, Integer> {
}