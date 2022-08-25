class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        
        int n = arr.length;
        for (int i=n-1;i>=0;i--) {
            int maxIndex = 0;
            int max = arr[0];
            for (int j=1;j<=i;j++) {
                if (max<arr[j]) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            
            if (maxIndex==i)
                continue;
            
            // Reverse upto j
            if (maxIndex!=0) {
                reverse(arr,0,maxIndex);
                res.add(maxIndex+1);
            }
            
            // Reverse upto i
            reverse(arr,0,i);
            res.add(i+1);
        }
        
        return res;
    }
    
    public void reverse(int[] arr,int start,int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}