package Validation;

public class Inputs {
	public static String required(String value, String fieldName) {
		if(value == null || value.trim().isEmpty()) {
			throw new IllegalArgumentException("Lauks "+fieldName+" jāaizpilda");
		}
		return value.trim();
	}
	
	public static int posInt(String value, String fieldName) {
		String cleaned = required(value, fieldName);
		try {
			int number = Integer.parseInt(cleaned);
			
			if(number <= 0) {
				throw new IllegalArgumentException("Laukā "+fieldName+" jāievieto pozitīvs skaitlis!");
			}
			
			return number;
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException("Laukā "+fieldName+" jāievieto pozitīvs skaitlis!");
		}
	}
	
	public static String countryCode(String value, String fieldName) {
		String cleaned = required(value, fieldName);
		
		if(!cleaned.matches("[a-zA-Z]{3}")) {
			throw new IllegalArgumentException("Laukā "+fieldName+" jāievieto 3 burti, piemēram LVA!");
		}
		return cleaned.toUpperCase();
	}
	
	public static String maxLenght(String value, String fieldName, int max) {
		String cleaned = required(value, fieldName);
		
		if(cleaned.length() > max) {
			throw new IllegalArgumentException("Laukā "+fieldName+" drīkst būt ne vairāk, kā "+max+" burti");
		}
		return cleaned;
	}
	
	public static String validatePK(String columnName, String value) {
		switch(columnName.toLowerCase()) {
		case "id": 
			return String.valueOf(posInt(value, columnName));
		case "code":
		case "countrycode":
			return countryCode(value, columnName);
		default: 
			return required(value, columnName);
		}
	}
}
