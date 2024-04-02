package com.javalesson.collections.collectionsClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {
    List<Card.Znach> znaches = Arrays.asList(Card.Znach.values());
    List<Card.Mast> mastes = Arrays.asList((Card.Mast.values()));

    @Override
    public int compare(Card card1, Card card2) {
        if (znaches.indexOf(card1.getZnach()) < znaches.indexOf(card2.getZnach())) {
            return 1;
        } else if (znaches.indexOf(card1.getZnach()) > znaches.indexOf(card2.getZnach())) { //если больше, возвращаем 1
            return -1;
        } else if (znaches.indexOf(card1.getZnach()) == znaches.indexOf(card2.getZnach())) {//если равны, сравниваем по масти
            if (mastes.indexOf(card1.getMast()) < mastes.indexOf(card2.getMast())) {
                return -1;
            } else if (mastes.indexOf(card1.getMast()) > mastes.indexOf(card2.getMast())) {
                return 1;
            }

        }
        return 0;
    }
}
