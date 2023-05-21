package com.psl.Gems.pokerGame;

import java.util.ArrayList;

public class Card {
public int suitWeight;
public int rankWeight;

public Card() {
	super();
}
public Card(int suitWeight, int rankWeight) {
	super();
	this.suitWeight = suitWeight;
	this.rankWeight = rankWeight;
}
public int getSuitWeight() {
	return suitWeight;
}
public void setSuitWeight(int suitWeight) {
	this.suitWeight = suitWeight;
}
public int getRankWeight() {
	return rankWeight;
}
public void setRankWeight(int rankWeight) {
	this.rankWeight = rankWeight;
}
public String showCard()
{
	StringBuilder builder=new StringBuilder();
	builder.append("card[suitWeight=");
	builder.append(suitWeight);
	builder.append(",rankWeight=");
	builder.append(rankWeight);
	builder.append("]");
	return builder.toString();
}
public static String rankWeightMapping(int rank)
{
	if(rank==0)
	{
		return "TWO";
	}
	else if(rank==1)
	{
		return "THREE";
	}
	else if(rank==2)
	{
		return "FOUR";
	}
	else if(rank==3)
	{
		return "FIVE";
	}
	else if(rank==4)
	{
		return "SIX";
	}
	else if(rank==5)
	{
		return "SEVEN";
	}
	else if(rank==6)
	{
		return "EIGHT";
	}
	else if(rank==7)
	{
		return "NINE";
	}
	else if(rank==8)
	{
		return "TEN";
	}
	else if(rank==9)
	{
		return "JACK";
	}
	else if(rank==10)
	{
		return "QUEEN";
	}
	else if(rank==11)
	{
		return "KING";
	}
	else if(rank==12)
	{
		return "ACE";
	}
	else
	{
		return (rank+" Is a invalid rank weight");
	}
}

public static String suitWeightMapping(int suit)
{
	if(suit==0)
	{
		return "CLUB";
	}
	else if(suit==1)
	{
		return "DIAMOND";
	}
	else if(suit==2)
	{
		return "HEART";
	}
	else if(suit==3)
	{
		return "SPADE";
	}
	else
	{
		return (suit+" Is a invalid suit weight");
	}
}

public ArrayList<String> showCardByCard()
{
	ArrayList<String>arr=new ArrayList<>();
	String s=suitWeightMapping(suitWeight);
	String r=rankWeightMapping(rankWeight);
	arr.add(s);
	arr.add(r);
	return arr;
}
public void showWinnerCard()
{
	
}
}
