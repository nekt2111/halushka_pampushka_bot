package Bot;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.util.Objects;

public final class HelloWorldBot extends Bot {

    public HelloWorldBot(String token, String botName) {
        super(token, botName);
    }

    @Override
    protected void processTheException(Exception e) {
        e.printStackTrace();
        System.out.println(e.toString());
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage());
        System.out.println(update.getMessage().getText());

        sendTextMessage(update.getMessage(), getResponseMessageText(update.getMessage().getText()));
        File img = new File("../img/jereb.jpg");

        if (Objects.equals(update.getMessage().getText(), "jereb")) {
            sendImageMessage(update.getMessage(),img);
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
                responseMessage = makeMagic(messageText);
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
