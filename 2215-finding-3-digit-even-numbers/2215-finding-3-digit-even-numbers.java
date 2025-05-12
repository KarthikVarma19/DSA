class Solution {
    
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> st = new TreeSet<>();
        int n = digits.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){ 
                    if(i == j || i == k || j == k || (digits[k]&1) == 1){
                        continue;
                    }
                    int sum = 0;
                    sum += (digits[i] * 100);
                    sum += (digits[j] * 10);
                    sum += digits[k];
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