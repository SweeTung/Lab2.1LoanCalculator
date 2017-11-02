package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView TextViewMonthlyPayment, TextViewStatus;
    private ImageView imageViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextViewMonthlyPayment = (TextView)findViewById(R.id.textViewMonthlyPayment);
        TextViewStatus = (TextView)findViewById(R.id.textViewStatus);
        imageViewStatus= (ImageView)findViewById(R.id.imageViewStatus);

        //TO GET THE INTENT ACTIVITY
        Intent intent = getIntent();  //Asking "who called this?"
        double payment = intent.getDoubleExtra(MainActivity.LOAN_PAYMENT, 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        //TODO: DISPLAY OUTPUTs


        if (status.equals("Accepted")) {
            imageViewStatus.setImageResource(R.drawable.thumbsup);
            TextViewMonthlyPayment.setText(payment+"");
            TextViewStatus.setText(status);

        }
        else if (status.equals("Rejected"))
        {
            imageViewStatus.setImageResource(R.drawable.thumbsdown);
            TextViewMonthlyPayment.setText(payment+"");
            TextViewStatus.setText(status);
        }

    }

    public void closeActivity(View view){
        //Terminate
        finish();
        imageViewStatus.setImageResource(R.drawable.trollthumbs);
    }
}
