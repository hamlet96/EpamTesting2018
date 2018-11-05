package com.spbstu.hw5.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Data {
    private int summary[];
    private String elements[];
    private String color;
    private String metals;
    private String vegetables[];
}