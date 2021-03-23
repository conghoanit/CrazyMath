package com.hoanpc.lesson22.view;

import javax.swing.*;
import java.awt.*;

// Tất cả Frame, Panel, Component UI (Text, Button, Image...)
// đều gọi chung là Component

public abstract class BaseGui
        extends JFrame
        implements BaseView {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;

    public BaseGui() {
        initComponent();
        initSubComponents();
        initListeners();
    }

    @Override
    public void initComponent() {
        // setTitle

        setLayout(new CardLayout());

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void initSubComponents() {}

    @Override
    public void initListeners() {}

}