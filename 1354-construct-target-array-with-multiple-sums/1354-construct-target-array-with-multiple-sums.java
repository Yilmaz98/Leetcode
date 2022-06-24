class Solution {
    public boolean isAll1(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 1)
                return false;
        }
        return true;
    } 
    
    public boolean isPossible(int[] target) {
        
        if(target.length == 1) {
            return target[0] == 1? true: false;
        }
        
        if(target.length == 2) {
            if(target[0] == 1 || target[1] == 1)
                return true;
            else {
                if(target[0]>target[1])
                {
                    if(target[0] % target[1] == 1)  
                        return true;
                    else if(target[0] % target[1] == 0)
                        return false;
                }
                else if(target[0]<target[1]) {
                    if(target[1] % target[0] == 1)  
                        return true;
                    else if(target[1] % target[0] == 0)
                        return false;
                } 
            }
                
        }
        
               int maxElement = 0;
            int maxIndex = 0;
            long sum = 0;
           for(int i=0;i<target.length;i++) {
                if(target[i]> maxElement) {
                     maxElement = target[i];
                     maxIndex = i;
                }
                sum += target[i]; 
            }
            sum -= maxElement;
            if(sum >= maxElement)
                return false;
           if(maxElement%sum == 1)
               return true;
        
        while(true) {
            if(isAll1(target)) {
                return true;
            }
            maxElement = 0;
            maxIndex = 0;
            sum = 0;
            for(int i=0;i<target.length;i++) {
                if(target[i]> maxElement) {
                     maxElement = target[i];
                     maxIndex = i;
                }
                sum += target[i]; 
            }
            sum -= maxElement;
            if(sum >= maxElement)
                return false;
            target[maxIndex] = maxElement - (int)sum;
        }
    }
}