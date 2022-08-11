class Solution {
    
    public void flow(int[][] image, int i, int j, int newColor, boolean visited[][], int val)     {
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || visited[i][j] || image[i][j] != val) {
            return;
        }
        
        visited[i][j] = true;
        image[i][j] = newColor;
        
        flow(image,i+1,j,newColor,visited,val);
        flow(image,i,j+1,newColor,visited,val);
        flow(image,i-1,j,newColor,visited,val);
        flow(image,i,j-1,newColor,visited,val);
        
        visited[i][j] = false;
    }
        
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        
        flow(image,sr,sc,newColor,visited,image[sr][sc]);
        return image;
    }
}