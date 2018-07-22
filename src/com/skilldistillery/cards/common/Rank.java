package com.skilldistillery.cards.common;

public enum Rank
{
   TWO  ("2", 2),
   THREE("3", 3),
   FOUR ("4", 4),
   FIVE ("5", 5),
   SIX  ("6", 6),
   SEVEN("7", 7),
   EIGHT("8", 8),
   NINE ("9", 9),
   TEN  ("10", 10),
   JACK ("J", 10),
   QUEEN("Q", 10),
   KING ("K", 10),
   ACE  ("A", 11, 1);

   private String  letter;
   private int     value;
   private Integer alternateValue;

   Rank(String letter, int value)
   {
      this.letter = letter;
      this.value  = value;
   }

   Rank(String letter, int value, int alternateValue)
   {
      this(letter, value);
      this.alternateValue = alternateValue;
   }

   public int getAlternateValue()
   {
      if (alternateValue == null)
      {
         return value;
      }
      return alternateValue.intValue();
   }

   public int getValue()
   {
      return value;
   }

   public boolean hasAlternateValue()
   {
      return alternateValue != null;
   }

   public String toString()
   {
      return letter;
   }
}
