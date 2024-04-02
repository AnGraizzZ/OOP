package com.javalesson.collections.collectionsClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> {


    public enum Mast {CNERVI, BUBI, KRESTI, PIKI}

    public enum Znach {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Tothz}

    private final Mast mast;
    private final Znach znach;

    public Card(Mast mast, Znach znach) {
        this.mast = mast;
        this.znach = znach;
    }

    public Mast getMast() {
        return mast;
    }

    public Znach getZnach() {
        return znach;
    }

    @Override
    public int compareTo(Card card) {
        Znach[] values = Znach.values();// записываем значения enum в массив
        List<Znach> znaches = Arrays.asList(values);// преобразуем из полученного массива лист
        //проверяем индекс, если индекс проверяемого элемента меньше проверяющего, возвращаем -1
        if (znaches.indexOf(this.znach) < znaches.indexOf(card.getZnach())) {
            return -1;
        } else if (znaches.indexOf(this.znach) > znaches.indexOf(card.getZnach())) { //если больше, возвращаем 1
            return 1;
        } else if (znaches.indexOf(this.znach) == znaches.indexOf(card.getZnach())) {//если равны, сравниваем по масти
            return String.valueOf(mast).compareTo(String.valueOf(card.getMast()));
        }
        //иначе возвращаем 0
        return 0;
    }

    @Override
    public String toString() {
        return znach + " of " + mast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return mast == card.mast && znach == card.znach;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mast, znach);
    }
}
