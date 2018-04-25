package parser;

import utilities.Constants;
import utilities.MyDouble;

public class FeatureLibrary {
	/**
	 * This method tell us how big a^2 +b^7 compared to our boundary value 
	 * @param value
	 * @return
	 */
	public static boolean tooBig(Complex value) {
		MyDouble a = value.getReal();
		MyDouble b = value.getImag();
		MyDouble numOneSquared = a.square();
		double numOneSquaredDoubleVal = numOneSquared.doubleValue();
		double numOneDoubleVal = a.doubleValue();
		double numOneCubed = numOneSquaredDoubleVal * numOneDoubleVal;
		double numTwoDoubleVal = b.doubleValue();
		double numTwoRaisedToSeven = numTwoDoubleVal * numTwoDoubleVal * numTwoDoubleVal * numTwoDoubleVal * numTwoDoubleVal * numTwoDoubleVal * numTwoDoubleVal;
		double numOnePlusTwo= numOneCubed + numTwoRaisedToSeven;
		double v = Constants.BOUNDARY.doubleValue();
		if (numOnePlusTwo> v) {
			return true;
		} else {
			return false;
		}

	}
    /**
     * This method tell us how far the complex number is from its starting value 
     * @param startingValue
     * @return
     */
	public static int howFar(Complex startingValue) {
		Complex newNumber = new Complex(startingValue);
		int count = 1;
		if (FeatureLibrary.tooBig(newNumber)) {
			return 0;
		}
		for (int i = 0; i < Constants.LIMIT; i++) {
			newNumber = newNumber.multiply(newNumber);
			newNumber = newNumber.add(startingValue);
			if (FeatureLibrary.tooBig(newNumber)) {
				if (i == 0) {
					return 1;
				}
				return i + 1;
			}
			count++;
			if (count > Constants.LIMIT) {
				return -1;
			}
		}
		return count;
	}

}
