class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x>y){
            return removePattern(s,'a','b',x,y);
        }
        else{
            return removePattern(s,'b','a',y,x);
        }
    }
    private int removePattern(String s ,char first,char second,int high,int low){
        Stack<Character> st=new Stack<>();
        int score=0;
        // remove all the occurance of "ab" ? x>y : "ba" 
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==first && ch==second){
                st.pop();
                score+=high;
            }
            else{
                st.push(ch);
            }
        }
        
        // copying character in reversed order from stack
        StringBuilder remaining=new StringBuilder();
        while(!st.isEmpty()){
            remaining.insert(0,st.pop());
        }
        
        // remove other substring according to condition
        for(char ch:remaining.toString().toCharArray()){
            if(!st.isEmpty() && st.peek()==second && ch==first){
                st.pop();
                score+=low;
            }
            else{
                st.push(ch);
            }
        }
        return score;
    }
}