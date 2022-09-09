class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;

        List<String> all = new ArrayList<>();
        if(minutes < 100) {
            int first = (minutes * 100) + seconds;
            all.add(String.valueOf(first));
        }

        if(seconds < 40) {
            minutes = minutes - 1;
            seconds = seconds + 60;
            int second = minutes * 100 + seconds;
            all.add(String.valueOf(second));
        }
        
        int bestCost  = Integer.MAX_VALUE;

        for(String curr : all) {
            int cost = 0;
            char tempStartAt = (char) (startAt + '0');
            for(int j = 0;j<curr.length();j++) {
                if(curr.charAt(j) != tempStartAt)    {
                tempStartAt = curr.charAt(j);
                cost += moveCost;
                cost += pushCost;
            } else {
                cost += pushCost;
            }
            }
            bestCost = Math.min(cost, bestCost);
        }

        return bestCost;
    }
}