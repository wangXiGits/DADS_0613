package com.cloud.mina.milink.sportstate;

import org.apache.mina.core.session.IoSession;

public interface SportsPacketHandleState {
	public boolean handlePacket(IoSession session, Object message);

}
