package chain_of_responsibility;

// Chain of Responsibility-mönstret, ett designmönster som används för att skicka
// en förfrågan längs en kedja av potentiella hanterare tills en hanterare
// tar ansvar för att hantera den. Detta mönster är användbart när du har
// en uppsättning objekt som kan hantera en förfrågan, men inte på förhand
// vet vilken som kommer att göra det.

public class Logger {
    // Denna abstrakta klass fungerar som basklass för olika specifika loggerklasser
    // (InfoLogger, DebugLogger, ErrorLogger).
    //Den innehåller de allmänna mekanismerna för att hantera meddelanden och
    // skicka dem vidare längs kedjan.
}
