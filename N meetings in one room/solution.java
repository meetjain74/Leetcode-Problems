// Problem link: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] events = new int[n][2];
        for (int i=0;i<n;i++) {
            events[i][0] = start[i];
            events[i][1] = end[i];
        }
        
        // Sort on end time
        Arrays.sort(events,new Comparator<>(){
            public int compare(int a[],int b[]) {
                if (a[1]==b[1])
                    return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        
        int count = 0;
        int currentDay = -1;
        for (int i=0;i<n;i++) {
            int curr[] = events[i];
            if (currentDay<curr[0]) {
                currentDay = curr[1];
                count++;
            }
        }
        
        return count;
    }
}
