package com.example.notebook2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class NoteWriteActivity extends AppCompatActivity {

    EditText titleInput;
    EditText contextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_write);

        titleInput = (EditText) findViewById(R.id.titleInput);
        contextInput = (EditText) findViewById(R.id.contextInput);

        Button writeButton = (Button) findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain2();

            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void returnToMain2() {      //메인의 리스트뷰로
        String title = titleInput.getText().toString();
        String context = contextInput.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("title", title);
        intent.putExtra("context", context);
        setResult(RESULT_OK, intent);

        finish();
    }
}
