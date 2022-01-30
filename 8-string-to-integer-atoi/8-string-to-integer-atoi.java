class Solution {
    public int myAtoi(String s) {
        long val=0;
        boolean firstSignOccurence=true;
        boolean valueStored=false;
        int sign=1;
        for (int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if (!valueStored && Character.isSpace(ch))
                continue;
            else if (ch=='+' && firstSignOccurence)
            {
                valueStored=true;
                firstSignOccurence=false;
                sign=1;
            }
            else if (ch=='-' && firstSignOccurence)
            {
                valueStored=true;
                firstSignOccurence=false;
                sign=-1;
            }
            else if (Character.isDigit(ch))
            {
                firstSignOccurence=false;
                valueStored=true;
                val=val*10+(ch-'0');
                if (sign*val>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if (sign*val<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            else // Non digit character
                break;           
        }
        
        val=sign*val;
        return (int)val;
    }
}