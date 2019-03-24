package logger;

public class LogConsole implements Logable {
    @Override
    public String log(String content) {
        System.out.println(content + "   Logging to console.");
        return content;
    }
}
