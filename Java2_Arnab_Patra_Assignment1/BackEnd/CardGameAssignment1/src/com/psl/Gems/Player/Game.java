package com.psl.Gems.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.psl.Gems.pokerGame.Card;

public class Game
{

	public static HashMap<Integer,ArrayList<String>>mp=new HashMap<Integer,ArrayList<String>>();
	 
	public ArrayList<ArrayList<String>> player1_cards;
	public ArrayList<ArrayList<String>>player2_cards;
	
	PlayerName player1=new PlayerName();
	PlayerName player2=new PlayerName();
	
	ArrayList<String> player1_bestCard = new ArrayList<>();
	ArrayList<String> player2_bestCard = new ArrayList<>();
	
	static Integer mxScore1=0;
	static Integer mxScore2=0;
	
	String winnerName="";
	static Integer winner_point=0;
	public Game()
	{
		//constructor
	}
	public int maxScoreCalculation(Card c1,Card c2,Card c3)
	{
//		mp=new HashMap<Integer,ArrayList<String>>();
		int suit1=c1.suitWeight;
		int rank1=c1.rankWeight;
		int result1=rank1*4+suit1;
		mp.put(result1, c1.showCardByCard());
		
		int suit2=c2.suitWeight;
		int rank2=c2.rankWeight;
		int result2=rank2*4+suit2;
		mp.put(result2, c2.showCardByCard());
		
		int suit3=c3.suitWeight;
		int rank3=c3.rankWeight;
		int result3=rank3*4+suit3;
		mp.put(result3, c3.showCardByCard());
		
//		System.out.println("Map Values : "+mp);
		return Math.max(result1,Math.max(result2,result3));
	}
	
//	System.out.println("Map Values : "+mp);
	public void play() throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		player1.setPlayerName1("Arnab");
		player2.setPlayerName2("Persistent");
		
		
		
		System.out.println("Okayyyyyyy so "+player1.getPlayerName1()+" and "+player2.getPlayerName2()+" registered for the game");
		System.out.println("The game is about to begin .........");
			
		Player player=new Player();
		
		//Player 1 Cards :
		System.out.println("Three Random Cards for player 1: "+player1.getPlayerName1());
		Card c11=player.getRandomCard();
		System.out.println(c11.showCardByCard());
		Card c12=player.getRandomCard();
		System.out.println(c12.showCardByCard());
		Card c13=player.getRandomCard();
		System.out.println(c13.showCardByCard());
		player1_cards=player.PlayerHandCard(c11.showCardByCard(),c12.showCardByCard(),c13.showCardByCard());
		
		//Player 1 Max Score :
		Game g=new Game();
		mxScore1=g.maxScoreCalculation(c11, c12, c13);
//		System.out.println(mp.size());
		System.out.println(mxScore1);
		player1_bestCard.addAll(mp.get(mxScore1));
		System.out.println("player 1 winner card :"+mp.get(mxScore1));
		
		
		//Player 2 Cards :
		System.out.println("Three Random Cards for player 2: "+player2.getPlayerName2());
		Card c21=player.getRandomCard();
		System.out.println(c21.showCardByCard());
		Card c22=player.getRandomCard();
		System.out.println(c22.showCardByCard());
		Card c23=player.getRandomCard();
		System.out.println(c23.showCardByCard());
		player2_cards=player.PlayerHandCard(c21.showCardByCard(),c22.showCardByCard(),c23.showCardByCard());
		
		//Player 2 Max Score :
		mxScore2=g.maxScoreCalculation(c21, c22, c23);
		System.out.println(mxScore2);
		player2_bestCard.addAll(mp.get(mxScore2));
		System.out.println("player 2 winner card :"+mp.get(mxScore2));
		
		
		System.out.println("Map values : "+mp);
		System.out.println("Map Size :"+mp.size());
		if(mxScore1>mxScore2)
		{
			System.out.println("Winner Player "+player1.getPlayerName1());
			winnerName=player1.getPlayerName1();
			winner_point=mxScore1;
		}
		else
		{
			System.out.println("Winner Player "+player2.getPlayerName2());
			winnerName=player1.getPlayerName2();
			winner_point=mxScore2;
		}
		this.createJSON();
	}
	
	public void createJSON() throws IOException
	{
		JSONObject obj=new JSONObject();

		
		obj.put(player1.getPlayerName1(), player1_cards);
		obj.put(player2.getPlayerName2(), player2_cards);
		obj.put("Player1_bestCard", player1_bestCard);
		obj.put("Player2_bestCard",player2_bestCard);
		obj.put("winner",winnerName);
		
		obj.put("winner_point",winner_point);
		obj.put("Player1_point",this.mxScore1);
		obj.put("Player2_point",this.mxScore2);
		obj.put("mappedValues", mp);
		
		System.out.println(obj);
		
		File file=new File("E:\\1.1.1.1Persistent_Systems\\Persistent_Notes\\Notes\\CardGameAssignments\\out2.json");
		if (!file.exists()) {
		    file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		fw.write(obj.toString());
		fw.close();
	}
}