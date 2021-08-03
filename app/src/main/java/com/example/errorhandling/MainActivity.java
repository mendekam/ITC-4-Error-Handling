package com.example.errorhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math; // import class untuk square root

public class MainActivity extends AppCompatActivity {

    private EditText etAngka;
    private TextView tvResult;
    private Button btnSqrt, btnFactorial;

    double sqrt, factorial, angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAngka = findViewById(R.id.et_angka);
        btnSqrt = findViewById(R.id.btn_sqrt);
        btnFactorial = findViewById(R.id.btn_factorial);
        tvResult = findViewById(R.id.tv_result);

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    angka = Double.parseDouble(etAngka.getText().toString());
                    if (angka < 0) {
                        throw new ArithmeticException("Angka tidak boleh negatif!"); //throw exception apabila angka negatif (hasil imajiner)
                    } else {
                        sqrt = Math.sqrt(angka); //hitung akar menggunakan method Math.sqrt
                    }

                } catch (ArithmeticException ae){ //catch exception
                    Toast.makeText(MainActivity.this, ae.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("Runtime Error", "Angka Negatif");
                } catch (NumberFormatException nfe){ //catch exception
                    Toast.makeText(MainActivity.this, "Format Input Harus Angka!", Toast.LENGTH_SHORT).show();
                    Log.d("Format Angka", "Angka harus numerik");
                }
                tvResult.setText(String.valueOf(sqrt)); //menampilkan hasil
            }
        });

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    angka = Double.parseDouble(etAngka.getText().toString());
                    factorial = 1;
                    if (angka < 0) {
                        throw new ArithmeticException("Angka tidak boleh negatif!"); //throw exception apabila angka negatif (hasil tidak terdefinisi)
                    } else {
                        for (double i = angka; i >= 1; i--) {
                            factorial = factorial * i;
                        }
                    }
                } catch (ArithmeticException ae){ //catch exception
                    Toast.makeText(MainActivity.this, ae.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("Runtime Error", "Angka Negatif");
                } catch (NumberFormatException nfe){ //catch exception
                    Toast.makeText(MainActivity.this, "Format Input Harus Angka!", Toast.LENGTH_SHORT).show();
                    Log.d("Format Angka", "Angka harus numerik");
                }
                tvResult.setText(String.valueOf(factorial)); //menampilkan hasil
            }
        });
    }

}