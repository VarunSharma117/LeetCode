/*Question - [link](https://leetcode.com/problems/container-with-most-water/)
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the
line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.


Example 2:
Input: height = [1,1]
Output: 1



Solution performance -
50 / 50 test cases passed.
Status: Accepted
Runtime: 642 ms
Memory Usage: 39.9 MB


Solution - 
*/


class Solution {
    public int maxArea(int[] height) {
        int ltl=0;
        int maxarea = 0;
        try{
            for(int i=1; i<height.length;i++){
                for(int j=0;j<i;j++){
                    if(height[i]>height[j]){
                        ltl=height[j];
                    }
                    else{
                        ltl=height[i];
                    }
                    int b =i-j;
                    int area = ltl*b;
                    if (area>=maxarea){
                        maxarea=area;
                    }
                }
            }
        }
        catch(Exception e){}
        return maxarea;
    }
}
