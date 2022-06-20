class Solution {
    public int findKthLargest(int[] nums, int k) {
        return method2(nums,k);
    }
    
    // Using priority Queue
    private int method1(int[] nums,int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<nums.length;i++) {
            pq.add(nums[i]);
            
            if (pq.size()>k) {
                pq.poll();
            }
        }
        
        return pq.poll();
    }
    
    // Using quickSelect
    private int method2(int[] nums,int k) {
        int n = nums.length;
        k = n-k+1; // kth largest is n-k+1 smalllest element
        
        return kthSmallest(nums,k,0,n-1);
    }
    
    private int partition(int[] nums,int left,int right) {
        int pivot=nums[right]; // Taking end element as piv
        int i=left-1;
        for (int j=left;j<=right-1;j++) {
            if (nums[j]<=pivot)
                swapAtIndex(nums,++i,j);
        }
        swapAtIndex(nums,++i,right);
        return i;
    }
    
    private void swapAtIndex(int array[],int x,int y) {
        int temp=array[x];
        array[x]=array[y];
        array[y]=temp;
    }
    
    private int kthSmallest(int nums[],int k,int left,int right) {
        int p = partition(nums,left,right);

        if (p+1==k) {
            // kth smallest is at position p+1
            return nums[p];
        }
        else if (p+1>k) {
            // Find kth smallest in left array
            return kthSmallest(nums,k,left,p-1);
        }
        else {
            // Find (k-(p+1)+left)th element in right array
            return kthSmallest(nums,k,p+1,right);
        }
    }
}