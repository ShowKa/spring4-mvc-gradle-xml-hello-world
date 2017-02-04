package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_kokyaku_busho database table.
 * 
 */
@Entity
@Table(name = "m_kokyaku_busho")
@NamedQuery(name = "MKokyakuBusho.findAll", query = "SELECT m FROM MKokyakuBusho m")
public class MKokyakuBusho extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MKokyakuBushoPK id;

	@Column(name = "sekininsha_name", nullable = false, length = 255)
	private String sekininshaName;

	@Column(name = "tanto_shain_code", nullable = false, length = 255)
	private String tantoShainCode;

	@Version
	@Column(nullable = false)
	private int version;

	public MKokyakuBusho() {
	}

	public MKokyakuBushoPK getId() {
		return this.id;
	}

	public void setId(MKokyakuBushoPK id) {
		this.id = id;
	}

	public String getSekininshaName() {
		return this.sekininshaName;
	}

	public void setSekininshaName(String sekininshaName) {
		this.sekininshaName = sekininshaName;
	}

	public String getTantoShainCode() {
		return this.tantoShainCode;
	}

	public void setTantoShainCode(String tantoShainCode) {
		this.tantoShainCode = tantoShainCode;
	}

	@Override
	public int getVersion() {
		return this.version;
	}

	@Override
	public void setVersion(int version) {
		this.version = version;
	}

}