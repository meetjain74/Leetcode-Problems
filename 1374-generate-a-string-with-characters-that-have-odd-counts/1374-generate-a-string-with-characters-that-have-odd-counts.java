class Solution {
    public String generateTheString(int n) {
        char [] arr = new char [n];
        Arrays.fill(arr, 'a');
        if(n%2==0)
            arr[0]='b';
        
        return new String(arr);
    }
}