package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class MBusho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 255)
	private String code;

	@Column(nullable = false, length = 255)
	private String name;

	@Version
	@Column(nullable = false)
	private int version;

	public MBusho() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}