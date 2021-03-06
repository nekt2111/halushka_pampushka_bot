package Bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.InputStream;

public abstract class Bot extends TelegramLongPollingBot {
    private final String token, botName;

    protected Bot(String token, String botName){
        this.token = token;
        this.botName = botName;
    }

    public static void runBot(Bot newBot) {
        try {
            new TelegramBotsApi().registerBot(newBot);
        } catch (TelegramApiException e) {
            newBot.processTheException(e);
        }
    }

    public Message sendTextMessage(Message messageFrom, String text){
        try {
            SendMessage send = new SendMessage().setChatId(messageFrom.getChatId());

            send.setText(text.trim());
            return execute(send);
        } catch (Exception e) {
            processTheException(e);
            return null;
        }
    }

    public Message sendImageMessage(Message messageFrom, File file){
        try {
            SendPhoto send = new SendPhoto().setChatId(messageFrom.getChatId());
            send.setPhoto(file);

            return execute(send);
        } catch (Exception e) {
            processTheException(e);
            return null;
        }
    }

    public Message sendImageMessage(Message messageFrom, String url){
        try {
            SendPhoto send = new SendPhoto().setChatId(messageFrom.getChatId());
            send.setPhoto(url);

            return execute(send);
        } catch (Exception e) {
            processTheException(e);
            return null;
        }
    }

    protected abstract void processTheException(Exception e);

    @Override
    public final String getBotUsername() {
        return botName;
    }

    @Override
    public final String getBotToken() {
        return token;
    }
}
