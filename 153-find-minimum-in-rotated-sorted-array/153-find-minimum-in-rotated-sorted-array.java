class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while (low<=high) {
            
            // Found the min element window
            if (nums[low]<=nums[high]) {
                return nums[low];
            }
            
            int mid = low + (high-low)/2;
            int prev = (mid+n-1)%n; // mid-1
            int next = (mid+1)%n; // mid+1

            // Mid is min element if minimum than both mid+1 and mid-1
            if (nums[mid]<nums[prev] && nums[mid]<nums[next])
                return nums[mid];
            
            // Move to the unsorted array
            if (nums[mid]>=nums[low])
                low=mid+1;
            
            else //if (nums[mid]<nums[high])
                high=mid-1;
        }
    
        return -1;
    }
}

/*

Explanation - 

Consider the rotated sorted array consisting of 7 elements
4 5 6 7 0 1 2
We need to find the minimum element of this array

Consider
low = 0
high = 6
mid = 3

Now, arr[mid] is not the minimum element we either need to move left or right
The left and right arrays are - 
Left array including mid: 4 5 6 7 {Sorted}
Right array including mid: 7 0 1 2 {Unsorted}

We need to move to the unsorted array which contains the minimum element
arr[low]=4
arr[mid]=7
arr[high]=2

arr[mid]>arr[low] - Left array sorted
arr[mid]>arr[high] - Right array unsorted
Move to the right 

*/

/*

ANOTHER SIMILAR PROBLEM - 

Number of times a sorted array is rotated anticlockwise =>
It is same as finding minimum in rotated sorted array as the index
of the minimum element is the answer i.e the number of times the array is rotated

Ex - 
Consider the array 
0 1 2 4 5 6 7

Now we rotate the array 4 times anticlockise, we get
4,5,6,7,0,1,2 
Minimum element in the array = 0 
Index of minimum element = 4 (equal to no of rotations)

Hence, the number of rotations in a sorted array anticlockwise is equal
to the index of the minimum element in the rotated sorted array

*/