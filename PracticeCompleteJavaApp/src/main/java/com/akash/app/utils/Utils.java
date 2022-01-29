package com.akash.app.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	private final Random random = new SecureRandom();
	private final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);

		for (int itr = 0; itr < length; itr++) {
			returnValue.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}
		return new String(returnValue);
	}

}
