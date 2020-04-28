package com.database.foodtruck.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5的全称是Message-Digest Algorithm5（信息-摘要算法），
 * MD5算法简单来说就是把任意长度的字符串变换成固定长度（通常是128位）的十六进制字符串。
 * 在存储密码过程中，直接存储明文密码是很危险的，
 * 因此在存储密码过程中，直接存储明文密码。
 * Created by Jenny on 2019/2/19.
 */

public class MD5Utils {
    /**
     * MD5加密的算法
     */
    public static String md5(String text){
        MessageDigest digest = null;
        try {
            // 创建加密对象
            digest = MessageDigest.getInstance("md5");
            // 调用加密对象的方法，加密的动作已经完成
            byte[] result = digest.digest(text.getBytes());
            // 接下来，我们要对加密后的结果，进行优化，按照mysql的优化思路走
            // mysql的优化思路：
            // 第一步，将数据全部转换成正数：
            StringBuilder sb = new StringBuilder();
            for (byte b:result){
                // 第一步，将数据全部转换成正数：
                // 解释：为什么采用b&255
                /*
                 * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                 * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                 * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                 * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                 * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                 */
                int number = b & 0xff;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                String hex = Integer.toHexString(number);
                if (hex.length() == 1){
                    sb.append("0" + hex);
                }else {
                    sb.append(hex);
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
