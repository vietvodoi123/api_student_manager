package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;

//POJO
@Entity
@Table(name="tblStudent2")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true,length = 10)
    private String masv;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String khoa;

    public Student(){}

    public Student(Long id, String masv, String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String khoa) {
        this.id = id;
        this.masv = masv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.khoa = khoa;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", masv='" + masv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", khoa='" + khoa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getMasv(), student.getMasv()) && Objects.equals(getHoTen(), student.getHoTen()) && Objects.equals(getNgaySinh(), student.getNgaySinh()) && Objects.equals(getGioiTinh(), student.getGioiTinh()) && Objects.equals(getDiaChi(), student.getDiaChi()) && Objects.equals(getKhoa(), student.getKhoa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMasv(), getHoTen(), getNgaySinh(), getGioiTinh(), getDiaChi(), getKhoa());
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
