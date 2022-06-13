package kpi.acts.appz.bot.hellobot;

import kpi.acts.appz.bot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.naming.OperationNotSupportedException;
import javax.sound.sampled.*;
import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public final class HelloWorldBot extends Bot {
    private static HashMap<String, InputStream> audios;
    private static HashMap<String, Long> audioLengths;
    private static AudioFormat audioFormat;
    public static void main(String[] args){
        boolean needsReturn = false;

        try {
            needsReturn = Test();
        }
        catch (Exception e) {
            e.printStackTrace();
            needsReturn = true;
        }
        if (needsReturn) {
            return;
        }
        if(args == null || args.length != 2){
            System.out.println("You must run bot with 2 args - BotToken and bot UserName");
        } else {
            ApiContextInitializer.init();
            Bot.runBot(new HelloWorldBot(args[0], args[1]));
        }
    }

    private static String[] SplitText(String text) {
        return ("_" + text + "_")
                .toLowerCase()
                .replaceAll(" ", "_")
                .replaceAll("ю", "у")
                .replaceAll("я", "а")
                //.replaceAll("н", "нн")
                //.replaceAll("у", "ууу")
                //.replaceAll("т", "тт")
                //.replaceAll("л", "лл")
                //.replaceAll("е", "ее")
                .replaceAll("э", "е")
                .replaceAll("ё", "о")
                .replaceAll("ы", "и")
                .replaceAll("й", "и")
                .replaceAll("ь", "")
                .replaceAll("\\.", "")
                .replaceAll("!", "")
                .replaceAll("\\?", "")
                .replaceAll("-", "")
                .replaceAll(",", "")
                .split("");
    }

    private static boolean Test() throws Exception {

        LoadAudios();

        String[] letters = SplitText("никита линовицкий мае девяносто пять балив");

        InputStream[] toCombine = new InputStream[letters.length];
        Long[] toCombineLengths = new Long[letters.length];

        for (int i = 0; i < letters.length; i++) {
            toCombine[i] = audios.get(letters[i]);
            toCombineLengths[i] = audioLengths.get(letters[i]);
        }

        Combine(toCombine, toCombineLengths);

        return true;
    }

    private static void LoadAudio(String folder, String letter) throws OperationNotSupportedException, UnsupportedAudioFileException, IOException {
        if (audios == null || audioLengths == null) {
            throw new OperationNotSupportedException();
        }
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(folder + letter + ".wav"));

        audios.put(letter, new ByteArrayInputStream(audioStream.readAllBytes()));
        audioLengths.put(letter, audioStream.getFrameLength());
        if (audioFormat == null) {
            audioFormat = audioStream.getFormat();
        }
    }

    private static void Combine(InputStream[] streams, Long[] lengths) {
        try {
            long length = 0;

            Vector<InputStream> streamVector = new Vector<>(streams.length);

            for (int i = 0; i < streams.length; i++) {
                length += lengths[i];
                streamVector.add(new ByteArrayInputStream(streams[i].readAllBytes()));
                streams[i].reset();
            }

            AudioInputStream appendedFiles =
                    new AudioInputStream(
                            new SequenceInputStream(streamVector.elements()),
                            audioFormat,
                            length);

            AudioSystem.write(appendedFiles,
                    AudioFileFormat.Type.WAVE,
                    new File("D:\\wavAppended.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void LoadAudios() throws OperationNotSupportedException, UnsupportedAudioFileException, IOException {
        if (audios != null || audioLengths != null) {
            throw new OperationNotSupportedException();
        }
        audios = new HashMap<>();
        audioLengths = new HashMap<>();

        String folder = "D:\\Projects\\KPI\\halushka_pampushka_bot\\bot\\appz_bot_example-master\\telegram_bot\\src\\audioResources\\";

        LoadAudio(folder, "_");
        LoadAudio(folder, "а");
        LoadAudio(folder, "б");
        LoadAudio(folder, "в");
        LoadAudio(folder, "г");
        LoadAudio(folder, "д");
        LoadAudio(folder, "е");
        LoadAudio(folder, "ж");
        LoadAudio(folder, "з");
        LoadAudio(folder, "и");
        LoadAudio(folder, "к");
        LoadAudio(folder, "л");
        LoadAudio(folder, "м");
        LoadAudio(folder, "н");
        LoadAudio(folder, "о");
        LoadAudio(folder, "п");
        LoadAudio(folder, "р");
        LoadAudio(folder, "с");
        LoadAudio(folder, "т");
        LoadAudio(folder, "у");
        LoadAudio(folder, "ф");
        LoadAudio(folder, "х");
        LoadAudio(folder, "ц");
        LoadAudio(folder, "ч");
        LoadAudio(folder, "ш");
        LoadAudio(folder, "щ");
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

        String imgPath;

        switch (update.getMessage().getText()) {
            case "jereb":
                imgPath = "https://cdn.discordapp.com/attachments/785190644997947416/976390958176407572/unknown.png";
                break;
            case "rolik":
                imgPath = "https://cdn.discordapp.com/attachments/785190644997947416/976225498910826587/unknown.png";
                break;
            default:
                return;
        }

        sendImageMessage(update.getMessage(), imgPath);
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
                responseMessage = "OOOH YYYEEEAAAAAAAAAAAAHHHH!!!!";
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
