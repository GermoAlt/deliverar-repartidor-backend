package com.uade.repartidorback.configuration;

import com.uade.repartidorback.models.Mensaje;
import com.uade.repartidorback.services.MensajeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

@Configuration
public class ConnectToWebSocket extends StompSessionHandlerAdapter{

	Logger logger = LoggerFactory.getLogger(ConnectToWebSocket.class);

	@Autowired
	MensajeService mensajeService;

	 @Override
	 public void afterConnected(StompSession session, StompHeaders headers) {
		 session.subscribe("/topic/repartidor", this);
	     String message = "one-time message from client";
		 session.send("/app/repartidor", message);
	 }
	 
	 @Override
	 public Type getPayloadType(StompHeaders headers) {
		 return Mensaje.class;
	  }
	 
	  @Override
	  public void handleFrame(StompHeaders headers, Object payload) {
		  Mensaje msg = (Mensaje) payload;
		  logger.info("Contenido: {}" , msg.getContenido());
		  logger.info("Emisor: " + msg.getEmisor());
		  mensajeService.guardarMensaje(msg);
	   }
	   
	   @Override
	   public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
		   logger.info("Error: " + exception.getMessage());
	   }
	   @Override
	   public void handleTransportError(StompSession session, Throwable exception) {
		   logger.info("Error: " + exception.getMessage());
	   }

}
