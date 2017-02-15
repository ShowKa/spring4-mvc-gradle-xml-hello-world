package com.mkyong.helloworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the m_nyukin_moto database table.
 * 
 */
@Entity
@Table(name="m_nyukin_moto")
@NamedQuery(name="MNyukinMoto.findAll", query="SELECT m FROM MNyukinMoto m")
public class MNyukinMoto extends AbstractEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="hanbai_kubun")
	private String hanbaiKubun;

	@Column(name="nyukin_hoho")
	private String nyukinHoho;

	@Column(name="nyukin_tsuki_kubun")
	private String nyukinTsukiKubun;

	private int shimebi;

	private int version;

	//bi-directional many-to-one association to RKokyakuNyukinMoto
	@OneToMany(mappedBy="MNyukinMoto")
	private List<RKokyakuNyukinMoto> RKokyakuNyukinMotos;

	//bi-directional one-to-one association to RNyukinMotoShukan
	@OneToOne(mappedBy="MNyukinMoto")
	private RNyukinMotoShukan RNyukinMotoShukan;

	public MNyukinMoto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHanbaiKubun() {
		return this.hanbaiKubun;
	}

	public void setHanbaiKubun(String hanbaiKubun) {
		this.hanbaiKubun = hanbaiKubun;
	}

	public String getNyukinHoho() {
		return this.nyukinHoho;
	}

	public void setNyukinHoho(String nyukinHoho) {
		this.nyukinHoho = nyukinHoho;
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

	public List<RKokyakuNyukinMoto> getRKokyakuNyukinMotos() {
		return this.RKokyakuNyukinMotos;
	}

	public void setRKokyakuNyukinMotos(List<RKokyakuNyukinMoto> RKokyakuNyukinMotos) {
		this.RKokyakuNyukinMotos = RKokyakuNyukinMotos;
	}

	public RKokyakuNyukinMoto addRKokyakuNyukinMoto(RKokyakuNyukinMoto RKokyakuNyukinMoto) {
		getRKokyakuNyukinMotos().add(RKokyakuNyukinMoto);
		RKokyakuNyukinMoto.setMNyukinMoto(this);

		return RKokyakuNyukinMoto;
	}

	public RKokyakuNyukinMoto removeRKokyakuNyukinMoto(RKokyakuNyukinMoto RKokyakuNyukinMoto) {
		getRKokyakuNyukinMotos().remove(RKokyakuNyukinMoto);
		RKokyakuNyukinMoto.setMNyukinMoto(null);

		return RKokyakuNyukinMoto;
	}

	public RNyukinMotoShukan getRNyukinMotoShukan() {
		return this.RNyukinMotoShukan;
	}

	public void setRNyukinMotoShukan(RNyukinMotoShukan RNyukinMotoShukan) {
		this.RNyukinMotoShukan = RNyukinMotoShukan;
	}

}