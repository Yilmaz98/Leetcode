class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zc=0,po=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0')
                zc++;
            else
                if(zc!=0)
                    po=Math.max(po+1,zc);
        }
        return po;
    }
}