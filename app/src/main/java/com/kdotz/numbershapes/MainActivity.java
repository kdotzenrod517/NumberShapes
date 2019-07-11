package com.kdotz.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int num;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(num);
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < num) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == num) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {

        Log.i("Info", "Button Pressed");

        EditText editText = (EditText) findViewById(R.id.editText);
        String message = "";

        if (editText.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {
            Number myNumber = new Number();
            myNumber.num = Integer.valueOf(editText.getText().toString());
            message = editText.getText().toString();
            if (myNumber.isTriangular() && myNumber.isSquare()) {
                message += " is square and triangular.";
            } else if (myNumber.isSquare()) {
                message += " is square but not triangular.";
            } else if (myNumber.isTriangular()) {
                message += " is triangular but not square.";
            } else {
                message += " is neither triangular or square.";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
