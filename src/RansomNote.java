import java.util.HashMap;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> ransomLetters = new HashMap<>();
        HashMap<Character, Integer> magazineLetters = new HashMap<>();

        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(ransomLetters.containsKey(c)){
                int val = ransomLetters.get(c);
                val++;
                ransomLetters.put(c, val);
            }else {
                ransomLetters.put(c, 1);
            }
        }

        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            if(magazineLetters.containsKey(c)){
                int val = magazineLetters.get(c);
                val++;
                magazineLetters.put(c, val);
            }else {
                magazineLetters.put(c, 1);
            }
        }


        for(Character c : ransomLetters.keySet()){
            if(magazineLetters.containsKey(c)){
                return false;
            }
            if(ransomLetters.get(c) > magazineLetters.get(c)){
                return false;
            }
        }

        return true;

    }

}
