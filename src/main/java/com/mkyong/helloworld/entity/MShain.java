package com.mkyong.helloworld.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_shain database table.
 * 
 */
@Entity
@Table(name="m_shain")
@NamedQuery(name="MShain.findAll", query="SELECT m FROM MShain m")
public class MShain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=255)
	private String code;

	@Column(nullable=false, length=255)
	private String name;

	@Column(name="shozoku_busho_code", nullable=false, length=255)
	private String shozokuBushoCode;

	@Version
	@Column(nullable=false)
	private int version;

	public MShain() {
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

	public String getShozokuBushoCode() {
		return this.shozokuBushoCode;
	}

	public void setShozokuBushoCode(String shozokuBushoCode) {
		this.shozokuBushoCode = shozokuBushoCode;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}