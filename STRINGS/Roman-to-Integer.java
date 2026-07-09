class Solution {
    public int romanToInt(String s) {
        int res=0;
        HashMap<Character,Integer>roman=new HashMap<>();

        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        for(int i=0;i<s.length()-1;i++){
            if(roman.get(s.charAt(i))<roman.get(s.charAt(i+1))){
                res-=roman.get(s.charAt(i));
            }else{
                res+=roman.get(s.charAt(i));
            }
        }
        return res+roman.get(s.charAt(s.length()-1));
    }
}

/*To solve this problem, I first created a HashMap<Character, Integer> to store the integer value corresponding to each Roman numeral, such as I → 1, V → 5, X → 10, and so on.

Then, I traversed the string from left to right. For each character, I compared its value with the value of the next character.

If the current character's value is greater than or equal to the next character's value, it represents a normal Roman numeral, so I added its value to the final answer.
Otherwise, it is one of the special subtraction cases (such as IV, IX, XL, XC, CD, or CM). In this case, I subtracted the current character's value from the answer.

To avoid an IndexOutOfBoundsException while accessing the next character, I iterated only up to the second-last character. After the loop, I added the value of the last character separately, since it is never followed by another character.

Finally, I returned the computed sum.

Time Complexity
O(n) — We traverse the string once, and each HashMap lookup takes O(1) on average.
Space Complexity
O(1) — The HashMap stores only the seven Roman numeral symbols, so its size is constant. Therefore, the extra space used is constant.*/
