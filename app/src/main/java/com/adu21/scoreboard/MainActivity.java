package com.adu21.scoreboard;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i = 50;
    int j = 100;
    int m = 150;
    private EditText et_student;
    private TableLayout student_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_table = findViewById(R.id.table_scoreboard);
        et_student = findViewById(R.id.et_student_name);
    }

    public void onAdd(View view) {
        i++;
        j++;
        m++;
        //Trying to add more Parameters
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.MATCH_PARENT
        );

        TableRow tableRow = new TableRow(this);
        tableRow.setId(m);
        if (!et_student.getText().toString().equals("")) {
            TextView txt = new TextView(this);
            txt.setText(et_student.getText().toString());
            txt.setTextSize(18);
            txt.setLayoutParams(params);
            txt.setPadding(0, 0, 130, 0);
            txt.setGravity(Gravity.CENTER);
            txt.setId(i);

            TextView cnt = new TextView(this);
            cnt.setText("1");
            cnt.setTextSize(18);
            cnt.setLayoutParams(params);
            cnt.setPadding(0, 0, 30, 0);
            cnt.setGravity(Gravity.CENTER);
            cnt.setId(j);

            ImageButton add = new ImageButton(this);
            add.setImageResource(R.drawable.ic_counter);
            add.setLayoutParams(params);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(cnt.getText().toString());
                    count++;
                    cnt.setText(Integer.toString(count));
                }
            });

            ImageButton sub = new ImageButton(this);
            sub.setImageResource(R.drawable.ic_dec);
            sub.setLayoutParams(params);
            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(cnt.getText().toString());
                    count--;
                    cnt.setText(Integer.toString(count));
                }
            });

            tableRow.addView(txt);
            tableRow.addView(cnt);
            tableRow.addView(add);
            tableRow.addView(sub);
            student_table.addView(tableRow);
            et_student.setText("");

            Log.d("Name", "" + txt.getId());
        }
    }

    public void onSort(View view) {

        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        ArrayList<Integer> score5 = new ArrayList<Integer>();
        ArrayList<String> name5 = new ArrayList<String>();

        Log.d("Name", "" + name + " " + scores);
        //Here We have to adjust the value of i such that the null value exception will gone.

        for (int a = 51; a <= i; a++) {
            TextView textView = findViewById(a);
            TextView score = findViewById(a + 50);
            TableRow row = findViewById(a + 100);
            //name.put(textView.getText().toString(),Integer.parseInt(score.getText().toString()));
            //Log.d("Name", ""+name.keySet()+" "+name.values());
            scores.add(Integer.parseInt(score.getText().toString()));
            name.add(textView.getText().toString());
            student_table.removeView(row);
        }
        Log.d("Name", "" + name + " " + scores);

        for (int k = 0; k < 5; k++) {
            String topper = name.get(max(scores));
            int high = scores.get(max(scores));
            Log.d("Name", "" + topper + " " + high);
            name5.add(topper);
            score5.add(high);
            name.remove(topper);
            scores.remove(max(scores));
            addView(topper, Integer.toString(high));
        }
/*
        m = 150;
        i = 50;
        j = 100;
       for(int k = 0; k < (i-56); k++){
            addView(name.get(k), Integer.toString(scores.get(k)));
        }
*/
    }

    int max(ArrayList<Integer> score) {
        int maxi = 0;
        for (int k = 0; k < score.size(); k++) {
            if (score.get(k) > maxi) {
                maxi = score.get(k);
            }
        }
        return score.indexOf(maxi);
    }

    void addView(String str, String countm) {
        i++;
        j++;
        m++;

        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.MATCH_PARENT
        );

        TableRow tableRow = new TableRow(this);
        tableRow.setId(m);
        TextView txt = new TextView(this);
        txt.setText(str);
        txt.setTextSize(18);
        txt.setLayoutParams(params);
        txt.setPadding(0, 0, 130, 0);
        txt.setGravity(Gravity.CENTER);
        txt.setId(i);

        TextView cnt = new TextView(this);
        cnt.setText(countm);
        cnt.setTextSize(18);
        cnt.setLayoutParams(params);
        cnt.setPadding(0, 0, 30, 0);
        cnt.setGravity(Gravity.CENTER);
        cnt.setId(j);

        ImageButton add = new ImageButton(this);
        add.setImageResource(R.drawable.ic_counter);
        add.setLayoutParams(params);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(cnt.getText().toString());
                count++;
                cnt.setText(Integer.toString(count));
            }
        });

        ImageButton sub = new ImageButton(this);
        sub.setImageResource(R.drawable.ic_dec);
        sub.setLayoutParams(params);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(cnt.getText().toString());
                count--;
                cnt.setText(Integer.toString(count));
            }
        });

        tableRow.addView(txt);
        tableRow.addView(cnt);
        tableRow.addView(add);
        tableRow.addView(sub);
        student_table.addView(tableRow);
    }
}