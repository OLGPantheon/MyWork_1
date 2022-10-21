package com.example.mywork_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity<RecyclerAdapter> extends AppCompatActivity implements View.OnClickListener{
    private Fragment fragment1,fragment2,fragment3,fragment4;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy调用");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart调用");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate调用");

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();

        initial();

        hide();
    }

    private void initial() {
        fragmentManager.beginTransaction();
        fragmentTransaction = fragmentManager.beginTransaction()
                .add(R.id.frameLayout,fragment1)
                .add(R.id.frameLayout,fragment2)
                .add(R.id.frameLayout,fragment3)
                .add(R.id.frameLayout,fragment4);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        int i = 0;
        switch (view.getId()){
            case R.id.linearLayout1:select(1);break;
            case R.id.linearLayout2:select(2);break;
            case R.id.linearLayout3:select(3);break;
            case R.id.linearLayout4:select(4);break;
        }
    }

    public void select(int i){
        hide();
        switch (i){
            case 1:showFragment(fragment1);break;
            case 2:showFragment(fragment2);break;
            case 3:showFragment(fragment3);break;
            case 4:showFragment(fragment4);break;
        }
    }

    private void showFragment(Fragment fragment){
        fragmentTransaction.show(fragment);
    }

    private void hide() {
        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        fragmentTransaction.commit();
    }

}