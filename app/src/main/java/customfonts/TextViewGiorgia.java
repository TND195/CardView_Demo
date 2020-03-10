package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewGiorgia extends AppCompatTextView {

    public TextViewGiorgia(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewGiorgia(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewGiorgia(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Georgia.ttf");
            setTypeface(tf);
        }
    }
}

