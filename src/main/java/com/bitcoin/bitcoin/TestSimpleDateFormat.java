package com.bitcoin.bitcoin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a = simpleDateFormat.format(date.getTime());
        System.out.println(a);
    }

}
