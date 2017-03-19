package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;

public interface NyukinKakeInfoService {

	public void validate(NyukinKakeInfoDomain domain);

	public void register(NyukinKakeInfoDomain domain);
}
