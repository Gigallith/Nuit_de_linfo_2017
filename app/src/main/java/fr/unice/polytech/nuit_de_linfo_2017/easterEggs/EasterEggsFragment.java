package fr.unice.polytech.nuit_de_linfo_2017.easterEggs;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.nuit_de_linfo_2017.R;
import fr.unice.polytech.nuit_de_linfo_2017.home.FragmentInterface;

/**
 * Created by Marion on 07/12/2017.
 */

public class EasterEggsFragment extends Fragment implements FragmentInterface {

    private List eastereggs = new ArrayList<EasterEgg>();

    public EasterEggsFragment() {
        EasterEgg easterEgg0 = new EasterEgg("Le bot fait tout","Bravo vous avez trouvez le 1er indice", 0);
        EasterEgg easterEgg1 = new EasterEgg("IMANOK", "Bravo vous avez trouvez le 2eme indice",1);
        eastereggs.add(easterEgg0);
        eastereggs.add(easterEgg1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.easter_eggs,container,false);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorFond));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable  Bundle bundle) {
        super.onActivityCreated(bundle);
        Globals g = Globals.getInstance();
        int data = g.getData();
        List eastereg = new ArrayList<EasterEgg>();
        for (int i = 0; i <= data; i++) {
            eastereg.add(eastereggs.get(i));
        }
        EasterEggsAdapter easterEggsAdapter = new EasterEggsAdapter(this.getContext(), 0, (ArrayList<EasterEgg>) eastereg);
        GridView gridView = (GridView) getView().findViewById(R.id.grid_easter);
        gridView.setAdapter(easterEggsAdapter);


    }

    @Override
    public void fragmentBecameVisible() {

    }

    public static EasterEggsFragment newInstance() {
        EasterEggsFragment fragment = new EasterEggsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}
