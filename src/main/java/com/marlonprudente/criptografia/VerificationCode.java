/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marlonprudente.criptografia;

/**
 *
 * @author Marlon
 */
/**
 * 
 * @author Jayr Motta
 *
 */
public class VerificationCode {
	public static String verificationCode;
	/*
	 * This define the default length of verification code
	 */
	public static int length = 12;
	/*
	 * Here is the allowed characters in the verification code
	 */
	public static char[] allowedCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
			'W', 'X', 'Y', 'Z'};
	public VerificationCode() {
		this.setVerificationCode(this.generateVerificationCode());
	}
	/*
	 * This constructor set the length of the verification code
	 */
	public VerificationCode(int length) {
		this.setLength(length);
		this.setVerificationCode(this.generateVerificationCode());
	}
	/*
	 * This core method generate the verification code and return him
	 */
	public static String generateVerificationCode() {
		String tmp = "";
		for (int i = 0; i < getLength(); i++) {
			int c = (int) Math.floor(Math.random()*getAllowedCharacters().length);
			tmp += getAllowedCharacters()[c];
		}
		return tmp;
	}
	public static String getVerificationCode() {
		return verificationCode;
	}
	public static void setVerificationCode(String verificationCode) {
		verificationCode = verificationCode;
	}
	public static int getLength() {
		return length;
	}
	public static void setLength(int tam) {
		length = tam;
	}
	//public static String toString() {
	//	return getVerificationCode();
	//}
	public static char[] getAllowedCharacters() {
		return allowedCharacters;
	}
}
