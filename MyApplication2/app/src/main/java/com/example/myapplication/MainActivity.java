package com.example.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "BTN";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    Button btn2;
    EditText etWebSearch,editText2,editText3;
    ImageButton btnBrowse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btn2 = findViewById(R.id.button2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG,"2nd Button clicked");
//            }
//        });
//        etWebSearch = findViewById(R.id.etWebSearch);
//        btnBrowse=findViewById(R.id.btnBrowse);
//        btnBrowse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = etWebSearch.getText().toString();
//                Uri uri = Uri.parse(url);
//                Intent i = new Intent(Intent.ACTION_VIEW,uri);
//                try {
//                    startActivity(i);
//                }catch (ActivityNotFoundException anfe){
//                    Log.e(TAG,"could not open specific url",anfe);
//                    Toast.makeText(MainActivity.this,"Could not find any app to open this",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }


    public void onButtonClicked(View v){
        Log.d(TAG,"Button Clicked");
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        editText2 = findViewById(R.id.editText2);
        String message= editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

}
