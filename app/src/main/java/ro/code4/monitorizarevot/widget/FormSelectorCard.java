package ro.code4.monitorizarevot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import ro.code4.monitorizarevot.R;

public class FormSelectorCard extends CardView {

    private TextView letter;
    private TextView text;
    private ImageView icon;

    public FormSelectorCard(Context context) {
        super(context);
        init(context, null);
    }

    public FormSelectorCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FormSelectorCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.widget_form_selector_card, this);

        setSelectableForeground(context);

        letter = findViewById(R.id.form_card_letter);
        icon = findViewById(R.id.form_card_image);
        text = findViewById(R.id.form_card_text);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FormSelectorCard, 0, 0);

            if (array.hasValue(R.styleable.FormSelectorCard_src)) {
                icon.setImageResource(array.getResourceId(R.styleable.FormSelectorCard_src, 0));
                letter.setVisibility(GONE);
            } else {
                icon.setVisibility(GONE);
                letter.setText(array.getResourceId(R.styleable.FormSelectorCard_letter, R.string.empty));
            }
            text.setText(array.getResourceId(R.styleable.FormSelectorCard_text, R.string.empty));

            array.recycle();
        }
    }

    public void setLetter(String c) {
        letter.setText(c);
        icon.setVisibility(GONE);
    }

    public void setText(String txt) {
        text.setText(txt);
    }

    public void setIcon(@DrawableRes Integer drawableRes) {
        icon.setImageResource(drawableRes);
        letter.setVisibility(GONE);
    }

    private void setSelectableForeground(Context context) {
        int[] selectableAttrs = new int[] { android.R.attr.selectableItemBackground };
        TypedArray ta = context.obtainStyledAttributes(selectableAttrs);
        Drawable selectableItemBackground = ta.getDrawable(0);
        ta.recycle();
        setForeground(selectableItemBackground);
    }
}
