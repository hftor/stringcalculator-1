package is.ru.stringcalculator;

public class Calculator {

        public static int add(String text){
                if(text.equals("")){
                        return 0;
                }
		else if(text.length() == 1){
			return toInt(text);
		}
		else if(text.substring(0, 2).equals("//")){
			String index = String.valueOf(text.charAt(2));
			String newString = text.replaceAll("\n", "");
			String newString2 = newString.replaceAll(index, ",");
			String newString3 = newString2.replaceAll("//", "");
			String newString4 = newString3.replaceFirst(",", "");

			return sum(splitNumbers(newString4));
			
		}
                else if(text.contains(",") || text.contains("\n")){
                        return sum(splitNumbers(text));
                }
                else{
                        return 1;
                }
        }

        private static int toInt(String number){
                return Integer.parseInt(number);
        }

        private static String[] splitNumbers(String numbers){
                return numbers.split("(,)|(\n)");
        }

        private static int sum(String[] numbers){
                int total = 0;
                for(String number : numbers){
                        total += toInt(number);
                }
                return total;
        }
}
