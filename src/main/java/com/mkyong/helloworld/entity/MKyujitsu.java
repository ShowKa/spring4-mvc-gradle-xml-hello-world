package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the m_kyujitsu database table.
 * 
 */
@Entity
@Table(name = "m_kyujitsu")
@NamedQuery(name = "MKyujitsu.findAll", query = "SELECT m FROM MKyujitsu m")
public class MKyujitsu extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MKyujitsuPK id;

	@Column(name = "kyujitsu_name")
	private String kyujitsuName;

	private int version;

	public MKyujitsu() {
	}

	public MKyujitsuPK getId() {
		return this.id;
	}

	public void setId(MKyujitsuPK id) {
		this.id = id;
	}

	public String getKyujitsuName() {
		return this.kyujitsuName;
	}

	public void setKyujitsuName(String kyujitsuName) {
		this.kyujitsuName = kyujitsuName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}