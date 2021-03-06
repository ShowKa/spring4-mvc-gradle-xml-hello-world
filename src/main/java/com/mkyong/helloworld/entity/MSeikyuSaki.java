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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * MSeikyuSaki generated by hbm2java
 */
@Entity
@Table(name = "m_seikyu_saki", catalog = "spring")
public class MSeikyuSaki extends AbstractEntity implements java.io.Serializable {

	private Integer id;
	private int version;
	private String seikyushoSakuseiTanto;
	private String seikyuKubun;
	private String seikyuSakiName;
	private Set<MKokyakuTantoBusho> MKokyakuTantoBushos = new HashSet<MKokyakuTantoBusho>(0);

	public MSeikyuSaki() {
	}

	public MSeikyuSaki(String seikyushoSakuseiTanto, String seikyuKubun, String seikyuSakiName) {
		this.seikyushoSakuseiTanto = seikyushoSakuseiTanto;
		this.seikyuKubun = seikyuKubun;
		this.seikyuSakiName = seikyuSakiName;
	}

	public MSeikyuSaki(String seikyushoSakuseiTanto, String seikyuKubun, String seikyuSakiName,
			Set<MKokyakuTantoBusho> MKokyakuTantoBushos) {
		this.seikyushoSakuseiTanto = seikyushoSakuseiTanto;
		this.seikyuKubun = seikyuKubun;
		this.seikyuSakiName = seikyuSakiName;
		this.MKokyakuTantoBushos = MKokyakuTantoBushos;
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

	@Column(name = "seikyusho_sakusei_tanto", nullable = false)
	public String getSeikyushoSakuseiTanto() {
		return this.seikyushoSakuseiTanto;
	}

	public void setSeikyushoSakuseiTanto(String seikyushoSakuseiTanto) {
		this.seikyushoSakuseiTanto = seikyushoSakuseiTanto;
	}

	@Column(name = "seikyu_kubun", nullable = false)
	public String getSeikyuKubun() {
		return this.seikyuKubun;
	}

	public void setSeikyuKubun(String seikyuKubun) {
		this.seikyuKubun = seikyuKubun;
	}

	@Column(name = "seikyu_saki_name", nullable = false)
	public String getSeikyuSakiName() {
		return this.seikyuSakiName;
	}

	public void setSeikyuSakiName(String seikyuSakiName) {
		this.seikyuSakiName = seikyuSakiName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MSeikyuSaki")
	public Set<MKokyakuTantoBusho> getMKokyakuTantoBushos() {
		return this.MKokyakuTantoBushos;
	}

	public void setMKokyakuTantoBushos(Set<MKokyakuTantoBusho> MKokyakuTantoBushos) {
		this.MKokyakuTantoBushos = MKokyakuTantoBushos;
	}

}
