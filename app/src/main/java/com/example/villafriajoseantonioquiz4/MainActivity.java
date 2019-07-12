package com.example.villafriajoseantonioquiz4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtPassword, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.etName);
        txtPassword = findViewById(R.id.etPassword);
        txtEmail = findViewById(R.id.etEmail);
    }

    public void goNext(View v){
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void saveInfo(View v) {
        FileOutputStream fos = null;
        //File file = new File(getExternalFilesDir(null), "user3.txt");
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "user3.txt");
        try {
            fos = new FileOutputStream(file);
            fos.write((txtName.getText().toString() + ", ").getBytes());
            fos.write((txtPassword.getText().toString() + ", ").getBytes());
            fos.write(txtEmail.getText().toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "saved data in external...", Toast.LENGTH_LONG).show();
    }
}
