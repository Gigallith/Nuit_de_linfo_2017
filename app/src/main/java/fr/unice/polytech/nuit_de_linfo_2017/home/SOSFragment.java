package fr.unice.polytech.nuit_de_linfo_2017.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.unice.polytech.nuit_de_linfo_2017.R;

/**
 * Created by Pierre on 07/12/2017.
 */

public class SOSFragment extends Fragment implements FragmentInterface {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sos_home,container,false);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorFond));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override
    public void fragmentBecameVisible() {

    }
}
