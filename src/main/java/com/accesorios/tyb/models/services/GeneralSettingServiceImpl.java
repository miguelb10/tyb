package com.accesorios.tyb.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accesorios.tyb.models.dao.IGeneralSettingDao;
import com.accesorios.tyb.models.entity.GeneralSetting;

@Service
public class GeneralSettingServiceImpl implements IGeneralSettingService{

	@Autowired
	private IGeneralSettingDao generalSettingDao;

	@Override
	public GeneralSetting findByNombre(String nombre) {
		return generalSettingDao.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public GeneralSetting findById(Long id) {
		return generalSettingDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public GeneralSetting save(GeneralSetting generalSetting) {
		return generalSettingDao.save(generalSetting);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		generalSettingDao.deleteById(id);		
	}
}
