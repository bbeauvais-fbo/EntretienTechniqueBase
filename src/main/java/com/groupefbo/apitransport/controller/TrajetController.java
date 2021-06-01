package com.groupefbo.apitransport.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupefbo.apitransport.entity.Trajet;
import com.groupefbo.apitransport.service.TrajetService;

@Controller
@RequestMapping("trajets")
public class TrajetController {

	private final TrajetService trajetService;

	public TrajetController(TrajetService trajetService) {
		super();
		this.trajetService = trajetService;
	}


	/**
	 * Endpoint permettant de remonter l'intégralité des {@link Trajet}
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Trajet>> getAllTrajet() {
		List<Trajet> trajets = trajetService.getAllTrajet();
		return trajets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(trajets);
	}

}
