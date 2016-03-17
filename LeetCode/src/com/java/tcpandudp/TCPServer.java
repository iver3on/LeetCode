package com.java.tcpandudp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TCPServer {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8888);
		Executor service = Executors.newScheduledThreadPool(5);  
		int count = 0;
		while(true){
				System.out.println("我是服务器端，我正在监听客户端请求...ss");
				Socket socket = serverSocket.accept();
				count++;
				service.execute(new ServerThreadPool(socket, count));  
				System.out.println("客户IP：" + socket.getInetAddress());
				System.out.println("目前登录人数：" + count);
			}	
	}
	
}