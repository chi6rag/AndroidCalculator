package net.chi6rag.android.androidcalculator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Custom Fonts
        Typography typography = new Typography();
        Typeface typeface = typography.importLocalFonts(this);
        typography.setFontToChildren((ViewGroup) findViewById(R.id.calculator), typeface);

    }
}
