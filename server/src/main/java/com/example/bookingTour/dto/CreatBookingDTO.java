package com.example.bookingTour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatBookingDTO {
    private int maBooking ;

    private String nameKH ;

    private String emailKH ;

    private String phoneNumber ;

    private String diaChi ;

    private Integer soChoNL ;

    private Integer soChoNguoiLon ;

    private Integer soChoTreEm ;

    private Integer soChoTreNho ;

    private Integer soChoEmBe ;

    private Integer tongGia ;

    private String tourId ;

    private int userId ;

}
