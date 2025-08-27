package com.cronit.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {

    @Test 
    void testHashAndVerifyPassword() {
        String password = "password123!";
        String hash = PasswordUtil.hashPassword(password);
        assertNotNull(hash, "Hash should not be null.");
        assertTrue(PasswordUtil.verifyPassword(hash, password), "Password should verify correctly.");
    }

    @Test
    void testWrongPasswordFailsVerification() {
        String password = "password123!";
        String wrongPassword = "wrongpass";

        String hash = PasswordUtil.hashPassword(password);

        assertFalse(
            PasswordUtil.verifyPassword(hash, wrongPassword),
            "Wrong password should not verify."
        );
    }

    @Test
    void testDifferentPasswordsProduceDifferentHashes() {
        String pw1 = "password123!";
        String pw2 = "password1234!";

        String hash1 = PasswordUtil.hashPassword(pw1);
        String hash2 = PasswordUtil.hashPassword(pw2);

        assertNotEquals(hash1, hash2, "Different passwords should yield different hashes.");
    }

    @Test
    void testSamePasswordDifferentSaltDifferentHashes() {
        String pw = "password123!";

        String hash1 = PasswordUtil.hashPassword(pw);
        String hash2 = PasswordUtil.hashPassword(pw);

        assertNotEquals(hash1, hash2, "Same password should generate different hashes due to random salt");
        assertTrue(PasswordUtil.verifyPassword(hash1, pw), "First hash should verify.");
        assertTrue(PasswordUtil.verifyPassword(hash2, pw), "Second hash should verify.");
    }
    
}