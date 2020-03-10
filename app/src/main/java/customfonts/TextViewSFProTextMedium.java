package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewSFProTextMedium extends AppCompatTextView {

    public TextViewSFProTextMedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewSFProTextMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewSFProTextMedium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/SanFranciscoText-Medium.otf");
            setTypeface(tf);
        }
    }
}
