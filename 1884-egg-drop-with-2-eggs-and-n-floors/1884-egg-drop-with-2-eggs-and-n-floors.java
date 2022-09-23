class Solution {
    public int twoEggDrop(int n) {
        int ans=1;
        while(n>0){
            n-=ans;
            ans++;
        }
        return ans-1;
    }
}