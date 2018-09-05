package mx.itesm.examexercise;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*Problem: A friend of yours works as waiter in a restaurant. He is not really good with numbers, so he always makes mistakes when giving the change to his customers
after they pay a bill. He knows that you are an expert mobile developer, so he asks you to use Android to create a super simple app where he can type the total amount
of the check and the total amount of money he received from the customer, and the app should tell him exactly the best way to give the change.

Requirements: The app shall be able to receive two values (“total due” and “total paid”), using EditText views, and shall calculate the “change” (that is, the difference
between the total paid and the total due). Then, with the change, the app shall tell the waiter, (using a TextView) what's the most efficient number of bills or coins he
has to give back as change. For simplicity purposes, no cent  shall be handled (consider only denominations of 500, 200, 100, 50, 20, 10, 5, 2, and 1 pesos). When the
application finishes the calculation, the phone shall vibrate.

Example: Let us suppose that the customer has to pay a bill of $ 181 pesos, and he decides to pay it with a banknote of $ 500 pesos. The application shall tell the waiter
that he needs to give back $ 319 pesos in change, putting together 1 banknote of 200 pesos, 1 banknote of 100 pesos, 1 banknote of 10 pesos, 1 coin of 5 pesos and 2 coins
of 2 pesos.*/

public class MainActivity extends AppCompatActivity {

    Button calc;
    EditText totalDue;
    EditText totalPaid;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = findViewById(R.id.calculate);
        totalDue = findViewById(R.id.dueText);
        totalPaid = findViewById(R.id.paidText);
        result = findViewById(R.id.resultText);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calculation = "";
                int counter = 0;
                int change;
                int paid = Integer.parseInt(totalPaid.getText().toString());
                int due = Integer.parseInt(totalDue.getText().toString());
                change = paid - due;

                //how many 500s
                if(change >= 500){
                    for(int i = 0; change >= 500; i++) {
                            change = change - 500;
                            counter = i+1;
                    }
                    calculation = counter + "x500$  ";
                }
                //how many 200s
                if(change >= 200){
                    for (int i = 0; change >= 200; i++) {
                        change = change - 200;
                        counter = i + 1;
                    }
                    calculation = calculation + counter + "x200$  ";
                }
                //how many 100s
                if(change >= 100){
                    for(int i = 0; change >= 100; i++) {
                        change = change - 100;
                        counter = i+1;
                    }
                    calculation = calculation + counter + "x100$  ";
                }
                //how many 50s
                if(change >= 50){
                    for(int i = 0; change >= 50; i++) {
                        change = change - 50;
                        counter = i+1;
                    }
                    calculation = calculation + counter + "x50$  ";
                }
                //how many 20s
                if(change >= 20){
                    for(int i = 0; change >= 20; i++) {
                        change = change - 20;
                        counter = i+1;
                    }
                    calculation = calculation + counter + "x20$  ";
                }
                //how many 10s
                if(change >= 10){
                    for(int i = 0; change >= 10; i++) {
                        change = change - 10;
                        counter = i+1;
                    }
                    calculation = calculation + counter + "x10$  ";
                }
                //how many 5s
                if(change >= 5){
                    for(int i = 0; change >= 5; i++) {
                        change = change - 5;
                        counter = i+1;
                    }
                    calculation = calculation + counter + "x5$  ";
                }
                //how many 2s
                if(change >= 2){
                    for(int i = 0; change >= 2; i++) {
                        change = change - 2;
                        counter = i+1;
                    }
                    calculation = calculation + counter + "x2$  ";
                }
                //how many 1s
                if(change >= 1){
                    for(int i = 0; change >= 1; i++) {
                        change = change - 1;
                        counter = i+1;
                    }
                    calculation = calculation + counter + "x1$  ";
                }
                if(change == 0) {
                    result.setText(calculation);
                    long pattern[] = {200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50};
                    Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vib.vibrate(pattern, -1);
                }

            }
        });

    }
}
