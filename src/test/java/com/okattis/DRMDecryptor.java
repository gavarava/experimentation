package com.okattis;

import java.util.stream.Stream;

public class DRMDecryptor {

    private static final String[] CHARACTER_VALUES_ARRAY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
        "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String decrypt(String encryptedData) {
        // divide
        String frontPart = encryptedData.substring(0, encryptedData.length() / 2);
        System.out.println(frontPart);

        int rotationValueOfFirstPart = getRotationValueOfData(frontPart);

        String backPart = encryptedData.substring(encryptedData.length() / 2, encryptedData.length());
        System.out.println(backPart);
        // merge

        // rotate

        return "";
    }

    private static int getRotationValueOfData(String frontPart) {
        int rotationValue = 0;
        for (int i = 0; i < CHARACTER_VALUES_ARRAY.length; i++) {
            if (frontPart.contains(CHARACTER_VALUES_ARRAY[i])) {
                rotationValue+=i;
            }
        }

        return 0;
    }

}
