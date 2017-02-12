package com.mkyong.helloworld.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * The persistent class for the m_busho_date database table.
 * 
 */
@Entity
@Table(name = "m_busho_date")
@NamedQuery(name = "MBushoDate.findAll", query = "SELECT m FROM MBushoDate m")
public class MBushoDate extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "busho_code")
	private String bushoCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "eigyo_date")
	private Date eigyoDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "keijo_date")
	private Date keijoDate;

	@Version
	private int version;

	public MBushoDate() {
	}

	public String getBushoCode() {
		return this.bushoCode;
	}

	public void setBushoCode(String bushoCode) {
		this.bushoCode = bushoCode;
	}

	public Date getEigyoDate() {
		return this.eigyoDate;
	}

	public void setEigyoDate(Date eigyoDate) {
		this.eigyoDate = eigyoDate;
	}

	public Date getKeijoDate() {
		return this.keijoDate;
	}

	public void setKeijoDate(Date keijoDate) {
		this.keijoDate = keijoDate;
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