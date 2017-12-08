package fr.unice.polytech.nuit_de_linfo_2017.chatbot;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.unice.polytech.nuit_de_linfo_2017.easterEggs.Globals;

public class Wendy
{
    private final List<Dialog> dialogs = new ArrayList<>();

    Dialog dialogEgg;
    public Wendy()
    {
        dialogEgg = new Dialog("(?:résout|énigme|resout|enigme) (?:2|deux)", "Bravo, vous avez résolue la deuxième énigme.");
        dialogs.add(dialogEgg);
        dialogs.add(new Dialog("Bonjour|Salut|Coucou", "Salut, comment ça va ?"));
        dialogs.add(new Dialog("ça va \\?", "Je vais bien et vous ?"));
        dialogs.add(new Dialog("ça va", "Super, en quoi puis-je vous aider ?"));
        dialogs.add(new Dialog("(?:nom|appel) \\?", "Salut, je m'appel Wendy."));
        dialogs.add(new Dialog("nom ?", "Salut, je m'appel Wendy."));

        dialogs.add(new Dialog("ça va ?", "Je vais bien et vous ?"));
        dialogs.add(new Dialog("(?:nom|appel) ?", "Salut, je m'appel Wendy."));
        dialogs.add(new Dialog("Je le savais", "Tu ne sais rien Jhon Snow !"));
        dialogs.add(new Dialog("Le saviez vous \\?", "C'est un jeu excelent !"));
        dialogs.add(new Dialog("(?:faire|subir|victime).*?(?:accident) \\?", "Gardez votre calme, placer vous derrière la barrière de sécurité et attendez l'arrivée des secours."));
        dialogs.add(new Dialog("(?:voir|assister).*?(?:accident)", "Rangez vous sur le coté si cela est possible afin d'appeler les secours."));
        dialogs.add(new Dialog("(?:résout|énigme|resout|enigme) (?:2|deux)", "Bravo, vous avez résolue la deuxième énigme."));
    }

    public String respond(final String message)
    {
        for (Dialog dialog: dialogs)
        {
            Optional<String> responce = dialog.match(message);
            if (responce.isPresent())
            {
                if(dialog == dialogEgg){
                    Globals g = Globals.getInstance();
                    g.setData(1);
                }
                return responce.get();
            }
        }
        return "Désolé, je ne comprends pas.";
    }
}
