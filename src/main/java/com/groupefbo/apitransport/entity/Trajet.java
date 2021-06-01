package com.groupefbo.apitransport.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trajet")
public class Trajet {

	@Id
	@Column(name = "id_trajet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String intitule;

	@Column(name = "moment_depart")
	private LocalDateTime momentDepart;

	/**
	 * Date et heure d'arrivée, null si le trajet n'est pas terminée
	 */
	@Column(name = "moment_arrivee")
	private LocalDateTime momentArrivee;

	@Builder.Default
	@OrderBy("ordre")
	@OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Etape> etapes = new ArrayList<>();

	public boolean estAujourdhui() {
		return momentDepart.toLocalDate().isEqual(LocalDate.now());
	}

}
