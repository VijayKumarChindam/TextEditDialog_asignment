package com.example.texteditdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText minput;
    private TextView showinput;
    private Button submit,btn_setText;
    private CheckBox reverseBox;
    private RadioButton upper , lower, init;
    private String stringinput, result="";
    private RadioGroup radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog setdialog = new Dialog(MainActivity.this);
                setdialog.setContentView(R.layout.textediter_dialog);

                showinput = setdialog.findViewById(R.id.showinput);
                btn_setText = setdialog.findViewById(R.id.SetText);
                reverseBox = setdialog.findViewById(R.id.reversebox);
                upper = setdialog.findViewById(R.id.upperCase);
                lower = setdialog.findViewById(R.id.LowerCase);
                init = setdialog.findViewById(R.id.initcap);

                stringinput = minput.getText().toString();
                showinput.setText(stringinput);

                setdialog.show();

                btn_setText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        showinput.getText().toString();

                        if (upper.isChecked())
                            minput.setText(showinput.getText().toString().toUpperCase());
                         else if(lower.isChecked())
                            minput.setText(showinput.getText().toString().toLowerCase());
                        else if(init.isChecked())
                            minput.setText(showinput.getText().toString().substring(0,1).toUpperCase()+showinput.getText().toString().substring(1).toLowerCase());

                       if (reverseBox.isChecked()){
                           StringBuffer sbr=new StringBuffer(stringinput);
                           sbr.reverse();
                           minput.setText(sbr.toString());
                           }

                        setdialog.dismiss();

                    }
                });

            }
        });
    }

    public void init(){
        minput=findViewById(R.id.edit_inputtext);
        submit=findViewById(R.id.btn_sumbit);
        radioButton=findViewById(R.id.radiogroup);
    }
}