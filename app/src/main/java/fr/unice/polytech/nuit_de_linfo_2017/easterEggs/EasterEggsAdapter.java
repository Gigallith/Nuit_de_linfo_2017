package fr.unice.polytech.nuit_de_linfo_2017.easterEggs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.nuit_de_linfo_2017.MainActivity;
import fr.unice.polytech.nuit_de_linfo_2017.R;

/**
 * Created by Marion on 07/12/2017.
 */

public class EasterEggsAdapter extends ArrayAdapter<EasterEgg> {


    public EasterEggsAdapter(@NonNull Context context, int resource, ArrayList<EasterEgg> easterEggs) {
        super(context, resource,  easterEggs);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            convertView = inflater.inflate(R.layout.easter_adapter,null);
        }



        EasterEgg easterEgg = getItem(position);

        TextView textView = (TextView) convertView.findViewById(R.id.text_east);
        textView.setText(easterEgg.getHint());


        return convertView;
    }
}
