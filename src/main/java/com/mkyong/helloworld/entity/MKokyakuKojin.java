package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_kokyaku_kojin database table.
 * 
 */
@Entity
@Table(name = "m_kokyaku_kojin")
@NamedQuery(name = "MKokyakuKojin.findAll", query = "SELECT m FROM MKokyakuKojin m")
public class MKokyakuKojin extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "kokyaku_code", unique = true, nullable = false, length = 255)
	private String kokyakuCode;

	@Column(name = "oya_kokyaku_code", nullable = false, length = 255)
	private String oyaKokyakuCode;

	@Version
	@Column(nullable = false)
	private int version;

	public MKokyakuKojin() {
	}

	public String getKokyakuCode() {
		return this.kokyakuCode;
	}

	public void setKokyakuCode(String kokyakuCode) {
		this.kokyakuCode = kokyakuCode;
	}

	public String getOyaKokyakuCode() {
		return this.oyaKokyakuCode;
	}

	public void setOyaKokyakuCode(String oyaKokyakuCode) {
		this.oyaKokyakuCode = oyaKokyakuCode;
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