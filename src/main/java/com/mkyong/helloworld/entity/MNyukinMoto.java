package com.mkyong.helloworld.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_nyukin_moto database table.
 * 
 */
@Entity
@Table(name = "m_nyukin_moto")
@NamedQuery(name = "MNyukinMoto.findAll", query = "SELECT m FROM MNyukinMoto m")
public class MNyukinMoto extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "hanbai_kubun")
	private String hanbaiKubun;

	@Version
	private int version;

	// bi-directional one-to-one association to MNyukinKakeInfo
	@OneToOne(mappedBy = "MNyukinMoto")
	private MNyukinKakeInfo MNyukinKakeInfo;

	// bi-directional many-to-one association to RKokyakuNyukinMoto
	@OneToMany(mappedBy = "MNyukinMoto")
	private List<RKokyakuNyukinMoto> RKokyakuNyukinMotos;

	// bi-directional one-to-one association to RNyukinMotoShukan
	@OneToOne(mappedBy = "MNyukinMoto")
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

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MNyukinKakeInfo getMNyukinKakeInfo() {
		return this.MNyukinKakeInfo;
	}

	public void setMNyukinKakeInfo(MNyukinKakeInfo MNyukinKakeInfo) {
		this.MNyukinKakeInfo = MNyukinKakeInfo;
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