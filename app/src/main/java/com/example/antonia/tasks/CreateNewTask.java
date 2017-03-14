package com.example.antonia.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Antonia on 3/13/2017.
 */

public class CreateNewTask extends TaskScreen {

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.create_new_task);

        final EditText written = (EditText) findViewById(R.id.writeNewTask);
        final EditText date = (EditText) findViewById(R.id.writeDate);
        final EditText time = (EditText) findViewById(R.id.writeTime);
        final EditText description = (EditText) findViewById(R.id.Description);

        Button saveChanges = (Button) findViewById(R.id.saveChanges);
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInformation(v, written, date, time, description);
                launchActivity();
            }
        });
    }

    private void launchActivity() {
        Intent intent = new Intent(this, TaskScreen.class);
        startActivity(intent);
    }

    private void addInformation(View v, EditText written, EditText date, EditText time, EditText description) {
        String nameOfTask = written.getText().toString();
        String theDate = date.getText().toString();
        String theTime = time.getText().toString();
        String theDescription = description.getText().toString();

        if(nameOfTask.matches("")) {
            Toast.makeText(v.getContext(), "You did not enter a title", Toast.LENGTH_SHORT).show();
            return;
        }
        if(theDate.matches("")) {
            Toast.makeText(v.getContext(), "You did not enter a date", Toast.LENGTH_SHORT).show();
            return;
        }
        if(theTime.matches("")) {
            Toast.makeText(v.getContext(), "You did not enter the time", Toast.LENGTH_SHORT).show();
            return;
        }

        RecyclerData mLog = new RecyclerData(nameOfTask, theDate, theTime, theDescription);
        //de aici vreau sa adaug in lista de Recycle View-uri

        written.setText("");
        date.setText("");
        time.setText("");
        description.setText("");
    }
}