package com.company;

public class Button {
    private String title;
    private OnClickListener onclickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnclickListener(OnClickListener onclickListener){
        this.onclickListener = onclickListener;
    }

    public void onClick(){
        this.onclickListener.onClick(this.title);
    }

    public interface OnClickListener {
        public void onClick(String title);
    }
}
