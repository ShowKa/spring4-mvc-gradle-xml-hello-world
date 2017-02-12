package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the m_kyujitsu database table.
 * 
 */
@Embeddable
public class MKyujitsuPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "busho_code", insertable = false, updatable = false)
	private String bushoCode;

	@Temporal(TemporalType.DATE)
	private java.util.Date kyujitsu;

	public MKyujitsuPK() {
	}

	public String getBushoCode() {
		return this.bushoCode;
	}

	public void setBushoCode(String bushoCode) {
		this.bushoCode = bushoCode;
	}

	public java.util.Date getKyujitsu() {
		return this.kyujitsu;
	}

	public void setKyujitsu(java.util.Date kyujitsu) {
		this.kyujitsu = kyujitsu;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MKyujitsuPK)) {
			return false;
		}
		MKyujitsuPK castOther = (MKyujitsuPK) other;
		return this.bushoCode.equals(castOther.bushoCode) && this.kyujitsu.equals(castOther.kyujitsu);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bushoCode.hashCode();
		hash = hash * prime + this.kyujitsu.hashCode();

		return hash;
	}
}