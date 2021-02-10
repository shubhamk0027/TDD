import java.util.ArrayList;

public class StringCalculator {

    private int timesAddInvoked;

    public StringCalculator(){
        timesAddInvoked=0;
    }

    public int GetCalledCount(){
        return timesAddInvoked;
    }

    private boolean isSpecialCharacter(char c) {
        if (c>='0' && c<='9') return false;
        if (c>='a' && c<='z') return false;
        return c < 'A' || c > 'Z';
    }


    /**
     * Assumes all the inputs provided are valid
     * Ignores numbers greater than 1000
     * By default separates the numbers by comma or new line character
     * Supports Custom Delimiter by providing input numbers string as -
     * “//[delimiter]\n[numbers…]” OR “//[delim1][delim2]\n[numbers...]” OR //d\n[numbers…] where d is a delimiter character
     * @param numbers is a string of positive integers numbers separated by delimiters
     * @return the sum of the numbers
     * @throws IllegalArgumentException when negative numbers are passed
     */
    public int Add(String numbers) throws IllegalArgumentException{

        timesAddInvoked++;

        if(numbers.length()==0) {
            return 0;
        }

        String[] stringNumbers;
        if(numbers.startsWith("//")){
            if(numbers.charAt(2)!='['){
                // single character delimiter
                char delimiterCharacter = numbers.charAt(2);
                stringNumbers = numbers.substring(4).split(String.valueOf(delimiterCharacter));
            }else{
                // multiple character delimiter of multiple length
                int till = numbers.indexOf("]\n");
                String[] delimiters = numbers.substring(3,till).split("\\]\\[");
                StringBuilder stringBuilder = new StringBuilder();
                for(int i=0;i<delimiters.length;i++){
                    if(i>0) stringBuilder.append("|");
                    for(int j=0;j<delimiters[i].length();j++){
                        if(isSpecialCharacter(delimiters[i].charAt(j))){
                            stringBuilder.append("\\");
                            stringBuilder.append(delimiters[i].charAt(j));
                        }
                    }
                }
                stringNumbers = numbers.substring(till+2).split(stringBuilder.toString());
            }
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
