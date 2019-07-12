package com.example.villafriajoseantonioquiz4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {

    EditText txtName, txtPassword, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txtName = findViewById(R.id.etName);
        txtPassword = findViewById(R.id.tvPassword);
        txtEmail = findViewById(R.id.etEmail);

        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int letter = 0;
        try {
            File file = new File(getExternalFilesDir(null), "user2.txt");
            fis = new FileInputStream(file);
            while((letter = fis.read()) != -1) {
                buffer.append((char)letter);
            }
            Toast.makeText(this, buffer.toString(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        txtName.setText(buffer.substring(0, buffer.indexOf(",")));
        txtPassword.setText(buffer.substring(buffer.indexOf(",")+1));
    }


    public void goPrevious(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void displayUser(View v) {
        Intent i = new Intent(this, Activity3.class);
        startActivity(i);
    }


}
