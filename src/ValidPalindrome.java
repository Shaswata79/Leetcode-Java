public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = cleanString(s);
        String reverse = "";

        for(int i = s.length() - 1; i >= 0; i--){
            reverse = reverse + s.charAt(i);
        }

        return reverse.equals(s);
    }

    private String cleanString(String input){
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

}
