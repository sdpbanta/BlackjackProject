package com.skilldistillery.cards.common;

import java.util.*;

public class Deck
{

   public static void main(String[] args)
   {
      Deck d = new Deck();
      System.out.println(d);
      d.shuffle();
      System.out.println(d);
      System.out.println(d.deal());
      System.out.println(d.deal());
      System.out.println(d.deal());
      System.out.println(d.deal());
      System.out.println(d.size());
   }

   private List<Card> cards;
   private Rank[] ranks = Rank.values();
   private Suit[] suits = Suit.values();

   {
      cards = new ArrayList<>(ranks.length * suits.length);
   }

   public Deck()
   {
      initialize();
   }

   public Card deal()
   {
      return cards.remove(0);
   }

   private void initialize()
   {
      cards.clear();
      for (Suit suit : suits)
      {
         for (Rank rank : ranks)
         {
            cards.add(new Card(rank, suit));
         }
      }
   }

   public void shuffle()
   {
      Collections.shuffle(cards);
   }

   public int size()
   {
      return cards.size();
   }

   public String toString()
   {
      String cardsString = "";
      String delimiter = "Deck: [";
      for (Card card : cards)
      {
         cardsString += delimiter + card.toString();
         delimiter = ", ";
      }
      return cardsString + "]";
   }

}
