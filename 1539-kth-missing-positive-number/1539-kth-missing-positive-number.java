class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            
            int expectedNumber = mid+1; //If no numbers were missing
            int numbersMissing = arr[mid]-expectedNumber;
            
            if (numbersMissing>=k)
                high=mid-1;
            else
                low=mid+1;
        }
        
        if (high==-1)
            return k;
        else {
            int missing = arr[high]-(high+1);
            return arr[high]+(k-missing);
        }
    }
}

/*

Explanation - 

If array does not had any missing numbers, array would be like 1,2,3,4,5,6,....
If array has missing numbers, missing numbers upto any index can be directly 
calculated by value at that index in array minus expected value
i.e
For position i in array(0 indexed array), we have
missingNumbers till i = arr[i]-(i+1) as i+1 is the expected value at that point

If missingNumbers >= k in an array, kth element lies between elements inside the list
If missingNumbers < k in an array, kth element lies outside of the list which can 
be directly determined by arr[end] + (k - missingNumbers)

Algorithm -> 
Apply Binary search
Calculate missing numbers upto mid
If missing numbers here greater than or equal to k, answer lies in left part of array
Else lies in right part of array

When low>high - 
High stores the nearest index where less than k elements are missing
The answer can be directly calculated by arr[high] + (k - missing)


*/