//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SportNo8TwoWayState.java
//  @ Date : 2017/6/11
//  @ Author : 
//
//

package com.cloud.mina.milink.sportstate;

import org.apache.mina.core.session.IoSession;

import com.cloud.mina.milink.sportpackage.No8TwoWayPacket;
import com.cloud.mina.util.PropertiesReader;
import com.cloud.mina.util.SaveSportsNo8PacketUtil;

/** */
public class SportNo8TwoWayState implements SportsPacketHandleState {
	public boolean handlePacket(IoSession session, Object message) {
		//		log.info(this.getClass().getSimpleName()+".handlePacket() begin...");
		No8TwoWayPacket packet = null;
		boolean result = false;
		if (message != null && message instanceof No8TwoWayPacket) {
			packet = (No8TwoWayPacket) message;
			if (packet.getPatientID() != null
					&& !"".equals(packet.getPatientID())) {
				session.setAttribute("patientId", packet.getPatientID());
				session.setAttribute("deviceId", packet.getDeviceID());
				session.setAttribute("company", packet.getCompany());
			}
			//数据存储入库
			for (int i = 0; i < packet.getStepcount2data().size(); i++) {
				if ("true".equals(PropertiesReader.getProp("isNewSport"))) {
					SaveSportsNo8PacketUtil.saveNewSportDetail(session, packet
							.getStepcount2data().get(i), packet.getStepdate()
							.get(i));

				} else {
					SaveSportsNo8PacketUtil.insertNo8DataForTwoWay(
							(String) session.getAttribute("patientId"),
							(String) session.getAttribute("company"),
							(String) session.getAttribute("deviceId"), packet
									.getStepcount2data().get(i), packet
									.getStepdate().get(i));
				}
			}
			//益体康、易兴等设备根据详细包分析出的有效步数包
			//			if(packet.isHasEffective()){
			//				for(int i=0;i<packet.getStepEffective().size();i++){
			//					if("true".equals(PropertiesReader.getProp("isNewSport"))){
			//						result = SaveSportsNo8PacketUtil.saveNewSportEffective(session, packet.getStepEffective().get(i),packet.getStepdate().get(i));
			//						
			//					}else{
			//						result = SaveSportsNo8PacketUtil.insertNo8DataForFourWay((String)session.getAttribute("patientId"), (String)session.getAttribute("company"), (String)session.getAttribute("deviceId"), packet.getStepEffective().get(i), packet.getStepdate().get(i));
			//					}
			//				}
			//			}
			//			if(result){
			SaveSportsNo8PacketUtil.sendNo8Ack(session, true, 2);
			//			}

			//通过观察者发送数据
			if ("true".equals(PropertiesReader.getProp("isNewSport"))) {
				//				SubjectFactory.getSubject((String)session.getAttribute("appType"), PropertiesReader.getProp("DATATYPE_STEPDETAIL")).notifyObserver();
			}
			//			log.info(this.getClass().getSimpleName()+".handlePacket() end.");
			return true;
		}
		return false;
	}
}
