package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_seikyu_saki database table.
 * 
 */
@Entity
@Table(name = "m_seikyu_saki")
@NamedQuery(name = "MSeikyuSaki.findAll", query = "SELECT m FROM MSeikyuSaki m")
public class MSeikyuSaki extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "seikyu_kubun")
	private String seikyuKubun;

	@Column(name = "seikyu_saki_name")
	private String seikyuSakiName;

	@Column(name = "seikyusho_sakusei_tanto")
	private String seikyushoSakuseiTanto;

	@Version
	private int version;

	public MSeikyuSaki() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeikyuKubun() {
		return this.seikyuKubun;
	}

	public void setSeikyuKubun(String seikyuKubun) {
		this.seikyuKubun = seikyuKubun;
	}

	public String getSeikyuSakiName() {
		return this.seikyuSakiName;
	}

	public void setSeikyuSakiName(String seikyuSakiName) {
		this.seikyuSakiName = seikyuSakiName;
	}

	public String getSeikyushoSakuseiTanto() {
		return this.seikyushoSakuseiTanto;
	}

	public void setSeikyushoSakuseiTanto(String seikyushoSakuseiTanto) {
		this.seikyushoSakuseiTanto = seikyushoSakuseiTanto;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}