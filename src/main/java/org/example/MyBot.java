package org.example;



import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void onUpdateReceived(org.telegram.telegrambots.meta.api.objects.Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            JSONObject user = new JSONObject();
            user.put("Date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            LocalTime time = LocalTime.now();
            user.put("Time", time.format(myFormatter));
            user.put("id", chatId);
            user.put("message", messageText);
            JSONArray usersArray = getUsersArray();
            usersArray.add(user);
            saveUsersArray(usersArray);
            SendMessage message = new SendMessage();

            if (messageText.equals("/start")) {

                message.setChatId(chatId);
                message.setText("Нажмите на одну из кнопок ниже \n" +
                        "пока мой бот больше ничего не умеет: ");

                // Создаем клавиатуру
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                keyboardMarkup.setSelective(true);
                keyboardMarkup.setResizeKeyboard(true);
                keyboardMarkup.setOneTimeKeyboard(false);

                // Создаем кнопки
                KeyboardButton button1 = new KeyboardButton();
                button1.setText("Погода");

                KeyboardButton button2 = new KeyboardButton();
                button2.setText("Анекдот");

                // Создаем ряды кнопок
                KeyboardRow row1 = new KeyboardRow();
                row1.add(button1);
                row1.add(button2);


                // Добавляем ряды кнопок в клавиатуру
                keyboardMarkup.setKeyboard(List.of(row1));

                // Устанавливаем клавиатуру в сообщение
                message.setReplyMarkup(keyboardMarkup);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            String out = null;
            try {
                out = massage.massageOut(update.getMessage().getText());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
            }
            message.setChatId(chatId);
            message.setText(out);
            System.out.println("id: " + update.getMessage().getChatId().toString()
                    + "\n"
                    + "massage: " + update.getMessage().getText());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String getBotUsername() {
        return "myQuestion_answer_bot";
    }

    @Override
    public String getBotToken() {
        return "5858376105:AAGahYyMPrLGIx5kTfTFDUkPhQphhKFzlFo";
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private JSONArray getUsersArray() {
        JSONParser parser = new JSONParser();
        JSONArray usersArray = new JSONArray();
        try {
            FileReader reader = new FileReader("src/main/java/org/example/example-json.json");
            Object obj = parser.parse(reader);
            usersArray = (JSONArray) obj;
            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return usersArray;
    }

    private void saveUsersArray(JSONArray usersArray) {
        try {
            FileWriter writer = new FileWriter("src/main/java/org/example/example-json.json");
            writer.write(usersArray.toJSONString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




