class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k == 0){
            Arrays.fill(code,0);
            return code;
        }
        int ans[] = new int[code.length];
        for(int i=0;i<code.length;i++){
            int j = k;
            int sum = 0;
            while(j!=0){
                int index = (j+i)%code.length;
                if(index < 0) index = code.length + index;
                sum += code[index];
                if(j>0) j--;
                else j++;
            }
            ans[i] = sum;
        }
        return ans;
    }
}