package com.test.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    public static final String scriptReg = "<script[\\s\\S]+?</script>";
    public static final String iframeReg = "<iframe[\\s\\S]+?</iframe>";

    public static String clearHtmlTag(String content) {
        if (!isNullOrEmpty(content)) {
            content = clearSpecialContent(content, scriptReg);
            content = clearSpecialContent(content, iframeReg);
            content = clearSpecialContent(content, "(<[^>\\s]*\\b(\\w)+\\b[^>]*>)|([\\s]+)|(<>)|(&nbsp;)");
            content = content.replace("\"", "").replace("<", "").replace(">", "");
        }
        return content;
    }

    public static String clearImageAndScript(String content) {
        String regexExpression = "<script[\\s\\S]+</script *>|<s*img[^>]*>";
        return clearSpecialContent(content, regexExpression);
    }

    public static String clearSpecialContent(String content, String regexExpression) {
        if (isNullOrEmpty(content)) {
            return "";
        }
        Pattern pattern = Pattern.compile(regexExpression, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        return content;
    }

    public static String replaceSpecialContent(String sourceStr, String targetStr, String regexExp, int flags) {
        Pattern pattern = Pattern.compile(regexExp, flags);
        Matcher matcher = pattern.matcher(sourceStr);
        sourceStr = matcher.replaceAll(targetStr);
        return sourceStr;
    }

    public static String substringContent(String sourceStr, String regexExp, int flags) {
        Pattern pattern = Pattern.compile(regexExp, flags);
        Matcher matcher = pattern.matcher(sourceStr);
        return matcher.find() ? matcher.group() : "";
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || "".equals(value);
    }

    /**
     * 判断传入的value是null还是空白的字符串
     *
     * @param value
     * @return
     */
    public static boolean isNullOrWhiteSpace(String value) {
        return value == null || "".equals(value) || "".equals(value.trim());
    }


    /**
     * 转半角的函数
     *
     * @param value 任意字符串
     * @return 半角字符串
     */
    public static String toDBC(String value) {
        char[] c = value.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 获取没有连字号的UUID
     *
     * @return
     */
    public static String getUUIDWithoutHyphen() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String trimStart(String source, char element) {
//        source.replaceFirst()
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do {
            int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
            int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source.lastIndexOf(element) : source.length();
            source = source.substring(beginIndex, endIndex);
            beginIndexFlag = (source.indexOf(element) == 0);
            endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
        } while (beginIndexFlag || endIndexFlag);
        return source;
    }

    /**
     * 过滤emoji表情
     *
     * @param source
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source) {
        if (isNullOrWhiteSpace(source)) {
            return source;
        }

        return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
    }

    public static String toString(Object obj, String defaultValue) {
        return obj != null ? obj.toString() : defaultValue;
    }

    public static String toString(Object obj) {
        return toString(obj, "");
    }

    /**
     * 生成32位md5码
     *
     * @param text
     * @return
     */
    public static String md5(String text) {
        StringBuilder builder = new StringBuilder();

        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());

            for (byte b : result) {
                int number = b & 0xff;
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    builder.append("0");
                }
                builder.append(str);
            }

        } catch (NoSuchAlgorithmException e) {

        }

        return builder.toString();
    }

    public static String padLeft(String str, int totalWidth, char paddingChar) {
        if (str == null || str.length() >= totalWidth) {
            return str;
        }

        StringBuilder result = new StringBuilder(totalWidth);
        int len = totalWidth - str.length();
        for (; len > 0; len--) {
            result.append(paddingChar);
        }
        result.append(str);
//        } else {
//            result.append(source);
//            for (; len > 0; len--) {
//                result.append(fillChar);
//            }
//        }
        return result.toString();
    }

}
