package com.example.c0774174_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}
