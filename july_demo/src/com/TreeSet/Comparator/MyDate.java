package com.TreeSet.Comparator;

/**
 * @author wkh
 * @create 2021-07-11 21:30
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public MyDate() {
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        MyDate myDate = (MyDate) o;
//
//        if (year != myDate.year) return false;
//        if (month != myDate.month) return false;
//        return day == myDate.day;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = year;
//        result = 31 * result + month;
//        result = 31 * result + day;
//        return result;
//    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
