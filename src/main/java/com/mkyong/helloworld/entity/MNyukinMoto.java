package com.mkyong.helloworld.entity;
// Generated Mar 19, 2017 11:27:00 PM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * MNyukinMoto generated by hbm2java
 */
@Entity
@Table(name = "m_nyukin_moto", catalog = "spring")
public class MNyukinMoto extends AbstractEntity implements java.io.Serializable {

	private Integer id;
	private int version;
	private MKokyakuTantoBusho MKokyakuTantoBusho;
	private String hanbaiKubun;
	private Set<MKokyakuTantoBusho> MKokyakuTantoBushos = new HashSet<MKokyakuTantoBusho>(0);
	private MNyukinKakeInfo MNyukinKakeInfo;

	public MNyukinMoto() {
	}

	public MNyukinMoto(MKokyakuTantoBusho MKokyakuTantoBusho, String hanbaiKubun) {
		this.MKokyakuTantoBusho = MKokyakuTantoBusho;
		this.hanbaiKubun = hanbaiKubun;
	}

	public MNyukinMoto(MKokyakuTantoBusho MKokyakuTantoBusho, String hanbaiKubun,
			Set<MKokyakuTantoBusho> MKokyakuTantoBushos, MNyukinKakeInfo MNyukinKakeInfo) {
		this.MKokyakuTantoBusho = MKokyakuTantoBusho;
		this.hanbaiKubun = hanbaiKubun;
		this.MKokyakuTantoBushos = MKokyakuTantoBushos;
		this.MNyukinKakeInfo = MNyukinKakeInfo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tanto_kokyaku_code", referencedColumnName = "kokyaku_code", nullable = false),
			@JoinColumn(name = "tanto_busho_code", referencedColumnName = "busho_code", nullable = false) })
	public MKokyakuTantoBusho getMKokyakuTantoBusho() {
		return this.MKokyakuTantoBusho;
	}

	public void setMKokyakuTantoBusho(MKokyakuTantoBusho MKokyakuTantoBusho) {
		this.MKokyakuTantoBusho = MKokyakuTantoBusho;
	}

	@Column(name = "hanbai_kubun", nullable = false)
	public String getHanbaiKubun() {
		return this.hanbaiKubun;
	}

	public void setHanbaiKubun(String hanbaiKubun) {
		this.hanbaiKubun = hanbaiKubun;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MNyukinMoto")
	public Set<MKokyakuTantoBusho> getMKokyakuTantoBushos() {
		return this.MKokyakuTantoBushos;
	}

	public void setMKokyakuTantoBushos(Set<MKokyakuTantoBusho> MKokyakuTantoBushos) {
		this.MKokyakuTantoBushos = MKokyakuTantoBushos;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "MNyukinMoto")
	public MNyukinKakeInfo getMNyukinKakeInfo() {
		return this.MNyukinKakeInfo;
	}

	public void setMNyukinKakeInfo(MNyukinKakeInfo MNyukinKakeInfo) {
		this.MNyukinKakeInfo = MNyukinKakeInfo;
	}

}
