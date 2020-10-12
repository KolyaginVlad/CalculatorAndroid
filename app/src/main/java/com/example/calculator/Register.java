package com.example.calculator;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ConstraintLayout layout = findViewById(R.id.lay2);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Button reg = new Button(this);
        Button log = new Button(this);
        final EditText login1 = new EditText(this);
        final EditText login2 = new EditText(this);
        final EditText pass1 = new EditText(this);
        final EditText pass2 = new EditText(this);
        reg.setText("Register");
        log.setText("Log in");
        double kx = 0.3;
        double ky = 0.1;
        layout.addView(login1, (int) (size.x * kx), (int) (size.y * ky));
        layout.addView(login2, (int) (size.x * kx), (int) (size.y * ky));
        layout.addView(pass1, (int) (size.x * kx), (int) (size.y * ky));
        layout.addView(pass2, (int) (size.x * kx), (int) (size.y * ky));
        layout.addView(reg, (int) (size.x * kx), (int) (size.y * ky));
        layout.addView(log, (int) (size.x * kx / 2), (int) (size.y * ky));
        login1.setX((float) (size.x * (1 - 2 * kx) / 4));
        pass1.setX((float) (size.x * (1 - 2 * kx) / 4));
        reg.setX((float) (size.x * (1 - 2 * kx) / 4) + login1.getWidth() / 2);
        login1.setY((float) (size.y * 0.40));
        pass1.setY((float) (size.y * 0.40 + size.y * ky));
        reg.setY((float) (size.y * 0.40 + 2 * size.y * ky));

        login2.setX((float) (size.x - size.x * (1 - 2 * kx)));
        pass2.setX((float) (size.x - size.x * (1 - 2 * kx)));
        log.setX((float) (size.x - size.x * (1 - 2 * kx)) + login2.getWidth());
        login2.setY((float) (size.y * 0.40));
        pass2.setY((float) (size.y * 0.40 + size.y * ky));
        log.setY((float) (size.y * 0.40 + 2 * size.y * ky));

        login1.setHint("Login for register");
        pass1.setHint("Password for register");
        login2.setHint("Login");
        pass2.setHint("Password");

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String login = login2.getText().toString();
                final String password = pass2.getText().toString();
                final String[] line = {""};
                if (!login.equals("") && !password.equals("")) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            URL url;
                            HttpsURLConnection connection = null;

                            try {
                                url = new URL("https://l12.scripthub.ru/api.php?module=auth&login=" + login + "&password=" + password);
                                connection = (HttpsURLConnection) url.openConnection();
                                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                                line[0] = br.readLine();

                                //Log.d("HTTP-GET", line);


                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                if (connection != null) {
                                    connection.disconnect();

                                }
                            }
                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (line[0].equals("true")) {
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        intent.putExtra("login", login);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Пользователь не найден!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String login = login1.getText().toString();
                final String password = pass1.getText().toString();
                final String[] line = {""};
                if (!login.equals("") && !password.equals("")) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            URL url;
                            HttpsURLConnection connection = null;

                            try {
                                url = new URL("https://l12.scripthub.ru/api.php?module=reg&login=" + login + "&password=" + password);
                                connection = (HttpsURLConnection) url.openConnection();
                                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                                line[0] = br.readLine();

                                //Log.d("HTTP-GET", line);


                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                if (connection != null) {
                                    connection.disconnect();

                                }
                            }
                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (line[0].equals("true")) {
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        intent.putExtra("login", login);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Ошибка!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);

        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},
                    1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted

                } else {
                    // permission denied
                }
                return;
        }
    }
}