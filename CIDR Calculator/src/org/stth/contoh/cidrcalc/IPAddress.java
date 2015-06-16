package org.stth.contoh.cidrcalc;

public class IPAddress {
	private String address;
	private int prefixMask;
	
	public IPAddress(String address, int prefix) {
		super();
		this.address = address;
		this.prefixMask = prefix;
	}
	public String getBinaryAddress(){
		return getBinaryAddress(address);
	}
	private String getBinaryAddress(String address){
		String[] s = address.split("\\.");
		String binaryAddress="";
		for (int i = 0; i < 4; i++) {
			binaryAddress = binaryAddress + getIPSegmentBinaryFromDecimal(Integer.parseInt(s[i]));
		}
		return binaryAddress;
	}
	private int getIPSegmentDecimalFromOktetBinaryString(String binaryString){
		int dec=0;
		for (int i = 0; i < 8; i++) {
			char x = binaryString.charAt(i);
			int idx = Character.getNumericValue(x);
			dec = dec + (idx * (int) Math.pow(2, 7-i));
		}
		return dec;
	}
	private String getIPDecimalFromBinary(String binaryString){
		String address="";
		String binarySegment1 = binaryString.substring(0, 8);
		String binarySegment2 = binaryString.substring(8, 16);
		String binarySegment3 = binaryString.substring(16, 24);
		String binarySegment4 = binaryString.substring(24, 32);
		address = getIPSegmentDecimalFromOktetBinaryString(binarySegment1)+"."+
				getIPSegmentDecimalFromOktetBinaryString(binarySegment2)+"."+
				getIPSegmentDecimalFromOktetBinaryString(binarySegment3)+"."+
				getIPSegmentDecimalFromOktetBinaryString(binarySegment4);
		return address;
	}
	private String getIPSegmentBinaryFromDecimal(int dec){
		
		//int dec = Integer.parseInt(s[n]);
		String octetBinary="";
		if (dec >= 128){
			octetBinary=octetBinary+"1";
			dec = dec - 128;
		} else octetBinary=octetBinary+"0";
		if (dec >= 64){
			octetBinary=octetBinary+"1";
			dec = dec - 64;
		} else octetBinary=octetBinary+"0";
		if (dec >= 32){
			octetBinary=octetBinary+"1";
			dec = dec - 32;
		} else octetBinary=octetBinary+"0";
		if (dec >= 16){
			octetBinary=octetBinary+"1";
			dec = dec - 16;
		} else octetBinary=octetBinary+"0";
		if (dec >= 8){
			octetBinary=octetBinary+"1";
			dec = dec - 8;
		} else octetBinary=octetBinary+"0";
		if (dec >= 4){
			octetBinary=octetBinary+"1";
			dec = dec - 4;
		} else octetBinary=octetBinary+"0";
		if (dec >= 2){
			octetBinary=octetBinary+"1";
			dec = dec - 2;
		} else octetBinary=octetBinary+"0";
		octetBinary=octetBinary+String.valueOf(dec);
		return octetBinary;
	}
	public String getBinaryNetmask(){
		StringBuilder sb = new StringBuilder(getBinaryAddress(address));
		for (int i = prefixMask; i < 32; i++) {
			sb.setCharAt(i, '0');
		}
		for (int i = 0; i < prefixMask; i++) {
			sb.setCharAt(i, '1');
		}
		return sb.toString();
	}
	public String getDecimalNetMask(){
		return getIPDecimalFromBinary(getBinaryNetmask());
	}
	public String getBinaryFirstHost(){
		StringBuilder sb = new StringBuilder(getBinaryAddress(address));
		for (int i = prefixMask; i < 31; i++) {
			sb.setCharAt(i, '0');
		}
		sb.setCharAt(31, '1');
		return sb.toString();
	}
	public String getDecimalFirstHost(){
		return getIPDecimalFromBinary(getBinaryFirstHost());
	}
	public String getBinaryLastHost(){
		StringBuilder sb = new StringBuilder(getBinaryAddress(address));
		for (int i = prefixMask; i < 31; i++) {
			sb.setCharAt(i, '1');
		}
		sb.setCharAt(31, '0');
		return sb.toString();
	}
	public String getDecimalLastHost(){
		return getIPDecimalFromBinary(getBinaryLastHost());
	}
	public String getBinaryBroadcast(){
		StringBuilder sb = new StringBuilder(getBinaryAddress(address));
		for (int i = prefixMask; i < 32; i++) {
			sb.setCharAt(i, '1');
		}
		return sb.toString();
	}
	public String getDecimalBroadcast(){
		return getIPDecimalFromBinary(getBinaryBroadcast());
	}
	
}
