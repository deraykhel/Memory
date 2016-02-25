import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;
import java.lang.Thread;

public class Memory implements ActionListener {
	JFrame frame;
	JFrame newFrame;
	JPanel contentPane;
	JPanel newContentPane;
	JLabel title; JLabel playerOne; JLabel playerTwo; JLabel playerOneScore; JLabel playerTwoScore; JLabel endGame;
	JLabel instructions;
	JLabel pokemon1; JLabel pokemon2;
	private int [][] boardS=new int [2][5];
	private int [][] boardM=new int [3][6];
	private int [][] boardL=new int [5][6];
	private int [][] boardH=new int [6][7];
	private boolean small=false;
	private boolean medium=false;
	private boolean large=false;
	private boolean huge=false;
	private boolean playerone=true; 
	private boolean playertwo=false;
	private boolean block=false;
	private int card1=-1;
	private int card2=-1;
	private int choice=0;
	private int p1score=0;
	private int p2score=0;
	private int max=0;
	private int test=0;

	
	JButton button0;	JButton button1;	JButton button2;	JButton button3;	JButton button4;	JButton button5;	JButton button6;	JButton button7;	JButton button8;	JButton button9;	JButton button10;	JButton button11;	JButton button12;	JButton button13;	JButton button14;	JButton button15;	JButton button16;	JButton button17;	JButton button18;	JButton button19;	
	JButton button20;	JButton button21;	JButton button22;	JButton button23;	JButton button24;	JButton button25;	JButton button26;	JButton button27;	JButton button28;	JButton button29;
	JButton button30;	JButton button31;	JButton button32;	JButton button33;	JButton button34;	JButton button35;	JButton button36;	JButton button37;	JButton button38;	JButton button39;	JButton button40;	JButton button41;	JButton button42;
	JButton resume;
	JButton quit; JButton again; JButton MainMenu;
	
	
	//
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	
	public Memory(){
		frame=new JFrame("Memory");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createIntro();
	}
	
	//
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand(); int cardnumber=0;
		
		if (eventName.length()==12){
			cardnumber=(int)Integer.parseInt(eventName.substring(eventName.length()-2, eventName.length()));
			eventName=eventName.substring(0,eventName.length()-2);
		}
		
		if (eventName.length()==11){
			cardnumber=(int)Integer.parseInt(eventName.substring(eventName.length()-1));
			eventName=eventName.substring(0,eventName.length()-1);
		}
		
		if (eventName.equals("Quit")) System.exit(3);
		
		if (eventName.equals("MainMenu")){ contentPane.removeAll(); createIntro(); }
		
		if (eventName.equals("help")){frame.setSize(750,750); contentPane.setLayout(new GridLayout(0,1,0,0)); 
			contentPane.remove(button0); contentPane.remove(button1); contentPane.remove(button2); contentPane.remove(button3); contentPane.remove(button4);
			button4 = new JButton(new ImageIcon("back.png")); button4.setActionCommand("back"); button4.addActionListener(this);
			contentPane.remove(title);
			contentPane.add(instructions);
			contentPane.add(button4);
		}
		
		if(eventName.equals("back")){	contentPane.setLayout(new GridLayout(1,6,0,0)); 	frame.setSize(600, 200);
			contentPane.removeAll();
			button4 = new JButton(new ImageIcon("help.png")); button4.setActionCommand("help"); button4.addActionListener(this);
			contentPane.add(title); contentPane.add(button0); contentPane.add(button1); contentPane.add(button2); contentPane.add(button3); contentPane.add(button4);
		}
		
		if (eventName.equals("small")){small=true; contentPane.removeAll(); max=5;
			frame.setSize(700, 300); contentPane.setLayout(new GridLayout(3,5,0,0)); 
			createButtons();
			contentPane.add(button0);contentPane.add(button1);contentPane.add(button2);contentPane.add(button3);contentPane.add(button4);contentPane.add(button5);contentPane.add(button6);contentPane.add(button7);contentPane.add(button8);contentPane.add(button9);
			createBoard();
			createPlayers();
			contentPane.add(resume);
		}
		
		if (eventName.equals("medium")){medium=true; contentPane.removeAll(); max=9;
			frame.setSize(1080, 365);contentPane.setLayout(new GridLayout(4,6,0,0));
			createButtons();
			contentPane.add(button0);contentPane.add(button1);contentPane.add(button2);contentPane.add(button3);contentPane.add(button4);contentPane.add(button5);contentPane.add(button6);contentPane.add(button7);contentPane.add(button8);contentPane.add(button9);
			contentPane.add(button10);contentPane.add(button11);contentPane.add(button12);contentPane.add(button13);contentPane.add(button14);contentPane.add(button15);contentPane.add(button16);contentPane.add(button17);
			createBoard();
			createPlayers();
			contentPane.add(resume);
		}
		
		if (eventName.equals("large")){large=true; contentPane.removeAll(); max=15;
			frame.setSize(815, 700);contentPane.setLayout(new GridLayout(6,5,0,0)); 
			createButtons();
			contentPane.add(button0);contentPane.add(button1);contentPane.add(button2);contentPane.add(button3);contentPane.add(button4);contentPane.add(button5);contentPane.add(button6);contentPane.add(button7);contentPane.add(button8);contentPane.add(button9);
			contentPane.add(button10);contentPane.add(button11);contentPane.add(button12);contentPane.add(button13);contentPane.add(button14);contentPane.add(button15);contentPane.add(button16);contentPane.add(button17);contentPane.add(button18);contentPane.add(button19);
			contentPane.add(button20);contentPane.add(button21);contentPane.add(button22);contentPane.add(button23);contentPane.add(button24);contentPane.add(button25);contentPane.add(button26);contentPane.add(button27);contentPane.add(button28);contentPane.add(button29);
			createBoard();
			createPlayers();
			contentPane.add(resume);
		}
		
		if (eventName.equals("huge")){huge=true; contentPane.removeAll(); max=21;
			frame.setSize(1085, 700); contentPane.setLayout(new GridLayout(7,6,0,0)); 
			createButtons();
			contentPane.add(button0);contentPane.add(button1);contentPane.add(button2);contentPane.add(button3);contentPane.add(button4);contentPane.add(button5);contentPane.add(button6);contentPane.add(button7);contentPane.add(button8);contentPane.add(button9);
			contentPane.add(button10);contentPane.add(button11);contentPane.add(button12);contentPane.add(button13);contentPane.add(button14);contentPane.add(button15);contentPane.add(button16);contentPane.add(button17);contentPane.add(button18);contentPane.add(button19);
			contentPane.add(button20);contentPane.add(button21);contentPane.add(button22);contentPane.add(button23);contentPane.add(button24);contentPane.add(button25);contentPane.add(button26);contentPane.add(button27);contentPane.add(button28);contentPane.add(button29);
			contentPane.add(button30);contentPane.add(button31);contentPane.add(button32);contentPane.add(button33);contentPane.add(button34);contentPane.add(button35);contentPane.add(button36);contentPane.add(button37);contentPane.add(button38);contentPane.add(button39);
			contentPane.add(button40);contentPane.add(button41);
			createBoard();
			createPlayers();
			contentPane.add(resume);
		}
		if (eventName.equals("resume")){
			if (card2!=-1){
				if(playerone){ playerone=false; playertwo=true;}
				else if (playertwo){ playerone=true; playertwo=false;}	
				failReset(card1,card2);
				choice=0;
				block=false;
				card2=-1;
			}	
		}	
	
		if(eventName.equals("revealcard")){
			if (!block){
			reveal(cardnumber); boolean match=false;
			if(choice==1)card1=cardnumber;
			if(choice==2){card2=cardnumber; block=true;}	
			
			if (card2!=-1){ 	
				if(small){ int check1=0; int check2=0;
					check1=boardS[card1/5][card1-(5*(card1/5))];
					check2=boardS[card2/5][card2-(5*(card2/5))];
					match=check(check1, check2);
				}
				if(medium){ int check1=0; int check2=0;
					check1=boardM[card1/6][card1-(6*(card1/6))];
					check2=boardM[card2/6][card2-(6*(card2/6))];
					match=check(check1,check2);
				}
				if(large){ int check1=0; int check2=0;
					check1=boardL[card1/6][card1-(6*(card1/6))];
					check2=boardL[card2/6][card2-(6*(card2/6))];
					match=check(check1,check2);
				}	
				if(huge){ int check1=0; int check2=0;
					check1=boardH[card1/7][card1-(7*(card1/7))];
					check2=boardH[card2/7][card2-(7*(card2/7))];
					match=check(check1,check2);
				}
			
				if(match){
						if(playerone){ p1score++; playerOneScore.setText(""+p1score); }
						else if (playertwo){ p2score++;	 playerTwoScore.setText(""+p2score); }	
						correct(card1, card2);
						choice=0;
						card2=-1;
						block=false;
					}
			
			
		
		if(p1score+p2score==max && max!=0)	endReset();}
		}
		}
		if(playerone){	playerOne.setIcon(new ImageIcon("playerOne.png"));	playerTwo.setIcon(new ImageIcon("playerTwoFalse.png"));	}
		else{		playerOne.setIcon(new ImageIcon("playerOneFalse.png"));	playerTwo.setIcon(new ImageIcon("playerTwo.png"));	}
	}

	//
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	
	
	
	public void createIntro(){
		
		contentPane=new JPanel();
		contentPane.setLayout(new GridLayout(1,6,0,0));
		title=new JLabel (new ImageIcon("Title.png"));
		contentPane.add(title);
		instructions=new JLabel(new ImageIcon("details.png"));
		button0 = new JButton(new ImageIcon("small.png"));   button0.setActionCommand("small"); 	button0.addActionListener(this);
		button1 = new JButton(new ImageIcon("medium.png"));  button1.setActionCommand("medium"); 	button1.addActionListener(this);
		button2 = new JButton(new ImageIcon("large.png"));  button2.setActionCommand("large"); 	button2.addActionListener(this);
		button3 = new JButton(new ImageIcon("huge.png"));  button3.setActionCommand("huge"); 	button3.addActionListener(this);
		button4=new JButton(new ImageIcon("help.png")); button4.setActionCommand("help"); button4.addActionListener(this);
		
		contentPane.add(button0);
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600, 200);
	}
	public void createBoard(){
		int r=0; int counter=0; int c=0; int selectionnumber=0; boolean found=false;
		int[] arrayS={0,1,2,3,4,5,6,7,8,9};
		int[] arrayM={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		int[] arrayL={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
		int[] arrayH={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41};
		if(small){
			while(r<2){
				while (c<5){	found=false; counter=0;
					selectionnumber=(int)((Math.random()*10));
					while(counter<arrayS.length && !(found)){
						if (selectionnumber==arrayS[counter]){
							arrayS[counter]=-1;
							boardS[r][c]=selectionnumber;
							found=true;
						} 
						else counter++;
					}
					if(found==true)   c++;
				}r++; c=0;
			}

		}
		if(medium){
			while(r<3){
				while (c<6){	found=false; counter=0;
					selectionnumber=(int)((Math.random()*18));
					while(counter<arrayM.length && !(found)){ 
						if (selectionnumber==arrayM[counter]){
							arrayM[counter]=-1;
							boardM[r][c]=selectionnumber;
							found=true;
						} 
						else counter++;
					}
					if(found==true)   c++;
				}r++; c=0;
			}
		}
		
		if(large){
			while(r<5){
				while (c<6){	found=false; counter=0;
					selectionnumber=(int)((Math.random()*30));
					while(counter<arrayL.length && !(found)){
						if (selectionnumber==arrayL[counter]){
							arrayL[counter]=-1;
							boardL[r][c]=selectionnumber;
							found=true;
						} 
						else counter++;
					}
					if(found==true)   c++;
				}r++; c=0;
			}
		}
		
		if(huge){
			while(r<6){
				while (c<7){	found=false; counter=0;
					selectionnumber=(int)((Math.random()*42));
					while(counter<arrayH.length && !(found)){
						if (selectionnumber==arrayH[counter]){
							arrayH[counter]=-1;
							boardH[r][c]=selectionnumber;
							found=true;
						} 
						else counter++;
					}
					if(found==true)   c++;
				}r++; c=0;
			}
		}
	
	}
	
	//
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	
	public void createButtons(){
		button0 = new JButton(new ImageIcon("pokeball.png"));  	button0.setActionCommand("revealcard0"); 	button0.addActionListener(this);
		button1 = new JButton(new ImageIcon("pokeball.png"));  	button1.setActionCommand("revealcard1"); 	button1.addActionListener(this);
		button2 = new JButton(new ImageIcon("pokeball.png"));  	button2.setActionCommand("revealcard2"); 	button2.addActionListener(this);
		button3 = new JButton(new ImageIcon("pokeball.png"));  	button3.setActionCommand("revealcard3"); 	button3.addActionListener(this);
		button4 = new JButton(new ImageIcon("pokeball.png"));  	button4.setActionCommand("revealcard4"); 	button4.addActionListener(this);
		button5 = new JButton(new ImageIcon("pokeball.png"));  	button5.setActionCommand("revealcard5"); 	button5.addActionListener(this);
		button6 = new JButton(new ImageIcon("pokeball.png"));  	button6.setActionCommand("revealcard6"); 	button6.addActionListener(this);
		button7 = new JButton(new ImageIcon("pokeball.png"));  	button7.setActionCommand("revealcard7"); 	button7.addActionListener(this);
		button8 = new JButton(new ImageIcon("pokeball.png"));  	button8.setActionCommand("revealcard8"); 	button8.addActionListener(this);
		button9 = new JButton(new ImageIcon("pokeball.png"));  button9.setActionCommand("revealcard9"); 	button9.addActionListener(this);
		
		if (!small){
			button10 = new JButton(new ImageIcon("pokeball.png"));  	button10.setActionCommand("revealcard10"); 	button10.addActionListener(this);
			button11 = new JButton(new ImageIcon("pokeball.png"));  	button11.setActionCommand("revealcard11"); 	button11.addActionListener(this);
			button12 = new JButton(new ImageIcon("pokeball.png"));  	button12.setActionCommand("revealcard12"); 	button12.addActionListener(this);
			button13 = new JButton(new ImageIcon("pokeball.png"));  	button13.setActionCommand("revealcard13"); 	button13.addActionListener(this);
			button14 = new JButton(new ImageIcon("pokeball.png"));  	button14.setActionCommand("revealcard14"); 	button14.addActionListener(this);
			button15 = new JButton(new ImageIcon("pokeball.png"));  	button15.setActionCommand("revealcard15"); 	button15.addActionListener(this);
			button16 = new JButton(new ImageIcon("pokeball.png"));  	button16.setActionCommand("revealcard16"); 	button16.addActionListener(this);
			button17 = new JButton(new ImageIcon("pokeball.png"));  	button17.setActionCommand("revealcard17"); 	button17.addActionListener(this);
		}
		if (!small && !medium){
			button18 = new JButton(new ImageIcon("pokeball.png"));  	button18.setActionCommand("revealcard18"); 	button18.addActionListener(this);
			button19 = new JButton(new ImageIcon("pokeball.png"));  	button19.setActionCommand("revealcard19"); 	button19.addActionListener(this);
			button20 = new JButton(new ImageIcon("pokeball.png"));  	button20.setActionCommand("revealcard20"); 	button20.addActionListener(this);
			button21 = new JButton(new ImageIcon("pokeball.png"));  	button21.setActionCommand("revealcard21"); 	button21.addActionListener(this);
			button22 = new JButton(new ImageIcon("pokeball.png"));  	button22.setActionCommand("revealcard22"); 	button22.addActionListener(this);
			button23 = new JButton(new ImageIcon("pokeball.png"));  	button23.setActionCommand("revealcard23"); 	button23.addActionListener(this);
			button24 = new JButton(new ImageIcon("pokeball.png"));  	button24.setActionCommand("revealcard24"); 	button24.addActionListener(this);
			button25 = new JButton(new ImageIcon("pokeball.png"));  	button25.setActionCommand("revealcard25"); 	button25.addActionListener(this);
			button26 = new JButton(new ImageIcon("pokeball.png"));  	button26.setActionCommand("revealcard26"); 	button26.addActionListener(this);
			button27 = new JButton(new ImageIcon("pokeball.png"));  	button27.setActionCommand("revealcard27"); 	button27.addActionListener(this);
			button28 = new JButton(new ImageIcon("pokeball.png"));  	button28.setActionCommand("revealcard28"); 	button28.addActionListener(this);
			button29 = new JButton(new ImageIcon("pokeball.png"));  	button29.setActionCommand("revealcard29"); 	button29.addActionListener(this);
		}
		if (huge){
			button30 = new JButton(new ImageIcon("pokeball.png"));  	button30.setActionCommand("revealcard30"); 	button30.addActionListener(this);
			button31 = new JButton(new ImageIcon("pokeball.png"));  	button31.setActionCommand("revealcard31"); 	button31.addActionListener(this);
			button32 = new JButton(new ImageIcon("pokeball.png"));  	button32.setActionCommand("revealcard32"); 	button32.addActionListener(this);
			button33 = new JButton(new ImageIcon("pokeball.png"));  	button33.setActionCommand("revealcard33"); 	button33.addActionListener(this);
			button34 = new JButton(new ImageIcon("pokeball.png"));  	button34.setActionCommand("revealcard34"); 	button34.addActionListener(this);
			button35 = new JButton(new ImageIcon("pokeball.png"));  	button35.setActionCommand("revealcard35"); 	button35.addActionListener(this);
			button36 = new JButton(new ImageIcon("pokeball.png"));  	button36.setActionCommand("revealcard36"); 	button36.addActionListener(this);
			button37 = new JButton(new ImageIcon("pokeball.png"));  	button37.setActionCommand("revealcard37"); 	button37.addActionListener(this);
			button38 = new JButton(new ImageIcon("pokeball.png"));  	button38.setActionCommand("revealcard38"); 	button38.addActionListener(this);
			button39 = new JButton(new ImageIcon("pokeball.png")); 		button39.setActionCommand("revealcard39"); 	button39.addActionListener(this);
			button40 = new JButton(new ImageIcon("pokeball.png"));  	button40.setActionCommand("revealcard40"); 	button40.addActionListener(this);
			button41 = new JButton(new ImageIcon("pokeball.png"));  	button41.setActionCommand("revealcard41"); 	button41.addActionListener(this);
		}
		resume=new JButton(new ImageIcon("resume.png")); 	resume.setActionCommand("resume"); 		resume.addActionListener(this);
	}
	public void createPlayers(){
		playerOne=new JLabel(new ImageIcon("playerOne.png"));
		playerTwo=new JLabel(new ImageIcon("playerTwoFalse.png"));
		contentPane.add(playerOne); playerOneScore = new JLabel ("0"); contentPane.add(playerOneScore);
		contentPane.add(playerTwo);playerTwoScore = new JLabel ("0"); contentPane.add(playerTwoScore);
	}
	
	//
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	
	public void reveal(int cardnumber){
		if (small){
			max=5;
			if(cardnumber==0){button0.setIcon(new ImageIcon("C"+boardS [0][0]+".png")); button0.setActionCommand("nothing");}
			else if(cardnumber==1){button1.setIcon(new ImageIcon("C"+boardS [0][1]+".png")); button1.setActionCommand("nothing");}
			else if(cardnumber==2){button2.setIcon(new ImageIcon("C"+boardS [0][2]+".png")); button2.setActionCommand("nothing");}
			else if(cardnumber==3){button3.setIcon(new ImageIcon("C"+boardS [0][3]+".png")); button3.setActionCommand("nothing");}
			else if(cardnumber==4){button4.setIcon(new ImageIcon("C"+boardS [0][4]+".png")); button4.setActionCommand("nothing");}
			else if(cardnumber==5){button5.setIcon(new ImageIcon("C"+boardS [1][0]+".png")); button5.setActionCommand("nothing");}
			else if(cardnumber==6){button6.setIcon(new ImageIcon("C"+boardS [1][1]+".png")); button6.setActionCommand("nothing");}
			else if(cardnumber==7){button7.setIcon(new ImageIcon("C"+boardS [1][2]+".png")); button7.setActionCommand("nothing");}
			else if(cardnumber==8){button8.setIcon(new ImageIcon("C"+boardS [1][3]+".png")); button8.setActionCommand("nothing");}
			else if(cardnumber==9){button9.setIcon(new ImageIcon("C"+boardS [1][4]+".png")); button9.setActionCommand("nothing");}
			choice++;			
		}
		if (medium){
			max=9;
			if(cardnumber==0){button0.setIcon(new ImageIcon("C"+boardM [0][0]+".png")); button0.setActionCommand("nothing");}
			else if(cardnumber==1){button1.setIcon(new ImageIcon("C"+boardM [0][1]+".png"));button1.setActionCommand("nothing");}
			else if(cardnumber==2){button2.setIcon(new ImageIcon("C"+boardM [0][2]+".png"));button2.setActionCommand("nothing");}
			else if(cardnumber==3){button3.setIcon(new ImageIcon("C"+boardM [0][3]+".png"));button3.setActionCommand("nothing");}
			else if(cardnumber==4){button4.setIcon(new ImageIcon("C"+boardM [0][4]+".png"));button4.setActionCommand("nothing");}
			else if(cardnumber==5){button5.setIcon(new ImageIcon("C"+boardM [0][5]+".png"));button5.setActionCommand("nothing");}
			else if(cardnumber==6){button6.setIcon(new ImageIcon("C"+boardM [1][0]+".png"));button6.setActionCommand("nothing");}
			else if(cardnumber==7){button7.setIcon(new ImageIcon("C"+boardM [1][1]+".png"));button7.setActionCommand("nothing");}
			else if(cardnumber==8){button8.setIcon(new ImageIcon("C"+boardM [1][2]+".png"));button8.setActionCommand("nothing");}
			else if(cardnumber==9){button9.setIcon(new ImageIcon("C"+boardM [1][3]+".png"));button9.setActionCommand("nothing");}
			else if(cardnumber==10){button10.setIcon(new ImageIcon("C"+boardM [1][4]+".png"));button10.setActionCommand("nothing");}
			else if(cardnumber==11){button11.setIcon(new ImageIcon("C"+boardM [1][5]+".png"));button11.setActionCommand("nothing");}
			else if(cardnumber==12){button12.setIcon(new ImageIcon("C"+boardM [2][0]+".png"));button12.setActionCommand("nothing");}
			else if(cardnumber==13){button13.setIcon(new ImageIcon("C"+boardM [2][1]+".png"));button13.setActionCommand("nothing");}
			else if(cardnumber==14){button14.setIcon(new ImageIcon("C"+boardM [2][2]+".png"));button14.setActionCommand("nothing");}
			else if(cardnumber==15){button15.setIcon(new ImageIcon("C"+boardM [2][3]+".png"));button15.setActionCommand("nothing");}
			else if(cardnumber==16){button16.setIcon(new ImageIcon("C"+boardM [2][4]+".png"));button16.setActionCommand("nothing");}
			else if(cardnumber==17){button17.setIcon(new ImageIcon("C"+boardM [2][5]+".png"));button17.setActionCommand("nothing");}
			choice++;
		}
		if (large){	
			max=15;
			if(cardnumber==0){button0.setIcon(new ImageIcon("C"+boardL [0][0]+".png"));button0.setActionCommand("nothing");}
			else if(cardnumber==1){button1.setIcon(new ImageIcon("C"+boardL [0][1]+".png"));button1.setActionCommand("nothing");}
			else if(cardnumber==2){button2.setIcon(new ImageIcon("C"+boardL [0][2]+".png"));button2.setActionCommand("nothing");}
			else if(cardnumber==3){button3.setIcon(new ImageIcon("C"+boardL [0][3]+".png"));button3.setActionCommand("nothing");}
			else if(cardnumber==4){button4.setIcon(new ImageIcon("C"+boardL [0][4]+".png"));button4.setActionCommand("nothing");}
			else if(cardnumber==5){button5.setIcon(new ImageIcon("C"+boardL [0][5]+".png"));button5.setActionCommand("nothing");}
			else if(cardnumber==6){button6.setIcon(new ImageIcon("C"+boardL [1][0]+".png"));button6.setActionCommand("nothing");}
			else if(cardnumber==7){button7.setIcon(new ImageIcon("C"+boardL [1][1]+".png"));button7.setActionCommand("nothing");}
			else if(cardnumber==8){button8.setIcon(new ImageIcon("C"+boardL [1][2]+".png"));button8.setActionCommand("nothing");}
			else if(cardnumber==9){button9.setIcon(new ImageIcon("C"+boardL [1][3]+".png"));button9.setActionCommand("nothing");}
			else if(cardnumber==10){button10.setIcon(new ImageIcon("C"+boardL [1][4]+".png"));button10.setActionCommand("nothing");}
			else if(cardnumber==11){button11.setIcon(new ImageIcon("C"+boardL [1][5]+".png"));button11.setActionCommand("nothing");}
			else if(cardnumber==12){button12.setIcon(new ImageIcon("C"+boardL [2][0]+".png"));button12.setActionCommand("nothing");}
			else if(cardnumber==13){button13.setIcon(new ImageIcon("C"+boardL [2][1]+".png"));button13.setActionCommand("nothing");}
			else if(cardnumber==14){button14.setIcon(new ImageIcon("C"+boardL [2][2]+".png"));button14.setActionCommand("nothing");}
			else if(cardnumber==15){button15.setIcon(new ImageIcon("C"+boardL [2][3]+".png"));button15.setActionCommand("nothing");}
			else if(cardnumber==16){button16.setIcon(new ImageIcon("C"+boardL [2][4]+".png"));button16.setActionCommand("nothing");}
			else if(cardnumber==17){button17.setIcon(new ImageIcon("C"+boardL [2][5]+".png"));button17.setActionCommand("nothing");}
			else if(cardnumber==18){button18.setIcon(new ImageIcon("C"+boardL [3][0]+".png"));button18.setActionCommand("nothing");}
			else if(cardnumber==19){button19.setIcon(new ImageIcon("C"+boardL [3][1]+".png"));button19.setActionCommand("nothing");}
			else if(cardnumber==20){button20.setIcon(new ImageIcon("C"+boardL [3][2]+".png"));button20.setActionCommand("nothing");}
			else if(cardnumber==21){button21.setIcon(new ImageIcon("C"+boardL [3][3]+".png"));button21.setActionCommand("nothing");}
			else if(cardnumber==22){button22.setIcon(new ImageIcon("C"+boardL [3][4]+".png"));button22.setActionCommand("nothing");}
			else if(cardnumber==23){button23.setIcon(new ImageIcon("C"+boardL [3][5]+".png"));button23.setActionCommand("nothing");}
			else if(cardnumber==24){button24.setIcon(new ImageIcon("C"+boardL [4][0]+".png"));button24.setActionCommand("nothing");}
			else if(cardnumber==25){button25.setIcon(new ImageIcon("C"+boardL [4][1]+".png"));button25.setActionCommand("nothing");}
			else if(cardnumber==26){button26.setIcon(new ImageIcon("C"+boardL [4][2]+".png"));button26.setActionCommand("nothing");}
			else if(cardnumber==27){button27.setIcon(new ImageIcon("C"+boardL [4][3]+".png"));button27.setActionCommand("nothing");}
			else if(cardnumber==28){button28.setIcon(new ImageIcon("C"+boardL [4][4]+".png"));button28.setActionCommand("nothing");}
			else if(cardnumber==29){button29.setIcon(new ImageIcon("C"+boardL [4][5]+".png"));button29.setActionCommand("nothing");}
			choice++;
		}
		if (huge){
			max=21;
			if(cardnumber==0){button0.setIcon(new ImageIcon("C"+boardH [0][0]+".png"));button0.setActionCommand("nothing");}
			else if(cardnumber==1){button1.setIcon(new ImageIcon("C"+boardH [0][1]+".png"));button1.setActionCommand("nothing");}
			else if(cardnumber==2){button2.setIcon(new ImageIcon("C"+boardH [0][2]+".png"));button2.setActionCommand("nothing");}
			else if(cardnumber==3){button3.setIcon(new ImageIcon("C"+boardH [0][3]+".png"));button3.setActionCommand("nothing");}
			else if(cardnumber==4){button4.setIcon(new ImageIcon("C"+boardH [0][4]+".png"));button4.setActionCommand("nothing");}
			else if(cardnumber==5){button5.setIcon(new ImageIcon("C"+boardH [0][5]+".png"));button5.setActionCommand("nothing");}
			else if(cardnumber==6){button6.setIcon(new ImageIcon("C"+boardH [0][6]+".png"));button6.setActionCommand("nothing");}
			else if(cardnumber==7){button7.setIcon(new ImageIcon("C"+boardH [1][0]+".png"));button7.setActionCommand("nothing");}
			else if(cardnumber==8){button8.setIcon(new ImageIcon("C"+boardH [1][1]+".png"));button8.setActionCommand("nothing");}
			else if(cardnumber==9){button9.setIcon(new ImageIcon("C"+boardH [1][2]+".png"));button9.setActionCommand("nothing");}
			else if(cardnumber==10){button10.setIcon(new ImageIcon("C"+boardH [1][3]+".png"));button10.setActionCommand("nothing");}
			else if(cardnumber==11){button11.setIcon(new ImageIcon("C"+boardH [1][4]+".png"));button11.setActionCommand("nothing");}
			else if(cardnumber==12){button12.setIcon(new ImageIcon("C"+boardH [1][5]+".png"));button12.setActionCommand("nothing");}
			else if(cardnumber==13){button13.setIcon(new ImageIcon("C"+boardH [1][6]+".png"));button13.setActionCommand("nothing");}
			else if(cardnumber==14){button14.setIcon(new ImageIcon("C"+boardH [2][0]+".png"));button14.setActionCommand("nothing");}
			else if(cardnumber==15){button15.setIcon(new ImageIcon("C"+boardH [2][1]+".png"));button15.setActionCommand("nothing");}
			else if(cardnumber==16){button16.setIcon(new ImageIcon("C"+boardH [2][2]+".png"));button16.setActionCommand("nothing");}
			else if(cardnumber==17){button17.setIcon(new ImageIcon("C"+boardH [2][3]+".png"));button17.setActionCommand("nothing");}
			else if(cardnumber==18){button18.setIcon(new ImageIcon("C"+boardH [2][4]+".png"));button18.setActionCommand("nothing");}
			else if(cardnumber==19){button19.setIcon(new ImageIcon("C"+boardH [2][5]+".png"));button19.setActionCommand("nothing");}
			else if(cardnumber==20){button20.setIcon(new ImageIcon("C"+boardH [2][6]+".png"));button20.setActionCommand("nothing");}
			else if(cardnumber==21){button21.setIcon(new ImageIcon("C"+boardH [3][0]+".png"));button21.setActionCommand("nothing");}
			else if(cardnumber==22){button22.setIcon(new ImageIcon("C"+boardH [3][1]+".png"));button22.setActionCommand("nothing");}
			else if(cardnumber==23){button23.setIcon(new ImageIcon("C"+boardH [3][2]+".png"));button23.setActionCommand("nothing");}
			else if(cardnumber==24){button24.setIcon(new ImageIcon("C"+boardH [3][3]+".png"));button24.setActionCommand("nothing");}
			else if(cardnumber==25){button25.setIcon(new ImageIcon("C"+boardH [3][4]+".png"));button25.setActionCommand("nothing");}
			else if(cardnumber==26){button26.setIcon(new ImageIcon("C"+boardH [3][5]+".png"));button26.setActionCommand("nothing");}
			else if(cardnumber==27){button27.setIcon(new ImageIcon("C"+boardH [3][6]+".png"));button27.setActionCommand("nothing");}
			else if(cardnumber==28){button28.setIcon(new ImageIcon("C"+boardH [4][0]+".png"));button28.setActionCommand("nothing");}
			else if(cardnumber==29){button29.setIcon(new ImageIcon("C"+boardH [4][1]+".png"));button29.setActionCommand("nothing");}
			else if(cardnumber==30){button30.setIcon(new ImageIcon("C"+boardH [4][2]+".png"));button30.setActionCommand("nothing");}
			else if(cardnumber==31){button31.setIcon(new ImageIcon("C"+boardH [4][3]+".png"));button31.setActionCommand("nothing");}
			else if(cardnumber==32){button32.setIcon(new ImageIcon("C"+boardH [4][4]+".png"));button32.setActionCommand("nothing");}
			else if(cardnumber==33){button33.setIcon(new ImageIcon("C"+boardH [4][5]+".png"));button33.setActionCommand("nothing");}
			else if(cardnumber==34){button34.setIcon(new ImageIcon("C"+boardH [4][6]+".png"));button34.setActionCommand("nothing");}
			else if(cardnumber==35){button35.setIcon(new ImageIcon("C"+boardH [5][0]+".png"));button35.setActionCommand("nothing");}
			else if(cardnumber==36){button36.setIcon(new ImageIcon("C"+boardH [5][1]+".png"));button36.setActionCommand("nothing");}
			else if(cardnumber==37){button37.setIcon(new ImageIcon("C"+boardH [5][2]+".png"));button37.setActionCommand("nothing");}
			else if(cardnumber==38){button38.setIcon(new ImageIcon("C"+boardH [5][3]+".png"));button38.setActionCommand("nothing");}
			else if(cardnumber==39){button39.setIcon(new ImageIcon("C"+boardH [5][4]+".png"));button39.setActionCommand("nothing");}
			else if(cardnumber==40){button40.setIcon(new ImageIcon("C"+boardH [5][5]+".png"));button40.setActionCommand("nothing");}
			else if(cardnumber==41){button41.setIcon(new ImageIcon("C"+boardH [5][6]+".png"));button41.setActionCommand("nothing");}
			choice++;
		}
	}
	public boolean check(int check1, int check2){
		boolean match=false;
		if (small){
			if((check1==0 && check2==1) ||(check1==1 && check2==0)||(check1==2 && check2==3) ||(check2==2 && check1==3) ||(check1==4 && check2==5) ||(check2==4 && check1==5) ||(check1==6 && check2==7) ||(check2==6 && check1==7) ||(check1==8 && check2==9)||(check2==8 && check1==9)){
				match=true;
			}
		}
		if (medium){
			if((check1==0 && check2==1) ||(check1==1 && check2==0)||(check1==2 && check2==3) ||(check2==2 && check1==3) ||(check1==4 && check2==5) ||(check2==4 && check1==5) ||(check1==6 && check2==7) ||(check2==6 && check1==7) ||(check1==8 && check2==9)||(check2==8 && check1==9)){
				match=true;
			}
			if((check1==10 && check2==11) ||(check1==11 && check2==10)||(check1==12 && check2==13) ||(check2==12 && check1==13) ||(check1==14 && check2==15) ||(check2==14 && check1==15) ||(check1==16 && check2==17) ||(check2==16 && check1==17)){
				match=true;
			}
		}
		if (large){
			if((check1==0 && check2==1) ||(check1==1 && check2==0)||(check1==2 && check2==3) ||(check2==2 && check1==3) ||(check1==4 && check2==5) ||(check2==4 && check1==5) ||(check1==6 && check2==7) ||(check2==6 && check1==7) ||(check1==8 && check2==9)||(check2==8 && check1==9)){
				match=true;
			}
			if((check1==10 && check2==11) ||(check1==11 && check2==10)||(check1==12 && check2==13) ||(check2==12 && check1==13) ||(check1==14 && check2==15) ||(check2==14 && check1==15) ||(check1==16 && check2==17) ||(check2==16 && check1==17) ||(check1==18 && check2==19)||(check2==18 && check1==19)){
				match=true;
			}
			if((check1==20 && check2==21) ||(check1==21 && check2==20)||(check1==22 && check2==23) ||(check2==22 && check1==23) ||(check1==24 && check2==25) ||(check2==24 && check1==25) ||(check1==26 && check2==27) ||(check2==26 && check1==27) ||(check1==28 && check2==29)||(check2==28 && check1==29)){
				match=true;
			}
		}
		if (huge){
			if((check1==0 && check2==1) ||(check1==1 && check2==0)||(check1==2 && check2==3) ||(check2==2 && check1==3) ||(check1==4 && check2==5) ||(check2==4 && check1==5) ||(check1==6 && check2==7) ||(check2==6 && check1==7) ||(check1==8 && check2==9)||(check2==8 && check1==9)){
				match=true;
			}
			if((check1==10 && check2==11) ||(check1==11 && check2==10)||(check1==12 && check2==13) ||(check2==12 && check1==13) ||(check1==14 && check2==15) ||(check2==14 && check1==15) ||(check1==16 && check2==17) ||(check2==16 && check1==17) ||(check1==18 && check2==19)||(check2==18 && check1==19)){
				match=true;
			}
			if((check1==20 && check2==21) ||(check1==21 && check2==20)||(check1==22 && check2==23) ||(check2==22 && check1==23) ||(check1==24 && check2==25) ||(check2==24 && check1==25) ||(check1==26 && check2==27) ||(check2==26 && check1==27) ||(check1==28 && check2==29)||(check2==28 && check1==29)){
				match=true;
			}
			if((check1==30 && check2==31) ||(check1==31 && check2==30)||(check1==32 && check2==33) ||(check2==32 && check1==33) ||(check1==34 && check2==35) ||(check2==34 && check1==35) ||(check1==36 && check2==37) ||(check2==36 && check1==37) ||(check1==38 && check2==39)||(check2==38 && check1==39)){
				match=true;
			}
			if((check1==40 && check2==41) ||(check1==41 && check2==40)){
				match=true;
			}
		}
		return match;
	}
	public void correct(int card1, int card2){
		if(card1==0||card2==0)button0.setEnabled(false);
		if(card1==1||card2==1)button1.setEnabled(false);
		if(card1==2||card2==2)button2.setEnabled(false);
		if(card1==3||card2==3)button3.setEnabled(false);
		if(card1==4||card2==4)button4.setEnabled(false);
		if(card1==5||card2==5)button5.setEnabled(false);
		if(card1==6||card2==6)button6.setEnabled(false);
		if(card1==7||card2==7)button7.setEnabled(false);
		if(card1==8||card2==8)button8.setEnabled(false);
		if(card1==9||card2==9)button9.setEnabled(false);
		
		if(card1==10||card2==10)button10.setEnabled(false);
		if(card1==11||card2==11)button11.setEnabled(false);
		if(card1==12||card2==12)button12.setEnabled(false);
		if(card1==13||card2==13)button13.setEnabled(false);
		if(card1==14||card2==14)button14.setEnabled(false);
		if(card1==15||card2==15)button15.setEnabled(false);
		if(card1==16||card2==16)button16.setEnabled(false);
		if(card1==17||card2==17)button17.setEnabled(false);
		
		if(card1==18||card2==18)button18.setEnabled(false);
		if(card1==19||card2==19)button19.setEnabled(false);
		if(card1==20||card2==20)button20.setEnabled(false);
		if(card1==21||card2==21)button21.setEnabled(false);
		if(card1==22||card2==22)button22.setEnabled(false);
		if(card1==23||card2==23)button23.setEnabled(false);
		if(card1==24||card2==24)button24.setEnabled(false);
		if(card1==25||card2==25)button25.setEnabled(false);
		if(card1==26||card2==26)button26.setEnabled(false);
		if(card1==27||card2==27)button27.setEnabled(false);
		if(card1==28||card2==28)button28.setEnabled(false);
		if(card1==29||card2==29)button29.setEnabled(false);
		
		if(card1==30||card2==30)button30.setEnabled(false);
		if(card1==31||card2==31)button31.setEnabled(false);
		if(card1==32||card2==32)button32.setEnabled(false);
		if(card1==33||card2==33)button33.setEnabled(false);
		if(card1==34||card2==34)button34.setEnabled(false);
		if(card1==35||card2==35)button35.setEnabled(false);
		if(card1==36||card2==36)button36.setEnabled(false);
		if(card1==37||card2==37)button37.setEnabled(false);
		if(card1==38||card2==38)button38.setEnabled(false);
		if(card1==39||card2==39)button39.setEnabled(false);
		if(card1==40||card2==40)button40.setEnabled(false);
		if(card1==41||card2==41)button41.setEnabled(false);
	}
	
	//
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	
	
		
	
	public void failReset(int card1, int card2){
		if((card1==0||card2==0)){button0.setIcon(new ImageIcon("pokeball.png")); button0.setActionCommand("revealcard0");}
		if(card1==1||card2==1){button1.setIcon(new ImageIcon("pokeball.png")); button1.setActionCommand("revealcard1"); }
		if(card1==2||card2==2){button2.setIcon(new ImageIcon("pokeball.png")); button2.setActionCommand("revealcard2"); }
		if(card1==3||card2==3){button3.setIcon(new ImageIcon("pokeball.png")); button3.setActionCommand("revealcard3"); }
		if(card1==4||card2==4){button4.setIcon(new ImageIcon("pokeball.png")); button4.setActionCommand("revealcard4"); }
		if(card1==5||card2==5){button5.setIcon(new ImageIcon("pokeball.png")); button5.setActionCommand("revealcard5"); } 
		if(card1==6||card2==6){button6.setIcon(new ImageIcon("pokeball.png")); button6.setActionCommand("revealcard6"); }
		if(card1==7||card2==7){button7.setIcon(new ImageIcon("pokeball.png")); button7.setActionCommand("revealcard7"); }
		if(card1==8||card2==8){button8.setIcon(new ImageIcon("pokeball.png")); button8.setActionCommand("revealcard8"); }
		if(card1==9||card2==9){button9.setIcon(new ImageIcon("pokeball.png")); button9.setActionCommand("revealcard9"); }
		
		
			if(card1==10||card2==10){button10.setIcon(new ImageIcon("pokeball.png")); button10.setActionCommand("revealcard10");}
			if(card1==11||card2==11){button11.setIcon(new ImageIcon("pokeball.png")); button11.setActionCommand("revealcard11");}
			if(card1==12||card2==12){button12.setIcon(new ImageIcon("pokeball.png")); button12.setActionCommand("revealcard12");}
			if(card1==13||card2==13){button13.setIcon(new ImageIcon("pokeball.png")); button13.setActionCommand("revealcard13");}
			if(card1==14||card2==14){button14.setIcon(new ImageIcon("pokeball.png")); button14.setActionCommand("revealcard14");}
			if(card1==15||card2==15){button15.setIcon(new ImageIcon("pokeball.png")); button15.setActionCommand("revealcard15");}
			if(card1==16||card2==16){button16.setIcon(new ImageIcon("pokeball.png")); button16.setActionCommand("revealcard16");}
			if(card1==17||card2==17){button17.setIcon(new ImageIcon("pokeball.png")); button17.setActionCommand("revealcard17");}
		
		
			if(card1==18||card2==18){button18.setIcon(new ImageIcon("pokeball.png")); button18.setActionCommand("revealcard18");}
			if(card1==19||card2==19){button19.setIcon(new ImageIcon("pokeball.png")); button19.setActionCommand("revealcard19");}
			if(card1==20||card2==20){button20.setIcon(new ImageIcon("pokeball.png")); button20.setActionCommand("revealcard20");}
			if(card1==21||card2==21){button21.setIcon(new ImageIcon("pokeball.png")); button21.setActionCommand("revealcard21");}
			if(card1==22||card2==22){button22.setIcon(new ImageIcon("pokeball.png")); button22.setActionCommand("revealcard22");}
			if(card1==23||card2==23){button23.setIcon(new ImageIcon("pokeball.png")); button23.setActionCommand("revealcard23");}
			if(card1==24||card2==24){button24.setIcon(new ImageIcon("pokeball.png")); button24.setActionCommand("revealcard24");}
			if(card1==25||card2==25){button25.setIcon(new ImageIcon("pokeball.png")); button25.setActionCommand("revealcard25");}
			if(card1==26||card2==26){button26.setIcon(new ImageIcon("pokeball.png")); button26.setActionCommand("revealcard26");}
			if(card1==27||card2==27){button27.setIcon(new ImageIcon("pokeball.png")); button27.setActionCommand("revealcard27");}
			if(card1==28||card2==28){button28.setIcon(new ImageIcon("pokeball.png")); button28.setActionCommand("revealcard28");}
			if(card1==29||card2==29){button29.setIcon(new ImageIcon("pokeball.png")); button29.setActionCommand("revealcard29");}
		
			if(card1==30||card2==30){button30.setIcon(new ImageIcon("pokeball.png")); button30.setActionCommand("revealcard30");}
			if(card1==31||card2==31){button31.setIcon(new ImageIcon("pokeball.png")); button31.setActionCommand("revealcard31");}
			if(card1==32||card2==32){button32.setIcon(new ImageIcon("pokeball.png")); button32.setActionCommand("revealcard32");}
			if(card1==33||card2==33){button33.setIcon(new ImageIcon("pokeball.png")); button33.setActionCommand("revealcard33");}
			if(card1==34||card2==34){button34.setIcon(new ImageIcon("pokeball.png")); button34.setActionCommand("revealcard34");}
			if(card1==35||card2==35){button35.setIcon(new ImageIcon("pokeball.png")); button35.setActionCommand("revealcard35");}
			if(card1==36||card2==36){button36.setIcon(new ImageIcon("pokeball.png")); button36.setActionCommand("revealcard36");}
			if(card1==37||card2==37){button37.setIcon(new ImageIcon("pokeball.png")); button37.setActionCommand("revealcard37");}
			if(card1==38||card2==38){button38.setIcon(new ImageIcon("pokeball.png")); button38.setActionCommand("revealcard38");}
			if(card1==39||card2==39){button39.setIcon(new ImageIcon("pokeball.png")); button39.setActionCommand("revealcard39");}
			if(card1==40||card2==40){button40.setIcon(new ImageIcon("pokeball.png")); button40.setActionCommand("revealcard40");}
			if(card1==41||card2==41){button41.setIcon(new ImageIcon("pokeball.png")); button41.setActionCommand("revealcard41");}
		
	}
	public void endReset(){
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.setLayout(new GridLayout(2,2,0,0));
				if (p1score>p2score) endGame= new JLabel(new ImageIcon("playerOneWins.png"));
				else  endGame=new JLabel(new ImageIcon("playerTwoWins.png"));
				MainMenu=new JButton(new ImageIcon("MainMenu.png")); MainMenu.setActionCommand("MainMenu"); MainMenu.addActionListener(this);	
				quit=new JButton(new ImageIcon("Quit.png")); quit.setActionCommand("Quit"); quit.addActionListener(this);	
				if (small){		again=new JButton(new ImageIcon("PlayAgain.png")); again.setActionCommand("small"); again.addActionListener(this);	}
				else if (medium){		again=new JButton(new ImageIcon("PlayAgain.png")); again.setActionCommand("medium"); again.addActionListener(this);	}
				else if (large){		again=new JButton(new ImageIcon("PlayAgain.png")); again.setActionCommand("large"); again.addActionListener(this);	}
				else if (huge){			again=new JButton(new ImageIcon("PlayAgain.png")); again.setActionCommand("huge"); again.addActionListener(this);	}
				contentPane.add(endGame);
				contentPane.add(MainMenu);
				contentPane.add(again);
				contentPane.add(quit);
				small=false;
				medium=false;
				large=false;
				huge=false;
				playerone=true;
				playertwo=false;
				p1score=0; p2score=0; 
				test++;
				frame.setSize(900, 200);
	}
	
	//
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	
	private static void runGUI(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		Memory greeting = new Memory();
	}
	public static void main (String [] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				runGUI();}
			});
		}
}
