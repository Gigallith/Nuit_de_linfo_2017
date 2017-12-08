package fr.unice.polytech.nuit_de_linfo_2017.questions;

/**
 * @author Gaetan Vialon
 *         Created the 07/12/2017.
 */

public class LeSaviezVous {


    private String questions;
    private String anecdote;
    private boolean response;


    public LeSaviezVous(String questions, String anecdote, boolean response) {
        this.questions = questions;
        this.anecdote = anecdote;
        this.response = response;
    }


    public String getQuestions() {
        return questions;
    }

    public String getAnecdote() {
        return anecdote;
    }

    public boolean isResponse() {
        return response;
    }
}

