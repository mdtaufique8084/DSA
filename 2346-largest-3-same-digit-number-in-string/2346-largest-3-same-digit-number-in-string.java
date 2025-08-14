class Solution {
    public String largestGoodInteger(String num) {
        String[] arr=new String[10];
        for(int i=9;i>=0;i--){
            arr[9-i]=String.valueOf(i).repeat(3);
        }
        for(String str:arr){
            if(num.contains(str)){
                return str;
            }
        }
        return "";
    }
}