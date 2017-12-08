package fr.unice.polytech.nuit_de_linfo_2017.chatbot;

import fr.unice.polytech.nuit_de_linfo_2017.R;

public class MyMessage extends ChatMessage
{
    public MyMessage(String message)
    {
        super(message);
    }

    @Override
    public int getLayout()
    {
        return R.layout.my_message;
    }
}
