class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int diffs[] = new int[n];
		diffs[0] = arr[0]-1;
		for (int i=1;i<n;i++) {
		    diffs[i]= (arr[i]==arr[i-1]) ? 0 : arr[i]-arr[i-1]-1;
		}
        
        int currSum = 0;
        int p = -1;
        while (currSum<k && p<n-1) {
            currSum += diffs[++p];
        }

        int num = 0;
        if (currSum<k) {
            num = arr[p]+(k-currSum);
        }
        else {
            currSum = currSum - diffs[p];
            num = (p==0 ? 0 : arr[p-1]) + (k-currSum); 
        }
        
        return num;
    }
}
