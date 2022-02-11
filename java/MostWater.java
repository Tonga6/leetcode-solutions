// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

class Solution {
    public int maxArea(int[] height) {
        int currArea, maxArea, leftWall, rightWall, maxWall;
        currArea = maxArea = leftWall = rightWall = maxWall = 0;

        for (int i = 0; i < height.length; i++){
            leftWall = height[i];
            if (leftWall > maxWall){
                maxWall = leftWall;
                for (int j = i + 1; j < height.length; j++){
                    rightWall = height[j];
                    currArea = Math.min(leftWall, rightWall) * (j - i);

                    if (currArea > maxArea)
                        maxArea = currArea;
                }
            }
        }
        return maxArea;
    }
}