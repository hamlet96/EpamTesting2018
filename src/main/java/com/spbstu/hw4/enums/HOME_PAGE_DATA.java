package com.spbstu.hw4.enums;

public enum HOME_PAGE_DATA {
    LOGIN("epam"), PASSWORD("1234"), USER_NAME("PITER CHAILOVSKII"), IMAGES_COUNT(4),
    TEXTS(new String[] {"To include good practices\nand ideas from successful\nEPAM projec", "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}),
    SERVICES(new String[] {"Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different Elements"});


    public String[] strAr;
    public String str;
    public Integer i;
    HOME_PAGE_DATA(String str){
        this.str = str;
    }
    HOME_PAGE_DATA(Integer i){
        this.i= i;
    }
    public Integer getInt() {
        return this.i;
    }
    @Override
    public String toString() {
        return str;
    }
    HOME_PAGE_DATA(String[] strAr){
        this.strAr = strAr;
    }
}