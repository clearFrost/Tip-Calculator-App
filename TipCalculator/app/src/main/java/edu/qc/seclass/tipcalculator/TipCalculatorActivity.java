package edu.qc.seclass.tipcalculator;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.tipcalculator.R;



public class TipCalculatorActivity extends AppCompatActivity {

    double DoubleCheck;
    int numberofPeople;

            EditText checkAmountUser;
            EditText partySizeUser;
            Button computeButton;
            EditText fifteenpercenttip;
            EditText twentypercenttip;
            EditText twentyfivepercenttip;
            EditText fifteenpercenttotaltip;
            EditText twentypercenttotaltip;
            EditText twentyfivepercenttotaltip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        checkAmountUser = findViewById(R.id.checkAmountValue);
        partySizeUser = findViewById(R.id.partySizeValue);
        computeButton= findViewById(R.id.buttonCompute);
        computeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                    if (checkAmountUser.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Invalid Input please put a real number", Toast.LENGTH_LONG).show();
                    } else if (partySizeUser.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Invalid Input please put a real number", Toast.LENGTH_LONG).show();
                    } else if (Integer.valueOf(partySizeUser.getText().toString()) == 0) {
                        Toast.makeText(getApplicationContext(), "Invalid Input please put a number greater than 0", Toast.LENGTH_LONG).show();

                    } else {
                        fifteenpercenttip = findViewById(R.id.fifteenPercentTipValue);
                        twentypercenttip = findViewById(R.id.twentyPercentTipValue);
                        twentyfivepercenttip = findViewById(R.id.twentyfivePercentTipValue);
                        fifteenpercenttotaltip = findViewById(R.id.fifteenPercentTotalValue);
                        twentypercenttotaltip = findViewById(R.id.twentyPercentTotalValue);
                        twentyfivepercenttotaltip = findViewById(R.id.twentyfivePercentTotalValue);

                        DoubleCheck = Double.parseDouble(checkAmountUser.getText().toString());
                        numberofPeople = Integer.parseInt(partySizeUser.getText().toString());

                        fifteenpercenttip.setText((String.valueOf(tipCalculation(DoubleCheck, numberofPeople, 0.15))));
                        twentypercenttip.setText(String.valueOf(tipCalculation(DoubleCheck, numberofPeople, 0.20)));
                        twentyfivepercenttip.setText(String.valueOf(tipCalculation(DoubleCheck, numberofPeople, 0.25)));

                        fifteenpercenttotaltip.setText(String.valueOf(totalCalculation(DoubleCheck, numberofPeople, 0.15)));
                        twentypercenttotaltip.setText(String.valueOf(totalCalculation(DoubleCheck, numberofPeople, 0.20)));
                        twentyfivepercenttotaltip.setText(String.valueOf(totalCalculation(DoubleCheck, numberofPeople, 0.25)));
                    }
                }
                                         }

        );
    }

    public int tipCalculation(double DoubleCheck,int numberofPeople, double percent){
        return (int) Math.ceil((DoubleCheck/numberofPeople) *percent);
    }

    public int totalCalculation(double DoubleCheck,int numberofPeople, double percent){
        double tip = ((DoubleCheck/numberofPeople)*percent);
        return (int) Math.ceil((DoubleCheck/numberofPeople)+tip);
    }
}