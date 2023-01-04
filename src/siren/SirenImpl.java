package siren;

public class SirenImpl implements Siren
{
	@Override
	public boolean checkSirenValidity(String siren)
	{
		if (siren.length() != 9) // siren must contains exactly 9 characters
			return false;
		else
		{
			int sum = computeSirenSum(siren);
			return	sum % 10 == 0;
		}
	}

	@Override
	public String computeFullSiren(String sirenWithoutControlNumber)
	{
		int sum = computeSirenSum(sirenWithoutControlNumber);
		int lastDigit = sum % 10;
		if (lastDigit != 0)
			lastDigit = 10 - lastDigit;
		char controlNumber = Character.forDigit(lastDigit, 10);
		return sirenWithoutControlNumber + controlNumber;
	}
	// compute the sum as described by the Lugh algorithm with full siren or siren without control number
	
	private int computeSirenSum(String sirenWithOrWithoutControlNumber)
	{
		int sum = 0;
		for (int i=sirenWithOrWithoutControlNumber.length() - 1; i >= 0; i--)
		{
			if (!Character.isDigit(sirenWithOrWithoutControlNumber.charAt(i))) // siren must contsins only digits
				return -1;
			else
			{
				int index = Character.getNumericValue(sirenWithOrWithoutControlNumber.charAt(i));
				if (i % 2 == 1)
				{
					index = index * 2;
					if (index > 9)
						index -= 9; // if index > 9, add the 2 digits of index which is equivalent to substract 9 to index
				}
				sum += index;
			}
		}
		return sum;
	}	
}
