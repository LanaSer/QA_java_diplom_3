package client;

import client.User;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterGenerator {
    public static User random() {
        return new User(RandomStringUtils.randomAlphabetic(10) + "@example.com", "123422", RandomStringUtils.randomAlphabetic(10));
    }
}
