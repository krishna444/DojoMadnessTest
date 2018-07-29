package com.kpaudel.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity: Hero
 * 
 * @author Krishna Paudel
 *
 */
@Entity
public class Hero implements Serializable {
	private static final long serialVersionUID = -7478286910761048802L;
	@Id
	private Integer id;
	private String name;
	private String realName;
	private int health;
	private int armour;
	private int shield;

	/**
	 * Default constructor
	 */
	public Hero() {

	}

	/**
	 * Initializes hero entity
	 * 
	 * @param id
	 * @param name
	 * @param realName
	 * @param health
	 * @param armour
	 * @param shield
	 */
	public Hero(Integer id, String name, String realName, int health, int armour, int shield) {
		this.id = id;
		this.name = name;
		this.realName = realName;
		this.health = health;
		this.armour = armour;
		this.shield = shield;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmour() {
		return armour;
	}

	public void setArmour(int armour) {
		this.armour = armour;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public String toString() {
		return String.format("Hero[id=%d]", this.id);
	}

}
