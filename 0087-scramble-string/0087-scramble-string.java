class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String,Boolean> hm = new HashMap<>();
        return f(s1, s2, hm);
    }
    public boolean f(String s, String t, HashMap<String,Boolean> hm){
        if(s.equals(t)) return true;
        int n = s.length();
        String key = s + "." + t;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        boolean result = false;
        for(int i = 1; i < n; i++){
            boolean notswapped = f(s.substring(0, i), t.substring(0, i), hm) && f(s.substring(i), t.substring(i), hm);
            if(notswapped) {
                result = true;
                break;
            }
            boolean swapped = f(s.substring(0, i), t.substring(n-i), hm) && f(s.substring(i), t.substring(0, n-i), hm);
            if(swapped){
                result = true;
                break;
            }
        }
        hm.put(key, result);
        return result;
    }
    /*
    //Recursive Code Got TLE at 195/290 testcases passed 
    //Time Complexity:- Exponential
    //Space Complexity:- Can't be Determeined
    public boolean isScramble(String s1, String s2) {
        return f(s1, s2);
    }
    public boolean f(String s, String t){
        if(s.equals(t)) return true;
        int n = s.length();
        for(int i = 1; i < n; i++){
            boolean notswapped = f(s.substring(0, i), t.substring(0, i)) && f(s.substring(i), t.substring(i));
            if(notswapped) return true;
            boolean swapped = f(s.substring(0, i), t.substring(n-i)) && f(s.substring(i), t.substring(0, n-i));
            if(swapped) return true;
        }
        return false;
    }
    */
}