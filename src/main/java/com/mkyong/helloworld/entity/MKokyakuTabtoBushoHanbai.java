package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_kokyaku_tabto_busho_hanbai database table.
 * 
 */
@Entity
@Table(name = "m_kokyaku_tabto_busho_hanbai")
@NamedQuery(name = "MKokyakuTabtoBushoHanbai.findAll", query = "SELECT m FROM MKokyakuTabtoBushoHanbai m")
public class MKokyakuTabtoBushoHanbai extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MKokyakuTabtoBushoHanbaiPK id;

	@Column(name = "block_number")
	private String blockNumber;

	@Version
	private int version;

	public MKokyakuTabtoBushoHanbai() {
	}

	public MKokyakuTabtoBushoHanbaiPK getId() {
		return this.id;
	}

	public void setId(MKokyakuTabtoBushoHanbaiPK id) {
		this.id = id;
	}

	public String getBlockNumber() {
		return this.blockNumber;
	}

	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}