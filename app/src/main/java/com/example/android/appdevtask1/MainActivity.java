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
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.profile1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.profile2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.profile3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.profile4);
        boolean checked1 = checkBox1.isChecked();
        boolean checked2 = checkBox2.isChecked();
        boolean checked3 = checkBox3.isChecked();
        boolean checked4 = checkBox4.isChecked();

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

        //To check if profile is empty
        else if(!checked1 && !checked2 && !checked3 && !checked4)
            Toast.makeText(checkBox4.getContext(),"Please choose at least one profile",Toast.LENGTH_SHORT).show();

        //To start new Activity
       else {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
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