package com.example.automaticlightcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText User_name;
    private EditText Pass;
    public Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    User_name = (EditText)findViewById(R.id.Username);
    Pass = (EditText)findViewById(R.id.Password);
    login = (Button)findViewById(R.id.Login);

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String user = User_name.getText().toString();
            String pass = Pass.getText().toString();

            if (user.equals("Admin") && (pass.equals("admin")) ){
                Intent main_menu = new Intent(MainActivity.this, MainMenu.class);
                startActivity(main_menu);
            }
            else{
                Toast.makeText(MainActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }
        }
    });

    }
}
