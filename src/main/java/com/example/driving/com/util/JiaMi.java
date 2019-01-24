package com.example.driving.com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JiaMi {

	public String MD5Jiami(String instr) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			instr=new BigInteger(1,md5.digest(instr.getBytes())).toString(32);
			instr=new String (instr.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return instr;
	}
}
