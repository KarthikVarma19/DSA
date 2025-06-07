class Solution {
    public String clearStars(String s) {
        char arr[] = s.toCharArray();
        Deque<Integer>[] map = new Deque[26];
        for(int i = 0; i < 26; i++){
            map[i] = new ArrayDeque<>();
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '*'){
                for(int j = 0; j < 26; j++){
                    if(!map[j].isEmpty()){
                        arr[map[j].pop()] = '*';
                        break;
                    }
                }
            }else {
                map[arr[i]-'a'].push(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c: arr){
            if(c != '*'){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}