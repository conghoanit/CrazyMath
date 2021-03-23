package com.hoanpc.lesson22.view;

import javax.swing.*;

public abstract class BasePanel
        extends JPanel
        implements BaseView {

    public BasePanel() {
        initComponent();
        initSubComponents();
        initListeners();
    }

    @Override
    public void initComponent() {
        setLayout(null);
    }

}