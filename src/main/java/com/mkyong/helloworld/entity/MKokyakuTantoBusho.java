package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_kokyaku_tanto_busho database table.
 * 
 */
@Entity
@Table(name = "m_kokyaku_tanto_busho")
@NamedQuery(name = "MKokyakuTantoBusho.findAll", query = "SELECT m FROM MKokyakuTantoBusho m")
public class MKokyakuTantoBusho extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MKokyakuTantoBushoPK id;

	@Column(name = "sekininsha_name")
	private String sekininshaName;

	@Column(name = "shohizei_kubun")
	private String shohizeiKubun;

	@Version
	private int version;

	public MKokyakuTantoBusho() {
	}

	public MKokyakuTantoBushoPK getId() {
		return this.id;
	}

	public void setId(MKokyakuTantoBushoPK id) {
		this.id = id;
	}

	public String getSekininshaName() {
		return this.sekininshaName;
	}

	public void setSekininshaName(String sekininshaName) {
		this.sekininshaName = sekininshaName;
	}

	public String getShohizeiKubun() {
		return this.shohizeiKubun;
	}

	public void setShohizeiKubun(String shohizeiKubun) {
		this.shohizeiKubun = shohizeiKubun;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}