package com.zhang.websocket;

import javax.websocket.ClientEndpoint;
import javax.websocket.Session;

@ClientEndpoint(
//		decoders={DrawingDecoder.class},
//		encoders={DrawingEncoder.class}
		)
public class DrawingClient {
	private Session session;
	

}
