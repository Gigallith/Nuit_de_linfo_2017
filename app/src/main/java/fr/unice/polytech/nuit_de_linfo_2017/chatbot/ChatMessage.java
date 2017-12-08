package fr.unice.polytech.nuit_de_linfo_2017.chatbot;

public abstract class ChatMessage
{
    private final String message;

    public ChatMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public abstract int getLayout();
}
