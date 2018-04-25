package parser;

import utilities.MyDouble;

/**
 * @author Tewodros Kasahun
 */
public class Complex {
	private final MyDouble real;
	private final MyDouble imag;
	private static long numberCreated = 0;

	public Complex(MyDouble realIn, MyDouble imagIn) {
		real = realIn;
		imag = imagIn;
		numberCreated++;
	}

	public Complex(MyDouble realIn) {

		real = realIn;
		imag = MyDouble.zero;
		numberCreated++;

	}

	public Complex(Complex orig) {

		real = orig.getReal();
		imag = orig.getImag();
		numberCreated++;
	}

	public Complex add(Complex param) {
		Complex added = new Complex(this.getReal().add(param.getReal()), this.getImag().add(param.getImag()));
		return added;
	}

	public Complex subtract(Complex param) {
		Complex subtracted = new Complex(this.getReal().subtract(param.getReal()),
				this.getImag().subtract(param.getImag()));
		return subtracted;
	}
    /**
     * This method multiply two complex numbers 
     * @param param
     * @return
     */
	public Complex multiply(Complex param) {
		MyDouble r1r2 = this.getReal().multiply(param.getReal());
		MyDouble r1i2 = this.getReal().multiply(param.getImag());
		MyDouble i1r2 = this.getImag().multiply(param.getReal());
		MyDouble i1i2 = this.getImag().multiply(param.getImag());
		MyDouble prodImg = MyDouble.zero.subtract(i1i2);
		MyDouble sum1 = r1r2.add(prodImg);
		MyDouble sum2 = r1i2.add(i1r2);
		Complex multiplyed = new Complex(sum1, sum2);
		return multiplyed;
	}
    /**
     * This method will divide two complex numbers
     * @param param
     * @return
     */
	public Complex divide(Complex param) {
		MyDouble ac = this.getReal().multiply(param.getReal());
		MyDouble bd = this.getImag().multiply(param.getImag());
		MyDouble sum1 = ac.add(bd);
		MyDouble cSquar = param.getReal().square();
		MyDouble dSquar = param.getImag().square();
		MyDouble cd = cSquar.add(dSquar);
		MyDouble real1 = sum1.divide(cd);
		MyDouble bc = this.getImag().multiply(param.getReal());
		MyDouble ad = this.getReal().multiply(param.getImag());
		MyDouble bcMinsad = bc.subtract(ad);
		MyDouble image1 = bcMinsad.divide(cd);
		Complex divided = new Complex(real1, image1);
		return divided;
	}
    /**
     * Compare two complex numbers 
     * @param param
     * @return
     */
	public int compareTo(Complex param) {
		int result;
		if (this.norm().compareTo(param.norm()) == 1) {
			result = 1;
		} else if (this.norm().compareTo(param.norm()) == 0) {
			result = 0;
		} else {
			result = -1;
		}
		return result;
	}

	public String toString() {
		if (real.isZero()) {
			return imag.toString() + "i";
		} else if (imag.isZero()) {
			return real.toString();
		} else {
			if (imag.compareTo(MyDouble.zero) == 1 && real.compareTo(MyDouble.zero) == 1) {
				return real.toString() + "+" + imag.toString() + "i";
			} else if (imag.compareTo(MyDouble.zero) == -1) {
				String tostring = real.toString() + imag.toString() + "i";
				return tostring;
			} else {
				return real.toString() + "+" + imag.toString() + "i";

			}
		}
	}
    /**
     * it norm two complex numbers 
     * @return
     */
	public MyDouble norm() {
		MyDouble aSquar = this.getReal().square();
		MyDouble bSquare = this.getImag().square();
		MyDouble sum = aSquar.add(bSquare);
		MyDouble result = sum.sqrt();
		return result;
	}
     /**
      * This method will parse a string into double
      * @param thingToParse
      * @return
      */
	public static Complex parseComplex(String thingToParse) {
		String trimed = thingToParse.trim();
		String insidTrim = trimed.replaceAll("\\s+", "");
		int strlen = insidTrim.length();
		if (strlen == 1) {
			String realAndImage = insidTrim.substring(0, strlen);
			double theImag = Double.parseDouble(realAndImage);
			if (theImag == 0) {
				MyDouble realFinal = new MyDouble(0);
				MyDouble imageFinal = new MyDouble(0);
				Complex parse = new Complex(realFinal, imageFinal);
				return parse;
			}
		}
		
		int indeOfPlus = insidTrim.indexOf("+");

		if (indeOfPlus == -1) {
			String stringToAvoidFirstMin = insidTrim.substring(1, strlen);

			int indesofMinus = stringToAvoidFirstMin.indexOf("-");
			String realString = insidTrim.substring(0, indesofMinus + 1);
			double thereal = Double.parseDouble(realString);
			String imagString = insidTrim.substring(indesofMinus + 1, strlen - 1);
			double theImag = Double.parseDouble(imagString);
			MyDouble realFinal = new MyDouble(thereal);
			MyDouble imageFinal = new MyDouble(theImag);
			Complex parse = new Complex(realFinal, imageFinal);
			return parse;
		} else {
			String realString = insidTrim.substring(0, indeOfPlus);
			double thereal = Double.parseDouble(realString);
			String imagString = insidTrim.substring(indeOfPlus + 1, strlen - 1);
			double theImag = Double.parseDouble(imagString);
			MyDouble realFinal = new MyDouble(thereal);
			MyDouble imageFinal = new MyDouble(theImag);
			Complex parse = new Complex(realFinal, imageFinal);
			return parse;
		}
	}
    /**
     * This method will return the number of created complex number 
     * @return
     */
	public static long getNumberCreated() {
		return numberCreated;
	}

	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (this.getClass() != other.getClass()) {
			return false;
		} else {
			Complex casted = (Complex) other;
			return this.real.equals(casted.real) && this.imag.equals(casted.imag);
		}
	}

	public MyDouble getReal() {
		return real;
	}

	public MyDouble getImag() {
		return imag;
	}

}
