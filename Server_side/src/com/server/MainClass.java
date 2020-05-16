package com.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner( System.in );
		System.out.println("start server ...");
		ServerSocket svc = new ServerSocket(6869);
		System.out.println("chọn chạy theo đa luồng hay đơn luồng");
		int num= input.nextInt();
		switch(num) {
			case 1:
				System.out.println(num);
				while(true) {
				Socket sc = svc.accept();
				System.out.println("server "+ sc.getLocalAddress().getHostName());
				DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
				for(int i = 0;i<15;i++) {
					dos.writeUTF(""+ i);
					Thread.sleep(1000);
				}
				}
			case 2:
				System.out.println(num);
				while(true) {
				ExecutorService executorService = Executors.newFixedThreadPool(2);
				executorService.execute(new Runnable() {
				    public void run() {
						DataOutputStream dos;
						try {
							Socket sc1 = svc.accept();
							System.out.println("server "+ sc1.getLocalAddress().getHostName());
							dos = new DataOutputStream(sc1.getOutputStream());
							for(int i = 0;i<15;i++) {
								dos.writeUTF(""+ i);
								Thread.sleep(1000);
								}
						} catch (IOException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				    }
				});
				
//				new Thread(new Runnable() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						DataOutputStream dos;
//						try {
//							dos = new DataOutputStream(sc1.getOutputStream());
//							for(int i = 0;i<15;i++) {
//								dos.writeUTF(""+ i);
//								Thread.sleep(1000);
//								}
//						} catch (IOException | InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}).start();
				}
				
				
		}
//		while(true) {
//			Socket sc = svc.accept();
//			System.out.println("server "+ sc.getLocalAddress().getHostName());
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					try {
//						DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
//						for(int i = 0;i<15;i++) {
//							dos.writeUTF(""+ i);
//							Thread.sleep(1000);
//						}
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					// TODO Auto-generated method stub
//					catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				}
//			}).start();
//		}
	}

}
