package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getAuthInfoWithInvalid() {
        Faker faker = new Faker();
        return new AuthInfo("vasya", faker.internet().password());
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }
}

