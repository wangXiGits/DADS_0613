package com.cloud.mina.util;

import org.apache.mina.core.session.IoSession;

import com.cloud.mina.milink.sportstate.SportsPacketHandleState;


public class HandleUtil {
	public static boolean abc(SportsPacketHandleState state,IoSession session, Object message){
		return state.handlePacket(session, message);
	}
}
