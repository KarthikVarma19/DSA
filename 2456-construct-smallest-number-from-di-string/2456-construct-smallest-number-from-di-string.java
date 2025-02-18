class Solution {
    String ans = "";
    public String smallestNumber(String pattern) {
        Set<Integer> used = new HashSet<>();
        for(int i = 1; i <= 9; i++){
            used.add(i);
            if(sol(0, pattern, "" + i, used)){
                return ans;
            }
            used.remove(i);
        }
        return "";
    }
    public boolean sol(int idx, String pattern, String temp, Set<Integer> used){
        if(idx == pattern.length()){
            ans = temp;
            return true;
        }
        int prev = temp.charAt(temp.length()-1) - '0';

        if(pattern.charAt(idx) == 'I'){
            for(int next = prev+1; next <= 9; next++){
                if(used.contains(next)) continue;

                used.add(next);
                if(sol(idx+1, pattern, temp + next, used)){
                    return true;
                }
                used.remove(next);
            }
        }
        else{
            for(int next = prev-1; next >= 1; next--){
                if(used.contains(next)){
                    continue;
                }

                used.add(next);
                if(sol(idx+1, pattern, temp + next, used)){
                    return true;
                }
                used.remove(next);
            }
        }
        return false;
    }
}