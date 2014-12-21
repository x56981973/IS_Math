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


public class tasktwo extends Activity {

    private EditText inputView;
    private TextView outputView;
    private Button calcBtn;
    private Button clearBtn;
    private View.OnClickListener btnListener;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasktwo);
        InitView();
    }

    void InitView(){
        inputView = (EditText) findViewById(R.id.edit_input);
        outputView = (TextView) findViewById(R.id.edit_output);
        calcBtn = (Button) findViewById(R.id.btn_calc);
        clearBtn = (Button) findViewById(R.id.btn_clear);

        btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == calcBtn){
                    int input;
                    input = Integer.valueOf(inputView.getText().toString());
                    outputView.setText(Integer.toString(dataMap[input]));
                }else if(view == clearBtn){
                    inputView.setText("");
                    outputView.setText("");
                }

            }
        };
        calcBtn.setOnClickListener(btnListener);
        clearBtn.setOnClickListener(btnListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tasktwo, menu);
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
            intent.setClass(tasktwo.this,taskone.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_taskthree) {
            Intent intent = new Intent();
            intent.setClass(tasktwo.this,taskthree.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_taskfour) {
            Intent intent = new Intent();
            intent.setClass(tasktwo.this,taskfour.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
