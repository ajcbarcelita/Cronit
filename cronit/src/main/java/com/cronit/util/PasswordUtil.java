package com.cronit.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

import java.util.Arrays;

public final class PasswordUtil {
    private PasswordUtil() {}

    public static final int ITERATIONS = 4;
    public static final int MEMORY_KB = 131072; // 128 MB
    public static final int PARALLELISM = 2;

    public static String hashPassword(String pw) {
        char[] password = pw.toCharArray();
        Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
        try {
            return argon2.hash(ITERATIONS, MEMORY_KB, PARALLELISM, password);
        } finally {
            Arrays.fill(password, '\0');
        }
    }

    public static boolean verifyPassword(String hash, String pw) {
        char[] password = pw.toCharArray();
        Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
        try {
            return argon2.verify(hash, password);
        } finally {
            Arrays.fill(password, '\0');
        }
    }
}
