package com.gloria.study.algorithm.sort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;

/**
 * 冒泡排序
 * @author luoxin
 * @version 1.0
 * @date 2020/4/19 10:32 下午
 */
public class BubbleSort {


    public static void bubbleSort(int[] a){
        //遍历
        for (int i =0;i< a.length ;i++){
            for (int j = 0 ; j<a.length-1-i;j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        int[] a = {3,5,1,6,9};
        BubbleSort.bubbleSort(a);
        try {
            String s = objectMapper.writeValueAsString(a);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }




}
