package com.cloud.mina.milink.bpstate;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

public interface BloodPressurePacketHandleState {
	public static Logger log = Logger.getLogger(BloodPressurePacketHandleState.class);
	public boolean handlePacket(IoSession session,Object message);
}
