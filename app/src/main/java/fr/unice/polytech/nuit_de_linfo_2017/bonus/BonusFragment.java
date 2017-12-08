package fr.unice.polytech.nuit_de_linfo_2017.bonus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fr.unice.polytech.nuit_de_linfo_2017.R;
import fr.unice.polytech.nuit_de_linfo_2017.easterEggs.Globals;

/**
 * Created by user on 07/12/2017.
 */

public class BonusFragment extends Fragment {

    private View bonusView;

    private RelativeLayout codeInput;

    private ImageButton up;
    private ImageButton down;
    private ImageButton left;
    private ImageButton right;

    private Button aButton;
    private Button bButton;

    private TextView answer;

    KonamiCode konamiCode;

    public BonusFragment() {
        konamiCode = new KonamiCode();
    }

    public static BonusFragment newInstance(){
        BonusFragment fragment = new BonusFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bonus_layout, container, false);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorFond));

        bonusView = rootView.findViewById(R.id.bonus_view);

        answer = (TextView) rootView.findViewById(R.id.answerTextView) ;
        codeInput = (RelativeLayout) rootView.findViewById(R.id.code_input);

        up = (ImageButton) rootView.findViewById(R.id.UpButton);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upAction(v);
            }
        });
        down = (ImageButton) rootView.findViewById(R.id.DownButton);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downAction(v);
            }
        });
        left = (ImageButton) rootView.findViewById(R.id.LeftButton);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftAction(v);
            }
        });
        right = (ImageButton) rootView.findViewById(R.id.RightButton);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightAction(v);
            }
        });
        aButton = (Button) rootView.findViewById(R.id.buttonA);
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AAction(v);
            }
        });
        bButton = (Button) rootView.findViewById(R.id.buttonB);
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BAction(v);
            }
        });


        return rootView;
    }

    private void BAction(View v) {
        konamiCode.addInput(KonamiCode.KSInput.B);
        System.out.println("B");
    }

    private void AAction(View v) {
        konamiCode.addInput(KonamiCode.KSInput.A);
        System.out.println("A");
        if (konamiCode.isComplete()) {
            codeInput.setVisibility(View.INVISIBLE);
            answer.setVisibility(View.VISIBLE);
        }
    }

    private void rightAction(View v) {
        System.out.println("right");
        konamiCode.addInput(KonamiCode.KSInput.RIGHT);
    }

    private void leftAction(View v) {
        System.out.println("left");
        konamiCode.addInput(KonamiCode.KSInput.LEFT);
    }

    private void downAction(View v) {
        System.out.println("down");
        konamiCode.addInput(KonamiCode.KSInput.DOWN);
    }

    public void upAction(View v) {
        System.out.println("up");
        konamiCode.addInput(KonamiCode.KSInput.UP);
        if (konamiCode.reversedIsComplete()){
            Globals g = Globals.getInstance();
            g.incremente();
        }
    }

}
