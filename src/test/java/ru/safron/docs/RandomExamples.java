package ru.safron.docs;

import static ru.safron.utils.RandomUtils.*;

public class RandomExamples {
    public static void main(String[] args) {
        System.out.println(getRandomString(17));

        String randomMessage = getRandomMessage(17, 17);
        System.out.println(randomMessage);

        int randomInt = getRandomInt(11111, 7777777);
        System.out.println(randomInt + "");

        String randomPhone = getRandomPhone();
        System.out.println(randomPhone);

        String randomPhoneWithPrefix = getRandomPhone("+7");
        System.out.println(randomPhoneWithPrefix);

        String difficultRandomPhoneWithPrefix = getDifficultRandomPhone("+8");
        System.out.println(difficultRandomPhoneWithPrefix);

        String randomEmail = getRandomEmail();
        System.out.println(randomEmail);
    }
}
