package com.cloud.mina.component.filter;

import org.apache.mina.core.buffer.IoBuffer;

import com.cloud.mina.milink.sportpackage.PackageData;

public class MHRootComponent extends PacketFilterComponent {

	public PackageData generateRealPackageData(IoBuffer buffer) {
		return null;
	}

	@Override
	public boolean check(IoBuffer buffer) {
		return false;
	}
}
