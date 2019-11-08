package com.lexcoin.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Author:chenyu
 * @Date: 2019/11/8 17:15
 */
public class Md5Utils {

    public static String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");

            //生成随机东东 不可逆
            byte[] bytes = md.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(bytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
