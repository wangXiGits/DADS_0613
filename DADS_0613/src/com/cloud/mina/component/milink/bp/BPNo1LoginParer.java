//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : BPNo1LoginParer.java
//  @ Date : 2017/6/11
//  @ Author : 
//
//



package com.cloud.mina.component.milink.bp;

import org.apache.mina.core.buffer.IoBuffer;

import com.cloud.mina.component.filter.MilinkBPComponent;
import com.cloud.mina.milink.bppackage.BPNo1LoginPacket;
import com.cloud.mina.milink.sportpackage.PackageData;
import com.cloud.mina.util.DeviceIDResolver;


/** */
public class BPNo1LoginParer extends MilinkBPComponent
{
	public boolean check(IoBuffer buffer) {
		if(buffer.get(8)==1 && buffer.get(9)==16)
		{
			return true;
		}
		return false;
	}

	@Override
	public PackageData generateRealPackageData(IoBuffer buffer) {
		log.info(this.getClass().getSimpleName()+".generateRealPackageData() begin...");
		BPNo1LoginPacket data = new BPNo1LoginPacket();
		data.setName("bloodpressure");
		data.setType("login");
		String deviceId = DeviceIDResolver.getDeviceIDFromBytes(buffer.array(), 10);
		String password = DeviceIDResolver.getPasswordFromBytes(buffer.array(), 26);
		data.setDeviceID(deviceId);
		data.setPassword(password);
		data.setPatientID(DeviceIDResolver.searchPatientidByDeviceid(data.getDeviceID()));
		data.setAppType(DeviceIDResolver.searchAppTypeByDeviced(data.getDeviceID()));
		log.info("deviceID="+data.getDeviceID()+" patientID="+data.getPatientID());
		log.info(this.getClass().getSimpleName()+".generateRealPackageData() end.");
		return data;
	}

}
