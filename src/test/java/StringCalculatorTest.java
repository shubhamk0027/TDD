import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void emptyStringTest(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(calculator.Add(""),0);
    }

    @Test
    public void addOneStringTest(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(calculator.Add("1"),1);
    }

    @Test
    public void addTwoStringsSeparatedByCommaTest(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(calculator.Add("1,2"),3);
    }

    @Test
    public void addTwoStringsSeparatedByNewLine(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(calculator.Add("1\n2"),3);
    }

    @Test
    public void addMoreThanTwoStringsSeparatedByNewLineOrComma(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(calculator.Add("1\n2,3,4\n5"),15);
    }

    @Test
    public void customDelimiterTest1(){
        StringCalculator calculator= new StringCalculator();
        assertEquals(calculator.Add("//;\n1;2;3"),6);
    }

    @Test
    public void customDelimiterTest2(){
        StringCalculator calculator= new StringCalculator();
        assertEquals(calculator.Add("//__\n1__2__3"),6);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void negativesTest(){
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("negatives not allowed! - [-4, -5, -6]");
        StringCalculator calculator= new StringCalculator();
        calculator.Add("1,2\n3,-4\n-5,-6");
    }
}
