package com.example.c0774174_w2020_mad3125_midterm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.c0774174_w2020_mad3125_midterm.R.id.btnSubmit;
import static java.time.LocalDate.now;

public class MainActivity extends AppCompatActivity {

 TextView textView2;
TextInputEditText edtFname;
 TextInputEditText edtLname;
    String Gender_selected;
    EditText txtdate;
    RadioGroup rgGender;
    RadioButton rb_male;
    RadioButton rb_female;
    RadioButton type;
    RadioButton rb_others;
    String age;
    Button btn_submit ;
    DatePickerDialog datePickerDialog;
    final Calendar calendar = Calendar.getInstance();
    TextInputEditText edt_sin;
    TextInputEditText gross_income;
    TextInputEditText rrsp_contribution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        actionBar.show();
        setContentView(R.layout.activity_main);
        textView2 = (TextView)findViewById(R.id.textView2);
        //txtdate= (AppCompatAutoCompleteTextView)findViewById(R.id.txtDate);
        rgGender= (RadioGroup)findViewById(R.id.radioGroup);
         rb_male=(RadioButton)findViewById(R.id.radioButton1);
        rb_female=(RadioButton)findViewById(R.id.radioButton2);
         rb_others=(RadioButton)findViewById(R.id.radioButton3);
        edtFname = (TextInputEditText)findViewById(R.id.editText1);
        edtLname = (TextInputEditText)findViewById(R.id.editText2);
        edt_sin = (TextInputEditText)findViewById(R.id.editText3);
        gross_income = (TextInputEditText)findViewById(R.id.editText4);
        rrsp_contribution = (TextInputEditText)findViewById(R.id.editText5);
        btn_submit = findViewById(R.id.btnSubmit);
        txtdate = findViewById(R.id.txtDate);

        txtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
        int selectedId = rgGender.getCheckedRadioButtonId();
        type =  findViewById(selectedId);
        txtdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    closeKeyboard();
                    openDatePicker();
                }
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        double grossIncome = Double.parseDouble(gross_income.getText().toString());
                             String radioStatus = type.getText().toString();
                             Log.d("tetsts",radioStatus);
                        double rrsp = Double.parseDouble(rrsp_contribution.getText().toString());
                        CRACustomer customer = new CRACustomer(edt_sin.getText().toString(),
                                edtFname.getText().toString(),
                                edtLname.getText().toString(),
                                radioStatus, grossIncome, rrsp, age);
                     //   String sin = edt_sin.getText().toString();
                       // String fName = edtFname.getText().toString();
                       // String lName = edtLname.getText().toString();
                      //  customer.setSin_number(sin);
                       // customer.setFirst_name(fName);
                       /* customer.setLast_name(lName);
                        customer.setGender(Gender_selected);
                        customer.setGross_income(grossIncome);
                        customer.setRrsp_contribution(rrsp);*/


                    Intent intent = new Intent(MainActivity.this, DataDisplayActivity.class);
                    intent.putExtra("User_Data", customer);
                    startActivity(intent);

                }

        });
}
    @RequiresApi(api = Build.VERSION_CODES.O)
    private String dateFormat()
    {
        LocalDate l1 = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate now = LocalDate.now();
        Period diff = Period.between(l1, now);
        String years = String.valueOf(diff.getYears());
        String months = String.valueOf(diff.getMonths());
        String days = String.valueOf(diff.getDays());
        age="Age: "+years+"Years"+months+"Months"+days+"Days";
        return years;

    }
    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void openDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog
        DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                        String strDate = format.format(calendar.getTime());
                        txtdate.setText(strDate.toUpperCase());
                    }
                }, year, month, day);
        datePicker.getDatePicker().setMaxDate(new Date().getTime());
        datePicker.show();
    }

}










