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
			text = text.replaceFirst("\n", "");
			if(text.charAt(2) == '['){
				text = text.substring(2);
				while(text.startsWith("[")){
					text = replaceDelimiter(text);
				}
				return sum(splitNumbers(text));
			}
			return sum(splitNumbers(newDelimString(text)));
		}
                else if(text.contains(",") || text.contains("\n")){
                        return sum(splitNumbers(text));
                }
                else{
                        return 1;
                }
        }
	public static String replaceDelimiter(String text){
		text = text.substring(1);
                int i = 0;
                while(text.charAt(i) != ']'){
                	i++;
                }
                String del = text.substring(0, i);
                String newDel = "";
                for(int a = 0; a < del.length(); a++){
                	newDel += "\\";
                	newDel += del.charAt(a);
                }
                text = text.replaceFirst("]", "");
                text = text.replaceAll(newDel, ",");
                if(text.startsWith(",")){
                	text = text.substring(1);
                }
		return text;
	}
	public static String newDelimString(String text){
                String index = String.valueOf(text.charAt(2));
                String newString = text.replaceAll("\n", "");
                String newString2 = newString.replaceAll(index, ",");
                String newString3 = newString2.replaceAll("//", "");
                String newString4 = newString3.replaceFirst(",", "");

                return newString4;
        }

        private static int toInt(String number){
                return Integer.parseInt(number);
        }

        private static String[] splitNumbers(String numbers){
                return numbers.split("(,)|(\n)");
        }

	private static int sum(String[] numbers){
                int total = 0;
                String error = "Negatives not allowed:";
		boolean firstNeg = true;
		boolean containNegativeNumber = false;

		 for(String number : numbers){
                        if(checkIfNegative(toInt(number))){
				containNegativeNumber = true;
				if(firstNeg){
					firstNeg = false;
					error += number;
				}
				else{
					error += "," + number;
				}
                        }
			else{
				if(isNumberLessThatThousand(toInt(number))){
					total += toInt(number);
				}
			}
                }
		if(containNegativeNumber){
			throw new RuntimeException(error);
		}
                return total;
        }

        private static boolean checkIfNegative(int number){
                return number < 0;
        }

	private static boolean isNumberLessThatThousand(int number){
		return number <= 1000;
	}
}
