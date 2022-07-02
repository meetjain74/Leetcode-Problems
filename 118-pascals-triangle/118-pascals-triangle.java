class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=1;i<=numRows;i++) {
            List<Integer> row = new ArrayList<>();
            if (i==1)
                row.add(1);
            else {
                for (int j=0;j<i;j++) {
                    if (j==0)
                        row.add(ans.get(i-2).get(0));
                    else if (j==i-1)
                        row.add(ans.get(i-2).get(j-1));
                    else
                        row.add(ans.get(i-2).get(j-1)+ans.get(i-2).get(j));
                }
            }
            ans.add(row);
        }
            
        return ans;
    }
}