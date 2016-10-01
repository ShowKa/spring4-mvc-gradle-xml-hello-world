package com.mkyong.helloworld.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@Column(name = "country_id", nullable = false)
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int country_id;

	@Column(name = "country", nullable = false)
	public String country;

	@Column(name = "last_update", nullable = false)
	public Timestamp lastUpdate;

}
