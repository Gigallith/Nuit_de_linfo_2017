package fr.unice.polytech.nuit_de_linfo_2017.chatbot;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wendy
{
    private final List<Dialog> dialogs = new ArrayList<>();

    public Wendy()
    {
        dialogs.add(new Dialog("Bonjour|Salut|Coucou", "Salut, comment ça va ?"));
        dialogs.add(new Dialog("nom ?", "Salut, je m'appel Wendy."));
        dialogs.add(new Dialog("(?:résout|énigme|resout|enigme) (?:2|deux)", "Bravo, vous avez résolue la deuxième énigme."));
    }

    public String respond(final String message)
    {
        for (Dialog dialog: dialogs)
        {
            Optional<String> responce = dialog.match(message);
            if (responce.isPresent())
            {
                return responce.get();
            }
        }
        return "Désolé, je ne comprends pas.";
    }
}
