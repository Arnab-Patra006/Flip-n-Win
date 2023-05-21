package com.psl.Gems.pokerGame;

import java.util.ArrayList;
import java.util.Collections;

public class Pack 
{
	ArrayList<Card>pack;
	public Pack()
	{
		pack=new ArrayList<Card>();
		for(int i=0;i<=3;i++) //suit_weight
		{
			for(int j=0;j<=12;j++) //rank_weight
			{
				Card c=new Card(i,j);
				pack.add(c);
			}
		}
	}
	public ArrayList<Card> getPack()
	{
		return pack;
	}
	public void setPack(ArrayList<Card>pack)
	{
		this.pack=pack;
	}
	public void shuffle()
	{
		Collections.shuffle(pack);
	}
}
