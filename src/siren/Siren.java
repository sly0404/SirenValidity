package siren;

public interface Siren
{	
	boolean checkSirenValidity(String siren);
	String computeFullSiren(String sirenWithoutControlNumber);
}
