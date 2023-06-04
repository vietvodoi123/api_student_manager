package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tblSubject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true)
    private String mamh;
    @Column(nullable = false,unique = true)
    private String nameSubject;
    @Column(nullable = false,unique = false)
    private int soTinChi;
    @Column(nullable = false,unique = false)
    private String nameTeacher;

    public Subject(){}

    public Subject(String mamh, String nameSubject,int soTinChi, String nameTeacher) {
        this.mamh=mamh;
        this.nameSubject = nameSubject;
        this.soTinChi=soTinChi;
        this.nameTeacher = nameTeacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", mamh='" + mamh + '\'' +
                ", nameSubject='" + nameSubject + '\'' +
                ", soTinChi=" + soTinChi +
                ", nameTeacher='" + nameTeacher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return getSoTinChi() == subject.getSoTinChi() && Objects.equals(getMamh(), subject.getMamh()) && Objects.equals(getNameSubject(), subject.getNameSubject()) && Objects.equals(getNameTeacher(), subject.getNameTeacher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMamh(), getNameSubject(), getSoTinChi(), getNameTeacher());
    }
}
