class Solution {
    
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> st = new TreeSet<>();
        int n = digits.length;
        int num[] = new int[3];
        Arrays.fill(num, -1);
        int p = 2;
        int b = -1;
        for(int i = 0; i < n; i++){
            if((digits[i]&1) == 0){
                // last number with even number
                num[p] = digits[i];
                b = i;
                fillDigits(p-1, num, -1, -1, b, digits, st);
                num[p] = -1;
                b = -1;
            }
        }
        int size = st.size();
        int ans[] = new int[size];
        int fi = 0;
        for(Integer each: st){
            ans[fi] = each;
            fi++;
        }
        return ans;
    }
    public void fillDigits(int p, int num[], int a, int b, int c, int digits[],Set<Integer> st){
        if(p == -1){
            int sum = 0;
            sum += num[0] * 100;
            sum += num[1] * 10;
            sum += num[2];
            if((sum/100) != 0){
                st.add(sum);
            }
            return;
        }
        for(int i = 0; i < digits.length; i++){
            // skip if already selected
            if(i == a || i == b || i == c) continue;
            num[p] = digits[i];
            if(p == 1){
                b = i;
            }else{
                a = i;
            }
            num[p] = digits[i];
            fillDigits(p-1, num, a, b, c, digits, st);
            num[p] = -1;
            if(p == 1){
                b = -1;
            }else{
                a = -1;
            }
        }
    }

}