package com.darkghost.relaxbot;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends BaseAdapter {

    List<Message> messages = new ArrayList<Message>();
    Context context;

    public MessageAdapter(Context context) {
        this.context = context;
    }

    public void add(Message message){
        this.messages.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MessageViewHolder holder = new MessageViewHolder();
        LayoutInflater messageInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Message message = messages.get(i);

        if (message.isBelongs_to_curr_user()){
            view = messageInflater.inflate(R.layout.my_message, null);
            holder.messageBody = (TextView) view.findViewById(R.id.message_body);
            view.setTag(holder);
            holder.messageBody.setText(message.getText());
        } else {
            view = messageInflater.inflate(R.layout.their_message, null);
            holder.avatar = (View) view.findViewById(R.id.avatar);
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.messageBody = (TextView) view.findViewById(R.id.message_body);
            view.setTag(holder);

            holder.name.setText(message.getMemberData().getName());
            holder.messageBody.setText(message.getText());
            GradientDrawable drawable = (GradientDrawable) holder.avatar.getBackground();
            drawable.setColor(Color.parseColor(message.getMemberData().getColor()));
        }

        return view;
    }
}

class MessageViewHolder {
    public View avatar;
    public TextView name;
    public TextView messageBody;
}
