package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewGiorgiaBold extends AppCompatTextView {

    public TextViewGiorgiaBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewGiorgiaBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewGiorgiaBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/georgia bold.ttf");
            setTypeface(tf);
        }
    }
}