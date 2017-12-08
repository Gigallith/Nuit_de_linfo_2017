package fr.unice.polytech.nuit_de_linfo_2017.questions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import fr.unice.polytech.nuit_de_linfo_2017.R;

/**
 * @author Gaetan Vialon
 *         Created the 07/12/2017.
 */

public class LeSaviezVousFragment extends Fragment  {

    private TextView question;
    private TextView reponse;
    private LeSaviezVousParser leSaviezVousParser;
    private LeSaviezVous leSaviezVous;
    private Button vraiButton;
    private Button fauxButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_questions,container,false);
        leSaviezVousParser = new LeSaviezVousParser(getContext());
        question = (TextView) rootView.findViewById(R.id.question);
        reponse = (TextView) rootView.findViewById(R.id.reponse);
        fauxButton = (Button) rootView.findViewById(R.id.falseButton);
        vraiButton = (Button) rootView.findViewById(R.id.trueButton);
        fauxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leSaviezVous.isResponse()==false){
                    changeQuestion();
                }else {
                    setAnecdote();
                }
            }
        });

        vraiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leSaviezVous.isResponse()){
                    changeQuestion();
                }else {
                    setAnecdote();
                }
            }
        });
        changeQuestion();
        return rootView;
    }

    private void changeQuestion(){
        System.out.println("bonne reponse");
        reponse.setText("");
        leSaviezVous = leSaviezVousParser.getRandonLeSaviezVous();
        question.setText(leSaviezVous.getQuestions());
    }

    private void setAnecdote(){
        reponse.setText(leSaviezVous.getAnecdote());
    }

    public static LeSaviezVousFragment newInstance() {
        LeSaviezVousFragment fragment = new LeSaviezVousFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}
