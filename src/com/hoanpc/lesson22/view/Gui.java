package com.hoanpc.lesson22.view;

public class Gui extends BaseGui {

    @Override
    public void initComponent() {
        super.initComponent();
        setTitle("Crazy Math");
    }

    @Override
    public void initSubComponents() {
        add(new CrazyMathPanel());
    }
}