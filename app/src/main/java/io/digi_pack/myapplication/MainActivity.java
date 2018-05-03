package io.digi_pack.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Title;
    Button Button,Button2;
    EditText guess_number;
    int pcNum;
    int user_guess_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Title = findViewById(R.id.title);
        Button = findViewById(R.id.guess_button);
        Button2 = findViewById(R.id.guess_button2);
        guess_number = (EditText)findViewById(R.id.guess_number);


        init();

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });
    }

    public void init(){
        //建立一個隨機數字
        pcNum=(int)(Math.random()*99+1);
        Log.d("show random number",String.valueOf(pcNum));
        //如果要改變文字要先找到文字之後在set

        Title.setText("Start Guess");
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //取得數值
                user_guess_number = Integer.parseInt(guess_number.getText().toString());

                if(user_guess_number>pcNum){
                    Title.setText("在小一點");
                }else if(user_guess_number<pcNum){
                    Title.setText("在大一點");
                }else if(user_guess_number==pcNum){
                    Title.setText("中獎囉~");
                }

                Log.d("Test",String.valueOf(user_guess_number));
            }
        });
    }

}
