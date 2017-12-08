package fr.unice.polytech.nuit_de_linfo_2017.easterEggs;

/**
 * Created by Marion on 08/12/2017.
 */

public class EasterEgg {

    private String hint;
    private String solve;
    private int indice;

    public EasterEgg(String hint, String solve, int indice){
        this.hint = hint;
        this.solve = solve;
        this.indice = indice;
    }

    public String getHint() {
        return hint;
    }

    public String getSolve() {
        return solve;
    }

    public int getIndice() {
        return indice;
    }
}
