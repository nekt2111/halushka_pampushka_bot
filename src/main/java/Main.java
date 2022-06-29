import Bot.HelloWorldBot;
import Bot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot.runBot(new HelloWorldBot("5303909693:AAGH-wVmTPhhn8mSCvWgezuNGdwRdAXSplM","halushka_pampushka_bot"));
    }

    // TEST COMMIT 21312 312

}
