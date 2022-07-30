class Car {
    long pos;
    long speed;
    
    Car(long pos,long speed) {
        this.pos=pos;
        this.speed=speed;
    }
}

class Solution {
    public int racecar(int target) {
        // BFS
        Queue<Car> q = new LinkedList<>();
        q.add(new Car(0,1));
        HashSet<String> visited = new HashSet<>();
        visited.add("0 1");
        int instructions=0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                Car curr = q.poll();
                if (curr.pos==target)
                    return instructions;
                
                //Accelerate 
                long apos = curr.pos+curr.speed;
                long aspeed = curr.speed*2;
                String a = apos+" "+aspeed;
                
                // Only move if car distance with target is less than target
                if (!visited.contains(a) && Math.abs(target-apos)<target) {
                    visited.add(a);
                    q.add(new Car(apos,aspeed));
                }
                
                // Reverse
                long rpos = curr.pos;
                long rspeed = curr.speed>0?-1:1;
                String r = rpos+" "+rspeed;
                
                // Don't reverse further when pos less than 0
                if (!visited.contains(r) && Math.abs(target-rpos)<target) {
                    visited.add(r);
                    q.add(new Car(rpos,rspeed));
                }
            }
            instructions++;
        }

        return -1;
    }
}