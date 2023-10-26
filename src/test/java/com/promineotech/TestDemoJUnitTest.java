package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;



class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest	
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		
		// @formatter:off 
		 return Stream.of(
				arguments(3, 4, 7, false),
				arguments(1, 4, 5, false),
				arguments(1, 0, 2, true),
				arguments(1, -4, -3, true),
				arguments(3, -2, 1, true)			
				
				);						
		// @formatter:on 
	}


	@Test	
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(2,6)).isEqualTo(8);
		assertThat(testDemo.addPositive(30,70)).isEqualTo(100);
		assertThat(testDemo.addPositive(5,9)).isEqualTo(14);
		assertThat(testDemo.addPositive(55,23)).isEqualTo(78);
		
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForMultiplyNegative")
	void assertThatTwoNegativeNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.multiplyNegative(a,b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.multiplyNegative(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	/**
	 * 
	 * The method multiplyNegative() was tested with a Parameterized Test. 
	 * Arguments (see below) were used to provide values to the parameters and thereby test the validity of the method.
	 * 
	 * 
	 * 
	 */
	
	static Stream<Arguments> argumentsForMultiplyNegative() {
		
		// @formatter:off
		return Stream.of(
				arguments(-4, -6, 24, false),
				arguments(-3, -4, 12, false),
				arguments(0, -4, 0, true),
				arguments(-3, 4, -12, true)					
				
				);
		
		//@formatter:on
	}	
	
	/**
	 * 
	 * Creates a mocked version of the instance variable, testDemo. When getRandomInt()
	 * is called on mockDemo, return 5 instead of a random number. Call randomNumberSquared()
	 * on mockDemo. Assert that the returned number (which is 5) multiplied with itself gives 25.
	 * 
	 */

   @Test
   void assertThatNumberSquaredIsCorrect() {
	   TestDemo mockDemo = spy(testDemo);
	   doReturn(5).when(mockDemo).getRandomInt();
	   int fiveSquared = mockDemo.randomNumberSquared();
	   assertThat(fiveSquared).isEqualTo(25);
   };
}
	

	


