public class Palindrome {
    public static boolean isPalindrome(String word) {
        int b = 0;
        int e = word.length() - 1;

        while (b <= e) {
            if (Character.toLowerCase(word.charAt(b)) != Character.toLowerCase(word.charAt(e)))
                return false;

            b++;
            e--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}