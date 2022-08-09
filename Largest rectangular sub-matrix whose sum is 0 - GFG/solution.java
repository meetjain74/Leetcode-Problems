/*Problem link - https://practice.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1 */

class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int R = a.length;
        int C = a[0].length;
        
        int rowStart = -1;
        int rowEnd = -1;
        int colStart = -1;
        int colEnd = -1;
        int maxArea = 0;
        
        // Iterate over rows - Fix two rows left and right
        // Find sum of all columns between these rows
        // and store it in a temporary array of size C
        for (int left=0;left<R;left++) {
            int[] array = new int[C];
            for (int right=left;right<R;right++) {
                // Iterate over all rows
                for (int i=0;i<C;i++) {
                    array[i]+=a[right][i];
                }
                
                // Find largest subarray with sum 0 on array now
                int[] curr = largestSubarraySum0(array,C);
                if (curr[0]==0)
                    continue;
                
                int currLen = curr[0];
                int currWidth = right-left+1;
                int maxLength = colEnd-colStart+1;
                //System.out.println(rowStart+" "+rowEnd+" "+colStart+" "+colEnd);
                if ((currLen*currWidth>maxArea) || 
                    (currLen*currWidth==maxArea && currLen>maxLength)) {
                    maxArea = currLen*currWidth;
                    rowStart = left;
                    rowEnd = right;
                    colStart = curr[1]-curr[0]+1;
                    colEnd = curr[1];
                }
            }
        }
        
        //System.out.println(rowStart+" "+rowEnd+" "+colStart+" "+colEnd);
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (rowStart==-1) {
            // No submatrix exists
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(-1);
            ans.add(temp);
            return ans;
        }
        
        for (int i=rowStart;i<=rowEnd;i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j=colStart;j<=colEnd;j++) {
                temp.add(a[i][j]);
            }
            ans.add(temp);
        }
        
        return ans;
    }
    
    public static int[] largestSubarraySum0(int array[],int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        int end = -1;
        map.put(0,-1);
        
        int currSum = 0;
        for (int i=0;i<n;i++) {
            currSum = currSum+array[i];
            if (map.containsKey(currSum)) {
                int currLen = i-map.get(currSum);
                if (currLen>maxLen) {
                    maxLen = currLen;
                    end = i;
                }
            }
            else {
                map.put(currSum,i);
            }
        }
        
        return new int[]{maxLen,end};
    }
}
        
