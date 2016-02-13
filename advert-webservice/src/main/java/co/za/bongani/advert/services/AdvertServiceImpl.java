package co.za.bongani.advert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.za.bongani.advert.dao.AdvertDao;
import co.za.bongani.advert.dto.Advert;

public class AdvertServiceImpl implements AdvertService {

	@Autowired
	AdvertDao advertDao;
	
	@Override
	public boolean addAdvert(Advert advert) throws Exception {
		return advertDao.addAdvert(advert);
	}

	@Override
	public Advert getAdvertById(Long id) throws Exception {
		return advertDao.getAdvertById(id);
	}

	@Override
	public boolean updateAdvert(Advert advert) throws Exception {
		return updateAdvert(advert);
	}

	@Override
	public List<Advert> getAllAdverts() throws Exception {
		return advertDao.getAllAdverts();
	}

	@Override
	public boolean deleteAdvert(Long id) throws Exception {
		return advertDao.deleteAdvert(id);
	}

}
