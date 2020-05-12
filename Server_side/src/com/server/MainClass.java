package com.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("start server ...");
		ServerSocket svc = new ServerSocket(6869);
		while(true) {
			Socket sc = svc.accept();
			System.out.println("server "+ sc.getLocalAddress().getHostName());
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
						for(int i = 0;i<15;i++) {
							dos.writeUTF(""+ i);
							Thread.sleep(1000);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// TODO Auto-generated method stub
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();
		}
	}

}
