package com.lexcoin.utils;

import java.util.UUID;

/**
 * @Author:chenyu
 * @Date: 2019/11/8 17:22
 */
public class UuidUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
