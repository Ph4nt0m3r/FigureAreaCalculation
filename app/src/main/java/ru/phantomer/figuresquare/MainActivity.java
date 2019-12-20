package ru.phantomer.figuresquare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.textView);
        input = findViewById(R.id.editText);
    }

    public void start(View view) {
        String figure = input.getText().toString();

        if (input.getText().toString().isEmpty())
            return;

        String type = figure
                .split(";")[0]
                .replace("type=", "");

        if (type.equals("square")) {

            double side = Double.parseDouble(figure
                    .split("=")[2]
                    .replace(";", "")
            );

            output.setText(type + "'s acreage= " + Math.pow(side, 2));
        } else if (type.equals("circle")) {
            double radius = Double.parseDouble(figure
                    .split("=")[2]
                    .replace(";", "")
            );

            output.setText(type + "'s acreage=" + Math.pow(radius, 2) * Math.PI);
        } else if (type.equals("triangle")) {



                double one = Double.parseDouble(figure
                        .split(";")[1]
                        .replace("one=", ""));

                double angle1 = Double.parseDouble(figure
                        .split(";")[1]
                        .replace("angle1=", ""));

            double two = Double.parseDouble(figure
                    .split(";")[2]
                    .replace("two=", ""));

            double angle2 = Double.parseDouble(figure
                    .split(";")[2]
                    .replace("angle2=", ""));

            double three = Double.parseDouble(figure
                    .split(";")[3]
                    .replace("three=", ""));

            double angle3 = Double.parseDouble(figure
                    .split(";")[3]
                    .replace("angle3=", ""));

// WITH 3 SIDES
            if (type.contains("one") & type.contains("two") & type.contains("three")) {
                double p = (one + two + three) / 2;
                output.setText(type + "'s acreage= " + Math.sqrt(p * (p - one) * (p - two) * (p - three)));
            }

            //WITH 2 SIDES AND 1 ANGLE
            else if (type.contains("angle1") & type.contains("two") & type.contains("three")) {
                output.setText(type + "'s acreage= " + Math.sin(angle1) * two * three / 2);
            } else if (type.contains("one") & type.contains("angle2") & type.contains("three")) {
                output.setText(type + "'s acreage= " + Math.sin(angle2) * one * three / 2);
            } else if (type.contains("one") & type.contains("two") & type.contains("angle3")) {
                output.setText(type + "'s acreage= " + Math.sin(angle3) * one * two / 2);
            }

            //WITH 2 ANGLES AND 1 SIDE
            else if (type.contains("angle1") & type.contains("angle2") & type.contains("three")) {
                output.setText(type + "'s acreage= " +
                        (Math.pow(three, 2) / 2) * ((Math.sin(angle1) * Math.sin(angle2)) / Math.sin(angle1 + angle2)));
            } else if (type.contains("one") & type.contains("angle2") & type.contains("angle3")) {
                output.setText(type + "'s acreage= " +
                        (Math.pow(one, 2) / 2) * ((Math.sin(angle2) * Math.sin(angle3)) / Math.sin(angle2 + angle3)));
            } else if (type.contains("angle1") & type.contains("two") & type.contains("angle3")) {
                output.setText(type + "'s acreage= " +
                        (Math.pow(two, 2) / 2) * ((Math.sin(angle1) * Math.sin(angle3)) / Math.sin(angle1 + angle3)));
            }
        }


    }
}

