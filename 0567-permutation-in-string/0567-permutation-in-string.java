class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        // s1 ka count banao
        for(char c : s1.toCharArray()){
            s1Count[c - 'a']++;
        }
        
        // pehli window banao
        for(int i = 0; i < s1.length(); i++){
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        // window slide karo
        for(int i = s1.length(); i < s2.length(); i++){
            if(Arrays.equals(s1Count, windowCount)) return true;
            
            // naya character add karo
            windowCount[s2.charAt(i) - 'a']++;
            // purana character hatao
            windowCount[s2.charAt(i - s1.length()) - 'a']--;
        }
        
        return Arrays.equals(s1Count, windowCount);
    }
}

/*if(s1.length() > s2.length()) return false;

// 2 > 8? NO → aage badho! ✅
int[] s1Count = new int[26];
int[] windowCount = new int[26];
// dono arrays khali hain — sab 0!

// s1 ka count banao
for(char c : s1.toCharArray())

c='a' → s1Count['a'-'a']++ = s1Count[0]++ = 1
c='b' → s1Count['b'-'a']++ = s1Count[1]++ = 1

s1Count = [1,1,0,0,0...] // a=1, b=1


// pehli window banao — size = s1.length() = 2
for(int i = 0; i < 2; i++)


i=0 → s2.charAt(0)='e' → windowCount['e'-'a']++ = windowCount[4]++ = 1
i=1 → s2.charAt(1)='i' → windowCount['i'-'a']++ = windowCount[8]++ = 1

windowCount = [0,0,0,0,1,0,0,0,1,0...] // e=1, i=1



s1Count == windowCount? 
[1,1,0...] == [0,0,0,0,1,0,0,0,1,0...]? ❌

// naya add karo
s2.charAt(2)='d' → windowCount[3]++ = 1
// purana hatao
s2.charAt(2-2)=s2.charAt(0)='e' → windowCount[4]-- = 0

windowCount = [0,0,0,1,0,0,0,0,1,0...] // d=1, i=1



s1Count == windowCount? ❌

// naya add karo
s2.charAt(3)='b' → windowCount[1]++ = 1
// purana hatao
s2.charAt(1)='i' → windowCount[8]-- = 0

windowCount = [0,1,0,1,0...] // b=1, d=1


s1Count == windowCount? ❌

// naya add karo
s2.charAt(4)='a' → windowCount[0]++ = 1
// purana hatao
s2.charAt(2)='d' → windowCount[3]-- = 0

windowCount = [1,1,0,0,0...] // a=1, b=1


s1Count == windowCount?
[1,1,0...] == [1,1,0...]? ✅ → return true! 🎉*/