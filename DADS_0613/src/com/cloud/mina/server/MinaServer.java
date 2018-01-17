package com.cloud.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.cloud.mina.component.filter.ComponentIOFilter;
import com.cloud.mina.component.filter.MilinkBPComponent;
import com.cloud.mina.component.filter.MilinkSportComponent;
import com.cloud.mina.component.milink.bp.BPNo1LoginParer;
import com.cloud.mina.component.milink.bp.BPNo4SynsTimeParer;
import com.cloud.mina.component.milink.bp.BPNo8DataParer;
import com.cloud.mina.component.milink.sport.No8OneWayParser;
import com.cloud.mina.component.milink.sport.No8ThreeWayParser;
import com.cloud.mina.component.milink.sport.No8TwoWayParser;
import com.cloud.mina.component.milink.sport.SportLoginParser;
import com.cloud.mina.component.milink.sport.SportLogoutParser;
import com.cloud.mina.milink.strategy.StrategyFactoryHandler;

public class MinaServer {

	private static Logger log = Logger.getLogger(MinaServer.class);

	public static void main(String[] args) throws IOException {
		IoAcceptor acceptor = new NioSocketAcceptor(10);

		MilinkSportComponent milinkSportsComponent = new MilinkSportComponent();

		milinkSportsComponent.add(new SportLoginParser());
		milinkSportsComponent.add(new No8OneWayParser());
		milinkSportsComponent.add(new SportLogoutParser());
		milinkSportsComponent.add(new No8TwoWayParser());
		milinkSportsComponent.add(new No8ThreeWayParser());

		MilinkBPComponent milinkBPComponent = new MilinkBPComponent();
		milinkBPComponent.add(new BPNo1LoginParer());
		milinkBPComponent.add(new BPNo4SynsTimeParer());
		milinkBPComponent.add(new BPNo8DataParer());

		acceptor.getFilterChain().addLast("milinkSportsComponent", new ComponentIOFilter(milinkSportsComponent));
		acceptor.getFilterChain().addLast("milinkBPComponent", new ComponentIOFilter(milinkBPComponent));
		acceptor.getFilterChain().addLast("executors", new ExecutorFilter());
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30);
		acceptor.setHandler(new StrategyFactoryHandler());

		acceptor.bind(new InetSocketAddress(8891));

		log.info("Server is running...listening port 8891...");
	}
}
