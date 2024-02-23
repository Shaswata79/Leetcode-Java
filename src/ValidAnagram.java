import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sChars = new HashMap<>();
        Map<Character, Integer> tChars = new HashMap<>();

        System.out.println(s.length());
        System.out.println(t.length());
        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(sChars.containsKey(c)){
                int val = sChars.get(c);
                val++;
                sChars.put(c, val);
            }else{
                sChars.put(c, 1);
            }

            Character d = t.charAt(i);
            if(tChars.containsKey(d)){
                int val = tChars.get(d);
                val++;
                tChars.put(d, val);
            }else{
                tChars.put(d, 1);
            }
        }

        for(Character key : sChars.keySet()){
            if(tChars.get(key) != sChars.get(key)){
                return false;
            }
        }

        return true;
    }

}
