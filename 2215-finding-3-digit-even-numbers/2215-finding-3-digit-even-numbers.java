class Solution {
    
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> st = new TreeSet<>();
        int n = digits.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                for(int k = 0; k < n; k++){ 
                    if(i == k || j == k || (digits[k]&1) == 1){
                        continue;
                    }
                    int sum = (digits[i] * 100) +  (digits[j] * 10) + (digits[k]);
                    if((sum/100) != 0){
                        st.add(sum);
                    }
                }
            }
        }
        int size = st.size();
        int ans[] = new int[size];
        int fi = 0;
        for(Integer each: st){
            ans[fi++] = each;
        }
        return ans;
    }

}