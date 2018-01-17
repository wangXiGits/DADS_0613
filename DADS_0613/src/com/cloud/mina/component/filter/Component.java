package com.cloud.mina.component.filter;

import org.apache.mina.core.buffer.IoBuffer;

import com.cloud.mina.milink.sportpackage.PackageData;

/**
 * 解码器组件
 * 
 * @author Administrator
 * 
 */
public interface Component {
	public void add(Component t);

	public void remove(Component t);

	/**
	 * 
	 * @param buffer
	 * @return
	 */
	public PackageData getDataFromBuffer(IoBuffer buffer);

	public PackageData generateRealPackageData(IoBuffer buffer);
}
