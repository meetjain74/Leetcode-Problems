class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int resArr[] = new int[m+n];
        int k=0;
        while(i<m && j<n) {
            if (nums1[i]>nums2[j]) {
                resArr[k]=nums2[j];
                j++;
            }
            else {
                resArr[k]=nums1[i];
                i++;
            }
            k++;
        }
        
        while (i<m) {
            resArr[k]=nums1[i];
            i++;
            k++;
        }
        
        while (j<n) {
            resArr[k]=nums2[j];
            j++;
            k++;
        }
        
        // Copy resArray to nums1
        for (int p=0;p<k;p++) {
            nums1[p]=resArr[p];
        }
    }
}