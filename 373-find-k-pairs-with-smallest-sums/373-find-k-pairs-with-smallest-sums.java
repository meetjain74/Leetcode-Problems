class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] a,int[] b) {
                int x = a[0]+a[1];
                int y = b[0]+b[1];
                return x-y;
            }
        });
        
        //Put first element of all sorted lists
        for (int i=0;i<nums1.length && i<k;i++) {
            pq.add(new int[]{nums1[i],nums2[0],0});
        }
        
        int count=0;
        while (count<k && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(Arrays.asList(curr[0],curr[1]));
            count++;
            if (curr[2]+1==nums2.length)
                continue;
            pq.add(new int[]{curr[0],nums2[curr[2]+1],curr[2]+1});
        }
        
        return res;
    }
}

/* 

Similar to merge k sorted link list
Consider arrays: [x1,x2,x3,x4] and [y1,y2,y3]
        y1         y2         y3
x1 - (x1,y1)    (x1,y2)     (x1,y3)
x2 - (x2,y1)    (x2,y2)     (x2,y3)
x3 - (x3,y1)    (x3,y2)     (x3,y3)
x4 - (x4,y1)    (x4,y2)     (x4,y3)

The sorted lists given are-
(x1,y1), (x1,y2), (x1,y3)
(x2,y1), (x2,y2), (x2,y3)
(x3,y1), (x3,y2), (x3,y3)
(x4,y1), (x4,y2), (x4,y3)
Merge in sorted way i.e sum of xn and yn and find first k elements

*/