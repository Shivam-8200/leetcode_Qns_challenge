class Solution {
    public long sumAndMultiply(int n) {
       int place=1;
int x=0;
int sum=0;
while(n>0){
int digit=n%10;
sum=sum+digit;

if(digit!=0){
x+=digit*place;
place=place*10;
}
n=n/10;
}
return 1L*x*sum; 
    }
}