class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hL = horizontalCuts.length;
        int vL = verticalCuts.length;
        
        int maxLength = horizontalCuts[0];
        for (int i=1;i<=hL;i++) {
            if (i==hL)
                maxLength=Math.max(maxLength,h-horizontalCuts[i-1]);
            else
                maxLength=Math.max(maxLength,horizontalCuts[i]-horizontalCuts[i-1]);
        }
            
        int maxWidth = verticalCuts[0];
        for (int i=1;i<=vL;i++) {
            if (i==vL)
                maxWidth=Math.max(maxWidth,w-verticalCuts[i-1]);
            else
                maxWidth=Math.max(maxWidth,verticalCuts[i]-verticalCuts[i-1]);
        }
        
        return (int)(((long)maxLength*maxWidth)%1000000007);
    }
}