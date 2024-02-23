import java.util.HashMap;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        HashMap<Character, Integer> letters = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(letters.containsKey(c)){
                int val = letters.get(c);
                val++;
                letters.put(c, val);
            }else {
                letters.put(c, 1);
            }
        }

        Character largestOdd = null;
        int totalEven = 0;

        for (char c : letters.keySet()){
            int n = letters.get(c);
            if(n%2 == 1){
                if(largestOdd == null){
                    largestOdd = c;
                }else{
                    if(n > letters.get(largestOdd)){
                        largestOdd = c;
                    }
                }
            }
        }

        for (char c : letters.keySet()){
            int n = letters.get(c);
            if(n%2 == 1){
                if(c != largestOdd){
                    totalEven = totalEven + n - 1;
                }
            }else {     // even
                totalEven = totalEven + n;
            }
        }

        if(largestOdd == null){
            return totalEven;
        }

        return totalEven+letters.get(largestOdd);
    }
}
