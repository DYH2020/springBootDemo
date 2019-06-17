package com.test.demo.utils.serializers;

import java.io.Serializable;
import java.util.List;

public class CommonSection<T> implements Serializable {

    private List<T> list;
    private String letter;

    public CommonSection(String letter, List<T> list) {
        this.list = list;
        this.letter = letter;
    }

    public List<T> getList() {
        return list;
    }

    public String getLetter() {
        return letter;
    }
}
