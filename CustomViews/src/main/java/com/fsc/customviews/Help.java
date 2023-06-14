package com.fsc.customviews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.fsc.customviews.databinding.AlertHelpBinding;
import com.fsc.customviews.databinding.WidgetHelpBinding;

public class Help extends LinearLayout
{

    private WidgetHelpBinding widgetHelpBinding;

    public interface HelpListener
    {

        public void SetValue(String text);

    }

    public void setListener(HelpListener Helplistener)
    {

        this.Helplistener = Helplistener;

    }

    private HelpListener Helplistener;

    void SetValue(String text)
    {

        if (Helplistener != null) Helplistener.SetValue(text);

    }

    Context context;

    private HelpViewModel helpViewModel;

    private TypedArray attributes;

    public Help(Context context)
    {

        super(context);
        this.context = context;
        init();

    }

    public Help(Context context, AttributeSet attrs)
    {

        super(context, attrs);
        this.context = context;
        attributes = context.obtainStyledAttributes(attrs, R.styleable.Help);
        init();

    }

    public Help(Context context, AttributeSet attrs, int defStyle)
    {

        super(context, attrs, defStyle);
        this.context = context;
        attributes = context.obtainStyledAttributes(attrs, R.styleable.Help);
        init();

    }

    private void init()
    {

        helpViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(HelpViewModel.class);

        widgetHelpBinding = WidgetHelpBinding.inflate(LayoutInflater.from(context), this, true);
        ImageView IMG_Help = widgetHelpBinding.IMGHelp;
        IMG_Help.setOnClickListener(ONClickListener);

        helpViewModel.setMLD_STR_Title(attributes.getString(R.styleable.Help_title));
        helpViewModel.setMLD_STR_Text(attributes.getString(R.styleable.Help_body));

    }

    public void SetTitleBody(String Title, String Body)
    {

        helpViewModel.setMLD_STR_Title(Title);
        helpViewModel.setMLD_STR_Text(Body);

    }

    private OnClickListener ONClickListener = new OnClickListener()
    {

        public void onClick(View v)
        {

            //////////////////////////////////////
            //////////////////////////////////////
            //////////////////////////////////////

            if (v.getId() == R.id.IMG_Help)
            {

                SetValue("F click");

                AlertHelpBinding alertHelpBinding;
                alertHelpBinding = AlertHelpBinding.inflate(LayoutInflater.from(context));
                TextView TV_Title = alertHelpBinding.TVAlertHelpTitle;
                TextView TV_Body = alertHelpBinding.TVAlertHelpBody;
                helpViewModel.getMLD_STR_Title().observe((LifecycleOwner) context, TV_Title::setText);
                helpViewModel.getMLD_STR_Text().observe((LifecycleOwner) context, TV_Body::setText);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setView(alertHelpBinding.getRoot());

                alertDialogBuilder.setCancelable(true);

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();

            }

        }

    };

}
