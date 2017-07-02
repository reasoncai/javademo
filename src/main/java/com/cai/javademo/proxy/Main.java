package com.cai.javademo.proxy;

import java.awt.*;

/**
 * Created by reason on 16/11/25.
 */
public class Main {
    public static void main(String[] args){
        FontProvider fontProvider = ProviderFactory.getFontProvider();
        Font font = fontProvider.getFont("微软雅黑");

    }
}
