import java.awt.*;
import java.util.ArrayList;

public class StringCalculator {

    private int timesAddInvoked;

    public StringCalculator(){
        timesAddInvoked=0;
    }

    public int GetCalledCount(){
        return timesAddInvoked;
    }

    /**
     * Assumes the sum of the numbers lie in the range of int
     * Assumes all the inputs provided are valid
     * By default separates the numbers by comma or new line character
     * Supports Custom Delimiter by providing input numbers string as “//[delimiter]\n[numbers…]”
     * @param numbers is a string of positive integers numbers separated by comma or \n
     * @return the sum of the numbers
     */
    public int Add(String numbers){
        timesAddInvoked++;
        if(numbers.length()==0) {
            return 0;
        }

        String[] stringNumbers;
        if(numbers.startsWith("//")){
            int index = numbers.indexOf('\n');
            String newDelimiter = numbers.substring(2,index);
            stringNumbers = numbers.substring(index+1).split(newDelimiter);
        }else{
            stringNumbers = numbers.split("[,\n]");
        }

        int sum=0;
        ArrayList<Integer> negatives = new ArrayList <>();
        for(String number: stringNumbers) {
            int value = Integer.parseInt(number);
            if(value<0) {
                negatives.add(value);
            }else if(value<=1000){
                sum+=value;
            }
        }
        if(negatives.size()>0){
            throw new IllegalArgumentException("negatives not allowed! - "+negatives);
        }
        return sum;
    }


    public static void main(String[] args){
        System.out.println("String Calculator Running...");
    }

}
