package fr.unice.polytech.nuit_de_linfo_2017.chatbot;


import java.util.Optional;
import java.util.regex.Pattern;

public class Dialog
{
    private final Pattern pattern;
    private final String template;

    public Dialog(String pattern, String template)
    {
        this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        this.template = template;
    }

    public Optional<String> match(String message)
    {
        if (pattern.matcher(message).find())
        {
            return Optional.of(template);
        }
        return Optional.empty();
    }
}
