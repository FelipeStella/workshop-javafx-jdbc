package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {

	private SellerDao depDao = DaoFactory.createSellerDao();

	public List<Seller> findAll() {
		return depDao.findAll();
	}

	public void saveOrUpdate(Seller obj){
		if(obj.getId() == null){
			depDao.insert(obj);
		}
		else{
			depDao.update(obj);
		}
	}

	public void remove(Seller obj){
		depDao.deleteById(obj.getId());
	}

}
