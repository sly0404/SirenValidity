package siren;

public class Run
{

	public static void main(String[] args)
	{
		Siren siren = new SirenImpl();
		//String isValid = siren.computeFullSiren("73282932");
		String isValid = siren.computeFullSiren("11111117");
		
		System.out.println(isValid);

	}

}
