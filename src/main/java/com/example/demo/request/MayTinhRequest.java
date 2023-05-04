package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MayTinhRequest {

    private UUID ma;
    private String ten;

    private float gia;

    private String boNho;

    private boolean mauSac;

    private String hang;

    private String moTa;

}