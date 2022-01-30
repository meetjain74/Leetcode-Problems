class Solution {
    public String longestCommonPrefix(String[] strs) {
        String output = "";
        
        for (int index=0,len=strs[0].length();index<len;index++){
            boolean flag = true;
            char ch = strs[0].charAt(index);
            for (int i=1;i<strs.length;i++) {
                String temp = strs[i];
                if (index>=temp.length())
                    return output;
                
                if (temp.charAt(index)!=ch) 
                    flag = false;
            }
            if (!flag)
                return output;
            output = output+ch;
        }
        return output;
    }
}