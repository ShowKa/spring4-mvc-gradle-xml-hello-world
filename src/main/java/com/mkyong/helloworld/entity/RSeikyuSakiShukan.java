package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the r_seikyu_saki_shukan database table.
 * 
 */
@Entity
@Table(name = "r_seikyu_saki_shukan")
@NamedQuery(name = "RSeikyuSakiShukan.findAll", query = "SELECT r FROM RSeikyuSakiShukan r")
public class RSeikyuSakiShukan extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seikyu_saki_id")
	private int seikyuSakiId;

	@Column(name = "busho_code")
	private String bushoCode;

	@Column(name = "kokyaku_code")
	private String kokyakuCode;

	@Version
	private int version;

	public RSeikyuSakiShukan() {
	}

	public int getSeikyuSakiId() {
		return this.seikyuSakiId;
	}

	public void setSeikyuSakiId(int seikyuSakiId) {
		this.seikyuSakiId = seikyuSakiId;
	}

	public String getBushoCode() {
		return this.bushoCode;
	}

	public void setBushoCode(String bushoCode) {
		this.bushoCode = bushoCode;
	}

	public String getKokyakuCode() {
		return this.kokyakuCode;
	}

	public void setKokyakuCode(String kokyakuCode) {
		this.kokyakuCode = kokyakuCode;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}