package com.promineotech;
import java.util.*;

public class TestDemo {
	public int addPositive(int a, int b) {
		int sum = a + b;
		if(a > 0 && b > 0) {
			return sum; } else {
				throw new IllegalArgumentException("Both parameters must be positive!");
		}	

	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 *           if a and b are negative numbers, multiply, otherwise
	 *           throw an IllegalArgumentException with message.
	 * 
	 * 
	 * 
	 */
	
	public int multiplyNegative(int a, int b) {
			int product = a * b;
			if(a < 0 && b < 0) {
				return product; } else {
					throw new IllegalArgumentException("Both parameters must be negative!");
				}
	
	}
	
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number * number;
		
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
};
