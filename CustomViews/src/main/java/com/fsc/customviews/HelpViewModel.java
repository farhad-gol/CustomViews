package com.fsc.customviews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpViewModel extends ViewModel {

    private MutableLiveData<String> MLD_STR_Title = new MutableLiveData<>();
    private MutableLiveData<String> MLD_STR_Text = new MutableLiveData<>();

    public HelpViewModel() {

        MLD_STR_Title.setValue("F title");
        MLD_STR_Text.setValue("F body");

    }
    public MutableLiveData<String> getMLD_STR_Title() {
        return MLD_STR_Title;
    }

    public void setMLD_STR_Title(String Title) {
        this.MLD_STR_Title.setValue(Title);
    }

    public MutableLiveData<String> getMLD_STR_Text() {
        return MLD_STR_Text;
    }

    public void setMLD_STR_Text(String Text) {
        this.MLD_STR_Text.setValue(Text);
    }

}