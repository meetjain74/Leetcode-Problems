class Solution {
    public String removeDuplicates(String s, int k) {
        int i = 0;
        int n = s.length();
        int[] count = new int[n];
        char[] copy = s.toCharArray();
        for (int j=0;j<n;j++,i++) {
            copy[i]=copy[j];
            count[i]=1;
            if (i>0 && copy[i-1]==copy[j]) {
                count[i] = count[i-1]+1;
            }
            
            if (count[i]==k) {
                i-=k;
            }
        }
        
        return new String(copy,0,i);
    }
}