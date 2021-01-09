package com.example.notebook2;

public class NoteItem {

    String title;
    String context;

    public NoteItem(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "NoteItem{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
