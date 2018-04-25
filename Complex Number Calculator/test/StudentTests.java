package test;

import static org.junit.Assert.*;

import org.junit.Test;

import parser.Complex;
import parser.FeatureLibrary;
import utilities.MyDouble;

public class StudentTests {

	public void testStringHelper(double real, double imag, String str) {
		Complex complexValue = new Complex(new MyDouble(real), new MyDouble(imag));

		assertEquals(complexValue.toString(), str);
	}

	@Test
	public void testString() {
		testStringHelper(5.3, 2, "5.3+2i");
		testStringHelper(5.3, 0, "5.3");
		testStringHelper(0, 2, "2i");
		testStringHelper(5.3, -2, "5.3-2i");
		testStringHelper(-5.3, -2, "-5.3-2i");
		testStringHelper(-5.3, 2, "-5.3+2i");

	}

	public void testAdditionHelper(double real1, double imag1, double real2, double imag2, double real3, double imag3) {
		Complex first = new Complex(new MyDouble(real1), new MyDouble(imag1));
		Complex second = new Complex(new MyDouble(real2), new MyDouble(imag2));
		Complex sum = new Complex(new MyDouble(real3), new MyDouble(imag3));

		assertEquals(first.add(second), sum);
	}

	@Test
	public void testAdd() {
		testAdditionHelper(23.4, 23.5, 235.53, 527.24, 258.93, 550.74);
	}

	public void testParsingHelper(String str, double real, double imag) {
		Complex parseResult = Complex.parseComplex(str);
		Complex correctResult = new Complex(new MyDouble(real), new MyDouble(imag));

		assertEquals(correctResult, parseResult);
	}

	public void testMultiplicationHelper(double real1, double imag1, double real2, double imag2, double real3,
			double imag3) {

		Complex first = new Complex(new MyDouble(real1), new MyDouble(imag1));
		Complex second = new Complex(new MyDouble(real2), new MyDouble(imag2));
		Complex sum = new Complex(new MyDouble(real3), new MyDouble(imag3));

		assertEquals(first.multiply(second), sum);
	}

	@Test
	public void testMultiplication() {
		testMultiplicationHelper(2.0, 3.0, 4.0, 5.0, -7, 22);
	}

	public void testDivideHelper(double real1, double imag1, double real2, double imag2, double real3, double imag3) {

		Complex first = new Complex(new MyDouble(real1), new MyDouble(imag1));
		Complex second = new Complex(new MyDouble(real2), new MyDouble(imag2));
		Complex sum = new Complex(new MyDouble(real3), new MyDouble(imag3));

		assertEquals(first.divide(second), sum);
	}

	@Test
	public void testDdivide() {
		testDivideHelper(16.0, -2.0, 3.0, -2.0, 4.0, 2.0);
	}

	@Test
	public void testParse() {
		// YOU PUT YOUR SPECIFICS OF WHAT TO TEST DOWN HERE, USING THE HELPER
		// FOR EXAMPLE:
		testParsingHelper("1+2i", 1, 2);
		testParsingHelper("    1 + 2 i", 1, 2);
		testParsingHelper("-1-2i", -1, -2);
		testParsingHelper("1-2i", 1, -2);
		testParsingHelper("    -1 + 2 i", -1, 2);
		testParsingHelper("    0  ", 0, 0);
		testParsingHelper("   4+ 0i  ", 4, 0);
	}

	public void testCompareToHelper(double real1, double imag1, double real2, double imag2, int real3) {

		Complex first = new Complex(new MyDouble(real1), new MyDouble(imag1));
		Complex second = new Complex(new MyDouble(real2), new MyDouble(imag2));
		int sum1 = real3;

		assertEquals(first.compareTo(second), sum1);
	}

	@Test
	public void testCompareTo() {
		testCompareToHelper(4.0, 3.0, 4.0, 3.0, 0);
		testCompareToHelper(4.0, 3.0, 10.0, 10.0, -1);
		testCompareToHelper(10.0, 10.0, 4.0, 3.0, 1);
	}

	public void testTooBigHelper(double real1, double imag1, boolean result) {
		Complex num = new Complex(new MyDouble(real1), new MyDouble(imag1));
		assertEquals(FeatureLibrary.tooBig(num), result);
	}

	@Test
	public void testTooBig() {
		testTooBigHelper(3, 4, false);
		testTooBigHelper(32, 64, true);
	}

	public void testHowFarHelper(double real1, double imag1, int result) {
		Complex num = new Complex(new MyDouble(real1), new MyDouble(imag1));
		assertEquals(FeatureLibrary.howFar(num), result);
	}

	@Test
	public void testHowFar() {
		testHowFarHelper(0.4, 0.4, 11);
		testHowFarHelper(32, 64, 0);
		testHowFarHelper(1.1, 1.1, 2);
		testHowFarHelper(0.4, 0.4, 11);
		testHowFarHelper(3, 4, 1);
		testHowFarHelper(0.12, 0.6, -1);

	}

}
