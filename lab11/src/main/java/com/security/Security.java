package com.security;

public class Security {
	public boolean login(String userId, String password) {
			
        String errorMessage = "";

        // userId must not be null or spaces. Must be 8 chars minimum.
        // password must contain a digit and an upper case char

        if (userId == null || userId.trim().equals("")) {
            errorMessage = "UserID may not be null or empty";
            //throw new IllegalArgumentException();
            return false;
        }
        else if (password == null || password.trim().equals("")) {
            errorMessage = "Password may not be null or empty";
            return false;
        }
        else if (!validatePassword(password)) {
            errorMessage = "Password must be min 8 chars long with an uppercase and a number";
            
            throw new IllegalArgumentException(errorMessage);
            //return false;
        }
        else {
            errorMessage = errorMessage;
            return true;
        }
    }

    private boolean validatePassword(String password) {

        boolean hasUpper = false, hasDigit = false;

        if (password.length() < 8)
            return false;

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)) {
                hasUpper = true;
                // continue loop as no character can be both!
                continue;
            }

            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUpper && hasDigit;
    }
}

