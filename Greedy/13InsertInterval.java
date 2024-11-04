/*
57. Insert Interval (Medium)

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans= new ArrayList<>();
        int i=0,n=intervals.length,start=newInterval[0],end=newInterval[1];
        //Adding Left Non-Overlapping Intervals
        while(i<n && (intervals[i][1]<start)){
            ans.add(intervals[i]);
            i++;
        }
        //Logic to Interpret the New Intervals 
        //Start Interval is Minimum of All Overlapping Intervals
        //End Interval is Maximum of All Overlapping Intervals
        while(i<n && (intervals[i][0]<=end)){
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        ans.add(new int[]{start,end});
        //Adding Right Non-Overlapping Intervals
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        //Converting ArrayList into 2D array 
        int finalIntervals[][] = new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            finalIntervals[j][0] = ans.get(j)[0];
            finalIntervals[j][1] = ans.get(j)[1];
        }
        return finalIntervals;
    }
}

//Time Complexity:- O(n) 
//Space Complexity: O(|non-Overlapping Intevals|)
