class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int i=0,len=digits.length();i<len;i++) {
            char ch = digits.charAt(i);
            result = CartesianProduct(result,mapping(ch));
        }
        return result;
    }
    
    // Returns cartesian product of two lists
    private List<String> CartesianProduct(List<String> list1, List<String> list2) {
        List<String> product = new ArrayList<>();
        if (list1.isEmpty()) 
            return list2;
        
        for (int i=0;i<list1.size();i++) {
            for (int j=0;j<list2.size();j++) {
                product.add(list1.get(i)+list2.get(j));
            }
        }
        return product;
    }
    
    private List<String> mapping(char num) {
        switch(num) {
            case '2': return Arrays.asList("a","b","c");
            case '3': return Arrays.asList("d","e","f");
            case '4': return Arrays.asList("g","h","i");
            case '5': return Arrays.asList("j","k","l");
            case '6': return Arrays.asList("m","n","o");
            case '7': return Arrays.asList("p","q","r","s");
            case '8': return Arrays.asList("t","u","v");
            case '9': return Arrays.asList("w","x","y","z");
            default: return Arrays.asList("");
        }
    }
}
