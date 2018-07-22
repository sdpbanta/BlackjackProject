package com.skilldistillery.cards.common;

public class Card
{

   private Rank rank;
   private Suit suit;

   public Card(Rank rank, Suit suit)
   {
      this.rank = rank;
      this.suit = suit;
   }

   public int getAlternateValue()
   {
      return rank.getAlternateValue();
   }

   public int getValue()
   {
      return rank.getValue();
   }

   public boolean hasAlternateValue()
   {
      return rank.hasAlternateValue();
   }
   
   public boolean isAce()
   {
      return rank.equals(Rank.ACE);
   }

   public String toString()
   {
      return rank.toString() + suit.toString();
   }

}
