package com.example.android.appdevtask1;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements OnItemSelectedListener{
    private Switch mySwitch;
    public final static String EXTRA_MESSAGE = "com.example.android.appdevtask1.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwitch = (Switch) findViewById(R.id.mySwitch);

        //set the switch to ON
        mySwitch.setChecked(true);
        //attach a listener to check for changes in state
        mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    //switchStatus.setText("Switch is currently ON");
                } else {
                    //switchStatus.setText("Switch is currently OFF");
                }

            }
        });

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("CSE");
        categories.add("ECE");
        categories.add("EEE");
        categories.add("ICE");
        categories.add("MECH");
        categories.add("CIVIL");
        categories.add("CHEM");
        categories.add("MME");
        categories.add("PROD");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.profile1:
                if (checked);

                else
                    break;
            case R.id.profile2:
                if (checked);

                else
                    break;
            case R.id.profile3:
                if (checked);

                else
                    break;
            case R.id.profile4:
                if (checked);

                else
                    break;
        }
    }

    public void Submit(View view) {
        EditText usernameEditText = (EditText) findViewById(R.id.name);
        EditText rollnumberEditText = (EditText) findViewById(R.id.number);
        CheckBox checkBox = (CheckBox) findViewById(R.id.profile1);
        boolean checked = ((CheckBox) view).isChecked();

        //To check if profiles have been chosen
        switch(view.getId()) {
            case R.id.profile1:
                if (!checked);

                else
                    break;
            case R.id.profile2:
                if (!checked);

                else
                    break;
            case R.id.profile3:
                if (!checked);

                else
                    break;
            case R.id.profile4:
                if (!checked);

                else
                    break;
            default:
                Toast.makeText(checkBox.getContext(),"Please choose a profile",Toast.LENGTH_SHORT).show();
        }

        //To check if Name is empty
        if (isEmpty(usernameEditText)) {
            Toast.makeText(usernameEditText.getContext(), "Please fill in Name ", Toast.LENGTH_LONG).show();
            return;
        }

        //To check if Rollnumber is empty
        else if (isEmpty(rollnumberEditText)) {
            Toast.makeText(rollnumberEditText.getContext(), "Please fill in Roll Number ", Toast.LENGTH_LONG).show();
            return;
        }
        //To start new Activity
       else {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            TextView editText = (TextView) findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        else
            return true;
    }

}