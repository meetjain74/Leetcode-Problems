class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char ch: n.toCharArray()) {
            int digit = ch-'0';
            if (digit==9)
                return 9;
            maxDigit = Math.max(digit,maxDigit);
        }
        return maxDigit;
    }
}