package com.psl.Gems.Player;

import java.util.ArrayList;
import java.util.Random;

import com.psl.Gems.pokerGame.Card;
import com.psl.Gems.pokerGame.Pack;

public class Player{
	Pack p=new Pack();
	
	
	public void shuffle()
	{
		ArrayList<Card>pack=p.getPack();
		for(Card c:pack)
		{
			System.out.println(c.showCard());
		}
	}
	public Card getTopCard()
	{
		ArrayList<Card>pack=p.getPack();
		Card top_card=pack.get(0);
		return top_card;
	}
	public Card getRandomCard()
	{
		Random rand=new Random();
		ArrayList<Card>pack=p.getPack();
		int rand_idx=rand.nextInt(pack.size());
		Card rand_card=pack.get(rand_idx);
		pack.remove(rand_idx);
		return rand_card;
	}
	
	public int packSize()
	{
		ArrayList<Card>pack=p.getPack();
		return pack.size();
	}
	public ArrayList<ArrayList<String>>PlayerHandCard(ArrayList<String>s1,ArrayList<String>s2,ArrayList<String>s3)
	{
		ArrayList<ArrayList<String>>arr=new ArrayList<>();
		arr.add(s1);
		arr.add(s2);
		arr.add(s3);
		return arr;
	}
}



//A Player can do following actions with Pack of Cards 
//o can shuffle -done
//o can get top card -done
//o can add a card (duplicates are not allowed) -
//o can get random card 
//o can query size of pack. 
//o Can reset sequence in ascending/ descending order. 