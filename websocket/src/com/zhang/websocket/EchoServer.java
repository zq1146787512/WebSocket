package com.zhang.websocket;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/echo")
public class EchoServer {
	@OnOpen
	public String cas(){
		return "sds";
	}
	@OnMessage
	public String echo(String incomingMessage){
		return "I got this("+incomingMessage+")"+"so i am sending it back";
	}

}