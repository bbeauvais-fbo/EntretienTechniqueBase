package com.groupefbo.apitransport.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@OrderBy("ordre")
	@OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Etape> etapes = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public LocalDateTime getMomentDepart() {
		return momentDepart;
	}

	public void setMomentDepart(LocalDateTime momentDepart) {
		this.momentDepart = momentDepart;
	}

	public LocalDateTime getMomentArrivee() {
		return momentArrivee;
	}

	public void setMomentArrivee(LocalDateTime momentArrivee) {
		this.momentArrivee = momentArrivee;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(etapes, id, intitule, momentArrivee, momentDepart);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trajet other = (Trajet) obj;
		return Objects.equals(etapes, other.etapes) && Objects.equals(id, other.id) && Objects.equals(intitule, other.intitule)
			&& Objects.equals(momentArrivee, other.momentArrivee) && Objects.equals(momentDepart, other.momentDepart);
	}

}
