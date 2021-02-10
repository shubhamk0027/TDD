import org.junit.Test;

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
        assertEquals(calculator.Add("1\n2,3,4,\n5"),15);
    }
}
