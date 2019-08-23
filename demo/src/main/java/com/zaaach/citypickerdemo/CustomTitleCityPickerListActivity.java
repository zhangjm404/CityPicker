package com.zaaach.citypickerdemo;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zaaach.citypicker.CityPickerActivity;

/**
 * @author zjm$
 * @date 2019-08-23$
 */
public class CustomTitleCityPickerListActivity extends CityPickerActivity {

    @Override
    public void customTitleLayout(LinearLayout layoutTitle) {
        super.customTitleLayout(layoutTitle);
        layoutTitle.removeAllViews();
        TextView textView = new TextView(this);
        textView.setText("ttttt");
        textView.setBackgroundColor(Color.RED);
        layoutTitle.addView(textView);
    }
}
