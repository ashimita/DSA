package com.sriashi.fundamentals;

/**
 * Class for encrypting and decrypting using Caeser Cipher
 * 
 * Encoder: DEFGHIJKLMNOPQRSTUVWXYZABC
 * Decoder: XYZABCDEFGHIJKLMNOPQRSTUVW
 * 
 * @author ashimita
 *
 */
public class CaesearCipher {

	private char[] encoder = new char[26];
	private char[] decoder = new char[26];

	public CaesearCipher(int rotation) {
		for (int i = 0; i < 26; i++) {
			encoder[i] = (char) ('A' + (i + rotation) % 26);
			decoder[i] = (char) ('A' + (i + 26 - rotation) % 26);
		}
	}
	
	private String encrypt(String message){
		return transform(message, encoder);
	}
	
	private String decrypt(String secret) {
		return transform(secret, decoder);
	}

	private String transform(String original, char[] code) {
		char[] msg = original.toCharArray();
		for (int i = 0; i < msg.length; i++) {
			if (Character.isUpperCase(msg[i])) {
				int j = msg[i] - 'A';
				msg[i] = code[j];
			}
		}
		return new String(msg);
	}

	public static void main(String[] args) {
      CaesearCipher cipher = new CaesearCipher(3);
      System.out.println("Encryption code: "+new String(cipher.encoder));
      System.out.println("Decryption code: "+new String(cipher.decoder));
      System.out.println("**********");
      String encrypted = cipher.encrypt("RIJU IS A GOOD MEOW MEOW!");
      System.out.println("Encrypted: "+encrypted);
      String decrypted = cipher.decrypt(encrypted);
      System.out.println("DEcrypted: "+decrypted);
	}

}
