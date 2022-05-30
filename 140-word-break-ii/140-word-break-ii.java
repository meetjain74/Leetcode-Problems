class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        helper(ans,s,wordDict,"","",0,s.length(),false);
        return ans;
    }
    
    public void helper(List<String> ans,String s, List<String> wordDict,
                       String sentence, String word, int i, int size,boolean flag) {
        if (i==size) {
            if (flag) 
                ans.add(sentence.substring(0,sentence.length()-1));
            return;
        }
        
        word = word + Character.toString(s.charAt(i));
        helper(ans,s,wordDict,sentence,word,i+1,size,false);
        if (wordDict.contains(word)) {
            sentence = sentence + word + " ";
            word = "";
            helper(ans,s,wordDict,sentence,word,i+1,size,true);
        }
    }
}