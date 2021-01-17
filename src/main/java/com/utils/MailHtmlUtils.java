package com.utils;

public class MailHtmlUtils {
    public static String initHtml(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"UTF-8\"/>");
        stringBuilder.append("<title>Title</title>");
        stringBuilder.append("</head>");
        stringBuilder.append(" <body>");
        stringBuilder.append(content);
        stringBuilder.append(" </body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
