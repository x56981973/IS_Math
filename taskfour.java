package com.theolds.ismath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class taskfour extends Activity {

    private LinearLayout inputLayout;
    private EditText input1View, input2View;
    private TextView outputView, output2View;
    private Button calcBtn, clrBtn , ergBtn, showBtn;
    private View.OnClickListener btnListener;
    private String[][] dataMap = {
            {"63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76"},
            {"CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0"},
            {"B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15"},
            {"04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75"},
            {"09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84"},
            {"53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF"},
            {"D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8"},
            {"51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2"},
            {"CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73"},
            {"60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB"},
            {"E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79"},
            {"E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08"},
            {"BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A"},
            {"70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E"},
            {"E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF"},
            {"8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16"}
    };
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
        setContentView(R.layout.activity_taskfour);
        InitView();
    }

    void InitView() {

        inputLayout = (LinearLayout) findViewById(R.id.inputLayout);
        input1View = (EditText) findViewById(R.id.edit_input1);
        input2View = (EditText) findViewById(R.id.edit_input2);
        outputView = (TextView) findViewById(R.id.edit_output);
        output2View = (TextView) findViewById(R.id.edit_output2);
        calcBtn = (Button) findViewById(R.id.btn_calc);
        clrBtn = (Button) findViewById(R.id.btn_clear);
        ergBtn = (Button) findViewById(R.id.btn_erg);
        showBtn = (Button) findViewById(R.id.btn_show);

        btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == calcBtn){
                    int i, j, count =0;
                    i = Integer.valueOf(input1View.getText().toString());
                    j = Integer.valueOf(input2View.getText().toString());
                    for(int k = 0; k<256; k++){
                        int kl = k/16;
                        if(((Integer.bitCount(kl & i) + Integer.bitCount(Integer.parseInt(dataMap[kl][k-kl*16],16) & j))%2) == 0) count++;
                        if( i ==0 && j == 0) Log.i("test", Integer.bitCount(kl & i)+ "; " + Integer.bitCount(Integer.parseInt(dataMap[kl][k-kl*16],16) & j));
                    }
                    if(count < 128) count = 256 - count;
                    outputView.setText("inputs: " + input1View.getText() +" , " + input2View.getText()  + "\ncount: "
                            + String.valueOf(count) + "\nratio: " + String.valueOf((float) count/256) );
                }else if(view == clrBtn){
                    input1View.setText("");
                    input2View.setText("");
                    outputView.setText("");
                }else if(view == ergBtn){
                    int flag = 0 ;
                    int counth = 0;
                    int ih[] = new int[10];
                    int jh[] = new int[10];
                    int boolh[] = new int[10];
                    long startTime = System.currentTimeMillis();;
                    for(int i = 1; i<256; i++){
                        for(int j = 1; j<256; j++){
                            int reversed = 1;
                            int count = 0;
                            for(int k = 0; k<256; k++){
                                int kl = k/16;
                                if(((Integer.bitCount(kl & i) + Integer.bitCount(Integer.parseInt(dataMap[kl][k-kl*16],16) & j))%2) == 0) count++;
                            }

                            if(count < 128) {
                                count = 256 - count;
                                reversed = 0;
                            }
                            if(count > counth){
                                flag = 0;
                                counth = count;
                                ih[flag] = i;
                                jh[flag] = j;
                                boolh[flag] = reversed;
                            }else if(count == counth){
                                if(flag<9) {
                                    flag ++;
                                    ih[flag] = i;
                                    jh[flag] = j;
                                    boolh[flag] = reversed;
                                }
                            }
                            //if(i == 100 &&j== 103) Log.i("100.100",Integer.bitCount(x & i) + " " + Integer.bitCount(y & j));
                        }
                    }
                    String outputs = "the output is:";
                    for(int i = 0; i<ih.length; i++){
                        outputs = outputs + "\n" + ShowEqt( ih[i], jh[i]) + " = " + boolh[i];

                    }
                    output2View.setText("max ratio is: " + (float) counth/256 + "\n "+ outputs + "\ntime elapse: "+(System.currentTimeMillis() - startTime) + "ms");
                }else if(view == showBtn){
                    if(inputLayout.getVisibility() == View.VISIBLE) inputLayout.setVisibility(View.GONE);
                    else inputLayout.setVisibility(View.VISIBLE);
                }
            }
        };
        calcBtn.setOnClickListener(btnListener);
        clrBtn.setOnClickListener(btnListener);
        ergBtn.setOnClickListener(btnListener);
        showBtn.setOnClickListener(btnListener);
        inputLayout.setVisibility(View.GONE);
    }

    int CalcEqt(int input){
        int count = 0;
        int il = input/16;

        return count;
    }

    String ShowEqt(int input1, int input2){
        String output, inputs1, inputs2, zeros;
        inputs1 = Integer.toBinaryString(input1);
        inputs2 = Integer.toBinaryString(input2);
        output = " ";
        zeros = "00000000";
        inputs1 = zeros.substring(inputs1.length()) + inputs1;
        inputs2 = zeros.substring(inputs2.length()) + inputs2;
        for(int i = 0; i < 8; i++){
            if( inputs1.charAt(i) == '1') output = output + "a" + (7 - i) + "+  ";
        }
        for(int i = 0; i < 8; i++){
            if( inputs2.charAt(i) == '1') output = output + "b" + (7 - i) + "+  ";
        }
        output = output.substring(0, output.length()-3);
        return output;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_taskfour, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_tasktwo) {
            Intent intent = new Intent();
            intent.setClass(taskfour.this,tasktwo.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_taskthree) {
            Intent intent = new Intent();
            intent.setClass(taskfour.this,taskthree.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_taskone) {
            Intent intent = new Intent();
            intent.setClass(taskfour.this,taskone.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
