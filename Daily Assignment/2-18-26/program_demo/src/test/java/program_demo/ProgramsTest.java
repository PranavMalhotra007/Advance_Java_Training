package program_demo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ProgramsTest {
    @Test
    void testPalindromeTrue() {
        assertTrue(Programs.checkPalindrome("madam"));
    }
    @Test
    void testPalindromeFalse() {
        assertFalse(Programs.checkPalindrome("hello"));
    }
    @Test
    void testPalindromeSingleChar() {
        assertTrue(Programs.checkPalindrome("a"));
    }
    @Test
    void testPrimeNumber() {
        assertTrue(Programs.checkPrime(13));
    }
    @Test
    void testNonPrimeNumber() {
        assertFalse(Programs.checkPrime(15));
    }
    @Test
    void testArmstrongNumber() {
        assertTrue(Programs.checkArmstrong(153));
        assertTrue(Programs.checkArmstrong(370));
        assertFalse(Programs.checkArmstrong(123));
    }
    @Test
    void testSingleDigitArmstrong() {
        assertTrue(Programs.checkArmstrong(5));
    }
}