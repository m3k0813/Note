package com.example.notebook2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView outputView;
    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listview);

        adapter = new SingerAdapter();
        adapter.addItem(new NoteItem("안녕", "Hi"));
        adapter.addItem(new NoteItem("안녕하세요", "Hello"));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoteItem item = (NoteItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택: "+item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });



        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoteWriteActivity();

            }
        });

    }

    public void showNoteWriteActivity() {

        Intent intent = new Intent(getApplicationContext(), NoteWriteActivity.class);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 101) {
            if(intent != null) {
                String title = intent.getStringExtra("title");
                String context = intent.getStringExtra("context");
                adapter.addItem(new NoteItem(title, context));
                adapter.notifyDataSetChanged();
            }
        }
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<NoteItem> items = new ArrayList<NoteItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(NoteItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            NoteItemView view =null;
            if(convertView == null) {
                view = new NoteItemView(getApplicationContext());
            }else{
                view = (NoteItemView) convertView;
            }

            NoteItem item = items.get(position);
            view.setTitle(item.getTitle());
            view.setContextText(item.getContext());

            return view;
        }
    }
}
