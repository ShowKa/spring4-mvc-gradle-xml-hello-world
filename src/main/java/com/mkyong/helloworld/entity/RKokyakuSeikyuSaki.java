package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the r_kokyaku_seikyu_saki database table.
 * 
 */
@Entity
@Table(name = "r_kokyaku_seikyu_saki")
@NamedQuery(name = "RKokyakuSeikyuSaki.findAll", query = "SELECT r FROM RKokyakuSeikyuSaki r")
public class RKokyakuSeikyuSaki extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RKokyakuSeikyuSakiPK id;

	@Column(name = "seikyu_saki_id")
	private int seikyuSakiId;

	@Version
	private int version;

	public RKokyakuSeikyuSaki() {
	}

	public RKokyakuSeikyuSakiPK getId() {
		return this.id;
	}

	public void setId(RKokyakuSeikyuSakiPK id) {
		this.id = id;
	}

	public int getSeikyuSakiId() {
		return this.seikyuSakiId;
	}

	public void setSeikyuSakiId(int seikyuSakiId) {
		this.seikyuSakiId = seikyuSakiId;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}