package easy_questions;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } 

        if (x % 10 == 0 && x != 0) {
            return false;  
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf *= 10;
            reversedHalf += x % 10;
            x /= 10;
        }

        return reversedHalf == x || reversedHalf / 10 == x;
    }
    
}
