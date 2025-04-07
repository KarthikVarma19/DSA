class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> romanMap = new HashMap<>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int hightillnow = 1000;
        int total = 0;
        for(char ch: s.toCharArray()){
            int curVal = romanMap.get(ch);
            // System.out.println(curVal);
            total += curVal;
            if(hightillnow < curVal){
                total -= (hightillnow * 2);
            }
            hightillnow = curVal;
        }
        return total;

    }
}