package fr.unice.polytech.nuit_de_linfo_2017.chatbot;


import fr.unice.polytech.nuit_de_linfo_2017.R;

public class WendyMessage extends ChatMessage
{
    public WendyMessage(String message)
    {
        super(message);
    }

    @Override
    public int getLayout()
    {
        return R.layout.wendy_message;
    }
}
