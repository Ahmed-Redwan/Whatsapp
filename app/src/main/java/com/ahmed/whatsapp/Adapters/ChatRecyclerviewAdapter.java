package com.ahmed.whatsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.whatsapp.R;
import com.ahmed.whatsapp.model.Chat;

import java.util.ArrayList;

public class ChatRecyclerviewAdapter extends RecyclerView.Adapter<ChatRecyclerviewAdapter.ChatViewHolder> {
    Context context;
    ArrayList<Chat> chats;

    public ChatRecyclerviewAdapter(Context context, ArrayList<Chat> chats) {
        this.context = context;
        this.chats = chats;
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatRecyclerviewAdapter.ChatViewHolder(LayoutInflater.from(context).
                inflate(R.layout.chat_custom_recyclerview,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

        holder.iv_user.setImageResource(chats.get(position).getUserImg());
        holder.tv_username.setText(chats.get(position).getName());
        holder.tv_lastmsg.setText(chats.get(position).getLastMsg());
        holder.tv_numofMsg.setText(chats.get(position).getNumOfMsgs());
        holder.tv_msgDate.setText(chats.get(position).getMsgDate());
        if (chats.get(position).getStateOfMessages().equalsIgnoreCase("seen")){
            holder.tv_numofMsg.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_user, iv_MsgState;
        TextView tv_username, tv_lastmsg, tv_msgDate, tv_numofMsg;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user = itemView.findViewById(R.id.Chat_Customrv_iv_user);
            iv_MsgState = itemView.findViewById(R.id.Chat_Customrv_iv_msgState);
            tv_username = itemView.findViewById(R.id.Chat_Customrv_tv_username);
            tv_lastmsg = itemView.findViewById(R.id.Chat_Customrv_tv_lastmsg);
            tv_msgDate = itemView.findViewById(R.id.Chat_Customrv_tv_msgDate);
            tv_numofMsg = itemView.findViewById(R.id.Chat_Customrv_tv_msgNumber);

        }
    }
}
