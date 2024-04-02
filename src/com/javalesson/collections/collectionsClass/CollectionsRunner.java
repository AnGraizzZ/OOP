package com.javalesson.collections.collectionsClass;

import java.util.*;

public class CollectionsRunner {
    public static void main(String[] args) {
        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Znach znach: Card.Znach.values()){
            for (Card.Mast mast: Card.Mast.values())
            {
                deckOfCards.add(new Card(mast,znach));
            }
        }
        Collections.shuffle(deckOfCards);
        Collections.sort((deckOfCards));
        Card card = new Card(Card.Mast.PIKI, Card.Znach.Queen);
        int indexPosition = Collections.binarySearch(deckOfCards, card);
//        if(indexPosition>=0){
//            System.out.println("Карта находится в позиции"+ indexPosition);
//        }else {
//            System.out.println("Карта не найдена");
//        }
       List<Card> cardsList = new ArrayList<>();
        for (int i=0;i<52;i++){
            cardsList.add(null);
        }
       Collections.copy(cardsList,deckOfCards);
        Collections.addAll(cardsList,card);
        int frequency = Collections.frequency(cardsList, card);
            System.out.println("MIN: "+Collections.min(cardsList)+" and MAX: "+Collections.max(cardsList));
        //System.out.println(deckOfCards.size());
//        System.out.println("Перемешанная колода карт");
//        vivod(deckOfCards);

        Collections.sort(deckOfCards, new CardComparator());
//        System.out.println("\n\nОтсортированная колода карт");
//        vivod(deckOfCards);

    }

    private static void vivod(List<Card> deckOfCards) {
        for (int i = 0; i< deckOfCards.size(); i++){
            System.out.printf("%-20s %s", deckOfCards.get(i),(i+1)%4==0 ? "\n":" ");
        }
    }


}
