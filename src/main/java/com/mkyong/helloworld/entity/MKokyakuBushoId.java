package com.mkyong.helloworld.entity;
// Generated Jan 28, 2017 6:19:52 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MKokyakuBushoId generated by hbm2java
 */
@Embeddable
public class MKokyakuBushoId implements java.io.Serializable {

	private String kokyakuCode;
	private String bushoCode;

	public MKokyakuBushoId() {
	}

	public MKokyakuBushoId(String kokyakuCode, String bushoCode) {
		this.kokyakuCode = kokyakuCode;
		this.bushoCode = bushoCode;
	}

	@Column(name = "kokyaku_code", nullable = false)
	public String getKokyakuCode() {
		return this.kokyakuCode;
	}

	public void setKokyakuCode(String kokyakuCode) {
		this.kokyakuCode = kokyakuCode;
	}

	@Column(name = "busho_code", nullable = false)
	public String getBushoCode() {
		return this.bushoCode;
	}

	public void setBushoCode(String bushoCode) {
		this.bushoCode = bushoCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MKokyakuBushoId))
			return false;
		MKokyakuBushoId castOther = (MKokyakuBushoId) other;

		return ((this.getKokyakuCode() == castOther.getKokyakuCode()) || (this.getKokyakuCode() != null
				&& castOther.getKokyakuCode() != null && this.getKokyakuCode().equals(castOther.getKokyakuCode())))
				&& ((this.getBushoCode() == castOther.getBushoCode()) || (this.getBushoCode() != null
						&& castOther.getBushoCode() != null && this.getBushoCode().equals(castOther.getBushoCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getKokyakuCode() == null ? 0 : this.getKokyakuCode().hashCode());
		result = 37 * result + (getBushoCode() == null ? 0 : this.getBushoCode().hashCode());
		return result;
	}

}
