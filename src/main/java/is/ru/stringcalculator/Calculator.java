package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			int total = 0;
 			for(String number : text.split(",")){
		    		total += toInt(number);
			}
			return total;
		}
		else{
			return 1;
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
}
