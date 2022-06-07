class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        
        while(low<=high) {
            int mid = low + (high-low)/2;
            if (letters[mid]==target && letters[(mid+1)%letters.length]!=target)
                return letters[(mid+1)%letters.length];
            else if (letters[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        
        return letters[low%letters.length];
    }
}