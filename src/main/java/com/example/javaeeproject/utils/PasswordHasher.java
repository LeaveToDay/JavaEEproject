package com.example.javaeeproject.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static Boolean checkPasswords(String passwordPlain, String passwordEncrypted) {
        return BCrypt.checkpw(passwordPlain, passwordEncrypted);
    }
}
