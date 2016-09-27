package com.mkyong.helloworld.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@Column(name = "country_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int country_id;

	@Column(name = "country", nullable = false)
	public String country;

}
