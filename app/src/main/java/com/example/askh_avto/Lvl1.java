package com.example.askh_avto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Level;

public class Lvl1 extends AppCompatActivity {

    public int numLeft; //Переменная для левой картинки + текст
    public int numRight; //Переменная для правой картинки + текст
    Array array = new Array(); //Создали новый объект из класса Array
    Random random = new Random(); //Для генерации случайных чисел


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        // Sozdaem peremennuyu text_levels
        TextView text_levels = findViewById(R.id.text_lvls);
        text_levels.setText(R.string.level1); //установили текст

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        //код скругляет углы левой картинки
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        //код скругляет углы правой картинки
        img_right.setClipToOutline(true);

        //Путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        //Путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);

        //Развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Развернуть игру на весь экран - конец

        //кнопка НАЗАД - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки НАЗАД - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Lvl1.this, gamelvls.class);
                    startActivity(intent);
                    finish();
                    //Вернуться назад к выбору уровня - конец
                }catch (Exception e){
                    //здесь кода не будет
                }
                //Обрабатываем нажатие кнопки НАЗАД - конец
            }
        });
        //кнопка НАЗАД - конец

        numLeft = random.nextInt(10); //Генерируем случайное число от 0 до 9
        img_left.setImageResource(array.images1[numLeft]); //Достаем из массива картинку
        text_left.setText(array.texts1[numLeft]); //Достаем из массива текст

        numRight = random.nextInt(10); //Генерируем случайное число от 0 до 9

        //Цикл с предусловием, проверяющий равенство чисел - начало
        while (numLeft==numRight)
        {
            numRight = random.nextInt(10);
        }
        //Цикл с предусловием, проверяющий равенство чисел - конец

        img_right.setImageResource(array.images1[numRight]); //Достаем из массива картинку
        text_right.setText(array.texts1[numRight]); //Достаем из массива текст


    }

    // системная кнопка НАЗАД - начало
    @Override
    public void onBackPressed()
    {
        //Обрабатываем нажатие кнопки НАЗАД - начало
        try {
            //Вернуться назад к выбору уровня - начало
            Intent intent = new Intent(Lvl1.this, gamelvls.class);
            startActivity(intent);
            finish();
            //Вернуться назад к выбору уровня - конец
        }catch (Exception e){
            //здесь кода не будет
        }
        //Обрабатываем нажатие кнопки НАЗАД - конец
    }
    //системная кнопка НАЗАД - конец

}
