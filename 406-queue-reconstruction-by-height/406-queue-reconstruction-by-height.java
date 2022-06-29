class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people on descending order of height
        // and ascending order of k
        Arrays.sort(people, (a,b) -> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);

        // Now take one element from array and add it at the kth position
        List<int[]> ordered = new LinkedList<>();
        for (int[] p: people) 
            ordered.add(p[1], p);

        return ordered.toArray(new int[people.length][2]);
    }
}