class Solution {
    public String countAndSay(int n) {
        StringBuilder org = new StringBuilder("1");
        for(int k = 1; k < n; k++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int i = 1; i < org.length(); i++){
                if(org.charAt(i) == org.charAt(i-1)){
                    count++;
                }else{
                    sb.append(count).append(org.charAt(i-1));
                    count = 1;
                }
            }
            sb.append(count).append(org.charAt(org.length()-1));
            org = sb;
        }
        return org.toString();
    }
}