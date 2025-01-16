class Solution {
    public boolean isSubsequence(String s, String t) {
        int ptr1 = 0, ptr2 = 0;
        int len1 = s.length(), len2 = t.length();
        while(ptr1 < len1 && ptr2 < len2){
            if(s.charAt(ptr1) == t.charAt(ptr2)){
                ptr1++;
            }
            ptr2++;
        }
        return ptr1==len1;
    }
}