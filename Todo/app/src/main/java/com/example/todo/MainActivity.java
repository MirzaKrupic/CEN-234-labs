package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TODO_ID = "MainActivity/EXTRA_TODO_ID";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lista);
        setUpListAdapted();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long todoid = parent.getItemIdAtPosition(position);
                Intent intent = new Intent(MainActivity.this, TodoDetailsActivity.class);
                intent.putExtra(EXTRA_TODO_ID, todoid);
                startActivity(intent);
            }
        });
    }

    private void setUpListAdapted(){
        List<Todo> todos = AppDatabase.getInstance(this).todoDao().getAll();

        TodoListAdapter adapter = new TodoListAdapter(this, todos);
        listView.setAdapter(adapter);
    }

    public void onAddClick(View view){
        Intent intent = new Intent(this, TodoDetailsActivity.class);
        startActivity(intent);
    }
}