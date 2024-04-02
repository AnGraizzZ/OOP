package com.javalesson.collections.StackQueue;

import com.javalesson.collections.collectionsClass.Card;
import com.javalesson.collections.collectionsClass.CardComparator;

import java.util.*;

public class StackQueueLauncher2 {
    public static void main(String[] args) {
        Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator());
        for (Card.Znach znach: Card.Znach.values()){
            for (Card.Mast mast: Card.Mast.values())
            {
                cardDeck.offer(new Card(mast,znach));
            }
        }
        Deque<Card> cards = new ArrayDeque<>();
        for (int i=0; i<10;i++){
            cards.offerLast(cardDeck.poll());
        }
        for (int i=0; i<10;i++){
            System.out.println(cards.pollLast());
        }


        }
}
