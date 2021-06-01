package com.groupefbo.apitransport.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Emplacement géographique avec un nom d'identification. Exemple : "Paris" ou "Aire d'autoroute A234".
 * 
 * @author BBEAUVAIS
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "localisation")
public class Localisation {

	@Id
	@Column(name = "id_localisation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String libelle;

	@OneToMany(mappedBy = "depart", fetch = FetchType.LAZY)
	private List<Distance> distancesEnDepart;

	@OneToMany(mappedBy = "arrivee", fetch = FetchType.LAZY)
	private List<Distance> distancesEnArrivee;

}
