class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        
        yiluFill(image, sr, sc, color, image[sr][sc]);
        
        return image;
    }
    
    public void yiluFill(int[][] image, int sr, int sc, int color, int oldColor) {
        if(sr < 0 || sr >= image.length || sc <0 || sc >= image[0].length || image[sr][sc] != oldColor)
            return;
        
        image[sr][sc] = color;
        yiluFill(image, sr - 1, sc, color, oldColor);
        yiluFill(image, sr , sc - 1, color, oldColor);
        yiluFill(image, sr + 1, sc, color, oldColor);
        yiluFill(image, sr, sc + 1, color, oldColor);
    }
}