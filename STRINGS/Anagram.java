class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        if(s1.length()!=s2.length()){
            return false;
        }
        int freq[]=new int[26];
        for(char ch:s1.toCharArray()){
            freq[ch-'a']++;
        }

        for(char ch:s2.toCharArray()){
            freq[ch-'a']--;
        }

        for(int count:freq){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}

