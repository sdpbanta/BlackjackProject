package com.skilldistillery.cards.common;

public enum Suit
{
   CLUBS   ("\u2663"),
   DIAMONDS("\u2666"),
   HEARTS  ("\u2665"),
   SPADES  ("\u2660");
   
   private String letter;
   
   private Suit(String letter)
   {
      this.letter = letter;
   }
   
   public String toString()
   {
      return letter;
   }
}
