package com.example.bookingTour.service;

import com.example.bookingTour.dto.PieChartDTO;
import com.example.bookingTour.dto.ThongKeTourDTO;
import com.example.bookingTour.dto.TourDTO;
import com.example.bookingTour.dto.TourDetailDTO;
import com.example.bookingTour.dto.filter.TourFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITourSevice {
    Page<TourDTO> getAllTour(Pageable pageable, TourFilter filter, String searchThoiGian, String searchNoiKhoiHanh, String searchDiemDen);
    TourDTO getTourByMaTour(String maTour);
    TourDetailDTO getDetailTourByMaTour(String maTour);
    void createTour(TourDetailDTO tourDetailDTO);
    void updateSoChoTour(String maTour, Integer soChoDaDat);
    void updateTour(String maTour, TourDetailDTO tourDetailDTO);
    void deleteTour(String maTour);
    void updateImageTour(String maTour,Integer indexImage, String nameImg);
    List<ThongKeTourDTO> thongKeTourVoiNoiKhoiHanh();
    List<ThongKeTourDTO> thongKeSoTourTheoThang();
    List<PieChartDTO>  thongKeSoCho();
}
