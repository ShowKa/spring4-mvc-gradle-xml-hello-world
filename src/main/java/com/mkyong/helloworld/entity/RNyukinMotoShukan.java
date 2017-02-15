package com.mkyong.helloworld.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the r_nyukin_moto_shukan database table.
 * 
 */
@Entity
@Table(name="r_nyukin_moto_shukan")
@NamedQuery(name="RNyukinMotoShukan.findAll", query="SELECT r FROM RNyukinMotoShukan r")
public class RNyukinMotoShukan extends AbstractEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nyukin_moto_id")
	private int nyukinMotoId;

	private int version;

	//bi-directional one-to-one association to MNyukinMoto
	@OneToOne
	@JoinColumn(name="nyukin_moto_id")
	private MNyukinMoto MNyukinMoto;

	//bi-directional many-to-one association to MKokyakuBusho
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="busho_code", referencedColumnName="busho_code"),
		@JoinColumn(name="kokyaku_code", referencedColumnName="kokyaku_code")
		})
	private MKokyakuBusho MKokyakuBusho;

	public RNyukinMotoShukan() {
	}

	public int getNyukinMotoId() {
		return this.nyukinMotoId;
	}

	public void setNyukinMotoId(int nyukinMotoId) {
		this.nyukinMotoId = nyukinMotoId;
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

	public MKokyakuBusho getMKokyakuBusho() {
		return this.MKokyakuBusho;
	}

	public void setMKokyakuBusho(MKokyakuBusho MKokyakuBusho) {
		this.MKokyakuBusho = MKokyakuBusho;
	}

}