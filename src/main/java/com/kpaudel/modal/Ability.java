package com.kpaudel.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity: Ability
 * 
 * @author krishna
 *
 */
@Entity
public class Ability implements Serializable {
	private static final long serialVersionUID = -3373061977638221871L;
	@Id
	private Integer id;
	private Integer heroId;

	@Column(nullable = false)
	private String name;
	@Column(nullable = true,length=1000)
	private String description;
	@Column(nullable = false)
	private Boolean ultimate;

	public Ability() {

	}

	public Ability(Integer id, Integer heroId, String name, String description, Boolean ultimate) {
		this.id = id;
		this.heroId = heroId;
		this.name = name;
		this.description = description;
		this.ultimate = ultimate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHeroId() {
		return heroId;
	}

	public void setHeroId(Integer heroId) {
		this.heroId = heroId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getUltimate() {
		return ultimate;
	}

	public void setUltimate(Boolean ultimate) {
		this.ultimate = ultimate;
	}

	@Override
	public String toString() {
		return String.format("Ability[id=%d]", this.id);
	}

}
