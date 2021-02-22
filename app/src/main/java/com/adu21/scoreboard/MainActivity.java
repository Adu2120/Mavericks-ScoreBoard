package com.adu21.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    String tableRows;
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
        tableRows = "Tablerow" + i;
        i++;
        //Trying to add more Parameters
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.MATCH_PARENT);

        TableRow tableRow = new TableRow(this);
        if (!et_student.getText().toString().equals("")) {
            TextView txt = new TextView(this);
            txt.setText(et_student.getText().toString());
            txt.setTextSize(18);
            txt.setLayoutParams(params);
            txt.setPadding(0, 0, 150, 0);
            txt.setGravity(Gravity.CENTER);

            TextView cnt = new TextView(this);
            cnt.setText("1");
            cnt.setTextSize(18);
            cnt.setLayoutParams(params);
            cnt.setPadding(0, 0, 30, 0);
            cnt.setId(i);
            cnt.setGravity(Gravity.CENTER);

            ImageButton add = new ImageButton(this);
            add.setImageResource(R.drawable.ic_counter);
            add.setLayoutParams(params);
            add.setId(i);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(cnt.getText().toString());
                    count++;
                    cnt.setText(Integer.toString(count));
                }
            });

            tableRow.addView(txt);
            tableRow.addView(cnt);
            tableRow.addView(add);
            student_table.addView(tableRow);
            et_student.setText("");
        }
    }
}