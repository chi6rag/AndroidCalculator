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

    static Boolean state = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Custom Fonts
        Typography typography = new Typography();
        Typeface typefaceRobotoThin = (Typeface) (typography.importLocalFonts(this)[0]);
        Typeface typefaceRobotoMedium = (Typeface) (typography.importLocalFonts(this)[1]);
        typography.setFontToChildren((ViewGroup) findViewById(R.id.calculator),
                typefaceRobotoThin);
        typography.setFontToChildren( (ViewGroup) findViewById(R.id.digitalDisplay),
                typefaceRobotoMedium);

        // Calculator
        setOnClickListnerToChildTextViews((ViewGroup) findViewById(R.id.calculator));
    }

    @Override
    public void onClick(View v) {
        TextView digitalDisplayText = (TextView) findViewById(R.id.digitalDisplayText);
        if(digitalDisplayText.getText().toString().equals("0")){
            digitalDisplayText.setText("");
        }
        switch(v.getId()){
            case R.id.buttonSeven:
                digitalDisplayText.append("7");
                break;
            case R.id.buttonEight:
                digitalDisplayText.append("8");
                break;
            case R.id.buttonNine:
                digitalDisplayText.append("9");
                break;
            case R.id.buttonDivide:
                digitalDisplayText.append(" / ");
                break;
            case R.id.buttonFour:
                digitalDisplayText.append("4");
                break;
            case R.id.buttonFive:
                digitalDisplayText.append("5");
                break;
            case R.id.buttonSix:
                digitalDisplayText.append("6");
                break;
            case R.id.buttonMultiply:
                digitalDisplayText.append(" * ");
                break;
            case R.id.buttonOne:
                digitalDisplayText.append("1");
                break;
            case R.id.buttonTwo:
                digitalDisplayText.append("2");
                break;
            case R.id.buttonThree:
                digitalDisplayText.append("3");
                break;
            case R.id.buttonMinus:
                digitalDisplayText.append(" - ");
                break;
            case R.id.buttonZero:
                digitalDisplayText.append("0");
                break;
            case R.id.buttonDot:
                digitalDisplayText.append(".");
                break;
            case R.id.buttonEquals:
                Calculator calculator = new Calculator();
                String expression = digitalDisplayText.getText().toString();
                Log.d("chi6rag", "Expression: " + expression);
                String result = calculator.findValueInBraces(expression);
                Log.d("chi6rag", "Result: " + result);
                digitalDisplayText.setText(result);
                break;
            case R.id.buttonPlus:
                digitalDisplayText.append(" + ");
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
