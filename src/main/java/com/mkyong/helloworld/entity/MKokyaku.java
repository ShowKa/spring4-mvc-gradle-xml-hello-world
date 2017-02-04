package com.mkyong.helloworld.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_kokyaku database table.
 * 
 */
@Entity
@Table(name="m_kokyaku")
@NamedQuery(name="MKokyaku.findAll", query="SELECT m FROM MKokyaku m")
public class MKokyaku implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=255)
	private String code;

	@Column(nullable=false, length=255)
	private String address;

	@Column(name="gentei_kubun", nullable=false, length=255)
	private String genteiKubun;

	@Column(name="kokyaku_kubun", nullable=false, length=255)
	private String kokyakuKubun;

	@Column(nullable=false, length=255)
	private String name;

	@Column(name="shukan_busho_code", nullable=false, length=255)
	private String shukanBushoCode;

	@Version
	@Column(nullable=false)
	private int version;

	public MKokyaku() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGenteiKubun() {
		return this.genteiKubun;
	}

	public void setGenteiKubun(String genteiKubun) {
		this.genteiKubun = genteiKubun;
	}

	public String getKokyakuKubun() {
		return this.kokyakuKubun;
	}

	public void setKokyakuKubun(String kokyakuKubun) {
		this.kokyakuKubun = kokyakuKubun;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShukanBushoCode() {
		return this.shukanBushoCode;
	}

	public void setShukanBushoCode(String shukanBushoCode) {
		this.shukanBushoCode = shukanBushoCode;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}