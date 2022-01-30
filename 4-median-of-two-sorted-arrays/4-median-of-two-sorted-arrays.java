class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1=0,right1=nums1.length-1;
        int left2=0,right2=nums2.length-1;
        
        double median = getMedian(nums1,nums2,left1,right1,left2,right2);
        return median;
    }
    
    private double getMedian(int[] nums1, int[] nums2,
                            int left1,int right1,int left2,int right2)
    {
        // Size of both arrays
        int size1=right1-left1+1;
        int size2=right2-left2+1;
        
        // printArray(nums1,left1,right1);
        // printArray(nums2,left2,right2);
        
        // Base cases
        
        // If size of any one array is zero directly return median of other array
        if (size1==0)
            return medianOfArray(nums2,left2,right2);
        else if (size2==0)
            return medianOfArray(nums1,left1,right1);
        
        // If size of any one array is one
        if (size1==1)
        {
            // If other array also has size 1 
            if (size2==1)
                return (double) (nums1[left1]+nums2[left2])/2;
            
            // If other array has odd nuber of elements 
            // Merged array would have even number of elements
            // Hence we have to find average of two median numbers
            // The median will be the average of the two numbers -
            // (1) median of other array say array[m]
            // (2) median of three numbers - array[m-1],array[m+1] and 
            // the single element from another element array
            int mid=size2/2;
            if (size2%2!=0)
                return (double) (nums2[mid]+
                                 medianOfThreeNumbers
                                 (nums1[left1],nums2[left2+mid-1],
                                  nums2[left2+mid+1]))/2;
            
            // If other array has even number of elements
            // Merged array will have odd number of elements
            // Hence only need to find one median element
            // Median will be the median of three numbers -
            // Two median numbers of even array and 
            // the single element from another element array
            else
                return medianOfThreeNumbers
                (nums1[left1],nums2[left2+mid],nums2[left2+mid-1]);
        }
           
        // Do the same if other array has size 1
        else if (size2==1)
        {
            // size1 cannot be 1 now as already considered
            int mid=size1/2;
            if (size1%2!=0)
                return (double) (nums1[mid]+
                                medianOfThreeNumbers
                                (nums2[left2],nums1[left1+mid-1],
                                nums1[left1+mid+1]))/2;
            
            else
                return medianOfThreeNumbers
                (nums2[left2],nums1[left1+mid],nums1[left1+mid-1]);
        }
        
        // If size of any one array is 2
        if (size1==2)
        {
            // If other array also has size 2
            if (size2==2)
                return medianOfFourNumbers(nums1[left1],nums1[right1],
                                          nums2[left2],nums2[right2]);
            
            // If other array has odd number of elements
            // Merged array will also have odd number of elements
            // We need to find one median element
            // The median will be median of the three numbers -
            // (1) median of this array say array[mid]
            // (2) maximum of array[mid-1] and first number of 2 elements array
            // (3) minimum of array[mid+1] and second number of 2 elements array
            int mid=size2/2;
            if (size2%2!=0)
                return medianOfThreeNumbers(nums2[left2+mid],
                                Math.max(nums2[left2+mid-1],nums1[left1]),
                                Math.min(nums2[left2+mid+1],nums1[right1]));
            
            // If other array has even number of elements
            // Merged array will also have even number of elements
            // The median will be the median of the four numbers - 
            // (1 & 2) two mdeian numbers of array say array[mid] and array[mid-1]
            // (3) maximum of array[mid-2] and first number of 2 elements array
            // (4) minimum of array[mid+1] and second number of 2 elements array       
            else
                return medianOfFourNumbers(nums2[left2+mid],nums2[left2+mid-1],
                                Math.max(nums2[left2+mid-2],nums1[left1]),
                                Math.min(nums2[left2+mid+1],nums1[right1]));    
        }
        
        // Do the same if other array has size 2
        else if (size2==2)
        {
            // size1 cannot be 2 now as already considered 
            int mid=size1/2;
            if (size1%2!=0)
                return medianOfThreeNumbers(nums1[left1+mid],
                                Math.max(nums1[left1+mid-1],nums2[left2]),
                                Math.min(nums1[left1+mid+1],nums2[right2]));
            
            else 
                return medianOfFourNumbers(nums1[left1+mid],nums1[left1+mid-1],
                                Math.max(nums1[left1+mid-2],nums2[left2]),
                                Math.min(nums1[left1+mid+1],nums2[right2]));
        }
        
        // Recursive case
        
        // Now both arrays have size greater than 2
        // Compare the median of both the arrays and 
        // divide arrays to compute recursilvely
        // Also the array after divide should be even if before even and
        // similarly odd if previoulsy odd therefore choosing the first median
        // for an even array and hence using (size-1)
        int med1 = left1+(size1-1)/2;
        int med2 = left2+(size2-1)/2;
        
        // If median of first array is greater than equal to median of second array
        // We divide both array as -
        // First array -> left1 to med1
        // Second array -> med2 to right2
        if (nums1[med1] >= nums2[med2])
        {
            // Add second median for an even array
            if (size1%2==0)
                med1=med1+1;
            
            // Make no of elements removed same from both array
            int newSize1=med1-left1+1;
            int newSize2=right2-med2+1;
            int remove1=size1-newSize1;
            int remove2=size2-newSize2;
            if (remove1>remove2)
                med1=med1+(remove1-remove2);
            else if (remove1<remove2)
                med2=med2-(remove2-remove1);
            
            return getMedian(nums1,nums2,left1,med1,med2,right2);
        }
        
        // Else if median of first array is less than median of econd array
        // We divide both array as -
        // First array -> med1 to right1
        // Second array -> left2 to med2
        else
        {
            // Add second median for an even array
            if (size2%2==0)
                med2=med2+1;
            
            // Make no of elements removed same from both array
            int newSize1=right1-med1+1;
            int newSize2=med2-left2+1;
            int remove1=size1-newSize1;
            int remove2=size2-newSize2;
            if (remove1>remove2)
                med1=med1-(remove1-remove2);
            else if (remove1<remove2)
                med2=med2+(remove2-remove1);
            
            return getMedian(nums1,nums2,med1,right1,left2,med2);
        }
    }
    
    private double medianOfArray(int nums[],int left,int right)
    {
        int size=right-left+1;
        if (size==0)
            return -1; // Return invalid value
        
        else if (size%2==0) // Size is even
            return (double) (nums[left+size/2]+nums[left+size/2-1])/2;
        
        else // Size is odd
            return nums[left+size/2];     
    }
    
    private double medianOfThreeNumbers(int a,int b,int c)
    {
        if ((a>b && a<c) || (a<b && a>c))
            return a;
        else if ((b>a && b<c) || (b<a && b>c))
            return b;
        else
            return c;
    }
    
    private double medianOfFourNumbers(int a,int b,int c,int d)
    {
        int maximum=Math.max(a,Math.max(b,Math.max(c,d)));
        int minimum=Math.min(a,Math.min(b,Math.min(c,d)));
        
        double median = (double) (a+b+c+d-maximum-minimum)/2.0;
        return median;
    }

    private void printArray(int nums[],int left,int right)
    {
        for (int i=left;i<=right;i++)
            System.out.print(nums[i]+" ");
        System.out.println();
    }
}