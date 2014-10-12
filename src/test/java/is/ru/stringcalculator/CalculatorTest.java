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
        public void testNewline() {
                assertEquals(3, Calculator.add("1\n2"));
        }
}
