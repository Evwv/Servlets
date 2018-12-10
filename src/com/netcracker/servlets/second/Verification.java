package com.netcracker.servlets.second;

public class Verification {

    public String check(String login, String pass) {
        final String truePaswword = "googleBetterApple";
        final String trueLogin = "IamAdmin";
        StringBuilder stringBuilder = new StringBuilder();

        if (login.equals(trueLogin) && pass.equals(truePaswword)) {
            stringBuilder.append("<h1>Welcome to admin account</h1>");
        } else {
            stringBuilder.append("<h1>Welcome to the user account<h1>");
        }
        return stringBuilder.toString();
    }
}
