class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> temp = new ArrayList<>();
        for (int i=0;i<=rowIndex;i++) {
            List<Integer> row = new ArrayList<>();
            if (i==0)
                row.add(1);
            else {
                List<Integer> x = temp.get(i-1);
                for (int j=0;j<=i;j++) {
                    if (j==0)
                        row.add(x.get(0));
                    else if (j==i)
                        row.add(x.get(j-1));
                    else
                        row.add(x.get(j-1)+x.get(j));
                }
            }
            temp.add(row);
        }
        
        return temp.get(rowIndex);
    }
}