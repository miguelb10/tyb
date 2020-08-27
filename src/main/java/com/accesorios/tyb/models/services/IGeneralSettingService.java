package com.accesorios.tyb.models.services;

import com.accesorios.tyb.models.entity.GeneralSetting;

public interface IGeneralSettingService {

	public GeneralSetting findByNombre(String nombre);

	public GeneralSetting findById(Long id);

	public GeneralSetting save(GeneralSetting generalSetting);
	
	public void delete(Long id);
}
