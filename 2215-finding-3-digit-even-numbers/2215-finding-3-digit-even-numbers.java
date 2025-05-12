class Solution {
    
    public int[] findEvenNumbers(int[] digits) {
        int freq[] = new int[10];
        for(int i = 0; i < digits.length; i++){
            freq[digits[i]]++;
        }
        // Possible Answer Space Lies Between 100 to 999
        ArrayList<Integer> ls = new ArrayList<>();
        for(int num = 100; num < 999; num+=2){
            int temp = num;
            int d3 = temp % 10;
            temp /= 10;
            int d2 = temp % 10;
            temp /= 10;
            int d1 = temp;
            freq[d1]--;
            freq[d2]--;
            freq[d3]--;
            if(freq[d1] >= 0 && freq[d2] >= 0 && freq[d3] >= 0){
                ls.add(num);
            }
            freq[d1]++;
            freq[d2]++;
            freq[d3]++;
        }
        int ans[] = new int[ls.size()];
        int size = ls.size();
        for(int i = 0; i < size; i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }

}