package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_kofuri_koza database table.
 * 
 */
@Entity
@Table(name = "m_kofuri_koza")
@NamedQuery(name = "MKofuriKoza.findAll", query = "SELECT m FROM MKofuriKoza m")
public class MKofuriKoza extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nyukin_moto_id")
	private int nyukinMotoId;

	@Column(name = "kinyu_kikan_code")
	private String kinyuKikanCode;

	@Column(name = "kinyu_kikan_kubun")
	private String kinyuKikanKubun;

	@Column(name = "kinyu_kikan_tenpo_code")
	private String kinyuKikanTenpoCode;

	@Column(name = "koza_bango")
	private String kozaBango;

	@Version
	private int version;

	@Column(name = "yokinsha_name")
	private String yokinshaName;

	public MKofuriKoza() {
	}

	public int getNyukinMotoId() {
		return this.nyukinMotoId;
	}

	public void setNyukinMotoId(int nyukinMotoId) {
		this.nyukinMotoId = nyukinMotoId;
	}

	public String getKinyuKikanCode() {
		return this.kinyuKikanCode;
	}

	public void setKinyuKikanCode(String kinyuKikanCode) {
		this.kinyuKikanCode = kinyuKikanCode;
	}

	public String getKinyuKikanKubun() {
		return this.kinyuKikanKubun;
	}

	public void setKinyuKikanKubun(String kinyuKikanKubun) {
		this.kinyuKikanKubun = kinyuKikanKubun;
	}

	public String getKinyuKikanTenpoCode() {
		return this.kinyuKikanTenpoCode;
	}

	public void setKinyuKikanTenpoCode(String kinyuKikanTenpoCode) {
		this.kinyuKikanTenpoCode = kinyuKikanTenpoCode;
	}

	public String getKozaBango() {
		return this.kozaBango;
	}

	public void setKozaBango(String kozaBango) {
		this.kozaBango = kozaBango;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getYokinshaName() {
		return this.yokinshaName;
	}

	public void setYokinshaName(String yokinshaName) {
		this.yokinshaName = yokinshaName;
	}

}