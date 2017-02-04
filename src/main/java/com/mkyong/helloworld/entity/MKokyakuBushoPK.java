package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

/**
 * The primary key class for the m_kokyaku_busho database table.
 * 
 */
@Embeddable
@AllArgsConstructor
public class MKokyakuBushoPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "kokyaku_code", insertable = false, updatable = false, unique = true, nullable = false, length = 255)
	private String kokyakuCode;

	@Column(name = "busho_code", insertable = false, updatable = false, unique = true, nullable = false, length = 255)
	private String bushoCode;

	public MKokyakuBushoPK() {
	}

	public String getKokyakuCode() {
		return this.kokyakuCode;
	}

	public void setKokyakuCode(String kokyakuCode) {
		this.kokyakuCode = kokyakuCode;
	}

	public String getBushoCode() {
		return this.bushoCode;
	}

	public void setBushoCode(String bushoCode) {
		this.bushoCode = bushoCode;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MKokyakuBushoPK)) {
			return false;
		}
		MKokyakuBushoPK castOther = (MKokyakuBushoPK) other;
		return this.kokyakuCode.equals(castOther.kokyakuCode) && this.bushoCode.equals(castOther.bushoCode);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.kokyakuCode.hashCode();
		hash = hash * prime + this.bushoCode.hashCode();

		return hash;
	}
}