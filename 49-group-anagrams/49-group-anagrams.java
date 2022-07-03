class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(String i : strs){
            char[] ch = i.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            
            if(map.containsKey(s)){
                map.get(s).add(i);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(i);
                map.put(s,temp);
            }
        }
        
        for(String i : map.keySet()){
            list.add(map.get(i));
        }
        return list;
    }
}