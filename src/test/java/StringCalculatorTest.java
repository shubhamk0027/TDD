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
    public void addTwoStringTest(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(calculator.Add("1,2"),3);
    }

}
