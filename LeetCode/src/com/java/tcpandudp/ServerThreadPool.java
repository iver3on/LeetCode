package com.java.tcpandudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadPool implements Runnable {
	
	Socket socket = null;
	int count = 0;
	public ServerThreadPool(Socket socket,int count) {
		this.socket = socket;
		this.count =count;
	}

	// 线程执行的操作，响应客户端请求
	@Override
	public void run() {
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		OutputStream os = null;
		BufferedReader bf = null;
		PrintWriter pwWriter = null;
		try {
			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bf = new BufferedReader(inputStreamReader);
			String info = null;
			while ((info = bf.readLine()) != null) {
				System.out.println("我是服务器端，客户端发送过来是：" + info);
			}
			os = socket.getOutputStream();
			pwWriter = new PrintWriter(os);
			pwWriter.write("欢迎亲登录。。。"+count);
			pwWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pwWriter != null)
					pwWriter.close();
				if (os != null)
					os.close();
				if (bf != null)
					bf.close();
				if (inputStreamReader != null)
					inputStreamReader.close();
				if (inputStream != null)
					inputStream.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
