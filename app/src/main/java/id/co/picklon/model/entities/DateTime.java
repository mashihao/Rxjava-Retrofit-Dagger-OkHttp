package id.co.picklon.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class DateTime implements Parcelable {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minutes;

    public void setYearMonthDay(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setHourMinutes(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.year);
        dest.writeInt(this.month);
        dest.writeInt(this.day);
        dest.writeInt(this.hour);
        dest.writeInt(this.minutes);
    }

    public DateTime() {
    }

    protected DateTime(Parcel in) {
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.hour = in.readInt();
        this.minutes = in.readInt();
    }

    public static final Parcelable.Creator<DateTime> CREATOR = new Parcelable.Creator<DateTime>() {
        @Override
        public DateTime createFromParcel(Parcel source) {
            return new DateTime(source);
        }

        @Override
        public DateTime[] newArray(int size) {
            return new DateTime[size];
        }
    };
}
