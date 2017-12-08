package fr.unice.polytech.nuit_de_linfo_2017.chatbot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import fr.unice.polytech.nuit_de_linfo_2017.R;

public class ChatBot extends Fragment
{
    private ListView listView;
    private FloatingActionButton send;
    private EditText edit;
    public Wendy wendy = new Wendy();
    private ChatMessageAdapter messages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_chat_bot,container,false);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.white));

        listView = (ListView) rootView.findViewById(R.id.listView);
        send = (FloatingActionButton) rootView.findViewById(R.id.btn_send);
        edit = (EditText) rootView.findViewById(R.id.et_message);
        messages = new ChatMessageAdapter(getContext(), new ArrayList<ChatMessage>());
        listView.setAdapter(messages);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String message = edit.getText().toString();
                String response = wendy.respond(edit.getText().toString());
                messages.add(new MyMessage(message));
                messages.add(new WendyMessage(response));
                edit.setText("");
                listView.setSelection(messages.getCount() - 1);
            }
        });
        return rootView;
    }
}