package com.example.bookingTour.dto.filter;

public class TourFilter {

    private int minTotalMember;

    private int maxTotalMember;

    public TourFilter() {
    }

    public int getMinTotalMember() {return minTotalMember;}

    public void setMinTotalMember(int minTotalMember) {
        this.minTotalMember = minTotalMember;
    }

    public int getMaxTotalMember() {
        return maxTotalMember;
    }

    public void setMaxTotalMember(int maxTotalMember) {
        this.maxTotalMember = maxTotalMember;
    }
}
