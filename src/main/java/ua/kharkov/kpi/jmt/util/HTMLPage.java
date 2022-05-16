package ua.kharkov.kpi.jmt.util;

public final class HTMLPage {
    public static String getDOCTYPE() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">";
    }

    public static String getHeader(String title) {
        return "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <title>JavaMathTest - " + title + "</title>\n" +
                "    <link rel=\"stylesheet\" href=\"styles/background.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"styles/main.css\">\n" +
                "</head>";
    }

    public static String getBody1() {
        return "<body>\n" +
                "<ul class=\"circles\">\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "    <li></li>\n" +
                "</ul>\n" +
                "<div id=\"content\">";
    }

    public static String getBody2() {
        return "</div>\n" +
                "</body>\n" +
                "</html>";
    }

}
