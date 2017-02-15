package com.mkyong.helloworld.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the m_kokyaku_busho database table.
 * 
 */
@Entity
@Table(name = "m_kokyaku_busho")
@NamedQuery(name = "MKokyakuBusho.findAll", query = "SELECT m FROM MKokyakuBusho m")
public class MKokyakuBusho extends AbstractEntity {

	@EmbeddedId
	private MKokyakuBushoPK id;

	@Column(name = "sekininsha_name")
	private String sekininshaName;

	@Column(name = "shohizei_kubun")
	private String shohizeiKubun;

	@Version
	private int version;

	// bi-directional many-to-one association to MBusho
	@ManyToOne
	@JoinColumn(name = "busho_code")
	private MBusho MBusho;

	// bi-directional many-to-one association to MKokyaku
	@ManyToOne
	@JoinColumn(name = "kokyaku_code")
	private MKokyaku MKokyaku;

	// bi-directional many-to-one association to RKokyakuNyukinMoto
	@OneToMany(mappedBy = "MKokyakuBusho")
	private List<RKokyakuNyukinMoto> RKokyakuNyukinMotos;

	// bi-directional many-to-one association to RNyukinMotoShukan
	@OneToMany(mappedBy = "MKokyakuBusho")
	private List<RNyukinMotoShukan> RNyukinMotoShukans;

	public MKokyakuBusho() {
	}

	public MKokyakuBushoPK getId() {
		return this.id;
	}

	public void setId(MKokyakuBushoPK id) {
		this.id = id;
	}

	public String getSekininshaName() {
		return this.sekininshaName;
	}

	public void setSekininshaName(String sekininshaName) {
		this.sekininshaName = sekininshaName;
	}

	public String getShohizeiKubun() {
		return this.shohizeiKubun;
	}

	public void setShohizeiKubun(String shohizeiKubun) {
		this.shohizeiKubun = shohizeiKubun;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MBusho getMBusho() {
		return this.MBusho;
	}

	public void setMBusho(MBusho MBusho) {
		this.MBusho = MBusho;
	}

	public MKokyaku getMKokyaku() {
		return this.MKokyaku;
	}

	public void setMKokyaku(MKokyaku MKokyaku) {
		this.MKokyaku = MKokyaku;
	}

	public List<RKokyakuNyukinMoto> getRKokyakuNyukinMotos() {
		return this.RKokyakuNyukinMotos;
	}

	public void setRKokyakuNyukinMotos(List<RKokyakuNyukinMoto> RKokyakuNyukinMotos) {
		this.RKokyakuNyukinMotos = RKokyakuNyukinMotos;
	}

	public RKokyakuNyukinMoto addRKokyakuNyukinMoto(RKokyakuNyukinMoto RKokyakuNyukinMoto) {
		getRKokyakuNyukinMotos().add(RKokyakuNyukinMoto);
		RKokyakuNyukinMoto.setMKokyakuBusho(this);

		return RKokyakuNyukinMoto;
	}

	public RKokyakuNyukinMoto removeRKokyakuNyukinMoto(RKokyakuNyukinMoto RKokyakuNyukinMoto) {
		getRKokyakuNyukinMotos().remove(RKokyakuNyukinMoto);
		RKokyakuNyukinMoto.setMKokyakuBusho(null);

		return RKokyakuNyukinMoto;
	}

	public List<RNyukinMotoShukan> getRNyukinMotoShukans() {
		return this.RNyukinMotoShukans;
	}

	public void setRNyukinMotoShukans(List<RNyukinMotoShukan> RNyukinMotoShukans) {
		this.RNyukinMotoShukans = RNyukinMotoShukans;
	}

	public RNyukinMotoShukan addRNyukinMotoShukan(RNyukinMotoShukan RNyukinMotoShukan) {
		getRNyukinMotoShukans().add(RNyukinMotoShukan);
		RNyukinMotoShukan.setMKokyakuBusho(this);

		return RNyukinMotoShukan;
	}

	public RNyukinMotoShukan removeRNyukinMotoShukan(RNyukinMotoShukan RNyukinMotoShukan) {
		getRNyukinMotoShukans().remove(RNyukinMotoShukan);
		RNyukinMotoShukan.setMKokyakuBusho(null);

		return RNyukinMotoShukan;
	}

}