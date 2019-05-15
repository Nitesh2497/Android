package com.example.dangerouspermissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etPhone;
    Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhone = findViewById(R.id.etPhone);
        btnDial = findViewById(R.id.btnDial);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
                if(permission == PackageManager.PERMISSION_GRANTED){
                    callNumber();
                }else{
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},121);
                }
            }
        });
    }

    void callNumber(){
        String number = etPhone.getText().toString();
        Uri uri = Uri.parse("tel:" + number);
        Intent intent = new Intent(Intent.ACTION_CALL,uri);
        startActivity(intent);
    }
}
