package fr.unice.polytech.nuit_de_linfo_2017.chatbot;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fr.unice.polytech.nuit_de_linfo_2017.R;

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage>
{
    public ChatMessageAdapter(@NonNull Context context, List<ChatMessage> messages)
    {
        super(context, R.layout.my_message, messages);
    }

    @Override
    public int getViewTypeCount()
    {
        return 8;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ChatMessage chatMessage = getItem(position);

        convertView = LayoutInflater.from(getContext()).inflate(chatMessage.getLayout(), parent, false);
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(getItem(position).getMessage());

        convertView.findViewById(R.id.chatMessageView).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), chatMessage.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}
