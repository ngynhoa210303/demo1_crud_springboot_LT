package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "may_tinh")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MayTinhs {
    @Id
    @Column(name = "ma")
    @GeneratedValue()
    private UUID ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gia")
    private float gia;

    @Column(name = "bo_nho")
    private String boNho;

    @Column(name = "mau_sac")
    private boolean mauSac;

    @Column(name = "hang")
    private String hang;

    @Column(name = "mo_ta")
    private String moTa;

}
