class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int maxX = dots[0][0];
        int maxY = dots[0][1];
        int minX = dots[0][0];
        int minY = dots[0][1];
        for(int i = 1 ; i <= 3; i++){
            maxX = Math.max(maxX, dots[i][0]);
            maxY = Math.max(maxY, dots[i][1]);
            minX = Math.min(minX, dots[i][0]);
            minY = Math.min(minY, dots[i][1]);
        }
        return (maxX - minX) * (maxY - minY);
    }
}