class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int rIndex=0;
		for (int i=1;i<n;i++) {
			if (nums[i]<nums[i-1]) {
				rIndex = i;
				break;
			}
		}
        
        return binarySearch(nums,0,n-1,rIndex,target,n);
    }
    
    public static int binarySearch(int arr[],int low,int high,int rIndex, int key,int size) {
		if (low>high) return -1;

		int mid = (low+high)/2;
		int mid2 = (mid+rIndex)%size;
		if (arr[mid2]==key)
			return mid2;
		else if (arr[mid2]>key)
			return binarySearch(arr,low,mid-1,rIndex,key,size);
		else
			return binarySearch(arr,mid+1,high,rIndex,key,size);
	}
}