package com.example.automaticlightcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {

    public ImageButton light;
    ImageButton back;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        light = findViewById(R.id.lights_menu);
        back = findViewById(R.id.back_btn);

        dialog = new Dialog(MainMenu.this);
        dialog.setContentView(R.layout.dialog_box);

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent light_menu = new Intent(MainMenu.this, LightMenu.class);
                startActivity(light_menu);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder alert = new AlertDialog.Builder(MainMenu.this);

                alert.setTitle("Logout");
                alert.setMessage("Do you Want to Logout?");


                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent login_menu = new Intent(MainMenu.this, MainActivity.class);
                        startActivity(login_menu);
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

    }
}
