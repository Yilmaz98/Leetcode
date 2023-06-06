/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> imp = new HashMap<>();
        
        for(int i=0;i<employees.size();i++) {
            if(!adj.containsKey(employees.get(i).id)) {
                adj.put(employees.get(i).id, new ArrayList<>());
                imp.put(employees.get(i).id, employees.get(i).importance);
            }
               adj.get(employees.get(i).id).addAll(employees.get(i).subordinates);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        int sum = 0;
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            sum +=imp.get(curr);
            
            for(Integer nb : adj.get(curr)) {
                q.add(nb);
            }
        }
        
        return sum;
        }
  
}