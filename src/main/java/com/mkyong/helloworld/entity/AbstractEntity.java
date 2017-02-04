package com.mkyong.helloworld.entity;

import javax.persistence.Column;
import javax.persistence.Version;

public abstract class AbstractEntity {
	@Version
	@Column(nullable = false)
	private int version = -666;

	abstract public int getVersion();

	abstract public void setVersion(int version);
}
