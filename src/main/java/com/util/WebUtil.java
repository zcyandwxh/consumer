package com.util;

import org.apache.http.HttpResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

/**
 *   
 * <p>生成session</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/6 
 * @since V1.0
 *  
 */
public class WebUtil {

    private static String SESSION = "SESSION";

    /**
     * 获取session
     * @return
     */
    public static String getSession() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (SESSION.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        /**
         * 生成uuid
         */
        UUID firstUUID = UUID.randomUUID();
        UUID secondUUID = UUID.randomUUID();
        Random random = new Random();
        int index = random.nextInt(20);
        String str = firstUUID.toString().substring(0, index) + secondUUID.toString().substring(index);
        str = str.replace("-", "").toUpperCase();

        Cookie cookie = new Cookie(SESSION, str);

        request.setAttribute(SESSION, str);
        HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
        response.addCookie(cookie);
        return str;
    }
}
