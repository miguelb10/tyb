package com.accesorios.tyb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accesorios.tyb.models.entity.GeneralSetting;

public interface IGeneralSettingDao extends JpaRepository<GeneralSetting, Long> {

	@Query(value="select * from general_settings where nombre like ?1 limit 1", nativeQuery = true)
	public GeneralSetting findByNombre(String nombre);
}
