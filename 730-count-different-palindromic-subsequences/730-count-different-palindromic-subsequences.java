class Solution {
    int mod = 1000000007;
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        
        // Store next occurence of every character in s and -1 if no next occurence
        int next[] = new int[n];
        
        // Store previous occurence of every character in s and -1 if no previous occurence
        int prev[] = new int[n];
        
        // Store current occurence of character in string
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                prev[i]=map.get(ch);
            }
            else {
                prev[i]=-1;
            }
            
            map.put(ch,i);
        }
        
        map.clear();
        for (int i=n-1;i>=0;i--) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                next[i]=map.get(ch);
            }
            else {
                next[i]=-1;
            }
            
            map.put(ch,i);
        }
        
        // dp[i][j] stores the count of different palindromic subsequences
        // in the substring [i,j]
        int dp[][] = new int[n][n];
        
        // Diagonal elements are 1 as count of different palindromic subsequences
        // of length 1 is 1
        for (int i=0;i<n;i++) {
            dp[i][i] = 1;
        }
        
        // Different palindromic sequences of length 2 are 2
        // If both characters are unequal - char1 and char2 different subsequences
        // If both characters are equal - single char and both char subsequences
        for (int i=0;i<n-1;i++) {
            dp[i][i+1] = 2;
        }
        
        for (int g=2;g<n;g++) {
            for (int i=0,j=g;j<n;i++,j++) {
                
                int chi = s.charAt(i);
                int chj = s.charAt(j);
                
                if (chi!=chj) {
                    // Count different palindromic subsequences in prefix i.e [i,j)
                    // Count different palindromic subsequences in suffix i.e (i,j]
                    // As different palindromic subsequences in (i,j) 
                    // counted twice,subtract once
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                }
                
                else {
                    // chi and chj are equal say ch
                    // Get next and previous occurence of this character
                    
                    int nxt = next[i]; // Next occurence of ch after i
                    int prv = prev[j]; // Previous occurence of ch before j
                    
                    // Say string is (chi m chj)
                    // Where m is the middle part
                    
                    if (nxt>prv) {
                        // No same character ch between the string
                        // ch does not exists in middle part m i.e (i,j) 
                        
                        // Count different palindromic subsequences in middle part m
                        // Count different palindromic subsequences in middle part including
                        // ch at both ends - will also be a palindrome
                        // Character ch alone is a palindrome
                        // Character ch twice is a palindrome
                        
                        // i.e dp(m)+dp(m)+2
                        // Example- dp(abcda) = dp(bcd)+dp(bcd)+1+1
                        // first dp(bcd) represents palindromes- b,c,d
                        // second dp(bcd) represents palindromes - aba,aca,ada
                        // remaining 2 represents palindromes - a,aa
                        
                        dp[i][j] = dp[i+1][j-1] + dp[i+1][j-1] + 2;
                    }
                    
                    else if (nxt==prv) {
                        // Next occurence of chi is same as previous occurence of chj
                        // One occurence of ch in middle part. Ex - abcada
                        
                        // Count different palindromic subsequences in middle part m
                        // Count different palindromic subsequences in middle part including
                        // ch at both ends - will also be a palindrome
                        // Character ch alone is not a palindrome now as already counted
                        // Character ch twice is a palindrome
                        
                        // i.e dp(m)+dp(m)+1
                        // Example- dp(abcada) = dp(bcad)+dp(bcad)+1
                        // first dp(bcad) represents palindromes- b,c,a,d
                        // second dp(bcad) represents palindromes- aba,aca,aaa,ada
                        // remaining 1 represents palindrome- aa
                        // notice single character a is palindrome but not counted again
                        // as already included in first dp(bcad)
                        
                        dp[i][j] = dp[i+1][j-1] + dp[i+1][j-1] + 1;
                    }
                    
                    else {
                        // Next occurence of chi is less than previous occurence of chj
                        // Means more than or equal to two occurences of ch in middle part
                        // Ex - abacada
                        
                        // Count different palindromic subsequences in middle part m
                        // Count different palindromic subsequences in middle part including
                        // ch at both ends - will also be a palindrome 
                        // Character ch alone is not a palindrome now as already counted
                        // Character ch twice is not a palindrome now as already counted
                        // Also all palindromic subsequences between both ch 
                        // inside middle part is also counted twice - hence subtract once
                        
                        // i.e dp(m)+dp(m)-dp(m')
                        // where m' is part of string between next of chi and prev of chj
                        // Example- dp(abacada) = dp(bacad)+dp(bacad)-dp(c)
                        // first dp(bacad) represents palindromes- b,a,c,d,aa,aca
                        // second dp(bacad) represents palindromes- 
                        // aba,aaa,aca,ada,aaaa,aacaa
                        // notice a and aa is palindrome but not counted again
                        // as already included in first dp(bacad)
                        // Also you can see that palindrome aca has been counted twice
                        // i.e all distinct palindromic sequences of c have to be subtracted
                        // Example2 - dp(abacadafa) = dp(bacadaf)+dp(bacadaf)-dp(cad)
                        
                        dp[i][j] = dp[i+1][j-1] + dp[i+1][j-1] - dp[nxt+1][prv-1];
                    }
                }
                
                // Handle modulo
                if (dp[i][j]<0) {
                    dp[i][j] = dp[i][j]+mod;
                }
                else {
                    dp[i][j] = dp[i][j]%mod;
                }
            }
        }
        
        return dp[0][n-1];
    }
}