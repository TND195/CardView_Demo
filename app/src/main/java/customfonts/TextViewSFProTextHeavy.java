package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewSFProTextHeavy extends AppCompatTextView {

    public TextViewSFProTextHeavy(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewSFProTextHeavy(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewSFProTextHeavy(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/SanFranciscoText-Heavy.otf");
            setTypeface(tf);
        }
    }
}

