package org.example;

public class massage {
    private static String q = "null";


    public String massageOut(String qwestion) throws InterruptedException {



        switch (qwestion.toLowerCase()) {
            case ("/start"):
                q = "Привет дорогой друг\n" +
                        "я понимаю команды:\n" +
                        "/start\nрасписание\nпогода";
                break;
            case ("расписание"):
                selenium selenium1 = new selenium();
                q = selenium1.seleniumOut() + "\n" +
                        "Данные взяты с сайта https://urfu.ru/ru/students/study/schedule/";
                break;
            case ("погода"):
                wither1 wither = new wither1();
                q = wither.witherNow() + "\n Информация взята с сайта: " + wither.url;
                break;
            default:
                q = "Этот бот еще ничего не умеет, но скоро может чему то научится" +
                        "я понимаю команды:\n" +
                        "/start\nрасписание\nпогода" +
                        "P.S. это так на всякий случай:";
                break;

        }
        return q;
    }

}



