class Solution {
    class Disjointset {
        int parent[];
        int rank[];
        Disjointset(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
            }
        }
        void union(int u, int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if(ulp_u == ulp_v){
                return;
            }
            if(rank[ulp_v] < rank[ulp_u]){
                parent[ulp_v] = ulp_u;
            }
            else if(rank[ulp_u] < rank[ulp_v]){
                parent[ulp_u] = ulp_v;
            }else{
                parent[ulp_u] = ulp_v;
                rank[ulp_u]++;    
            }
        }
        int findUltimateParent(int node){
            if(node == parent[node]){
                return parent[node];
            }
            return parent[node] = findUltimateParent(parent[node]);
        }
        
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjointset djs = new Disjointset(n);
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                if(hm.containsKey(accounts.get(i).get(j))){
                    djs.union(i, hm.get(accounts.get(i).get(j)));
                }else{
                    hm.put(accounts.get(i).get(j), i);
                }
            }
        }
        HashMap<Integer,ArrayList<String>> fm = new HashMap<>();
        for(String each: hm.keySet()){
            int ulp = djs.findUltimateParent(hm.get(each));
            if( !fm.containsKey(ulp) ){
                fm.put(ulp, new ArrayList<>());
            }
            fm.get(ulp).add(each);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int eachKey: fm.keySet()){
            String name = accounts.get(eachKey).get(0);
            ArrayList<String> mails = fm.get(eachKey);
            Collections.sort(mails);
            List<String> merged = new ArrayList<>();
            merged.add(name);
            for(String eachmail: mails){
                merged.add(eachmail);
            }
            ans.add(merged);
        }
        return ans;
    }
}