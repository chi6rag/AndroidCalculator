package net.chi6rag.android.androidcalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator c = new Calculator();
        Log.d("chi6rag", c.findValueInBraces("3+2"));
    }
}
