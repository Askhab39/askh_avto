package com.example.askh_avto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class gamelvls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelvls);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //кнопка выхода с выбора уровни на главную стр
        Button button_back = (Button) findViewById(R.id.btn_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //здесь команда для кнопки

                //начало конструкци
                try {
                    Intent intent = new Intent(gamelvls.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }
                //конец конструкции
            }
        });
    }
    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed (){
        //начало конструкци
        try {
            Intent intent = new Intent(gamelvls.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e) {

        }
        //конец конструкции
    }
    //Системная кнопка "Назад" - конец
}