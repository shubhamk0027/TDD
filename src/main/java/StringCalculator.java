public class StringCalculator {

    /**
     * Assumes the sum of the numbers lie in the range of int
     * @param numbers is a string of integral numbers separated by comma or \n
     * @return the sum of the numbers
     */
    public int Add(String numbers){
        String[] stringNumbers = numbers.split("[,\n]");
        int sum=0;
        for(String number: stringNumbers) if(number.length()>0){
            sum=sum+Integer.parseInt(number);
        }
        return sum;
    }


    public static void main(String[] args){
        System.out.println("String Calculator");
        StringCalculator stringCalculator= new StringCalculator();
        stringCalculator.Add("");
    }

}
