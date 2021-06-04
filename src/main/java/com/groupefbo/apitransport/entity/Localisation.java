package com.groupefbo.apitransport.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Emplacement géographique avec un nom d'identification. Exemple : "Paris" ou "Aire d'autoroute A234".
 * 
 * @author BBEAUVAIS
 *
 */
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Distance> getDistancesEnDepart() {
		return distancesEnDepart;
	}

	public void setDistancesEnDepart(List<Distance> distancesEnDepart) {
		this.distancesEnDepart = distancesEnDepart;
	}

	public List<Distance> getDistancesEnArrivee() {
		return distancesEnArrivee;
	}

	public void setDistancesEnArrivee(List<Distance> distancesEnArrivee) {
		this.distancesEnArrivee = distancesEnArrivee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distancesEnArrivee, distancesEnDepart, id, libelle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localisation other = (Localisation) obj;
		return Objects.equals(distancesEnArrivee, other.distancesEnArrivee) && Objects.equals(distancesEnDepart, other.distancesEnDepart)
			&& Objects.equals(id, other.id) && Objects.equals(libelle, other.libelle);
	}

}
