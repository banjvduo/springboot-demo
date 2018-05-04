package com.banjvduo.demo.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemProperties {

    @Value("${name}")
    private String systemName;

    @Value("${author}")
    private String author;

    @Value("${ranNum}")
    private int ranNum;

    @Value("${ranStr}")
    private String ranStr;


    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRanNum() {
        return ranNum;
    }

    public void setRanNum(int ranNum) {
        this.ranNum = ranNum;
    }

    public String getRanStr() {
        return ranStr;
    }

    public void setRanStr(String ranStr) {
        this.ranStr = ranStr;
    }
}
