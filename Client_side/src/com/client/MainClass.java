package com.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("server side");
		try {
			Socket sc = new Socket("localhost",6869);
			DataInputStream dis = new DataInputStream(sc.getInputStream());
			for(int i=0;i<15;i++) {
				System.out.println("num "+ dis.readUTF());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
