class Solution {
    public String strWithout3a3b(int a, int b) {
        int n = a + b;
        int contA = 0;
        int contB = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++) {
            if((a >= b && contA != 2) || (contB == 2 && a > 0)) {
                sb.append("a");
                a--;
                contA++;
                contB=0;
            } else {
                sb.append("b");
                b--;
                contB++;
                contA=0;
            }
        }
        
        return sb.toString();
    }
}