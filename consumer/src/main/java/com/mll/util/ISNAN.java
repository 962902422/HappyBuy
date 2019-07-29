package com.mll.util;

public class ISNAN {
    public static void main(String[] args) {
        System.out.println(isNAN("17608487688"));
    }
    //判断用户名是否是手机号
    public static boolean isNAN(String username){
        boolean flag=true;
        char[] chars = username.toCharArray();
        if(chars.length==11){
            for (int i=0;i<chars.length;i++){
                if(Character.isDigit(chars[i])){
                }else {
                    return  false;
                }
            }
        }else {
            return  false;
        }
        return  flag;
    }
}
