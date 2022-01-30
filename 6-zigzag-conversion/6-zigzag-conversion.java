class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) 
            return s;

        // Create a list of rows storing respective row strings
        List<String> rows = new ArrayList<>();
        
        // Number of rows will be minimum of input string length or input rows
        for (int i=0;i<Math.min(numRows,s.length());i++)
            rows.add("");

        int currentRow = 0;
        boolean goingDown = false;

        for (int i=0;i<s.length();i++) 
        {
            char ch = s.charAt(i);
            rows.set(currentRow,rows.get(currentRow)+ch);
            
            if (currentRow == 0 || currentRow == numRows - 1) 
                goingDown = !goingDown;
            
            currentRow += goingDown ? 1 : -1;
        }

        String finalString="";
        for (int i=0;i<rows.size();i++)
            finalString+=rows.get(i);
        
        return finalString;
    }
}