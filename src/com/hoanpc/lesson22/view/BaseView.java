package com.hoanpc.lesson22.view;

public interface BaseView {
    // Cấu hình cho chính component:
    // title, background, size, location, layout...
    void initComponent();

    // Sub component: là các thành phần con
    // Cài đặt các thành phần con, bên trong component
    void initSubComponents();

    // Đăng ký lắng nghe các sự kiện
    void initListeners();

}