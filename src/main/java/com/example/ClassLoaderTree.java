package com.example;

import sun.misc.URLClassPath;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTree {
    public static void main(String[] args) {
        URLClassPath cp;
        URL[] urls;
        ClassLoader cl;

        System.out.println("---------- BootstrapClassPath: ----------");
        cp = sun.misc.Launcher.getBootstrapClassPath();
        urls = cp.getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toString());
        }

        System.out.println("\n---------- sun.boot.class.path: ----------");
        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println("\n---------- ExtClassPath: ----------");
        urls = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toString());
        }

        System.out.println("\n---------- SystemClassPath: ----------");
        urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toString());
        }

        System.out.println("\n---------- Class Path Tree: ----------");
        System.out.println("SystemClassLoader: " + ClassLoader.getSystemClassLoader());
        System.out.println("ExtClassLoader: " + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("BootstrapClassLoader: " + ClassLoader.getSystemClassLoader().getParent().getParent());
        cl = Thread.currentThread().getContextClassLoader();
        System.out.println("ContextClassLoader: " + cl);

    }
}
