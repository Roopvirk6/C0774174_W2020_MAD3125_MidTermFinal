package com.example.c0774174_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import static com.example.c0774174_w2020_mad3125_midterm.R.id.btnSubmit;

public class MainActivity extends AppCompatActivity {

 TextView textView2;
 TextInputEditText edtFname;
 TextInputEditText edtLname;
    String Gender_selected;
    TextView txt_date;
    RadioGroup rgGender;
    RadioButton rb_male;
    RadioButton rb_female;
    RadioButton rb_others;
    String age;
    Button btn_submit = (Button)findViewById(btnSubmit);
    TextView txt_age;
    DatePickerDialog datePickerDialog;
    final Calendar calendar = Calendar.getInstance();
    TextInputEditText edt_sin;
    TextInputEditText gross_income;
    TextInputEditText rrsp_contribution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_date= (TextView)findViewById(R.id.txtDate);
        rgGender= (RadioGroup)findViewById(R.id.btnRadioGroup);
        rb_male=(RadioButton)findViewById(R.id.radioButton1);
        rb_female=(RadioButton)findViewById(R.id.radioButton2);
        rb_others=(RadioButton)findViewById(R.id.radioButton3);
        edtFname = (TextInputEditText)findViewById(R.id.editText1);
        edtLname = (TextInputEditText)findViewById(R.id.editText2);
        edt_sin = (TextInputEditText)findViewById(R.id.editText3);
        gross_income = (TextInputEditText)findViewById(R.id.editText4);
        rrsp_contribution = (TextInputEditText)findViewById(R.id.editText5);

        final DatePickerDialog.OnDateSetListener t_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                //dateFormatDOB();
            }
        };

            txt_date.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    new DatePickerDialog(MainActivity.this, t_date, calendar
                            .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton1){
                    Gender_selected = rb_male.getText().toString();
                }
                else if(checkedId == R.id.radioButton2){
                    Gender_selected  = rb_female.getText().toString();
                }
                else {
                    Gender_selected = rb_others.getText().toString();
                }
            }

        });







            });




    }


}










