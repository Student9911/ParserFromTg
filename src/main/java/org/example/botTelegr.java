package org.example;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class botTelegr extends TelegramLongPollingBot {

    final private String BOT_TOKEN ="5858376105:AAGahYyMPrLGIx5kTfTFDUkPhQphhKFzlFo";
    final private String BOT_NAME = "myQuestion_answer_bot";


    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            massage massage = new massage();

            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            String chatId = update.getMessage().getChatId().toString();
            String out = null;
            try {
                out = massage.massageOut(update.getMessage().getText());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            message.setChatId(chatId);
            message.setText(out);
            System.out.println("id: "  + update.getMessage().getChatId().toString()
                    + "\n"
                    + "massage: " + update.getMessage().getText());
            //System.out.println();

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();

            }
        }

    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new botTelegr());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
