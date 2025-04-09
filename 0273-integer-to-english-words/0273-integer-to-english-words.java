class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num);
    }
    
    private String helper(int num){

        if(num < 20){ // Between 1 to 19
            return LESS_THAN_20[num];
        }
        if(num < 100){ // Between twenty to 99
            return TENS[num/10] + (((num%10)==0)? "": " " + helper(num%10));
        }
        if(num < 1_000){ //Between 100 to 999
            return helper(num/100) + " Hundred" +  (((num%100)==0)? "": " " + helper(num%100));
        }
        if(num < 1_000_000){ // Between 1000 to 9,99,999
            return helper(num/1_000) + " Thousand" +  (((num%1000)==0)? "": " " + helper(num%1000));
        }
        if(num < 1_000_000_000){ // Between 1_000_000 to 99,999,999
            return helper(num/1_000_000) + " Million" + (((num%1000000)==0)? "": " " + helper(num%1000000));
        }
        return helper(num/1_000_000_000) + " Billion" + (((num%1000000000)==0)? "": " " + helper(num%1000000000));
    }
}