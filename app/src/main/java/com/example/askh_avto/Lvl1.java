package com.example.askh_avto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    public int count = 0; //Счетчик правильных ответов


    @SuppressLint("ClickableViewAccessibility")
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

        //Массив для прогресса игры - начало
        final int[] progress =
                {
                        R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                };
        //Массив для прогресса игры - конец

        //подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Lvl1.this, R.anim.alpha);
        //подключаем анимацию - конец

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

        //Обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    //Если коснулся картинки - начало
                    img_right.setEnabled(false); //Блокируем правую картинку
                    if (numLeft>numRight)
                    {
                        img_left.setImageResource(R.drawable.img_true);
                    }
                    else
                    {
                        img_left.setImageResource(R.drawable.img_false);
                    }//Если коснулся картинки - конец
                }
                else if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    //Если отпустил палец - начало
                    if (numLeft>numRight)
                    {//Если левая картинка больше
                        if (count<10)
                        {
                            count = count + 1;
                        }

                        //Закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<10; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                    }
                        //Закрашиваем прогресс серым цветом - конец

                    //Определяем правильные ответы и закрашиваем зеленым - начало
                    for (int i=0; i<count; i++)
                    {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                    //Определяем правильные ответы и закрашиваем зеленым - конец
                    }else{
                    //Если отпустил палец - конец
                }
                //Условие касания картинки -конец
                return true;
            }
        });
        //Обрабатываем нажатие на левую картинку - конец


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
