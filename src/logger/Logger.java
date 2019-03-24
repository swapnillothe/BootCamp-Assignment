package logger;

class Logger implements Logable {
    private Logable firstLogger;
    private Logable secondLogger;

    public Logger(Logable logger) {
        this.firstLogger = logger;
    }

    Logger(Logable logger, Logable secondLogger) {
        this.firstLogger = logger;
        this.secondLogger = secondLogger;
    }

    @Override
    public String log(String content) {
        String fileContent = firstLogger.log(content);
        String consoleContent = secondLogger.log(content);
        return fileContent + " " + consoleContent;
    }
}
