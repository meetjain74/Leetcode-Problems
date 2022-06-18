// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends

/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		return sortRecursive(s);
	}
	
	// Iterative method to sort an array
	public Stack<Integer> sortIterative(Stack<Integer> s) {
	    Stack<Integer> sorted = new Stack<>();
		while (!s.isEmpty()) {
		    int x = s.pop();
		    while(!sorted.isEmpty() && sorted.peek()>x)
		        s.push(sorted.pop());
		    sorted.push(x);
		}
		
		return sorted;
	}
	
	// Recursive method to sort stack
	public Stack<Integer> sortRecursive(Stack<Integer> s) {
	    if (s.isEmpty())
	        return s;
	        
	   // Remove one element from stack and call the sort function again
	   int temp = s.pop();
	   Stack<Integer> res = sortRecursive(s);
	   
	   // Insert temp at correct position in sorted stack
	   insertAtCorrectPos(s,temp);
	   
	   return res;
	}
	
	private void insertAtCorrectPos(Stack<Integer> s,int x) {
	    if (s.isEmpty() || s.peek()<x) {
	        s.push(x);
	        return;
	    }
	    
	    int top = s.pop();
	    insertAtCorrectPos(s,x);
	    s.push(top);
	}
}