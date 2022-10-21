package com.example.mywork_1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button btn_getInfo;
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity2","onStart调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity2","onResume调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity2","onPause调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity2","onStop调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity2","onDestroy调用");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity2","onRestart调用");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Log.d("MainActivity2","onCreate调用");
        
        TextView activity_main2_header = findViewById(R.id.activity_main2_header);
        Intent intent1 = getIntent();
        activity_main2_header.setText(intent1.getStringExtra("name"));
        btn_getInfo = findViewById(R.id.btn_getInfo);
        btn_getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity2.this,ResultActivity.class);
                test.launch(intent2);
            }
        });
    }
    public ActivityResultLauncher test = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == 8080){
                        TextView textView_Info = findViewById(R.id.textView_Info);
                        textView_Info.setText(result.getData().getStringExtra("data"));
                    }
                }
            });
}