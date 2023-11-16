class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodfill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    public void floodfill(int[][] image, int sr, int sc, int color, int currColor) {
        if(sr <0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != currColor || color == currColor)
            return;
        
        image[sr][sc] = color;
        
        floodfill(image, sr + 1, sc, color, currColor);
        floodfill(image, sr, sc + 1, color, currColor);
        floodfill(image, sr - 1, sc, color, currColor);
        floodfill(image, sr, sc - 1, color, currColor);
    }
}