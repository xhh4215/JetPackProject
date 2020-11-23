package com.xdzl.golden.mango.application.bundles;

import java.io.Serializable;

public class MainBundle implements Serializable {

    private String title;
    private String tip;
    private String buttonText;



    public MainBundle(String title, String tip, String buttonText) {
        this.title = title;
        this.tip = tip;
        this.buttonText = buttonText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
