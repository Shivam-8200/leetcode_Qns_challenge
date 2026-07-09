class Solution {
    public long sumAndMultiply(int n) {
       long sum = 0;
long concat = 0;

// n ko string mein convert karo!
String s = String.valueOf(n);

for(char c : s.toCharArray()){
    int digit = c - '0';  // char to int!
    sum += digit;
    if(digit != 0){
        concat = concat * 10 + digit;  // concatenate!
    }
}

return concat * sum; 
    }
}