package javatests.test.object;

public enum Month {

    JANUARY("Январь", 31),
    FEBRUARY("Февраль", 28),
    MARCH("Март", 31),
    APRIL("Апрель", 30),
    MAY("Май", 31),
    JUNE("Июнь", 30),
    JULY("Июль", 31),
    AUGUST("Август", 31),
    SEPTEMBER("Сентябрь", 30),
    OCTOBER("Октябрь", 31),
    NOVEMBER("Ноябрь", 30),
    DECEMBER("Декабрь", 31);

    private String name;
    private int daysCount;

    Month(String name, int daysCount) {
        this.name = name;
        this.daysCount = daysCount;
    }

    public static Month[] getWinterMonths() {

        return new Month[]{DECEMBER, JANUARY, FEBRUARY};
    }

    public static Month[] getSummerMonths() {

        return new Month[]{JUNE, JULY, AUGUST};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                ", daysCount=" + daysCount +
                '}';
    }
}