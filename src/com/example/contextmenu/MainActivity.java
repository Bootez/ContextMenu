package com.example.contextmenu;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView)findViewById(R.id.tv_textView);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        menu.add(0, R.id.TEXT_COLOR_RED, 0, "Red");
        menu.add(0, R.id.TEXT_COLOR_GREEN, 0, "Green");
        menu.add(0, R.id.TEXT_COLOR_BLUE, 0, "Blue");
        menu.setGroupCheckable(0, true, true);
        menu.setHeaderIcon(R.drawable.ic_launcher);
        menu.setHeaderTitle("Text color settings");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.TEXT_COLOR_RED:
            textView.setTextColor(Color.RED);
            break;
        case R.id.TEXT_COLOR_GREEN:
            textView.setTextColor(Color.GREEN);
            break;
        case R.id.TEXT_COLOR_BLUE:
            textView.setTextColor(Color.BLUE);
            break;

        default:
            break;
        }
        return true;
    }

}
