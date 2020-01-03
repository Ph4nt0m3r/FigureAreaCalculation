package ru.phantomer.figuresquare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;

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

/*
Программа поддерживает ввод данных типа:
type=triangle;one=3;two=4;three=5;
type=triangle;angle1=3;angle2=4;angle3=5;
type=circle;radius=5;
type=square;side=5
*/

    public void start(View view) {
        String allString = input.getText().toString();

        if (allString.isEmpty())
            return;

        String type = allString
                .split(";")[0]
                .replace("type=", "");

        if (type.equals("square")) {

            double side = Double.parseDouble(allString
                    .split("=")[2]
                    .replace(";", "")
            );

            output.setText(type + "'s acreage= " + Math.pow(side, 2));
        } else if (type.equals("circle")) {
            double radius = Double.parseDouble(allString
                    .split("=")[2]
                    .replace(";", "")
            );

            output.setText(type + "'s acreage=" + Math.pow(radius, 2) * Math.PI);
        } else if (type.equals("triangle")) {

            // WITH 3 SIDES
            if (allString.contains("one") & allString.contains("two") & allString.contains("three")) {
                double one = Double.parseDouble(allString
                        .split(";")[1]
                        .replace("one=", ""));
                double two = Double.parseDouble(allString
                        .split(";")[2]
                        .replace("two=", ""));
                double three = Double.parseDouble(allString
                        .split(";")[3]
                        .replace("three=", ""));
                double p = (one + two + three) / 2;
                output.setText(type + "'s acreage= " + Math.sqrt(p * (p - one) * (p - two) * (p - three)));
            }

            //WITH 2 SIDES AND 1 ANGLE
            else if (allString.contains("angle1") & allString.contains("two") & allString.contains("three")) {
                double angle1 = Double.parseDouble(allString
                        .split(";")[1]
                        .replace("angle1=", ""));
                double two = Double.parseDouble(allString
                        .split(";")[2]
                        .replace("two=", ""));
                double three = Double.parseDouble(allString
                        .split(";")[3]
                        .replace("three=", ""));
                output.setText(type + "'s acreage= " + Math.sin(Math.toRadians(angle1)) * two * three / 2);
            } else if (allString.contains("one") & allString.contains("angle2") & allString.contains("three")) {
                double one = Double.parseDouble(allString
                        .split(";")[1]
                        .replace("one=", ""));
                double angle2 = Double.parseDouble(allString
                        .split(";")[2]
                        .replace("angle2=", ""));
                double three = Double.parseDouble(allString
                        .split(";")[3]
                        .replace("three=", ""));
                output.setText(type + "'s acreage= " + Math.sin(Math.toRadians(angle2)) * one * three / 2);
            } else if (allString.contains("one") & allString.contains("two") & allString.contains("angle3")) {
                double one = Double.parseDouble(allString
                        .split(";")[1]
                        .replace("one=", ""));
                double two = Double.parseDouble(allString
                        .split(";")[2]
                        .replace("two=", ""));
                double angle3 = Double.parseDouble(allString
                        .split(";")[3]
                        .replace("angle3=", ""));
                output.setText(type + "'s acreage= " + Math.sin(Math.toRadians(angle3)) * one * two / 2);
            }

            //WITH 2 ANGLES AND 1 SIDE
            else if (allString.contains("angle1") & allString.contains("angle2") & allString.contains("three")) {

                    double angle1 = Double.parseDouble(allString
                            .split(";")[1]
                            .replace("angle1=", ""));
                    double angle2 = Double.parseDouble(allString
                            .split(";")[2]
                            .replace("angle2=", ""));
                    double three = Double.parseDouble(allString
                            .split(";")[3]
                            .replace("three=", ""));
                    output.setText(type + "'s acreage= " +
                            (Math.pow(three, 2) * 0.5 * Math.sin(Math.toRadians(angle1)) * Math.sin(Math.toRadians(angle2)) / Math.sin(Math.toRadians(180 - angle1 - angle2))));
                }
                } else if (allString.contains("one") & allString.contains("angle2") & allString.contains("angle3")) {
                    double one = Double.parseDouble(allString
                            .split(";")[1]
                            .replace("one=", ""));
                    double angle2 = Double.parseDouble(allString
                            .split(";")[2]
                            .replace("angle2=", ""));
                    double angle3 = Double.parseDouble(allString
                            .split(";")[3]
                            .replace("angle3=", ""));
                    output.setText(type + "'s acreage= " +
                            (Math.pow(one, 2) * 0.5 * Math.sin(Math.toRadians(angle2)) * Math.sin(Math.toRadians(angle3)) / Math.sin(Math.toRadians(180 - angle2 - angle3))));
                } else if (allString.contains("angle1") & allString.contains("two") & allString.contains("angle3")) {

                    double angle1 = Double.parseDouble(allString
                            .split(";")[1]
                            .replace("angle1=", ""));
                    double two = Double.parseDouble(allString
                            .split(";")[2]
                            .replace("two=", ""));
                    double angle3 = Double.parseDouble(allString
                            .split(";")[3]
                            .replace("angle3=", ""));
                    output.setText(type + "'s acreage= " +
                            (Math.pow(two, 2) * 0.5 * Math.sin(Math.toRadians(angle1)) * Math.sin(Math.toRadians(angle3)) / Math.sin(Math.toRadians(180 - angle1 - angle3))));

            }
        }
    }


