class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

// s ke characters add karo
for(char c : s.toCharArray()){
    map.put(c, map.getOrDefault(c, 0) + 1);
}

// t ke characters minus karo
for(char c : t.toCharArray()){
    map.put(c, map.getOrDefault(c, 0) - 1);
}

// check karo sab 0 hain?
for(int val : map.values()){
    if(val != 0) return false;
}
return true;
    }
}