package com.theolds.ismath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class taskthree extends Activity {

    //private Timer timer;
    private Button generateBtn, calcBtn;
    private TextView outputView;
    private EditText countView;
    private View.OnClickListener btnListener;
    private int[] operands1, operands2;
    private String[] operands1s;
    private int[] dataMap = {0, 1, 141, 246, 203, 82, 123, 209, 232, 79, 41, 192, 176, 225,
            229, 199, 116, 180, 170, 75, 153, 43, 96, 95, 88, 63, 253, 204, 255, 64, 238,
            178, 58, 110, 90, 241, 85, 77, 168, 201, 193, 10, 152, 21, 48, 68, 162, 194,
            44, 69, 146, 108, 243, 57, 102, 66, 242, 53, 32, 111, 119, 187, 89, 25, 29,
            254, 55, 103, 45, 49, 245, 105, 167, 100, 171, 19, 84, 37, 233, 9, 237, 92,
            5, 202, 76, 36, 135, 191, 24, 62, 34, 240, 81, 236, 97, 23, 22, 94, 175, 211,
            73, 166, 54, 67, 244, 71, 145, 223, 51, 147, 33, 59, 121, 183, 151, 133, 16,
            181, 186, 60, 182, 112, 208, 6, 161, 250, 129, 130, 131, 126, 127, 128, 150,
            115, 190, 86, 155, 158, 149, 217, 247, 2, 185, 164, 222, 106, 50, 109, 216,
            138, 132, 114, 42, 20, 159, 136, 249, 220, 137, 154, 251, 124, 46, 195, 143,
            184, 101, 72, 38, 200, 18, 74, 206, 231, 210, 98, 12, 224, 31, 239, 17, 117,
            120, 113, 165, 142, 118, 61, 189, 188, 134, 87, 11, 40, 47, 163, 218, 212, 228,
            15, 169, 39, 83, 4, 27, 252, 172, 230, 122, 7, 174, 99, 197, 219, 226, 234, 148,
            139, 196, 213, 157, 248, 144, 107, 177, 13, 214, 235, 198, 14, 207, 173, 8, 78,
            215, 227, 93, 80, 30, 179, 91, 35, 56, 52, 104, 70, 3, 140, 221, 156, 125, 160,
            205, 26, 65, 28};
    private int[] map1 = {1, 3, 5, 15, 17, 51, 85, 255, 26, 46, 114, 150, 161, 248, 19, 53, 95, 225, 56, 72, 216, 115, 149, 164, 247, 2, 6, 10, 30, 34,
            102,170, 229, 52, 92, 228, 55, 89, 235, 38, 106, 190, 217, 112, 144, 171, 230, 49, 83, 245, 4, 12, 20, 60, 68, 204, 79, 209,
            104, 184,211, 110, 178, 205, 76, 212, 103, 169, 224, 59, 77, 215, 98, 166, 241, 8, 24, 40, 120, 136, 131, 158, 185, 208, 107,
            189, 220, 127,129, 152, 179, 206, 73, 219, 118, 154, 181, 196, 87, 249, 16, 48, 80, 240, 11, 29, 39, 105, 187, 214, 97, 163,
            254, 25, 43, 125, 135, 146, 173, 236, 47, 113, 147, 174, 233, 32, 96, 160, 251, 22, 58, 78, 210, 109, 183, 194, 93, 231, 50,
            86, 250, 21, 63, 65, 195, 94, 226, 61, 71, 201, 64, 192, 91, 237, 44, 116, 156, 191, 218, 117, 159, 186, 213, 100, 172, 239,
            42, 126, 130, 157, 188, 223, 122, 142, 137, 128, 155, 182, 193, 88, 232, 35, 101, 175, 234, 37, 111, 177, 200, 67, 197, 84,
            252, 31, 33, 99, 165, 244, 7, 9, 27, 45, 119, 153, 176, 203, 70, 202, 69, 207, 74, 222, 121, 139, 134, 145, 168, 227, 62, 66,
            198, 81, 243, 14, 18, 54, 90, 238, 41, 123, 141, 140, 143, 138, 133, 148, 167, 242, 13, 23, 57, 75, 221, 124, 132, 151, 162,
            253, 28, 36, 108, 180, 199, 82, 246};
    private int[] map2 = {0, 25, 1, 50, 2, 26, 198, 75, 199, 27, 104, 51, 238, 223, 3, 100, 4, 224, 14, 52, 141, 129, 239, 76, 113, 8, 200, 248, 105,
            28, 193, 125, 194, 29, 181, 249, 185, 39, 106, 77, 228, 166, 114, 154, 201, 9, 120, 101, 47, 138, 5, 33, 15, 225, 36, 18,
            240, 130, 69, 53, 147, 218, 142, 150, 143, 219, 189, 54, 208, 206, 148, 19, 92, 210, 241, 64, 70, 131, 56, 102, 221, 253,
            48, 191, 6, 139, 98, 179, 37, 226, 152, 34, 136, 145, 16, 126, 110, 72, 195, 163, 182, 30, 66, 58, 107, 40, 84, 250, 133,
            61, 186, 43, 121, 10, 21, 155, 159, 94, 202, 78, 212, 172, 229, 243, 115, 167, 87, 175, 88, 168, 80, 244, 234, 214, 116,
            79, 174, 233, 213, 231, 230, 173, 232, 44, 215, 117, 122, 235, 22, 11, 245, 89, 203, 95, 176, 156, 169, 81, 160, 127, 12,
            246, 111, 23, 196, 73, 236, 216, 67, 31, 45, 164, 118, 123, 183, 204, 187, 62, 90, 251, 96, 177, 134, 59, 82, 161, 108,
            170, 85, 41, 157, 151, 178, 135, 144, 97, 190, 220, 252, 188, 149, 207, 205, 55, 63, 91, 209, 83, 57, 132, 60, 65, 162,
            109, 71, 20, 42, 158, 93, 86, 242, 211, 171, 68, 17, 146, 217, 35, 32, 46, 137, 180, 124, 184, 38, 119, 153, 227, 165, 103,
            74, 237, 222, 197, 49, 254, 24, 13, 99, 140, 128, 192, 247, 112, 7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskthree);
        InitView();
    }

    void InitView(){
        generateBtn = (Button) findViewById(R.id.btn_gen);
        calcBtn = (Button) findViewById(R.id.btn_calc);
        outputView = (TextView) findViewById(R.id.text_output);
        countView = (EditText) findViewById(R.id.edit_count);

        //timer = new Timer();

        btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == generateBtn){
                    int count = 100000;
                    if(countView.getText().toString().length()>0) count = Integer.valueOf(countView.getText().toString());
                    operands1s = new String[count];
                    operands1 = new int[count];
                    operands2 = new int[count];
                    Random random = new Random();
                    for(int i = 0; i<count; i++){
                        operands1s[i] = String.valueOf(random.nextInt(256));
                        operands1[i] = random.nextInt(256);
                        operands2[i] = random.nextInt(256);
                    }
                }
                if(view == calcBtn){


                    outputView.setText(Calc());
                }
            }
        };

        generateBtn.setOnClickListener(btnListener);
        calcBtn.setOnClickListener(btnListener);
    }

    int CalcMul(String input1, int input2){
        int buf, output = 0;
        for(int i = 0; i < input1.length(); i++){
            if(input1.charAt(i) == '1'){
                buf = input2;
                for(int j = 0; j < input1.length()-1-i ; j++){
                    buf = buf<<1;
                    if(buf > 255){
                        buf = buf % 256;
                        buf = buf ^ 27;
                    }
                }
                output = output ^ buf;
            }
        }
        return output;
    }

    int CalcMul2(int input1, int input2){
        if((input1 == 0) || (input2 == 0)) return 0;
        else return map1[(map2[input1-1]+map2[input2-1]) % 255];
    }

    String Calc(){
        int count = 100000;
        String output;
        if(countView.getText().toString().length()>0) count = Integer.valueOf(countView.getText().toString());

        long endTime1, endTime2, endTime3, endTime4, endTime5, endTime6;

        ExecutorService pool = Executors.newFixedThreadPool(4);
        ExecutorService pool1 = Executors.newFixedThreadPool(4);
        ExecutorService pool2 = Executors.newFixedThreadPool(4);
        final int finalCount = count;
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0; i< finalCount /4; i++){
                    CalcMul(operands1s[i], operands2[i]);
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount /4; i< finalCount *2/4; i++){
                    CalcMul(operands1s[i], operands2[i]);
                }
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount *2/4; i< finalCount *3/4; i++){
                    CalcMul(operands1s[i], operands2[i]);
                }
            }
        };
        Thread t4 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount *3/4; i< finalCount ; i++){
                    CalcMul(operands1s[i], operands2[i]);
                }
            }
        };
        Thread t5 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0; i< finalCount /4; i++){
                    CalcMul2(operands1[i], operands2[i]);
                }
            }
        };
        Thread t6 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount /4; i< finalCount *2/4; i++){
                    CalcMul2(operands1[i], operands2[i]);
                }
            }
        };
        Thread t7 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount *2/4; i< finalCount *3/4; i++){
                    CalcMul2(operands1[i], operands2[i]);
                }
            }
        };
        Thread t8 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount *3/4; i< finalCount ; i++){
                    CalcMul2(operands1[i], operands2[i]);
                }
            }
        };
        Thread t9 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0; i< finalCount /4; i++){
                    CalcReverse(operands2[i]);
                }
            }
        };
        Thread t10 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount /4; i< finalCount *2/4; i++){
                    CalcReverse(operands2[i]);
                }
            }
        };
        Thread t11 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount *2/4; i< finalCount *3/4; i++){
                    CalcReverse(operands2[i]);
                }
            }
        };
        Thread t12 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = finalCount *3/4; i< finalCount ; i++){
                    CalcReverse(operands2[i]);
                }
            }
        };
        long startTime = System.currentTimeMillis();



        for(int i = 0; i<count; i++){
            CalcMul(operands1s[i], operands2[i]);
        }
        endTime1 = System.currentTimeMillis();

        for(int i = 0; i<count; i++){
            CalcMul2(operands1[i], operands2[i]);
        }
        endTime2 = System.currentTimeMillis();

        for(int i = 0; i<count; i++){
            CalcReverse(operands2[i]);
        }
        endTime3 = System.currentTimeMillis();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.shutdown();
        while(true){
            if(pool.isTerminated()) break;
        }
        endTime4 = System.currentTimeMillis();
        pool1.execute(t5);
        pool1.execute(t6);
        pool1.execute(t7);
        pool1.execute(t8);
        pool1.shutdown();
        while(true){
            if(pool1.isTerminated()) break;
        }
        endTime5 = System.currentTimeMillis();
        pool2.execute(t9);
        pool2.execute(t10);
        pool2.execute(t11);
        pool2.execute(t12);
        pool2.shutdown();
        while(true){
            if(pool2.isTerminated()) break;
        }
        endTime6 = System.currentTimeMillis();
        output = "multiply: " + String.valueOf(endTime1-startTime) +"ms\nquery: "
                + String.valueOf(endTime2-endTime1) +"ms\nreverse : "
                + String.valueOf(endTime3-endTime2) +"ms\n4 Threads multiply : "
                + String.valueOf(endTime4-endTime3) +"ms\n4 Threads query : "
                + String.valueOf(endTime5-endTime4) +"ms\n4 Threads reverse : "
                + String.valueOf(endTime6-endTime5) +"ms";

        return output;
    }

    int CalcReverse(int input){
        return dataMap[input];
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_taskthree, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_taskone) {
            Intent intent = new Intent();
            intent.setClass(taskthree.this,taskone.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_tasktwo) {
            Intent intent = new Intent();
            intent.setClass(taskthree.this,tasktwo.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_taskfour) {
            Intent intent = new Intent();
            intent.setClass(taskthree.this,taskfour.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
