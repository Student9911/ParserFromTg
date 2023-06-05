package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import java.time.LocalDate;
import java.util.List;

public class selenium {
    public String seleniumOut() throws InterruptedException {
        LocalDate.now();
        String date = LocalDate.now().toString().replaceAll("\\p{IsPunctuation}", "");
        String qwerty;
        System.setProperty("webdriver.opera.driver", "C:\\Users\\aurakhov\\IdeaProjects\\test\\selenium\\operadriver.exe");

        OperaDriver driver = new OperaDriver();
        driver.get("https://urfu.ru/ru/students/study/schedule/#student/55279/" + date + "/");
        WebElement element = driver.findElement(By.className("shedule-group-title"));


        Thread.sleep(1000);
        qwerty = driver.findElement(By.className("shedule-group-table")).getText();
        System.out.println(qwerty);
        //driver.close();
        //driver.quit();
        return qwerty;
    }

}


        //System.out.println(i);
       /*
       for (WebElement el:element.get(element.size())) {
            i ++;
            System.out.println(i);
            System.out.println(el.getTagName());

        }*/
















