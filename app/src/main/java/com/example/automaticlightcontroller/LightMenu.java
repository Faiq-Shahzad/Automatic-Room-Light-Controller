package com.example.automaticlightcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class LightMenu extends AppCompatActivity {

    Switch aSwitch;
    EditText Start;
    EditText End;
    ImageView low_bright;
    ImageView high_bright;
    SeekBar bright;
    Button scan;
    Button light_1;
    Button light_2;
    Button connected_1;
    Button connected_2;
    Dialog dialog;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_menu);

        aSwitch = findViewById(R.id.switch2);
        Start = findViewById(R.id.start_time);
        End = findViewById(R.id.end_time);
        bright = findViewById(R.id.seekBar);
        scan = findViewById(R.id.scan_btn);
        light_1 = findViewById(R.id.light01_btn);
        light_2 = findViewById(R.id.light02_btn);
        connected_1 = findViewById(R.id.lignt_con01);
        connected_2 = findViewById(R.id.light_con02);
        low_bright = findViewById(R.id.low_b);
        high_bright = findViewById(R.id.high_b);
        back = findViewById(R.id.back_btn);


        Start.setInputType(InputType.TYPE_NULL);
        End.setInputType(InputType.TYPE_NULL);

        dialog = new Dialog(LightMenu.this);
        dialog.setContentView(R.layout.dialog_box);



        bright.setEnabled(false);
        Start.setEnabled(false);
        End.setEnabled(false);
        low_bright.setEnabled(false);
        high_bright.setEnabled(false);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (aSwitch.isChecked()) {
                    bright.setEnabled(true);
                    Start.setEnabled(true);
                    End.setEnabled(true);
                    low_bright.setEnabled(true);
                    high_bright.setEnabled(true);

                } else {
                    bright.setEnabled(false);
                    Start.setEnabled(false);
                    End.setEnabled(false);
                    low_bright.setEnabled(false);
                    high_bright.setEnabled(false);
                }
            }
        });

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(Start);

            }
        });

        End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(End);
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (connected_1.getVisibility() == v.VISIBLE && connected_2.getVisibility() == v.VISIBLE){
                    Toast.makeText(LightMenu.this, "No Lights Available", Toast.LENGTH_SHORT).show();
                }
                else if (connected_1.getVisibility() == v.VISIBLE && connected_2.getVisibility() == v.INVISIBLE){
                    light_2.setVisibility(v.VISIBLE);
                }
                else if (connected_1.getVisibility() == v.INVISIBLE && connected_2.getVisibility() == v.VISIBLE){
                    light_1.setVisibility(v.VISIBLE);
                }
                else{
                    light_1.setVisibility(v.VISIBLE);
                    light_2.setVisibility(v.VISIBLE);
                }
            }
        });

        light_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                final AlertDialog.Builder alert = new AlertDialog.Builder(LightMenu.this);

                alert.setTitle("Confirm...!");
                alert.setMessage("Confirm Establish Connection with Contoller?");


                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        light_1.setVisibility(v.INVISIBLE);
                        connected_1.setVisibility(v.VISIBLE);
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();

            }
        });

        light_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                final AlertDialog.Builder alert = new AlertDialog.Builder(LightMenu.this);

                alert.setTitle("Confirm...!");
                alert.setMessage("Confirm Establish Connection with Contoller?");


                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        light_2.setVisibility(v.INVISIBLE);
                        connected_2.setVisibility(v.VISIBLE);
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();

            }
        });

        connected_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                final AlertDialog.Builder alert = new AlertDialog.Builder(LightMenu.this);

                alert.setTitle("Remove Light");
                alert.setMessage("Confirm Remove Light?");


                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        connected_1.setVisibility(v.INVISIBLE);
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();

            }
        });

        connected_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                final AlertDialog.Builder alert = new AlertDialog.Builder(LightMenu.this);

                alert.setTitle("Remove Light");
                alert.setMessage("Confirm Remove Light?");


                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        connected_2.setVisibility(v.INVISIBLE);
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_menu = new Intent(LightMenu.this, MainMenu.class);
                startActivity(main_menu);
            }
        });
    }

    public void showTimeDialog ( final EditText time){

        final Calendar calendar = Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                time.setText(hourOfDay + ":" + minute);
            }
        };

        new TimePickerDialog(LightMenu.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
    }
}
