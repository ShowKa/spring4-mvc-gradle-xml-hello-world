package com.mkyong.helloworld.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the r_kokyaku_nyukin_moto database table.
 * 
 */
@Entity
@Table(name = "r_kokyaku_nyukin_moto")
@NamedQuery(name = "RKokyakuNyukinMoto.findAll", query = "SELECT r FROM RKokyakuNyukinMoto r")
public class RKokyakuNyukinMoto extends AbstractEntity {

	@EmbeddedId
	private RKokyakuNyukinMotoPK id;

	@Version
	private int version;

	// bi-directional many-to-one association to MKokyakuBusho
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "busho_code", referencedColumnName = "busho_code"),
			@JoinColumn(name = "kokyaku_code", referencedColumnName = "kokyaku_code") })
	private MKokyakuBusho MKokyakuBusho;

	// bi-directional many-to-one association to MNyukinMoto
	@ManyToOne
	@JoinColumn(name = "nyukin_moto_id")
	private MNyukinMoto MNyukinMoto;

	public RKokyakuNyukinMoto() {
	}

	public RKokyakuNyukinMotoPK getId() {
		return this.id;
	}

	public void setId(RKokyakuNyukinMotoPK id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MKokyakuBusho getMKokyakuBusho() {
		return this.MKokyakuBusho;
	}

	public void setMKokyakuBusho(MKokyakuBusho MKokyakuBusho) {
		this.MKokyakuBusho = MKokyakuBusho;
	}

	public MNyukinMoto getMNyukinMoto() {
		return this.MNyukinMoto;
	}

	public void setMNyukinMoto(MNyukinMoto MNyukinMoto) {
		this.MNyukinMoto = MNyukinMoto;
	}

}