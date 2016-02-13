package co.za.bongani.advert;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.za.bongani.advert.dto.Advert;
import co.za.bongani.advert.services.AdvertService;

@Controller
@RequestMapping("/advert")
public class RestController {
	
	@Autowired
	AdvertService advertService;
	
	static final Logger logger = Logger.getLogger(RestController.class);
	
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody 
	void addAdvert(@RequestBody Advert advert){
		try{
			advertService.addAdvert(advert);
			logger.debug("Advert created successfully");
		} catch (Exception e){
			logger.debug(e);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public @ResponseBody 
	void updateAdvert(@RequestBody Advert advert){
		try{
			advertService.updateAdvert(advert);
			logger.debug("Advert updated successfully");
		} catch (Exception e){
			logger.debug(e);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody 
	Advert getAdvert(@PathVariable("id") Long id) {
		Advert advert = null;
		try{
			logger.debug("Fetching advert for id "+id);
			advert = advertService.getAdvertById(id);
			logger.debug("Successfully fetched advert for id "+id);
		} catch(Exception e){
			logger.debug(e);
		}
		return advert;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Advert> getAdverts() {
		List<Advert> advertList = null;
		try{
			logger.debug("Fetching all adverts");
			advertList = advertService.getAllAdverts();
			logger.debug("Successfully fetched all adverts");
		}catch(Exception e){
			logger.debug(e);
		}
		return advertList;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
	public @ResponseBody 
	void deleteAdvert(@PathVariable("id") Long id) {
		try{
			logger.debug("Deleting advert for id "+id);
			advertService.deleteAdvert(id);
			logger.debug("Successfully deleted advert for id "+id);
		} catch(Exception e){
			logger.debug(e);
		}
	}
}