package app.kalkulator.ru.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button delete;
    Button execute;
    Button sum;
    Button multiply;
    Button division;
    Button subtraction;
    String numberOne = "";
    String One = "";
    String Two = "";
    int Result;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText) findViewById(R.id.text1);
        firstNumber.setFocusable(false);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        delete = (Button) findViewById(R.id.delete);
        sum = (Button) findViewById(R.id.sum);
        multiply = (Button) findViewById(R.id.multiply);
        division = (Button) findViewById(R.id.division);
        subtraction = (Button) findViewById(R.id.subtraction);
        execute = (Button) findViewById(R.id.execute);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "0";
                firstNumber.setText(numberOne);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "1";
                firstNumber.setText(numberOne);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "2";
                firstNumber.setText(numberOne);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "3";
                firstNumber.setText(numberOne);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "4";
                firstNumber.setText(numberOne);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "5";
                firstNumber.setText(numberOne);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "6";
                firstNumber.setText(numberOne);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "7";
                firstNumber.setText(numberOne);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "8";
                firstNumber.setText(numberOne);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = numberOne + "9";
                firstNumber.setText(numberOne);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOne != null && numberOne.length() > 0) {
                    numberOne = numberOne.substring(0, numberOne.length() - 1);
                }
                firstNumber.setText(numberOne);
            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                One = numberOne;
                numberOne = "";
                 firstNumber.setText(numberOne);
                operation = "sum";
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                One = numberOne;
                numberOne = "";
                firstNumber.setText(numberOne);
                operation = "multiply";
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                One = numberOne;
                numberOne = "";
                 firstNumber.setText(numberOne);
                operation = "division";
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOne==""){
                    numberOne = numberOne + "-";
                    firstNumber.setText(numberOne);
                }else{
                    One = numberOne;
                    numberOne = "";
                     firstNumber.setText(numberOne);
                    operation = "subtraction";
                }
            }
        });
        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Two = numberOne;
                numberOne = "";
                firstNumber.setText(numberOne);
                int one;
                int two;
                try {
                    one = Integer.parseInt(One);
                } catch (NumberFormatException e) {
                    one = 0;
                }
                try {
                    two = Integer.parseInt(Two);
                } catch (NumberFormatException e) {
                    two = 0;
                }
                switch (operation) {
                    case "sum":
                        Result = one + two;
                        break;
                    case "multiply":
                        Result = one * two;
                        break;
                    case "division":
                        try {
                            Result = one / two;
                        } catch (ArithmeticException e) {
                            operation="Error(devision on zero)";
                        }
                        break;
                    case "subtraction":
                        Result = one - two;
                        break;
                    default:
                        operation="No operation selected";
                        //  firstNumber.setText(operation);
                        break;
                }
                if(operation=="No operation selected"|| operation=="Error(devision on zero)") {
                    firstNumber.setText(operation);
                }else{
                    Toast.makeText(MainActivity.this, String.valueOf(Result), Toast.LENGTH_SHORT).show();
                    firstNumber.setText(String.valueOf(Result));
                }
                operation="";
            }
        });

    }
}
