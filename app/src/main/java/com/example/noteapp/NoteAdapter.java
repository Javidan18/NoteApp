package com.example.noteapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{
    Context context;
    List<Note> note;

    public NoteAdapter(Context context, List<Note> note) {
        this.context = context;
        this.note = note;
    }



    @NonNull
    @Override
    public NoteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.note,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note noteL = note.get(position);

        holder.noteHeader.setText(noteL.getNoteHead());
        holder.notetv.setText(noteL.getNoteBody());

    }

    @Override
    public int getItemCount() {
        if(note!=null){
            return note.size();
        }
        return 0;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        dbHelper DataBaseHelper = new dbHelper(context.getApplicationContext());
        TextView noteHeader,notetv;
        Button deleteButton;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            deleteButton = itemView.findViewById(R.id.note_button);
            noteHeader = itemView.findViewById(R.id.textViewTitle);
            notetv = itemView.findViewById(R.id.textViewDescription);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(DataBaseHelper.deleteTitle(DataBaseHelper.getNoteId(noteHeader.getText().toString())));

                    Intent intent = new Intent(context,MainPage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    context.startActivity(intent);






                }
            });

        }
    }
}