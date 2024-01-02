package com.example.noteapp;

public class Note {

    private String noteHead;
    private String noteBody;

    // Constructor
    public Note(String noteHead, String noteBody) {

        this.noteHead = noteHead;
        this.noteBody = noteBody;
    }

    // Getters


    public String getNoteHead() {
        return noteHead;
    }

    public String getNoteBody() {
        return noteBody;
    }

}
