package Bot;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.naming.OperationNotSupportedException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class HelloWorldBot extends Bot {

    public HelloWorldBot(String token, String botName) {
        super(token, botName);
        try {
            AudioHelper.Initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void processTheException(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        String messageText = message.getText();

        System.out.println(message);
        System.out.println(messageText);

        sendTextMessage(message, getResponseMessageText(messageText));

        if (Objects.equals(messageText, "jereb")) {
            sendImageMessage(message,"https://cdn.discordapp.com/attachments/785190644997947416/985974844946513930/jereb.jpg");
        }

        String[] messageParts = messageText.split("");

        if (messageParts.length > 1 && messageParts[0].equals("@Sv")) {
            String audioText = messageText.substring("@Sv ".length());

            try {
                sendAudioMessage(message, "@Sv", AudioHelper.GetAudio(audioText));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getResponseMessageText(String messageText) {

        String responseMessage;

        switch (messageText.toLowerCase()) {
            case "tsymbal":
                responseMessage = "The best";
                break;
            case "halushka":
                responseMessage = "PAMPUSHKA :)";
                break;
            case "jereb":
                responseMessage = "BAD BOY";
                break;
            case "jerebez":
                responseMessage = "OOOOOH YEAAAAAAAAAHH!!!11!1!!!!";
                break;
            case "baba valya":
                responseMessage = "integral snaker";
                break;
            case "kpi":
                responseMessage = "Доброго вечора, ми з України";
                break;
            case "fiot":
                responseMessage = "IT-армія України";
                break;
            case "rolik":
                responseMessage = ".___.\n|\\\\\\\\_\n|rolex\\\nOOOO";
                break;
            case "stefania":
                responseMessage = "Kalush one love <3";
                break;
            case "eurovision":
                responseMessage = "All votes for >>>Poland<<<";
                break;
            case "aleksandra bondarenko":
                responseMessage = "ENGLISH MOTHERFUCKER, DO YOU SPEAK IT? my birdie ;)";
                break;
            default:
                String[] messageParts = messageText.split("");
                if (messageParts.length > 1 && messageParts[0].equals("@Sv")) {
                    responseMessage = "";
                } else {
                    responseMessage = makeMagic(messageText);
                }
                break;
        };

        return responseMessage + "\n Have a pampushka with a halushka :)";
    }

    public String makeMagic(String str) {

        if (str.length() <= 3) {
            return "SEREGA BOG!";
        }

        if(str.length() > 10) {
            return "NIKITA BOT!";
        }

        return "hui" + str.substring(3);
    }
}
