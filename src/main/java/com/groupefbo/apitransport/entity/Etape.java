package com.groupefbo.apitransport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Etapes successives dans un {@link Trajet}. L'ordre détermine comment se succèdent les {@link Localisation} dans le trajet. Exemple : Un trajet peut partir de
 * Marseille, avoir les étapes Lyon, Paris, puis finir à Lille.
 * 
 * @author BBEAUVAIS
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "etape")
public class Etape {

	@Id
	@Column(name = "id_etape")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer ordre;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_localisation", nullable = false)
	private Localisation localisation;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_trajet", nullable = false)
	@JsonIgnore
	private Trajet trajet;

}
