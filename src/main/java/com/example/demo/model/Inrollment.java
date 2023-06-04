package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tblInrollment")
public class Inrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String masv;
    @Column(nullable = false)
    private String mamh;
    private double score;
    public Inrollment(){}

    public Inrollment( String masv, String mamh, double score) {

        this.masv = masv;
        this.mamh = mamh;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Inrollment{" +
                "id=" + id +
                ", masv='" + masv + '\'' +
                ", mamh='" + mamh + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inrollment that)) return false;
        return Double.compare(that.getScore(), getScore()) == 0 && Objects.equals(getId(), that.getId())  && Objects.equals(getMasv(), that.getMasv()) && Objects.equals(getMamh(), that.getMamh());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMasv(), getMamh(), getScore());
    }
}
