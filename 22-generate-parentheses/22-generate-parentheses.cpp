class Solution {
public:
    vector<string>res;
    vector<string> generateParenthesis(int n) {
        fun("", n, 0);
        return res;
    }
    
    void fun(string s, int u, int left)
    {
        if(u==0 and left ==0 )
        {
            res.push_back(s);
            return;
        }
        if(u>0)
        {
            fun(s+'(', u-1, left+1);
        }
        if(left>0)
        {
            fun(s+')', u, left-1);
        }
    }
};