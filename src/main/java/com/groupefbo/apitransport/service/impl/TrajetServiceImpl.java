package com.groupefbo.apitransport.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupefbo.apitransport.dao.TrajetDao;
import com.groupefbo.apitransport.entity.Trajet;
import com.groupefbo.apitransport.service.TrajetService;

@Service
public class TrajetServiceImpl implements TrajetService {

	private final TrajetDao trajetDao;

	public TrajetServiceImpl(TrajetDao trajetDao) {
		super();
		this.trajetDao = trajetDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Trajet> getAllTrajet() {
		List<Trajet> trajets = trajetDao.findAll();
		
		// On force le chargement des données pour l'affichage
		forceChargementDonnee(trajets);
		return trajets;
	}

	private void forceChargementDonnee(List<Trajet> trajets) {
		trajets.forEach(trajet -> trajet.getEtapes().forEach(etape -> etape.getLocalisation().getLibelle()));
	}

}
