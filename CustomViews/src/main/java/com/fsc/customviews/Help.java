package com.fsc.customviews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Help extends LinearLayout
{
    public interface HelpListener
    {

        public void SetValue(boolean bol_Click);

    }

    public void setListener(HelpListener Helplistener)
    {

        this.Helplistener = Helplistener;

    }

    private HelpListener Helplistener;

    void SetValue(boolean bol_Click)
    {

        if (Helplistener != null) Helplistener.SetValue(bol_Click);

    }

    ImageView IMG_Help;

    String STR_Title = "";
    String STR_Body = "";

    Activity Act;
    Context context;

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
        init();

    }

    public Help(Context context, AttributeSet attrs, int defStyle)
    {

        super(context, attrs, defStyle);
        this.context = context;
        init();

    }

    private void init()
    {

        inflate(getContext(), R.layout.widget_help, this);

        IMG_Help = (ImageView) findViewById(R.id.IMG_Help);
        IMG_Help.setOnClickListener(ONClickListener);

    }

    public void SetTitleBody(String Title, String body)
    {

        STR_Title = Title;
        STR_Body = body;

    }

    public void SetAct(Activity Act)
    {

        this.Act = Act;

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

                //LayoutInflater li = LayoutInflater.from(Act);
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.alert_help, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setView(promptsView);

                final TextView TV_Title = (TextView) promptsView.findViewById(R.id.TV_AlertHelp_Title);

                final TextView TV_Body = (TextView) promptsView.findViewById(R.id.TV_AlertHelp_Body);

                TV_Title.setText(STR_Title);
                TV_Body.setText(STR_Body);

                alertDialogBuilder.setCancelable(true);

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();

            }

        }

    };

}
