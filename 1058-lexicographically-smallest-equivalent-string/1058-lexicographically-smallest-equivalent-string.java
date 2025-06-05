class Solution {
    class DSU {
        int parent[];
        DSU(int size){
            parent = new int[size+1];
            for(int i = 0; i <= size; i++){
                parent[i] = i;
            }
        }
        void union(int u, int v){
            int ulp_u = findUnionByParent(u);
            int ulp_v = findUnionByParent(v);
            if(ulp_u == ulp_v) return;
            // since v is larger make it smaller to keep lexi small
            if(ulp_u < ulp_v){
                parent[ulp_v] = ulp_u;
            }else{
                parent[ulp_u] = ulp_v;
            }
        }
        int findUnionByParent(int node){
            if(node == parent[node]){
                return node;
            }
            return parent[node] = findUnionByParent(parent[node]);
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {  
        DSU u = new DSU(26);
        for(int i = 0; i<s1.length(); i++){
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            u.union(c1-'a', c2-'a');
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            char cur = baseStr.charAt(i);
            int ulp = u.findUnionByParent(cur-'a');
            sb.append((char)('a'+ulp));
        }
        return sb.toString();
    }
}