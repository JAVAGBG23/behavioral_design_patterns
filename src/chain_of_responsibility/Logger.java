package chain_of_responsibility;

// Chain of Responsibility-mönstret, ett designmönster som används för att skicka
// en förfrågan längs en kedja av potentiella hanterare tills en hanterare
// tar ansvar för att hantera den. Detta mönster är användbart när du har
// en uppsättning objekt som kan hantera en förfrågan, men inte på förhand
// vet vilken som kommer att göra det.

public abstract class Logger {
    // Denna abstrakta klass fungerar som basklass för olika specifika loggerklasser
    // (InfoLogger, DebugLogger, ErrorLogger).
    //Den innehåller de allmänna mekanismerna för att hantera meddelanden och
    // skicka dem vidare längs kedjan.

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level == level) {
            write(message);
        } else if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}




















