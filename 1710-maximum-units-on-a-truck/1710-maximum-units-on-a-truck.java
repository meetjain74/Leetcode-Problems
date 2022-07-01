class Pair implements Comparable<Pair> {
    int boxes;
    int units;
    
    Pair(int boxes,int units) {
        this.boxes=boxes;
        this.units=units;
    }
    
    public int compareTo(Pair p) {
        return p.units-this.units;
    }
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int[] box: boxTypes) {
            pq.add(new Pair(box[0],box[1]));
        }
        
        int maxUnits = 0;
        while (!pq.isEmpty() && truckSize!=0) {
            Pair p = pq.poll();
            if (truckSize>p.boxes) {
                truckSize -= p.boxes;
                maxUnits += p.boxes*p.units;
            }
            else {
                maxUnits += truckSize*p.units;
                truckSize = 0;
            }
        }
        
        return maxUnits;
    }
}