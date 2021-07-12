package com.cs.regista;

public class StudentInfo {
    String sname;
    String sroll;

    public String getSname() {
        return sname;
    }

    public String getSroll() {
        return sroll;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSroll(String sroll) {
        this.sroll = sroll;
    }

    public StudentInfo(String sname, String sroll) {
        this.sname = sname;
        this.sroll = sroll;
    }
}
