package com.groupefbo.apitransport.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Distance entre deux {@link Localisation}. La relation n'est pas réciproque (A -> B n'est pas égale à B -> A) comme des chemins différents peuvent être pris.
 * 
 * @author BBEAUVAIS
 *
 */
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(BigDecimal kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Localisation getDepart() {
		return depart;
	}

	public void setDepart(Localisation depart) {
		this.depart = depart;
	}

	public Localisation getArrivee() {
		return arrivee;
	}

	public void setArrivee(Localisation arrivee) {
		this.arrivee = arrivee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivee, depart, id, kilometrage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distance other = (Distance) obj;
		return Objects.equals(arrivee, other.arrivee) && Objects.equals(depart, other.depart) && Objects.equals(id, other.id)
			&& Objects.equals(kilometrage, other.kilometrage);
	}

}
