package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
        public void testOneNumber() {
                assertEquals(1, Calculator.add("1"));
        }

	@Test
        public void testTwoNumber() {
                assertEquals(3, Calculator.add("1,2"));
        }

	@Test
        public void testThreeNumber() {
                assertEquals(6, Calculator.add("1,2,3"));
        }

	@Test
        public void testTenNumber() {
                assertEquals(55, Calculator.add("1,2,3,4,5,6,7,8,9,10"));
        }

	@Test
        public void testNewlineTwoNumbers() {
                assertEquals(3, Calculator.add("1\n2"));
        }

	@Test
        public void testNewlineMultipleNumbers() {
                assertEquals(6, Calculator.add("1\n2\n3"));
        }

	@Test
        public void testNewlineAndCommas() {
                assertEquals(6, Calculator.add("1,2\n3"));
        }

	@Test
        public void testNewDelimiter() {
                assertEquals(3, Calculator.add("//;\n1;2"));
        }

	@Test
        public void testThrowException() {
		try{
			Calculator.add("-1,2");
		}
		catch(RuntimeException e){
			assertEquals("Negatives not allowed:-1", e.getMessage());
		}
        }

	@Test
        public void testThrowExceptionForMultipleNegativeNumbers() {
                try{
                        Calculator.add("2,-4,3,-5");
                }
                catch(RuntimeException e){
                        assertEquals("Negatives not allowed:-4,-5", e.getMessage());
                }
        }

	@Test
        public void testNumberBiggerThanThousand() {
                assertEquals(2, Calculator.add("1001,2"));
        }

	@Test
        public void testForDelimiterOfAnyLength() {
                assertEquals(6, Calculator.add("//[***]\n1***2***3"));
        }

	@Test
        public void testForManyDifferentDelimiterOfAnyLength() {
                assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
        }
}
