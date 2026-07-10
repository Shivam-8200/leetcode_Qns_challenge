class Solution {
    public long sumAndMultiply(int n) {
        int place = 1;
        int x = 0;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;  // last digit nikalega like 10203004%10=4
            sum = sum + digit;

            if (digit != 0) {
                x += digit * place;
                place = place * 10;
            }
            n = n / 10;  // 102030004/4=1020300
        }
        return 1L * x * sum; // <- L = long hai
    }
}



/*
String s = String.valueOf(n);
int x = 0;
int sum = 0;

for(char c : s.toCharArray()){
    int digit = c - '0';
    sum += digit;
    if(digit != 0){
        x = x * 10 + digit;  // left to right concatenation!
    }
}
return 1L * x * sum;
*/