package co.za.bongani.advert.dao;

import java.util.List;

import co.za.bongani.advert.dto.Advert;

public interface AdvertDao {
	public boolean addAdvert(Advert advert) throws Exception;
	public Advert getAdvertById(Long id) throws Exception;
	public boolean updateAdvert(Advert advert) throws Exception;
	public List<Advert> getAllAdverts() throws Exception;
	public boolean deleteAdvert(Long id) throws Exception;
}
