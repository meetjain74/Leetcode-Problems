class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s==null || words==null || s.length()==0 || words.length==0) 
            return result;
        
        int noOfWords=words.length;
        int lengthOfOneWord=words[0].length(); 
        
        Map<String,Integer> frequencyOfWords = new HashMap<>();
        for (int i=0;i<noOfWords;i++) {
            String word=words[i];
            frequencyOfWords.put(word,frequencyOfWords.getOrDefault(word,0)+1);
        }
        
        // Iterate through the string s only upto length-lengthOfOneWord*noOfWords
        for (int i=0;i<=s.length()-noOfWords*lengthOfOneWord;i++) {
            
            Map<String,Integer> visitedWords = new HashMap<>();
            
            // The string from i to lengthOfOneWord*noOfWords 
            // should contain all words exactly once
            for (int j=0;j<noOfWords;j++) {
                int startIndex = i+j*lengthOfOneWord;
                int endIndex = startIndex+lengthOfOneWord;
                
                String temp = s.substring(startIndex,endIndex);
                
                if (frequencyOfWords.containsKey(temp)) {
                    visitedWords.put(temp,visitedWords.getOrDefault(temp,0)+1);
                    if (visitedWords.get(temp)>frequencyOfWords.get(temp))
                        break;
                }
                else {
                    break;
                }
                
                if (j==noOfWords-1)
                    result.add(i);
            }
        }
        return result;
    }
}