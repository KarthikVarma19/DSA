class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int maxi = 0;
        for(int g: groups) maxi = Math.max(maxi, g);
        int g[] = new int[maxi+1];
        Arrays.fill(g, -1);
        int v[] = new int[maxi+1];
        for(int i = 0; i < elements.length; i++){
            int ele = elements[i];
            if(ele > maxi || v[ele] == 1){
                continue;
            }
            v[ele] = 1;
            for(int mul=ele; mul <= maxi; mul += ele){
                if(g[mul] == -1){
                    g[mul] = i;
                    v[mul] = 1;
                }
            }
        }

        int ans[] = new int[groups.length];
        for(int i = 0; i < groups.length; i++){
            int ele = groups[i];
            ans[i] = g[ele];
        }
        return ans;

    }
}