package com.example.nurlan.numberapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math.*;


public class MainActivity extends AppCompatActivity {
    EditText et;
    EditText et2;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.textView);
        String num1 = et.getText().toString();
        String num2 = et2.getText().toString();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sqrt) {
            double d = Math.sqrt(Integer.valueOf(num1));
            tv.setText(String.valueOf(d));
        }
        if (id == R.id.pow) {
            double result = Math.pow(Double.valueOf(num1), Double.valueOf(num2));
            tv.setText(String.valueOf(result));
        }
        if (id == R.id.sin) {
            double result = Math.sin(Double.valueOf(num1));
            tv.setText(String.valueOf(result));
        }
        if (id == R.id.asin) {
            double result = Math.asin(Double.valueOf(num1));
            tv.setText(String.valueOf(result));
        }
        if (id == R.id.max) {
            double result = Math.max(Double.valueOf(num1), Double.valueOf(num2));
            tv.setText(String.valueOf(result));
        }
        if (id == R.id.min) {
            double result = Math.min(Double.valueOf(num1), Double.valueOf(num2));
            tv.setText(String.valueOf(result));
        }
        if (id == R.id.round) {
            double result = Math.round(Double.valueOf(num1));
            tv.setText(String.valueOf(result));
        }
        if (id == R.id.sumdigits) {
            int sumOfDigits = 0;
            for (int q = 1; q < num1.length() + 1; q++) {
                String oneDigit = num1.substring((q - 1), q);
                sumOfDigits = sumOfDigits + Integer.valueOf(oneDigit);
            }
            tv.setText(String.valueOf(sumOfDigits));
        }
        if (id == R.id.even) {
            String s = num1;
            String[] masS;
            String result = "";
            masS = s.split("#");

            for (int i = 0; i < masS.length; i++) {
                if (Integer.valueOf(masS[i]) % 2 == 0) {
                    result = result + masS[i] + " ";
                }
            }
            if (result.equals("")) {
                result = "четных чисел нет";
            }


            tv.setText(String.valueOf(result));
        }
        if (id == R.id.odd) {
            String s = num1;
            String[] masS;
            String result = "";
            masS = s.split("#");

            for (int i = 0; i < masS.length; i++) {
                if (Integer.valueOf(masS[i]) % 2 == 1) {
                    result = result + masS[i] + " ";
                }
            }
            if (result.equals("")) {
                result = "нечетных чисел нет";
            }


            tv.setText(String.valueOf(result));
        }

        if (id == R.id.nonZero) {

            String w = num1;
            String[] a;
            a = w.split("#");
            int kolvo = 0;

            for (int i = 0; i < a.length; i++) {
                int digit = Integer.valueOf(a[i]);
                Log.d("Цифра  ", a[i]);
                if (digit != 0) {
                    kolvo++;
                }
            }
            tv.setText(String.valueOf(kolvo));
        }

        if (id == R.id.sum_fives) {
            String[] fivs = num1.split("#");
            int result = 0;

            for (int i = 0; i < fivs.length; i++) {
                int digit = Integer.valueOf(fivs[i]);
                Log.d("Цифра  ", fivs[i]);
                if (digit > 0 && digit % 5 == 0) {
                    result = result + digit;
                }
            }
            tv.setText(String.valueOf(result));
        }

        if (id == R.id.srednee) {
            String[] sred = num1.split("#");
            double res = 0;

            for (int i = 0; i < sred.length; i++) {
                double digit = Double.valueOf(sred[i]);
                Log.d("Цифра  ", sred[i]);
                if (i > 0) {
                    res = (digit + res) / 2;
                } else {
                    res = digit;
                }
            }
            tv.setText(String.valueOf(res));
        }

        if (id == R.id.sum_four_eight) {
            String[] a = num1.split("#");
            int result = 0;

            for (int i = 0; i < a.length; i++) {
                int digit = Integer.valueOf(a[i]);
                Log.d("Цифра  ", a[i]);
                if (digit > 3 && digit < 15) {
                    result = result + digit;
                }
            }
            tv.setText(String.valueOf(result));
        }
        if (id == R.id.phone_bill) {
            double sumResult = 0;
            double discount = 0;

            if (Integer.valueOf(num2) < 1 || Integer.valueOf(num2) > 7 || num2.equals("")) {
                Toast t = Toast.makeText(this, "Нет такого дня недеели, введите цифру от 1 до 7", Toast.LENGTH_LONG);
                t.show();
            } else {
                if (Integer.valueOf(num2) == 6 || Integer.valueOf(num2) == 7) {
                    sumResult = Integer.valueOf(num1) * 1.5 * 0.8;
                    discount = Integer.valueOf(num1) * 1.5 * 0.2;
                    tv.setText("Ваша скидка выходного дня " + discount + " сом. " + "Счет за разговоры с учетом скидки " + String.valueOf(sumResult) + " сом");
                } else {
                    sumResult = Integer.valueOf(num1) * 1.5;
                    tv.setText("Ваша скидка " + discount + " сом. " + "Счет за разговоры " + String.valueOf(sumResult) + " сом");
                }
            }
        }
        if (id == R.id.discount) {
            double sumResult = 0;
            String discount = "0%";
            if (Integer.valueOf(num1) > 1000) {
                discount = "5%";
                sumResult = Integer.valueOf(num1) / 100 * 95;
            } else if (Integer.valueOf(num1) > 500) {
                discount = "3%";
                sumResult = Integer.valueOf(num1) / 100 * 97;
            } else {
                sumResult = Integer.valueOf(num1);
            }
            tv.setText("Ваша скидка " + discount + ". Сумма к оплате " + String.valueOf(sumResult) + " сом");
        }

        if (id == R.id.seasonTime) {
            String season = "Осень";
            int m = Integer.valueOf(num1);
            if (m < 1 || m > 12) {
                Toast qw = Toast.makeText(this, "Нет такого месяца, введите цифру от 1 до 12", Toast.LENGTH_SHORT);
                qw.show();
            } else {
                if (m == 12 || m < 3) {
                    season = "Зима";
                } else if (m > 2 && m < 6) {
                    season = "Весна";
                } else if (m > 5 && m < 9) {
                    season = "Лето";
                }
                tv.setText("Месяц - " + m + " - это время года - " + season);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
