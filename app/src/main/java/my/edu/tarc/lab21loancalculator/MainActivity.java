package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String LOAN_PAYMENT ="payment";
    public static final String LOAN_STATUS ="status";

    private EditText editTextPrice, editTextDownpayment, editTextRepayment, editTextInterestRate, editTextSalary;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice =(EditText)findViewById(R.id.editTextPrice);
        editTextDownpayment=(EditText)findViewById(R.id.editTextDownPayment);
        editTextRepayment=(EditText)findViewById(R.id.editTextRepayment);
        editTextInterestRate=(EditText)findViewById(R.id.editTextInterestRate);
        editTextSalary=(EditText)findViewById(R.id.editTextSalary);
    }

    public void calculateLoan(View view){
        //TODO: CALCULATE repayment amount and determine
        double MonthlyPayment;
        String status;
        double TotalInterest,TotalLoan;

        double Vprice = Double.parseDouble(editTextPrice.getText().toString());
        double Dpayment=Double.parseDouble(editTextDownpayment.getText().toString());
        double Repayment=Double.parseDouble(editTextRepayment.getText().toString());
        double Interest=(Double.parseDouble(editTextInterestRate.getText().toString()))/100;
        double Salary=Double.parseDouble(editTextSalary.getText().toString());

        TotalInterest = (Vprice - Dpayment)*Interest*(Repayment/12);
        TotalLoan = (Vprice-Dpayment)+TotalInterest;
        MonthlyPayment=TotalLoan/Repayment;

        if(MonthlyPayment > (Salary*30/100))
        {
            status="Rejected";
        }
        else
        {
            status="Accepted";
        }

        //Explicit Intent===> call to another activity
        Intent intent = new Intent (this,ResultActivity.class);
        //Use putExtra method to pass to next activity
        //format:  putExtra(TAG, value);
        intent.putExtra(LOAN_PAYMENT, MonthlyPayment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);
    }

    public void Reset (View view){
        editTextPrice.setText("");
        editTextDownpayment.setText("");
        editTextRepayment.setText("");
        editTextInterestRate.setText("");
        editTextSalary.setText("");


    }
}
