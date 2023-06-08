package org.example;

import java.io.IOException;

public class massage {
    private static String q = "null";


    public static String massageOut(String qwestion) throws InterruptedException, IOException {



        switch (qwestion.toLowerCase()) {
            case ("/start"):
                q ="";
                break;
            case ("погода"):
                wither1 wither = new wither1();
                q = wither.witherNow() + "\n Информация взята с сайта: " + wither.url;
                break;
            case ("анекдот") :
                ParseAnekdot anekdot = new ParseAnekdot();
                q = anekdot.RandomAnekdot();
                break;
            default:
                q = "Этот бот еще ничего не умеет, но скоро может чему то научится" +
                        "я понимаю команды:\n" +
                        "/start\nрасписание\nпогода\n" +
                        "P.S. это так на всякий случай:";
                break;

        }
        return q;
    }

}



