package com.example.c0774174_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DataDisplayActivity extends AppCompatActivity {

    CRACustomer customer;
    TextView txt_sin;
    TextView txt_full_Name;
    TextView txt_gender;
    TextView txt_gross_income, txt_taxDate, txt_federal_tax, txt_provincialTax, lbl_cpp, lbl_empInsurance,
            lbl_RrspContributed, lbl_Cf_RRSP,
            lbl_taxableIncome, lbl_taxPaid, lbl_TaxFilingDate;
    double cpp = 0;
    double rrsp = 0;
    double rrspCf = 0;
    double totalTaxableAmount;
    double federalTax;
    double provincialTax;
    double totalTaxPaid;
    double emp_Insurance;
    TextView lblAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        txt_sin = findViewById(R.id.txt_Sin);
        txt_full_Name = findViewById(R.id.txt_fullName);
        txt_gender = findViewById(R.id.txt_gender);
        txt_gross_income = findViewById(R.id.txt_grossIncome);
        lbl_RrspContributed = findViewById(R.id.txt_rrspContribution);
        lbl_cpp = findViewById(R.id.txt_Cpp);
        lbl_empInsurance = findViewById(R.id.txt_empInsurance);
        lbl_Cf_RRSP = findViewById(R.id.txt_cfRrsp);
        lbl_taxableIncome = findViewById(R.id.id_taxableIncome);
        txt_federal_tax = findViewById(R.id.txt_federalTax);
        txt_provincialTax = findViewById(R.id.txt_provincialTax);
        lbl_taxPaid = findViewById(R.id.txt_taxPayed);
        lbl_TaxFilingDate = findViewById(R.id.txt_taxFilingDate);

        Intent mIntent = getIntent();
        CRACustomer customer = mIntent.getParcelableExtra("User_Data");

        txt_sin.setText(" SIN: \t" + customer.getSin_number());
        txt_full_Name.setText(" FULL NAME: \t" + customer.getFull_name());
        txt_gender.setText(" GENDER: \t" + customer.getGender());
        txt_gross_income.setText(" GROSS INCOME: \t" + customer.getGross_income());
        lbl_RrspContributed.setText("RRSP Contributed: \t" + customer.getRrsp_contribution());
        rrsp = customer.getRrsp_contribution();


        //CPP CALCULATED
        double grossIncome = customer.getGross_income();
        if (grossIncome> 57400.00)
        {
            cpp = (57400.00 * 0.051);
        }
        else
        {
            cpp = (grossIncome * 0.051);
        }

        lbl_cpp.setText("CPP Contribution in Year:\t" + cpp);

        //Employee Insurance Calculated
        if (grossIncome > 53100.00)
        {
            emp_Insurance = (53100.00 * 0.0162);
        }
        else
        {
            emp_Insurance = (grossIncome * 0.0162);
        }

        lbl_empInsurance.setText("Employee Insurance in Year:\t" + emp_Insurance);

        //Calculate RRSP

        rrsp = customer.getRrsp_contribution();
        double maximumRRSP = (grossIncome * 0.18);
        if (rrsp > maximumRRSP)
        {

        }
        else
        {
            
        }










    }
}
