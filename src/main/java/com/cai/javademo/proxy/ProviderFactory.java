package com.cai.javademo.proxy;

/**
 * Created by reason on 16/11/25.
 */
public abstract class ProviderFactory {
    public static FontProvider getFontProvider(){
        return new FontProviderFromDisk();
    }
}
