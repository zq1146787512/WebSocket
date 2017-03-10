<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
  	var echo_websocket;
  	
  	function init(){
  		output=document.getElementById("output");
  		
  	}
  	
  	
  	
  	function send_echo(){
  		var wsUri="ws://localhost:8080/websocket/echo";
  		writeToScreen("Connecting to "+wsUri);
  		echo_websocket=new WebSocket(wsUri);
  		echo_websocket.onopen=function (evt){
  		/* alert("11"+evt.data); */
  			writeToScreen("Connected !");
  			doSend(textID.value);			
  		};
  		echo_websocket.onmessage= function (evt){
  		/* alert("22"+evt.data); */
  			writeToScreen("Received message:"+evt.data);
  			echo_websocket.close();		
  		};
  		echo_websocket.onerror= function (evt){
  		/* alert("33"+evt.data); */
  			writeToScreen('<span style="color: red;">error:</span>'+evt.data);
  			
  			echo_websocket.close();
  			
  		};	
  	}
  	function doSend(message){
  		echo_websocket.send(message);
  		writeToScreen("Send message:"+message);
  		
  	}
  	
  	function writeToScreen(message){
  		var pre=document.createElement("p");
  		pre.style.wordWrap="break-word";
  		pre.innerHTML=message;
  		output.appendChild(pre);
  	}
  	
  	
  	window.addEventListener("load",init,false);
  	
  </script>
  
  <body>
   <h1>Echo Server</h1>
   
   <div style="text-align: left;">
   		<form action="echo">
   			<input onclick="send_echo()" value="Press to send" type="button" />
   			<input id="textID" name="message" value="Hello Web Sockets" type="text"/>
   			<br>
   		</form>
   </div>
   <div id="output"></div>
  </body>
</html>
