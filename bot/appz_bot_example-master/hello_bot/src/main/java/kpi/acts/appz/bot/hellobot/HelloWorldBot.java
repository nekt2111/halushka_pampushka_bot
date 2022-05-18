package kpi.acts.appz.bot.hellobot;

import kpi.acts.appz.bot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.util.Objects;

public final class HelloWorldBot extends Bot {
    public static void main(String[] args){
        if(args == null || args.length != 2){
            System.out.println("You must run bot with 2 args - BotToken and bot UserName");
        } else {
            ApiContextInitializer.init();
            Bot.runBot(new HelloWorldBot(args[0], args[1]));
        }
    }

    private HelloWorldBot(String token, String botName) {
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

        if (Objects.equals(update.getMessage().getText(), "jereb")) {
            sendImageMessage(update.getMessage(), "https://cdn.discordapp.com/attachments/785190644997947416/976225498910826587/unknown.png");
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
