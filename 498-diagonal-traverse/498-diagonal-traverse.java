class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int res[] = new int[m*n];
        
        int idx = 0; //Pointer to move on the resultant array
        int row = 0;
        int col = 0;
        
        //In each diagonal the sum of indices all through its length remains same
        //The sum could range between 0 to (m-1)+(n-1)
        //sum is even -> up
        //sum is odd -> down
        
        for(int sum=0;sum<=m+n-2;sum++){
            
            if(sum%2==0) {
                //Up Direction i.e row-- col++
                while(row>=0 && col<n){
                    res[idx++] = mat[row][col];
                    row--;
                    col++;
                }
                row++; //As row goes out of matrix and becomes negative
                
                //When all the columns of a row are covered i.e. col becomes n 
                if(col==n){ 
                    row++; //To bring it back in the matrix
                    col--; //As col becomes n we need to decrement it
                }
            }
            
            else {
                //Down Direction i.e row++ col--
                while(row < m && col >= 0){
                    res[idx++] = mat[row][col];
                    row++;
                    col--;
                }
                col++; //As col goes out of matrix and becomes negative
                
                //When all the rows of a column are covered i.e. row becomes m
                if(row==m){
                    row--; //As row becomes m we need to decrement it
                    col++; //To bring it back in the matrix
                }
            }
        }
        
        return res;
    }
}

//To imagine the above approach

//            | (-1,0)| (-1,1)| (-1,2)| (-1,3)|
//     _______|_______|_______|_______|_______|_______
//     (0,-1) | (0,0) | (0,1) | (0,2) | (0,3) | (0,4)
//     _______|_______|_______|_______|_______|_______
//     (1,-1) | (1,0) | (1,1) | (1,2) | (1,3) | (1,4)
//     _______|_______|_______|_______|_______|_______
//     (2,-1) | (2,0) | (2,1) | (2,2) | (2,3) | (2,4)
//     _______|_______|_______|_______|_______|_______
//     (3,-1) | (3,0) | (3,1) | (3,2) | (3,3) | (3,4)
//     _______|_______|_______|_______|_______|_______
//            | (-1,0)| (-1,1)| (-1,2)| (-1,3)|   