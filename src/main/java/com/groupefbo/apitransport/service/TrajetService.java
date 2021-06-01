package com.groupefbo.apitransport.service;

import java.util.List;

import com.groupefbo.apitransport.entity.Trajet;

public interface TrajetService {

	/**
	 * Récupération de la liste de tous les {@link Trajet} actifs.
	 * @return
	 */
	List<Trajet> getAllTrajet();


}
