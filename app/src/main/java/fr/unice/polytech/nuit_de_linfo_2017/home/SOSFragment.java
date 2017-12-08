package fr.unice.polytech.nuit_de_linfo_2017.home;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import fr.unice.polytech.nuit_de_linfo_2017.R;

/**
 * Created by Pierre on 07/12/2017.
 */

public class SOSFragment extends Fragment implements FragmentInterface {

    private TextView appeler;
    private TextView protect;
    private ImageButton buttonCall;
    private TextView takeCare;
    private TextView smokeLabel;
    private TextView walkLabel;
    private CheckBox box;
    private CheckBox box1;
    private CheckBox box2;
    private CheckBox box3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sos_home,container,false);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorFond));
        appeler = (TextView) rootView.findViewById(R.id.appelerLabel);
        appeler.setText("Appelez le 112 pour prévenir les secours");
        appeler.setTextColor(Color.BLACK);
        protect = (TextView) rootView.findViewById(R.id.protectLabel);
        protect.setText("Sécurisez la zone à l'aide de triangle(s) \nde signalisation et en allumant vos \nfeux de detresse");
        protect.setTextColor(Color.BLACK);
        buttonCall = (ImageButton)rootView.findViewById(R.id.call);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = "tel:112";
                Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse( n ) );
                startActivity( intent );
            }
        });

        takeCare = (TextView) rootView.findViewById(R.id.takeCareLabel);
        takeCare.setText("Si la victime est un motard, ne lui \nretirez pas son casque");
        takeCare.setTextColor(Color.BLACK);
        smokeLabel = (TextView)rootView.findViewById(R.id.smokeLabel);
        smokeLabel.setText("Ne fumez pas près de la zone accidentée");
        smokeLabel.setTextColor(Color.BLACK);
        walkLabel = (TextView)rootView.findViewById(R.id.walkLabel);
        walkLabel.setText("Mettez les passagers de la voiture \nen sécurité sur le bas-coté et couvrez \nla victime afin" +
                " qu'elle n'ait pas froid ");
        walkLabel.setTextColor(Color.BLACK);
        box = (CheckBox)rootView.findViewById(R.id.checkTakeCare);
        box1 = (CheckBox)rootView.findViewById(R.id.checkProtect);
        box2 = (CheckBox)rootView.findViewById(R.id.checkWalk);
        box3 = (CheckBox)rootView.findViewById(R.id.checkSmoke);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxes();
                }
            }
        };
        box.setOnCheckedChangeListener(listener);
        box1.setOnCheckedChangeListener(listener);
        box2.setOnCheckedChangeListener(listener);
        box3.setOnCheckedChangeListener(listener);
        return rootView;
    }

    private void checkBoxes(){
        if(box.isChecked() && box1.isChecked() && box2.isChecked() && box3.isChecked()){
            Toast.makeText(getActivity(),"Merci, vous avez exécuté tous les gestes adaptés à la situation",Toast.LENGTH_LONG).show();
            box.setChecked(false);
            box1.setChecked(false);
            box2.setChecked(false);
            box3.setChecked(false);
        }
    }

    @Override
    public void fragmentBecameVisible() {

    }
}
