package com.bornfire.xbrl.controllers;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt_Decrypt {


	 public static String decrypt( String strToDecrypt,String psuDeviceID) {
	        try {
	    		// strToDecrypt="{\"PhoneNumber\":\"23057777897\",\"AccountInfo\":{\"SchemeName\":\"BBAN\",\"AccountNumber\":\"020001057270\",\"AccountName\":\"\"},\"BankCode\":\"12\",\"Permissions\":[\"ReadAccountsDetails\",\"ReadBalances\",\"ReadTransactionsDetails\",\"DebitAccount\"]}";
	        	strToDecrypt="MANIVANNNAN";
	        	psuDeviceID="7ecc9d09dad0959e20220801110009ntkDGO2";
	            final byte[] iv = new byte[16];
	            final IvParameterSpec ivspec = new IvParameterSpec(iv);
	            final SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	            final KeySpec spec = new PBEKeySpec(psuDeviceID.toCharArray(), "Bcrypt0M@ur1u8@2022#".getBytes(), 65536, 256);
	            final SecretKey tmp = factory.generateSecret(spec);
	            final SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(2, secretKey, ivspec);
	            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));

	        }
	        catch (Exception e) {
	            System.out.println("Error while decrypting: " + e.toString());
	            return null;
	        
	        }
	    }
	    
	  public static String encrypt( String strToEncrypt,String psuDeviceID) {
	        try {
	        	strToEncrypt="{\"PhoneNumber\":\"23057777897\",\"AccountInfo\":{\"SchemeName\":\"BBAN\",\"AccountNumber\":\"020001057270\",\"AccountName\":\"\"},\"BankCode\":\"12\",\"Permissions\":[\"ReadAccountsDetails\",\"ReadBalances\",\"ReadTransactionsDetails\",\"DebitAccount\"]}";
	        	psuDeviceID="7ecc9d09dad0959e20220801110009ntkDGO2";

	            final byte[] iv = new byte[16];
	            System.out.println(iv.toString());
	            final IvParameterSpec ivspec = new IvParameterSpec(psuDeviceID.getBytes("UTF8"));
	            final SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	            final KeySpec spec = new PBEKeySpec(psuDeviceID.toCharArray(), "Bcrypt0M@ur1u8@2022#".getBytes(), 65536, 256);
	            final SecretKey tmp = factory.generateSecret(spec);
	            final SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	            cipher.init(1, secretKey, ivspec);
	            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
	        }
	        catch (Exception e) {
	            System.out.println("Error while encrypting: " + e.toString());
	            return null;
	        }
	    }
	 public static void main(String[] args) throws Exception {
		 String Ss = encrypt(null, null);
		 System.out.println(Ss);
	 }

}
