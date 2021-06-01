package com.groupefbo.apitransport.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.groupefbo.apitransport.dao.TrajetDao;
import com.groupefbo.apitransport.entity.Trajet;

@Repository
public class TrajetDaoImpl implements TrajetDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Trajet> findAll() {
		return entityManager.createQuery("FROM Trajet", Trajet.class).getResultList();
	}

}
