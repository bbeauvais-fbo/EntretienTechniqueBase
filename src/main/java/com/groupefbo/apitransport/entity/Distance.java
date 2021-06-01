package com.groupefbo.apitransport.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Distance entre deux {@link Localisation}. La relation n'est pas réciproque (A -> B n'est pas égale à B -> A) comme des chemins différents peuvent être pris.
 * 
 * @author BBEAUVAIS
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "distance")
public class Distance {

	@Id
	@Column(name = "id_distance")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private BigDecimal kilometrage;

	@JoinColumn(name = "id_depart", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Localisation depart;

	@JoinColumn(name = "id_arrivee", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Localisation arrivee;

}
