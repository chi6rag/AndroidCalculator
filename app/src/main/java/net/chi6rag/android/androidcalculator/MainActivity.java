package net.chi6rag.android.androidcalculator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Custom Fonts
        Typography typography = new Typography();
        Typeface typeface = typography.importLocalFonts(this);
        typography.setFontToChildren((ViewGroup) findViewById(R.id.calculator), typeface);

        // Calculator
        Calculator c = new Calculator();
        Log.d("chi6rag", c.findValueInBraces("2+3/Indbfj{chirg}"));
        setOnClickListnerToChildTextViews((ViewGroup) findViewById(R.id.calculator));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonSeven:
                Log.d("chi6rag", "Seven");
                break;
            case R.id.buttonEight:
                Log.d("chi6rag", "Eight");
                break;
            case R.id.buttonNine:
                Log.d("chi6rag", "Nine");
                break;
            case R.id.buttonDivide:
                Log.d("chi6rag", "Divide");
                break;
            case R.id.buttonFour:
                Log.d("chi6rag", "Four");
                break;
            case R.id.buttonFive:
                Log.d("chi6rag", "Five");
                break;
            case R.id.buttonSix:
                Log.d("chi6rag", "Six");
                break;
            case R.id.buttonMultiply:
                Log.d("chi6rag", "Multiply");
                break;
            case R.id.buttonOne:
                Log.d("chi6rag", "One");
                break;
            case R.id.buttonTwo:
                Log.d("chi6rag", "Two");
                break;
            case R.id.buttonThree:
                Log.d("chi6rag", "Three");
                break;
            case R.id.buttonMinus:
                Log.d("chi6rag", "Minus");
                break;
            case R.id.buttonZero:
                Log.d("chi6rag", "Zero");
                break;
            case R.id.buttonComma:
                Log.d("chi6rag", "Comma");
                break;
            case R.id.buttonEquals:
                Log.d("chi6rag", "Equals");
                break;
            case R.id.buttonPlus:
                Log.d("chi6rag", "Plus");
                break;
        }
    }


    private void setOnClickListnerToChildTextViews(ViewGroup parentNode){
        int childrenCount = parentNode.getChildCount();
        for(int index = 0; index < childrenCount; index+=1){
            View child = parentNode.getChildAt(index);
            if(child instanceof TextView){
                child.setOnClickListener(this);
            }
            else if(child instanceof ViewGroup){
                setOnClickListnerToChildTextViews((ViewGroup) child);
            }
        }
    }
}
