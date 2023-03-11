package fr.istic.vv;

class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (day < 1 || day > 31) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public Date nextDate() {
        if (day == 31 && month == 12) {
            day = 1;
            month = 1;
            year++;
        } else if (((day == 30) && (month == 4 || month == 6 || month == 9 || month == 11)) ||
                   (day == 28 && month == 2 && !isLeapYear(year)) ||
                   (day == 29 && month == 2 && isLeapYear(year)) ||
                   (day == 31)
                   ) {
            day = 1;
            month++;
        } else {
            day++;
        }
        return new Date(day, month, year);
    }


    public Date previousDate(){
        if (day ==1) {
            if (month == 1) {
                day = 31;
                month = 12;
                year--;
            }
            else {
                if (month == 3 && isLeapYear(year)) {
                    day = 29;
                }
                else if (month == 3 && !isLeapYear(year)) {
                    day = 28;
                }
                else if (month == 5 || month == 7 || month == 10 || month == 12) {
                    day = 30;
                }
                else {
                    day = 31;
                }
                month--;
            }
        }
        else {
            day--;
        }
        return new Date(day, month, year);
    }

    public int compareTo(Date other) {
        if (year < other.year) {
            return -1;
        } else if (year > other.year) {
            return 1;
        } else {
            if (month < other.month) {
                return -1;
            } else if (month > other.month) {
                return 1;
            } else {
                return Integer.compare(day, other.day);
            }
        }

    }




}