package com.groupefbo.apitransport.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Etapes successives dans un {@link Trajet}. L'ordre détermine comment se succèdent les {@link Localisation} dans le trajet. Exemple : Un trajet peut partir de
 * Marseille, avoir les étapes Lyon, Paris, puis finir à Lille.
 * 
 * @author BBEAUVAIS
 *
 */
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public Localisation getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, localisation, ordre, trajet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etape other = (Etape) obj;
		return Objects.equals(id, other.id) && Objects.equals(localisation, other.localisation) && Objects.equals(ordre, other.ordre)
			&& Objects.equals(trajet, other.trajet);
	}

}
