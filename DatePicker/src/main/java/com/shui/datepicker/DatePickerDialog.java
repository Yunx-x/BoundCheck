package com.shui.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.shui.datepicker.utils.DatePickerUtils;

import java.util.ArrayList;
import java.util.Calendar;

public class DatePickerDialog extends BottomSheetDialogFragment {
    private VWheelView mWheelYear;
    private VWheelView mWheelMonth;
    private VWheelView mWheelDay;

    private TextView startDate;
    private TextView endDate;

    private boolean isStartMode = true;

    @Override
    public void onStart() {
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = DatePickerUtils.getScreenWidth(getContext());
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        getDialog().setCancelable(false);
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_date_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWheelYear = view.findViewById(R.id.wheel_year);
        mWheelMonth = view.findViewById(R.id.wheel_moth);
        mWheelDay = view.findViewById(R.id.wheel_day);

        startDate = view.findViewById(R.id.date_picker_start);
        endDate = view.findViewById(R.id.date_picker_end);
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStartMode = true;
                startDate.setBackgroundResource(R.drawable.bg_date_item_focus);
                endDate.setBackgroundResource(R.drawable.bg_date_item);
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStartMode = false;
                endDate.setBackgroundResource(R.drawable.bg_date_item_focus);
                startDate.setBackgroundResource(R.drawable.bg_date_item);
            }
        });

        view.findViewById(R.id.dialog_picker_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ArrayList<String> dataYear = new ArrayList<>();
        ArrayList<String> dataMoth = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        for (int i = 2018; i <= calendar.get(Calendar.YEAR); i++) {
            dataYear.add(i + "年");
        }

        mWheelYear.setItems(dataYear);
        mWheelYear.setSeletion(dataYear.indexOf(currentYear + "年"));
        mWheelYear.setOnWheelViewListener(new VWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                changeText();
            }
        });
        for (int i = 1; i < 13; i++) {
            dataMoth.add(i + "月");
        }

        mWheelMonth.setItems(dataMoth);
        mWheelMonth.setSeletion(dataMoth.indexOf(currentMonth + "月"));
        mWheelMonth.setOnWheelViewListener(new VWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                changeText();
                changeDayData(mWheelYear.getSeletedItem(), item, -1);
            }
        });

        changeDayData(currentYear + "年", currentMonth + "月", currentDay);
        changeText();
    }

    private void changeDayData(String year, String month, int currentDay) {
        int m = Integer.parseInt(month.replace("月", ""));
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12://31天
                setDayData(31, currentDay);
                break;
            case 4:
            case 6:
            case 9:
            case 11://30天
                setDayData(30, currentDay);
                break;
            case 2://2月
                int yearInt = Integer.parseInt(year.replace("年", ""));
                if (yearInt % 4 == 0) {
                    setDayData(29, currentDay);
                } else {
                    setDayData(28, currentDay);
                }
                break;
        }
    }

    private void setDayData(int maxDay, int currentDay) {
        ArrayList<String> dataDay = new ArrayList<>();
        for (int i = 1; i < maxDay + 1; i++) {
            dataDay.add(i + "日");
        }

        int oldIndex = mWheelDay.getSeletedIndex();
        mWheelDay.setItems(dataDay);
        mWheelDay.setOnWheelViewListener(new VWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                changeText();
            }
        });

        if (currentDay == -1) {
            if (oldIndex + 1 > dataDay.size()) {
                mWheelDay.setSeletion(dataDay.size() - 1);
            } else {
                mWheelDay.setSeletion(oldIndex);
            }
        } else {
            mWheelDay.setSeletion(dataDay.indexOf(currentDay + "日"));
        }
    }

    private void changeText() {
        String year = mWheelYear.getSeletedItem();
        String month = mWheelMonth.getSeletedItem();
        String day = mWheelDay.getSeletedItem();
        if (isStartMode) {
            startDate.setText(year + month + day);
        } else {
            endDate.setText(year + month + day);
        }
    }
}
