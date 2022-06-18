class Solution {
    public boolean isIdealPermutation(int[] nums) {
        return localInversions(nums) == globalInversions(nums);
    }
    
    private int localInversions(int[] nums) {
        int count = 0;
        for (int i=0,len=nums.length;i<len-1;i++) {
            if (nums[i]>nums[i+1])
                count++;
        }
        return count;
    }
    
    private int globalInversions(int[] nums) {
        return mergeSortAndCount(nums,0,nums.length-1);
    }
    
    // Merge sort the array and count the inversions
    private int mergeSortAndCount(int[] nums,int left,int right) {
        int count=0;
        if (left>=right)
            return 0;
        
        int mid = left + (right-left)/2;
        count += mergeSortAndCount(nums,left,mid);
        count += mergeSortAndCount(nums,mid+1,right);
        count += mergeAndCount(nums,left,mid,right);
        
        return count;
    }
    
    private int mergeAndCount(int[] nums,int left,int mid,int right) {
        // Left subarray: left to mid
        // Right subarray: mid+1 to right
        
        int sizeL = mid-left+1;
        int sizeR = right-mid;
        
        // Create temporary arrays and copy values
        int leftArr[] = new int[sizeL];
        int rightArr[] = new int[sizeR];
        
        for (int i=0;i<sizeL;i++)
            leftArr[i] = nums[left+i];
        for (int i=0;i<sizeR;i++)
            rightArr[i] = nums[mid+1+i];
        
        
        int i=0,j=0; // Initial index of both ssubarrays
        int k=left; // Initial index for merged sorted array
        int mergeInversions = 0;
        
        while (i<sizeL && j<sizeR) {
			if (leftArr[i]<=rightArr[j]) {
				nums[k]=leftArr[i];
				i++;
			}
			else {
				nums[k]=rightArr[j];
                // Found smaller number in rightArray
                // Count inversions for that element in right array with all 
                // elements in left array greater than equal to current
                mergeInversions += (mid+1)-(left+i);
				j++;
			}
			k++;
		}
        
        while (i<sizeL) {
			nums[k]=leftArr[i];
			i++;
			k++;
		}
        
        while (j<sizeR) {
			nums[k]=rightArr[j];
			j++;
			k++;
		}
        
        return mergeInversions;
    }
}