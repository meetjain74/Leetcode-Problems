class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
		getNums(res,0,n);
        return res;
    }
    
    public void getNums(List<Integer> res,int i,int num) {
		//if (i>num) return;

		if (i!=0 && i<=num) 
			res.add(i);

		for (int j= (i==0) ? 1:0;j<=9;j++) {
			int n = i*10+j;
			if (n<=num) {
				getNums(res,n,num);
			}
		}
	}
}