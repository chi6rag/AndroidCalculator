package net.chi6rag.android.androidcalculator;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chiragaggarwal on 27/06/15.
 */
public class Typography {

    public Typeface importLocalFonts(Context c){
        return getRobotoThin(c);
    }

    public void setFontToChildren(ViewGroup myParentlayout, Typeface typeFace){
        int childCount = myParentlayout.getChildCount();
        for(int index = 0; index < childCount; index+=1){
            View child = myParentlayout.getChildAt(index);
            if(child instanceof ViewGroup){
                setFontToChildren( (ViewGroup)child, typeFace);
            }
            else if(child instanceof TextView){
                ((TextView) child).setTypeface(typeFace);
            }
        }
    }

    private Typeface getRobotoThin(Context c){
        return Typeface.createFromAsset(c.getAssets(), "fonts/Roboto-Thin.ttf");
    }

}
