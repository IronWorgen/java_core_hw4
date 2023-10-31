package org.example;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class UserAuthentication {

    public static boolean userCheck(String login, String password, String confirmPassword) {
        if (login.length() >= 20) {
            throw new WrongLoginException("Длинный логин");
        }

        if (password.length() >= 20) {
            throw new WrongPasswordException("Длинный пароль");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

        return true;
    }
}
