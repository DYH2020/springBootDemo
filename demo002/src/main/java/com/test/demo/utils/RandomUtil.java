package com.test.demo.utils;

import java.util.Random;

public class RandomUtil {

    //数字+字母
    private static final String CHARS = "1234560987qazxswedcvfrtgbnhyujmkliopPLOKMIJNUHBYGVCFTRDXZSEWAQ";

    //字母
    private static final String LETTERS = "QAZXSWEDCVFRTGBNHYUIOPJKLMqwertyuioplkjhgfdsazxcvbnm";


    /**
     * 获取由随机数组成的字符串
     *
     * @param length 字符串长度
     * @param type   随机数组成类型，1-数字，2-字母，3-数字字母混合
     * @return
     */
    public static String getRandomCode(int length, int type) {
        switch (type) {
            case 1:
                return getDigitCode(length);
            case 2:
                return getLetterCode(length);
            case 3:
                return getCharCode(length);
            default:
                return "";
        }
    }

    /**
     * 获取数字验证码
     * @param length
     * @return
     */
    private static String getDigitCode(int length) {
        String code = "";
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            code += random.nextInt(10);
        }

        return code;
    }

    /**
     * 获取字母验证码
     * @param length
     * @return
     */
    private static String getLetterCode(int length) {
        String code = "";
        Random random = new Random();
        int bound = LETTERS.length();

        for (int i = 0; i < length; i++) {
            code += LETTERS.charAt(random.nextInt(bound));
        }

        return code;
    }

    /**
     * 获取字符验证码（数字+字母）
     * @param length
     * @return
     */
    private static String getCharCode(int length) {
        String code = "";
        Random random = new Random();
        int bound = CHARS.length();

        for (int i = 0; i < length; i++) {
            code += CHARS.charAt(random.nextInt(bound));
        }

        return code;
    }
}
