package kpi.acts.appz.bot.hellobot;

import kpi.acts.appz.bot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.objects.Update;

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
        sendTextMessage(update.getMessage(), getResponseMessageText(update.getMessage().getText()));
    }

    public String getResponseMessageText(String messageText) {

        String responseMessage = switch (messageText.toLowerCase()) {
            case "tsymbal" -> "The best";
            case "halushka" -> "PAMPUSHKA :)";
            case "jereb" -> "BAD BOY";
            case "baba valya" -> "∫∫∫integral snaker∫∫∫";
            case "kpi" -> "Доброго вечора, ми з України 💙💛";
            case "fiot" -> "IT-армія України";
            case "rolik" -> "";
            case "stefanie" -> "";
            case "eurovision" -> "";
            default -> makeMagic(messageText);
        }

        return responseMessage + "\n Have a pampushka with a halushka :)";
    }

    public String makeMagic(String str) {

        if (str.length() > 3 && str.length() < 10) {
            return "hui" + str.substring(3);
        }
        else if(str.length() > 10) {
            return "NIKITA BOT!";
        }

        return "SEREGA BOG!";
    }
}
