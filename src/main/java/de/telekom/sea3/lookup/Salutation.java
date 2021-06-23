package de.telekom.sea3.lookup;

public enum Salutation {
	Mr, Mrs, Diverse;

	public static Salutation fromString(final String value) {

		switch (value.toUpperCase()) {

		case "MRS":
		case "MRS.":
		case "FEMALE":
		case "F":
		case "FRAU":
			return Mrs;
		case "MR":
		case "MR.":
		case "MALE":
		case "M":
		case "MANN":
			return Mr;
		case "OTHER":
		case "DIVERSE":
		case "D":
			return Diverse;

		default:
			throw new IllegalArgumentException("Unexpected value: " + value);
		}
	}
	
	public Byte toByte() {
		switch (this) {
		case Mrs:
			return 1;
		case Mr:
			return 2;
		case Diverse:
			return 3;
		default:
			throw new RuntimeException("Unexpected value: " + toByte());
		}
	}

	public static Salutation fromByte(byte b) {
		switch (b) {
		case 1:
			return Mrs;
		case 2:
			return Mr;
		case 3:
			return Diverse;
		default:
			throw new RuntimeException("Unexpected case! " + fromByte(b));
		}
	}
	
	@Override
	public String toString() {
		switch (this) {
		case Mrs:
			return "Mrs";
		case Mr:
			return "Mr";
		case Diverse:
			return "Diverse";
		default:
			throw new IllegalArgumentException("Unexpected Case - please check...");
		}
	} 
}