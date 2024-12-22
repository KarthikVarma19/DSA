class Solution {
    private static class Project{
        int capital;
        int profit;
        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();
        for(int i=0;i<n;i++){
            projects.add(new Project(capital[i],profits[i]));
        }
        Collections.sort(projects, (a,b)-> a.capital-b.capital);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        int i = 0;
        while(k-->0){
            while(i<n && projects.get(i).capital <= w){
                maxHeap.add(projects.get(i).profit);
                i++;
            }
            if(maxHeap.isEmpty()) break;
            w += maxHeap.remove();
        }
        return w;
    }
}