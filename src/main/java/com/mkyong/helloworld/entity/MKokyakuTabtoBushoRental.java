package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_kokyaku_tabto_busho_rental database table.
 * 
 */
@Entity
@Table(name = "m_kokyaku_tabto_busho_rental")
@NamedQuery(name = "MKokyakuTabtoBushoRental.findAll", query = "SELECT m FROM MKokyakuTabtoBushoRental m")
public class MKokyakuTabtoBushoRental extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MKokyakuTabtoBushoRentalPK id;

	@Column(name = "course_code")
	private String courseCode;

	@Version
	private int version;

	public MKokyakuTabtoBushoRental() {
	}

	public MKokyakuTabtoBushoRentalPK getId() {
		return this.id;
	}

	public void setId(MKokyakuTabtoBushoRentalPK id) {
		this.id = id;
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}