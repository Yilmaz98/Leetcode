/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        
        List<Interval> input = new ArrayList<>();
        
        for(List<Interval> each : schedule) {
            for(Interval e : each) {
                input.add(e);
            }
        }
        
        Collections.sort(input, (a,b)-> a.start - b.start);
        
        TreeMap<Integer, Integer> m = new TreeMap<>();
        List<Integer> keys = new ArrayList<>();
        
        for(Interval each : input) {
            m.put(each.start,m.getOrDefault(each.start,0)+1);
            m.put(each.end,m.getOrDefault(each.end,0)-1);
        }
        
        for(Integer i : m.keySet()) {
            keys.add(i);
        }
        
        int sum = 0;
        for(Integer i : m.keySet()) {
            sum += m.get(i);
            
            if(sum == 0) {
                int ceilingKey = keys.indexOf(i)+1;
                if(ceilingKey < keys.size()) {
                    Interval curr = new Interval(i,keys.get(ceilingKey));
                    result.add(curr);
                }
            }
        }
        
        return result;
    }
}