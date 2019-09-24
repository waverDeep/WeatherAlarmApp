package com.example.weatheralarmapp.main_fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weatheralarmapp.R;
import com.example.weatheralarmapp.db_connect.MemoDBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MemoFragment extends Fragment {

    TextView tvDay_1;
    TextView tvDay_2;
    TextView tvDay_3;
    TextView tvDay_4;
    TextView tvDay_5;
    TextView tvDay_6;
    TextView tvDay_7;

    EditText edtDay_1;
    EditText edtDay_2;
    EditText edtDay_3;
    EditText edtDay_4;
    EditText edtDay_5;
    EditText edtDay_6;
    EditText edtDay_7;

    Button btnSave;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_memo, container, false);

        tvDay_1 = (TextView) view.findViewById(R.id.tvDay_1);
        tvDay_2 = (TextView) view.findViewById(R.id.tvDay_2);
        tvDay_3 = (TextView) view.findViewById(R.id.tvDay_3);
        tvDay_4 = (TextView) view.findViewById(R.id.tvDay_4);
        tvDay_5 = (TextView) view.findViewById(R.id.tvDay_5);
        tvDay_6 = (TextView) view.findViewById(R.id.tvDay_6);
        tvDay_7 = (TextView) view.findViewById(R.id.tvDay_7);

        edtDay_1 = (EditText) view.findViewById(R.id.edtDay_1);
        edtDay_2 = (EditText) view.findViewById(R.id.edtDay_2);
        edtDay_3 = (EditText) view.findViewById(R.id.edtDay_3);
        edtDay_4 = (EditText) view.findViewById(R.id.edtDay_4);
        edtDay_5 = (EditText) view.findViewById(R.id.edtDay_5);
        edtDay_6 = (EditText) view.findViewById(R.id.edtDay_6);
        edtDay_7 = (EditText) view.findViewById(R.id.edtDay_7);

        btnSave = (Button) view.findViewById(R.id.btnSave);

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat weekdayFormat = new SimpleDateFormat("EE", Locale.getDefault());

        String weekDay = weekdayFormat.format(currentTime);
        DayForm(weekDay);

        ReadMemo();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMemo();
            }
        });

        return view;
    }

    public void AddMemo() {
        MemoDBHelper dbHelper = new MemoDBHelper(getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        dbHelper.AllDelete(database);

        for (int i=1; i<8 ; i++) {
            String id = String.valueOf(i);
            switch (i) {
                case 1:
                    dbHelper.addContact(id, tvDay_1.getText().toString() ,edtDay_1.getText().toString(), database);
                    break;

                case 2:
                    dbHelper.addContact(id, tvDay_2.getText().toString(), edtDay_2.getText().toString(), database);
                    break;

                case 3:
                    dbHelper.addContact(id, tvDay_3.getText().toString(), edtDay_3.getText().toString(), database);
                    break;

                case 4:
                    dbHelper.addContact(id, tvDay_4.getText().toString(), edtDay_4.getText().toString(), database);
                    break;

                case 5:
                    dbHelper.addContact(id, tvDay_5.getText().toString(), edtDay_5.getText().toString(), database);
                    break;

                case 6:
                    dbHelper.addContact(id, tvDay_6.getText().toString(), edtDay_6.getText().toString(), database);
                    break;

                case 7:
                    dbHelper.addContact(id, tvDay_7.getText().toString(), edtDay_7.getText().toString(), database);
                    break;
            }
        }

        dbHelper.close();
    }

    public void ReadMemo() {
        MemoDBHelper dbHelper = new MemoDBHelper(getContext());
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = dbHelper.readContact(database);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String Memo_Contents = cursor.getString(2);

            if (Memo_Contents != null) {
                String day = cursor.getString(1);

                if (day.equals(tvDay_1.getText().toString()))
                    edtDay_1.setText(Memo_Contents);

                else if (day.equals(tvDay_2.getText().toString()))
                    edtDay_2.setText(Memo_Contents);

                else if (day.equals(tvDay_3.getText().toString()))
                    edtDay_3.setText(Memo_Contents);

                else if (day.equals(tvDay_4.getText().toString()))
                    edtDay_4.setText(Memo_Contents);

                else if (day.equals(tvDay_5.getText().toString()))
                    edtDay_5.setText(Memo_Contents);

                else if (day.equals(tvDay_6.getText().toString()))
                    edtDay_6.setText(Memo_Contents);

                else if (day.equals(tvDay_7.getText().toString()))
                    edtDay_7.setText(Memo_Contents);

            }
        }

        cursor.close();
        dbHelper.close();
    }

    public void DayForm(String weekDay) {
        switch (weekDay) {
            case "Mon":
                tvDay_1.setText("월요일");
                tvDay_2.setText("화요일");
                tvDay_3.setText("수요일");
                tvDay_4.setText("목요일");
                tvDay_5.setText("금요일");
                tvDay_6.setText("토요일");
                tvDay_7.setText("일요일");
                break;

            case "Tue":
                tvDay_1.setText("화요일");
                tvDay_2.setText("수요일");
                tvDay_3.setText("목요일");
                tvDay_4.setText("금요일");
                tvDay_5.setText("토요일");
                tvDay_6.setText("일요일");
                tvDay_7.setText("월요일");
                break;

            case "Wed":
                tvDay_1.setText("수요일");
                tvDay_2.setText("목요일");
                tvDay_3.setText("금요일");
                tvDay_4.setText("토요일");
                tvDay_5.setText("일요일");
                tvDay_6.setText("월요일");
                tvDay_7.setText("화요일");
                break;

            case "Thu":
                tvDay_1.setText("목요일");
                tvDay_2.setText("금요일");
                tvDay_3.setText("토요일");
                tvDay_4.setText("일요일");
                tvDay_5.setText("월요일");
                tvDay_6.setText("화요일");
                tvDay_7.setText("수요일");
                break;

            case "Fri":
                tvDay_1.setText("금요일");
                tvDay_2.setText("토요일");
                tvDay_3.setText("일요일");
                tvDay_4.setText("월요일");
                tvDay_5.setText("화요일");
                tvDay_6.setText("수요일");
                tvDay_7.setText("목요일");
                break;

            case "Sat":
                tvDay_1.setText("토요일");
                tvDay_2.setText("일요일");
                tvDay_3.setText("월요일");
                tvDay_4.setText("화요일");
                tvDay_5.setText("수요일");
                tvDay_6.setText("목요일");
                tvDay_7.setText("금요일");
                break;

            case "Sun":
                tvDay_1.setText("일요일");
                tvDay_2.setText("월요일");
                tvDay_3.setText("화요일");
                tvDay_4.setText("수요일");
                tvDay_5.setText("목요일");
                tvDay_6.setText("금요일");
                tvDay_7.setText("토요일");
                break;
        }
    }
}
