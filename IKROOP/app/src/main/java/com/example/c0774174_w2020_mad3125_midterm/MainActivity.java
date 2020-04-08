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
 TextInputEditText edt_fname;
 TextInputEditText edt_lname;
    String Gender_selected;
    TextView txt_date;
    RadioGroup rg_gender;
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
        rg_gender= (RadioGroup)findViewById(R.id.btnRadioGroup);
        rb_male=(RadioButton)findViewById(R.id.radioButton1);
        rb_female=(RadioButton)findViewById(R.id.radioButton2);
        rb_others=(RadioButton)findViewById(R.id.radioButton3);
        edt_fname = (TextInputEditText)findViewById(R.id.editText1);
        edt_lname = (TextInputEditText)findViewById(R.id.editText2);
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
                dateFormatDOB();
            };



        }




    }










