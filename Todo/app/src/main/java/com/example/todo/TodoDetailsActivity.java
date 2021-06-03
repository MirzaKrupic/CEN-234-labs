package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TodoDetailsActivity extends AppCompatActivity {
    private TextView titleInput, descriptionInput;
    private long id;
    private Button saveButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_details);

        titleInput = findViewById(R.id.enterTitle);
        descriptionInput = findViewById(R.id.addDescription);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            id = extras.getLong(MainActivity.EXTRA_TODO_ID);
            Todo todo = AppDatabase.getInstance(this).todoDao().getTodoById(id);
            titleInput.setText(todo.getTitle());
            descriptionInput.setText(todo.getDescription());
            saveButton.setText("Update");
            saveButton.setOnClickListener(this::onUpdate);
            cancelButton.setText("Delete");
            cancelButton.setOnClickListener(this::onDelete);
        }
    }

    public void onSave(View view){
        Todo todo = new Todo(titleInput.getText().toString(), descriptionInput.getText().toString());
        AppDatabase.getInstance(this).todoDao().add(todo);

        Intent intet = new Intent(this, MainActivity.class);
        startActivity(intet);
    }

    public void onCancel(View view){
        Intent intet = new Intent(this, MainActivity.class);
        startActivity(intet);
    }

    public void onUpdate(View view){
        AppDatabase.getInstance(this).todoDao().update(id, titleInput.getText().toString(), descriptionInput.getText().toString());

        Intent intet = new Intent(this, MainActivity.class);
        startActivity(intet);
    }

    public void onDelete(View view){
        Todo todo = AppDatabase.getInstance(this).todoDao().getTodoById(id);
        AppDatabase.getInstance(this).todoDao().delete(todo);
        Intent intet = new Intent(this, MainActivity.class);
        startActivity(intet);
    }
}