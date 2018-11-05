package system;

import java.net.*;

import sellerFrame.SellerLogIn;

import java.io.*;  
class Seller{  
	DataInputStream din;
	DataOutputStream dout;
	BufferedReader br;
	public Seller(){
		new SellerLogIn();
	}

	public static void main(String[] args) {
		new Seller();
	}

	private void sendMessage(DataOutputStream dout, BufferedReader br,
		String str) throws IOException {
		String str2;  
		str2=br.readLine();  
		dout.writeUTF(str2);  
		dout.flush();  
	
	}
	
	private String readMessage(DataInputStream din, BufferedReader br,
			String str) throws IOException {
			str=din.readUTF();  
			System.out.println("client says: "+str);   
			return str;
		}
	
}  
