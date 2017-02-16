package com.mkyong.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_nyukin_kake_info database table.
 * 
 */
@Entity
@Table(name = "m_nyukin_kake_info")
@NamedQuery(name = "MNyukinKakeInfo.findAll", query = "SELECT m FROM MNyukinKakeInfo m")
public class MNyukinKakeInfo extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "nyukin_hoho_kubun")
	private String nyukinHohoKubun;

	@Column(name = "nyukin_tsuki_kubun")
	private String nyukinTsukiKubun;

	private int shimebi;

	@Version
	private int version;

	// bi-directional one-to-one association to MNyukinMoto
	@OneToOne
	@JoinColumn(name = "id")
	private MNyukinMoto MNyukinMoto;

	public MNyukinKakeInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNyukinHohoKubun() {
		return this.nyukinHohoKubun;
	}

	public void setNyukinHohoKubun(String nyukinHohoKubun) {
		this.nyukinHohoKubun = nyukinHohoKubun;
	}

	public String getNyukinTsukiKubun() {
		return this.nyukinTsukiKubun;
	}

	public void setNyukinTsukiKubun(String nyukinTsukiKubun) {
		this.nyukinTsukiKubun = nyukinTsukiKubun;
	}

	public int getShimebi() {
		return this.shimebi;
	}

	public void setShimebi(int shimebi) {
		this.shimebi = shimebi;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MNyukinMoto getMNyukinMoto() {
		return this.MNyukinMoto;
	}

	public void setMNyukinMoto(MNyukinMoto MNyukinMoto) {
		this.MNyukinMoto = MNyukinMoto;
	}

}