package org.stth.contoh.cidrcalc;

public class CobaIP {
	public static void main(String[] args) {
		IPAddress ip = new IPAddress("172.20.1.134", 24);
		System.out.println(ip.getBinaryAddress());
		System.out.println(ip.getBinaryNetmask());
		System.out.println(ip.getDecimalNetMask());
		System.out.println(ip.getBinaryFirstHost());
		System.out.println(ip.getDecimalFirstHost());
		System.out.println(ip.getBinaryLastHost());
		System.out.println(ip.getDecimalLastHost());
		System.out.println(ip.getBinaryBroadcast());
		System.out.println(ip.getDecimalBroadcast());
	}

}
