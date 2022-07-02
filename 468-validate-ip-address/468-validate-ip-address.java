class Solution {
    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP))
            return "IPv4";
        if (isIPv6(queryIP))
            return "IPv6";
        
        return "Neither";
    }
    
    private boolean isIPv4(String IP) {
        IP+=".";
        String curr = "";
        int dotCount = 0;
        for (char ch: IP.toCharArray()) {
            if (ch=='.') {
                if (curr.equals(""))
                    return false;
                
                if (curr.length()>3)
                    return false;
                
                int num = Integer.parseInt(curr);
                if (num<0 || num>255)
                    return false;
                
                dotCount++;
                curr="";
                continue;
            }
                
            else if (!Character.isDigit(ch))
                return false;
            
            else if (curr.equals("0"))
                return false;
            
            curr += ch;
        }
        
        if (dotCount!=4)
            return false;
        
        return true;
    }
    
    private boolean isIPv6(String IP) {
        IP+=":";
        String curr = "";
        int colonCount = 0;
        for (char ch: IP.toCharArray()) {
            if (ch==':') {
                if (curr.equals(""))
                    return false;
                
                if (curr.length()>4)
                    return false;
                
                colonCount++;
                curr="";
                continue;
            }
            
            else if (!isHex(ch))
                return false;
            
            curr += ch;
        }
        
        if (colonCount!=8)
            return false;
        
        return true;
    }
    
    private boolean isHex(char ch) {
        if (Character.isDigit(ch) || (ch>='a' && ch<='f') || (ch>='A' && ch<='F'))
            return true;
        return false;
    }
}