package com.example.ktlt.Utils;

import javax.servlet.http.HttpSession;

public class Util {
    public static String username ="";
    public static void  Util(HttpSession session){
         username = (String) session.getAttribute("user");
    }
}
