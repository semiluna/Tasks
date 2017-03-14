package com.example.antonia.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import static com.example.antonia.tasks.R.styleable.RecyclerView;

public class TaskScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_task_screen);

        Button tasksButton = (Button) findViewById(R.id.newTask);

        tasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        }
        );
    }

    private void launchActivity() {
        Intent intent = new Intent(this, CreateNewTask.class);
        startActivity(intent);
    }


}
