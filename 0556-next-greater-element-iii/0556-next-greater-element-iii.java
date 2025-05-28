class Solution {
    public int nextGreaterElement(int n) {
        char num[] = String.valueOf(n).toCharArray();
        int len = num.length;
        int ld = num[len-1]-'0';
        int i = len - 2;
        // Finding the First Element Which is Smallest From Back
        while(i >= 0 && num[i] >= num[i+1]){
            i--;
        }
        if(i < 0){
            return -1;
        }
        int j = len-1;
        // Finding the First Element Which is Greater than Our Smallest Element
        while(num[i] >= num[j]){
            j--;
        }
        swap(num, i, j);
        reverse(num, i+1, len-1);
        long ans = Long.parseLong(String.valueOf(num));
        if(ans == n || ans > Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
    public void swap(char num[], int i, int j){
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public void reverse(char num[], int i, int j){
        while(i < j){
            swap(num, i, j);
            i++;
            j--;
        }
    }
}