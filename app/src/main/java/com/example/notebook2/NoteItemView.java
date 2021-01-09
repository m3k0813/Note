package com.example.notebook2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class NoteItemView extends LinearLayout {

    TextView titleText;
    TextView contextText;

    public NoteItemView(Context context) {
        super(context);
        init(context);
    }

    public NoteItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

         titleText = (TextView) findViewById(R.id.titleText);
         contextText = (TextView) findViewById(R.id.contextText);
    }

    public  void setTitle(String title) {
        titleText.setText(title);
    }
    public  void setContextText(String context) {
        contextText.setText(context);
    }
}
