package com.mkyong.helloworld.entity;
// Generated Jan 28, 2017 1:11:14 AM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * KbKokyaku generated by hbm2java
 */
@Entity
@Table(name = "kb_kokyaku", catalog = "spring")
public class KbKokyaku implements java.io.Serializable {

	private String kubun;
	private int version;
	private String name;
	private Set<MKokyaku> MKokyakus = new HashSet<MKokyaku>(0);

	public KbKokyaku() {
	}

	public KbKokyaku(String kubun, String name) {
		this.kubun = kubun;
		this.name = name;
	}

	public KbKokyaku(String kubun, String name, Set<MKokyaku> MKokyakus) {
		this.kubun = kubun;
		this.name = name;
		this.MKokyakus = MKokyakus;
	}

	@Id

	@Column(name = "kubun", unique = true, nullable = false)
	public String getKubun() {
		return this.kubun;
	}

	public void setKubun(String kubun) {
		this.kubun = kubun;
	}

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kbKokyaku")
	public Set<MKokyaku> getMKokyakus() {
		return this.MKokyakus;
	}

	public void setMKokyakus(Set<MKokyaku> MKokyakus) {
		this.MKokyakus = MKokyakus;
	}

}
