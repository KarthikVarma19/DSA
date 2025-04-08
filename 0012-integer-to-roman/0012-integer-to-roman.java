class Solution {
    public String intToRoman(int num) {
        // Order Key Map
        TreeMap<Integer,String> integerMap = new TreeMap<>(Collections.reverseOrder()){
            {
                put(1000, "M");
                put(900, "CM");
                put(500, "D");
                put(400, "CD");
                put(100, "C");
                put(90, "XC");
                put(50, "L");
                put(40, "XL");
                put(10, "X");
                put(9, "IX");
                put(5, "V");
                put(4, "IV");
                put(1, "I");
            }
        };
        int temp = num;
        String roman = "";
        for(Integer key: integerMap.keySet()){
            if(temp == 0) break;
            int times = temp/key;
            if(key <= temp){
                // Mod key Gives you the Remainder
                temp %= key;
                roman += integerMap.get(key).repeat(times);
            }
        }
        return roman;
    }
}