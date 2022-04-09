import java.util.*;
public class Main {
	static List<String> ans = new ArrayList<>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean visited[] = new boolean[26];
		getUniquePermutations(str.toCharArray(),visited,0);
		Collections.sort(ans);
		for (int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}

	public static void getUniquePermutations(char str[],boolean[] visited,int i) {
		if (i==str.length) {
			ans.add(String.valueOf(str));
			return;
		}

		for (int j=i;j<str.length;j++) {
			char ch = str[j];
			if (!visited[ch-'A']) {
				swapAtIdx(str,i,j); // swap str[i] and str[j]
				getUniquePermutations(str,new boolean[26],i+1);
				swapAtIdx(str,i,j); // unswap str[i] and str[j] while backtrack
				visited[ch-'A']=true;
			}
		}
	}

	public static void swapAtIdx(char str[],int i,int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
}


/*
Example testcase - 

Input:
ABA

Output:
AAB
ABA
BAA
*/
