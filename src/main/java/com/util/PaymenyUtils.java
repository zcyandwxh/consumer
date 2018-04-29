package com.util;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
public class PaymenyUtils {
    public static String payment() {
        UUID firstUUID = UUID.randomUUID();
        UUID secondUUID = UUID.randomUUID();
        Random random = new Random();
        int index = random.nextInt(20);
        String str = firstUUID.toString().substring(0, index) + secondUUID.toString().substring(index);
        str = str.replace("-", "").toUpperCase();

//        LOGGER.info("UUID {}", str);
        return str;
    }
}
