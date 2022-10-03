class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInData = new HashMap<>();
    Map<String, Pair<Double, Double>> journeyData = new HashMap<>();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInData.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String,Integer> sourceData = checkInData.get(id);
        String sourceStation = sourceData.getKey();
        Integer startTime = sourceData.getValue();
        
        String routeKey = sourceStation + "->" + stationName;
        Pair<Double,Double> tripData = journeyData.getOrDefault(routeKey, new Pair<>(0.0,0.0));
        
        Double totalTripTime = tripData.getKey();
        Double totalTrips = tripData.getValue();
        
        Integer currentTime = t - startTime;
        
        journeyData.put(routeKey, new Pair<>(totalTripTime+currentTime,totalTrips+1 ));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
         Pair<Double,Double> tripData = journeyData.get(routeKey);
         Double totalTripTime = tripData.getKey();
        Double totalTrips = tripData.getValue();
        return totalTripTime/totalTrips;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */