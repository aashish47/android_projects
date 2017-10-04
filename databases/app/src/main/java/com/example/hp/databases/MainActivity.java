package com.example.hp.databases;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hp.databases.db.TodoDbHelper;
import com.example.hp.databases.db.tables.TodoTable;
import com.example.hp.databases.models.Todo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvTodos;
    EditText etNewTodo;
    ImageButton btnAdd,btnDel;
    ArrayList<Todo> todos = new ArrayList<>();

    SQLiteDatabase todoDb;


    public static final String TAG = "DB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoDb = new TodoDbHelper(this).getWritableDatabase();

        rvTodos = (RecyclerView) findViewById(R.id.rvTodos);
        etNewTodo = (EditText) findViewById(R.id.etNewTodo);
        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnDel = (ImageButton) findViewById(R.id.btnDel);

        todos = TodoTable.getAllTodos(todoDb);

        final TodoAdapter todoArrayAdapter = new TodoAdapter();
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        rvTodos.setAdapter(todoArrayAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long todoId = TodoTable.insertTodo(
                        todoDb,
                        new Todo(etNewTodo.getText().toString(), false)
                );
                Log.d(TAG, "onClick: " + todoId);
                etNewTodo.setText(null);

                todos = TodoTable.getAllTodos(todoDb);
                Log.d(TAG, "onClick: "+todos.get(0).isDone());
                todoArrayAdapter.notifyDataSetChanged();

            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TodoTable.deleteTodo(
                        todoDb
                );
                todos = TodoTable.getAllTodos(todoDb);
                todoArrayAdapter.notifyDataSetChanged();
            }
        });


    }


    class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

        @Override
        public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            return new TodoViewHolder(li.inflate(R.layout.list_item_todo, parent, false));
        }

        @Override
        public void onBindViewHolder(final TodoViewHolder holder,  int position) {
            holder.text1.setText(todos.get(position).getTask());
            final int id = todos.get(position).getId();

            holder.text1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(holder.text1.isChecked()){
                        TodoTable.updateTodo(todoDb,true,id);
                    }
                    else {
                        TodoTable.updateTodo(todoDb,false,id);
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "getItemCount: " + todos.size());
            return todos.size();
        }

        class TodoViewHolder extends RecyclerView.ViewHolder {
            CheckBox text1;

            public TodoViewHolder(View itemView) {
                super(itemView);
                text1 = (CheckBox) itemView.findViewById(R.id.cbtTodo);
            }
        }
    }
}