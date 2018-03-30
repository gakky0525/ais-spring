package ais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ais.entity.BuildingMst;

/*入院病棟・退院時病棟マスタリポジトリ*/

public interface BuildingMstRepository extends JpaRepository<BuildingMst, Integer>{

}
