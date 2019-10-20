package com;

import org.apache.commons.lang3.StringUtils;

public class TestDemo {
    public static void main(String[] args) {
        String str = "  ";
//        System.out.println(StringUtils.isEmpty(str)); // false
//        System.out.println(StringUtils.isBlank(str)); // true
        System.out.println(StringUtils.isEmpty(str));
    }
}
