package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_busho database table.
 * 
 */
@Entity
@Table(name = "m_busho")
@NamedQuery(name = "MBusho.findAll", query = "SELECT m FROM MBusho m")
public class MBusho extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String code;

	@Column(name = "busho_kubun")
	private String bushoKubun;

	@Column(name = "jigyo_kubun")
	private String jigyoKubun;

	private String name;

	@Version
	private int version;

	public MBusho() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBushoKubun() {
		return this.bushoKubun;
	}

	public void setBushoKubun(String bushoKubun) {
		this.bushoKubun = bushoKubun;
	}

	public String getJigyoKubun() {
		return this.jigyoKubun;
	}

	public void setJigyoKubun(String jigyoKubun) {
		this.jigyoKubun = jigyoKubun;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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