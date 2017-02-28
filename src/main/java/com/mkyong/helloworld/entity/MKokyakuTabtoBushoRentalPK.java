package com.mkyong.helloworld.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the m_kokyaku_tabto_busho_rental database table.
 * 
 */
@Embeddable
public class MKokyakuTabtoBushoRentalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="kokyaku_code", insertable=false, updatable=false)
	private String kokyakuCode;

	@Column(name="busho_code", insertable=false, updatable=false)
	private String bushoCode;

	public MKokyakuTabtoBushoRentalPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MKokyakuTabtoBushoRentalPK)) {
			return false;
		}
		MKokyakuTabtoBushoRentalPK castOther = (MKokyakuTabtoBushoRentalPK)other;
		return 
			this.kokyakuCode.equals(castOther.kokyakuCode)
			&& this.bushoCode.equals(castOther.bushoCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.kokyakuCode.hashCode();
		hash = hash * prime + this.bushoCode.hashCode();
		
		return hash;
	}
}