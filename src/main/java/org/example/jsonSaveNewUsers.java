package org.example;



/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;
public class jsonSaveNewUsers {


     public String jsonSearcheAndAdd(int id) {
        boolean write = false;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser
                    .parse(new FileReader("src/main/java/org/example/example-json.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("users");
            //обходим циклом массив jsona и сравниваем значения
            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                if ((id == (int) book.get("id")) && !(book.get("name").equals("null"))) {
                    System.out.println("\nТекущий элемент: " + jsonObject.keySet().iterator().next());
                    System.out.println("subject: " + book.get("subject"));
                    System.out.println("date: " + book.get("date"));
                    write = false;
                    // если нашли значения выходим из метода
                    break;
                    //иначе устанавливаем значение true
                } else {
                    write = true;
                }
            }
            //Если значение True значит мы не нашли в записях новость и надо ее записать
            if (write) {
                massage massage = new massage();
                botTelegr bot = new botTelegr();
                Scanner in = new Scanner(System.in);

                System.out.println("создаем новую запись");
                JSONObject newEvents = new JSONObject();
                newEvents.put("id", id);
                newEvents.put("name", );
                jsonArray.add(newEvents);
                System.out.println("и пишем в файл");

                try (FileWriter file = new FileWriter("src/main/java/org/example/example-json.json")) {
                    file.write(String.valueOf(jsonObject));
                    System.out.println("данные в Json файл успешно добавлены!");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

