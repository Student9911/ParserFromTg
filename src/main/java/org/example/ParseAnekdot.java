package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseAnekdot  {
    private String anekdot;


    public String RandomAnekdot() throws IOException{
        String url = "https://www.anekdot.ru/last/anekdot/";
        Document doc = Jsoup.connect(url).get();
        Elements anekdots = doc.select(".topicbox");
        List<String> anekdotList = new ArrayList<>();
        for (Element anekdot : anekdots) {
            String text = anekdot.select(".text").text();
            anekdotList.add(text);
        }
        String[] anekdotArray = anekdotList.toArray(new String[0]);
        for (String anekdot : anekdotArray) {
            //System.out.println(anekdot);
        }
        Random random = new Random();
        anekdot = anekdotArray[random.nextInt(anekdotArray.length)];
        if (anekdot.equals("")) {
            anekdot = anekdotArray[random.nextInt(anekdotArray.length)];
        }
        System.out.println(anekdot);

        return anekdot;

    }

}

