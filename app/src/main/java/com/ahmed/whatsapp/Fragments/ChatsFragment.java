package com.ahmed.whatsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmed.whatsapp.Adapters.ChatRecyclerviewAdapter;
import com.ahmed.whatsapp.R;
import com.ahmed.whatsapp.model.Chat;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {
    RecyclerView recyclerView;
    ChatRecyclerviewAdapter chatRecyclerviewAdapter;
    ArrayList<Chat> chats;
    RecyclerView.LayoutManager layoutManager;

    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chats, container, false);
        recyclerView=v.findViewById(R.id.Chats_Recyclerview);
        chats=new ArrayList<>();
        chats.add(new Chat(R.drawable.ic_launcher_background,"Ahmed",
                "Ahmed:hello","today","10","seen"));
        chats.add(new Chat(R.drawable.ic_launcher_background,"Mohammed",
                "Mohammed:hi khalid","yesterday","20","unseen"));
        chats.add(new Chat(R.drawable.ic_launcher_background,"Omar ahmed khalid",
                "omar:hi khalid","yesterday","20","unseen"));
        chatRecyclerviewAdapter=new ChatRecyclerviewAdapter(getContext(),chats);
        layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(chatRecyclerviewAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        return v;
    }
}