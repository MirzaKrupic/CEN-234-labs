package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TodoListAdapter extends BaseAdapter {
    private Context context;
    private List<Todo> todoList;

    public TodoListAdapter(Context context, List<Todo> todoList) {
        this.context = context;
        this.todoList = todoList;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return todoList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.todo_list_item, parent, false);

        Todo todo = todoList.get(position);
        TextView itemTitle = convertView.findViewById(R.id.item_title);
        TextView itemDescription = convertView.findViewById(R.id.item_description);
        itemTitle.setText(todo.getTitle());
        itemDescription.setText(todo.getDescription());
        return convertView;
    }
}
