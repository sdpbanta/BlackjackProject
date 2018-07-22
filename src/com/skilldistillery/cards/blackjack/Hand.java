package com.skilldistillery.cards.blackjack;

import java.util.*;

import com.skilldistillery.cards.common.*;

public class Hand
   implements Comparable
{

   public static void main(String[] args)
   {
      Hand h = new Hand();
      h.add(new Card(Rank.ACE, Suit.CLUBS));
      System.out.println(h.toString() + "\n");
      h.add(new Card(Rank.ACE, Suit.DIAMONDS));
      System.out.println(h.toDealerString());
      System.out.println(h.toString() + "\n");
      h.add(new Card(Rank.ACE, Suit.HEARTS));
      System.out.println(h.toString() + "\n");
      System.out.println("Blackjack: " + h.isBlackjack() + "\n");
      h.add(new Card(Rank.TEN, Suit.SPADES));
      System.out.println(h.toString() + "\n");
      System.out.println("Blackjack: " + h.isBlackjack() + "\n");
      h.clear();
      h.add(new Card(Rank.ACE, Suit.SPADES));
      h.add(new Card(Rank.TEN, Suit.SPADES));
      System.out.println(h.toString() + "\n");
      System.out.println("Blackhack: " + h.isBlackjack() + "\n");
      System.out.println("Bust: " + h.isBust() + "\n");
      h.add(new Card(Rank.JACK, Suit.SPADES));
      System.out.println(h.toString() + "\n");
      System.out.println("Blackhack: " + h.isBlackjack() + "\n");
      System.out.println("Bust: " + h.isBust() + "\n");
      System.out.println(h.compareTo(h));
      Hand h2 = new Hand();
      h2.add(new Card(Rank.TEN, Suit.HEARTS));
      h2.add(new Card(Rank.ACE, Suit.HEARTS));
      System.out.println(h.compareTo(h2));
      System.out.println(h2.compareTo(h));
      h2.add(new Card(Rank.TWO, Suit.HEARTS));
      System.out.println(h2.compareTo(h));
   }


   private List<Card> cards = new ArrayList<>();


   public void add(Card card)
   {
      cards.add(card);
   } // end add( )


   public void clear()
   {
      cards.clear();
   } // end clear( )


   @Override
   public int compareTo(Object o)
   {
      if (o == null || o instanceof Hand == false)
      {
         return 1;
      }

      Hand h2 = (Hand) o;
      if (this.isBlackjack() && h2.isBlackjack())
      {
         return 0;
      }
      else if (this.isBlackjack())
      {
         return 1;
      }
      else if (h2.isBlackjack())
      {
         return -1;
      }
      else
      {
         return this.getValue() - h2.getValue();
      }
   } // end compareTo( )


   public int getValue()
   {
      int value = 0;

      for (Card card : cards)
      {
         value += card.getValue();
      }

      for (Card card : cards)
      {
         if (value > 21 && card.hasAlternateValue())
         {
            value -= card.getValue();
            value += card.getAlternateValue();
         }
      }

      return value;
   } // end getValue( )


   public boolean isBlackjack()
   {
      if (cards.size() == 2 && getValue() == 21)
      {
         return true;
      }

      return false;
   } // end isBlackjack( )


   public boolean isBust()
   {
      return getValue() > 21;
   } // end isBust( )


   public boolean isSoft()
   {
      int value = 0;

      for (Card card : cards)
      {
         value += card.getValue();
      }

      for (Card card : cards)
      {
         if (value > 21 && card.hasAlternateValue())
         {
            value = value - card.getValue() + card.getAlternateValue();
         }
         else if (value <= 21 && card.hasAlternateValue())
         {
            return true;
         }
      }

      return false;
   } // end isSoft( )


   public String toDealerString()
   {
      return cards.get(0).toString() + " XX";
   } // end toDealerString( )


   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      for (Card card : cards)
      {
         sb.append(card.toString());
         sb.append(' ');
      }
      sb.append("(" + getValue());
      if (isBlackjack())
      {
         sb.append(" blackjack");
      }
      else if (isBust())
      {
         sb.append(" bust");
      }
      else if (isSoft())
      {
         sb.append(" soft");
      }
      else
      {
         sb.append(" hard");
      }
      sb.append(")");
      return sb.toString();
   } // end toString( )

}
