package fr.unice.polytech.nuit_de_linfo_2017.twitter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import fr.unice.polytech.nuit_de_linfo_2017.MainActivity;
import fr.unice.polytech.nuit_de_linfo_2017.R;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

/**
 * Created by Pierre on 08/12/2017.
 */

public class TwitterFragment extends Fragment {

    Button buttonTweet;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.twitter_layout,container,false);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.white));
        buttonTweet = (Button)rootView.findViewById(R.id.buttonTweet);
        editText = (EditText)rootView.findViewById(R.id.editText);
        final Context context = this.getContext();
        buttonTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TweetComposer.Builder builder = new TweetComposer.Builder(context)
                        .text(editText.getText().toString());
                builder.show();
            }
        });
        return rootView;
    }
}
