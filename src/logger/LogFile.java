package logger;

public class LogFile implements Logable {
    @Override
    public String log(String content) {
        System.out.println(content + "   Logging to file.");
        return content;
    }
}
