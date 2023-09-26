package com.example.bookingTour.service;
import com.example.bookingTour.dto.*;
import com.example.bookingTour.entity.Booking;

import java.util.List;

public interface IBookingService  {

    void createBooking(Booking booking);

    Booking getBookingByMaBooking(int maBooking);

    void updateBookingById(int maBooking , BookingUpdateDTO bookingUpdateDTO);

    BookingTourDTO getTourBooking(int maBooking);

    List<BookingDTO> getBookingByNameKH(String nameKH);

    void approveBooking(int maBooking);

    void cancelBooking(int maBooking);

    void draftBooking(int maBooking);

    void deleteBooking(int maBooking);

    List<ThongKeBookingDTO>  thongKeLuongBookingTrongThang();

    List<ThongKeBookingDTO>  thongKeLuongBookingTrongTuan();

    List<PieChartDTO> tinhPhanTramCacDoTuoi();

    List<BookingUserDTO> getListBookingByUserId(int userId);

}
