import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class TicTacToe extends Applet implements ActionListener
{
	private static final long serialVersionUID = 1L;
	Label header = new Label("Player X make your move!", Label.CENTER);
	Button typeButton = new Button();
	Panel playPanel = new Panel();
	Button[][] box = new Button[3][3];
	boolean moved = false;
	boolean firstPlayer = true;
	boolean gameType = true;
	boolean playEnabled = true;
	int[] score = new int[3];
	int turnNum = 0;
	public void init()
	{
		playPanel.setLayout(new GridLayout(3,3));
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{	
				box[i][j] = new Button("");
				box[i][j].addActionListener(this);
				playPanel.add(box[i][j]);
				score[i] = 0;
			}
		}
		typeButton = new Button("Switch Game Type to Single Player");
		typeButton.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.add("North", header);
		this.add("Center",playPanel);
		this.add("South",typeButton);
		this.setSize(new Dimension(250, 250));
		this.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		header.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		typeButton.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				box[i][j].setBackground(null);
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		String blank[] = new String[9];
		int index = 0;
		String turn = "O";
		String turn2 = "X";
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if(e.getSource() == box[i][j] && box[i][j].getLabel().equals("") && playEnabled)
				{
					go(i,j);
					moved = false;
					if (!gameType && playEnabled)
					{
						for (int k = 0; k < 3; k++)
						{
							for (int l = 0; l < 3; l++)
							{
								if (box[k][l].getLabel() == "")
								{
									blank[index] = Integer.toString(k) + Integer.toString(l);
									index++;
								}
							}
						}
						for (int k = 0; k < 2; k++)
						{	
							if (k == 1)
							{
								turn = "X";
								turn2 = "O";
							}
							if (!moved && playEnabled)
							{
								if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals(turn2) && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn2) && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals(turn) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn2) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals(turn2)) go(0, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals(turn2) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn2) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(0, 1);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals(turn) && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals(turn2) && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn2) && box[2][2].getLabel().equals("")) go(2, 0);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn2) && box[2][2].getLabel().equals("")) go(1, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals(turn2) && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals(turn2)) go(1, 0);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals(turn2) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn2) && box[2][2].getLabel().equals("")) go(1, 0);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals(turn2) && box[2][0].getLabel().equals(turn2) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(0, 1);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals(turn) && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn2) && box[2][2].getLabel().equals("")) go(2, 0);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals(turn) && box[0][2].getLabel().equals(turn2) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn2) && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals(turn) && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals(turn2) && box[2][0].getLabel().equals(turn2) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals(turn) && box[0][1].getLabel().equals(turn2) && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals(turn2)) go(1, 0);
								else if (box[0][0].getLabel().equals(turn) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals(turn2) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals("") && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals(turn) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals("") && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn2) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals(turn) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals("") && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 0);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals(turn2) && box[0][2].getLabel().equals(turn) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn2) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(1, 2);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals("") && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(0, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals(turn2) && box[1][0].getLabel().equals(turn2) && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 1);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals("") && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals(turn2)) go(0, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals(turn2) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals("") && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals(turn)) go(0, 0);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals(turn2) && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals(turn)) go(2, 1);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals("") && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn2) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals(turn)) go(0, 0);
								else if (box[0][0].getLabel().equals(turn2) && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn2) && box[2][2].getLabel().equals(turn)) go(1, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals(turn) && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn2) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 0);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals("") && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals("") && box[1][1].getLabel().equals(turn2) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals(turn) && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(0, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals(turn2) && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals(turn2) && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals(turn) && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals("") && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals("") && box[0][1].getLabel().equals(turn2) && box[0][2].getLabel().equals("") && box[1][0].getLabel().equals(turn2) && box[1][1].getLabel().equals(turn) && box[1][2].getLabel().equals("") && box[2][0].getLabel().equals("") && box[2][1].getLabel().equals(turn) && box[2][2].getLabel().equals("")) go(2, 2);
								else if (box[0][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[2][2].getLabel().equals(turn)) go(0,0);
								else if (box[1][1].getLabel().equals("") && ((box[0][0].getLabel().equals(turn) && box[2][2].getLabel().equals(turn)) || (box[0][2].getLabel().equals(turn) && box[2][0].getLabel().equals(turn)))) go(1,1);
								else if (box[2][2].getLabel().equals("") && (box[0][0].getLabel()).equals(turn) && box[1][1].getLabel().equals(turn)) go(2,2);
								else if (box[0][2].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[2][0].getLabel().equals(turn)) go(0,2);
								else if (box[2][0].getLabel().equals("") && box[1][1].getLabel().equals(turn) && box[0][2].getLabel().equals(turn)) go(2,0);
								else
								{
									for (int l = 0; l < index && !moved && playEnabled; l++)
									{
										if(blank[l].substring(0,1).equals("0") && box[1][Integer.parseInt(blank[l].substring(1))].getLabel().equals(turn) && box[2][Integer.parseInt(blank[l].substring(1))].getLabel().equals(turn)
												|| blank[l].substring(0,1).equals("1") && box[0][Integer.parseInt(blank[l].substring(1))].getLabel().equals(turn) && box[2][Integer.parseInt(blank[l].substring(1))].getLabel().equals(turn)
												|| blank[l].substring(0,1).equals("2") && box[0][Integer.parseInt(blank[l].substring(1))].getLabel().equals(turn) && box[1][Integer.parseInt(blank[l].substring(1))].getLabel().equals(turn)
												|| blank[l].substring(1).equals("0") && box[Integer.parseInt(blank[l].substring(0,1))][1].getLabel().equals(turn) && box[Integer.parseInt(blank[l].substring(0,1))][2].getLabel().equals(turn)
												|| blank[l].substring(1).equals("1") && box[Integer.parseInt(blank[l].substring(0,1))][0].getLabel().equals(turn) && box[Integer.parseInt(blank[l].substring(0,1))][2].getLabel().equals(turn)
												|| blank[l].substring(1).equals("2") && box[Integer.parseInt(blank[l].substring(0,1))][0].getLabel().equals(turn) && box[Integer.parseInt(blank[l].substring(0,1))][1].getLabel().equals(turn))
										{
											go(Integer.parseInt(blank[l].substring(0,1)),Integer.parseInt(blank[l].substring(1)));
										}
									}
								}
							}	
						}
						if (box[1][1].getLabel().equals("") && !moved && playEnabled)
						{
							go(1,1);
						}
						else if(!moved && playEnabled)
						{
							go(Integer.parseInt(blank[0].substring(0,1)),Integer.parseInt(blank[0].substring(1)));
						}
					}	
				}
				else if((e.getSource() == box[i][j]) && !playEnabled)
				{
					newGame();
				}
				else if(e.getSource() == typeButton)
				{
					if (gameType)
					{
						gameType = false;
						typeButton.setLabel("Switch Game Type to Multi Player");
						score[0] = 0;
						score[1] = 0;
						score[2] = 0;
					}
					else
					{
						gameType = true;
						typeButton.setLabel("Switch Game Type to Single Player");
					}
					firstPlayer = false;
					newGame();
				}
			}
		}
	}
	public void go(int y, int x)
	{
		moved = true;
		turnNum++;
		if (turnNum % 2 == 0 && !firstPlayer || turnNum % 2 == 1 && firstPlayer)
		{
			box[y][x].setLabel("X");
		}
		else if (turnNum % 2 == 1 && !firstPlayer || turnNum % 2 == 0 && firstPlayer)
		{
			box[y][x].setLabel("O");
		}
		if (!box[y][0].getLabel().equals("") && box[y][0].getLabel().equals(box[y][1].getLabel()) && box[y][1].getLabel().equals(box[y][2].getLabel()))
		{	
			box[y][0].setBackground(Color.red);
			box[y][1].setBackground(Color.red);
			box[y][2].setBackground(Color.red);
			playEnabled = false;
		}
		else if (!box[0][x].getLabel().equals("") && box[0][x].getLabel().equals(box[1][x].getLabel()) && box[1][x].getLabel().equals(box[2][x].getLabel()))
		{	
			box[0][x].setBackground(Color.red);
			box[1][x].setBackground(Color.red);
			box[2][x].setBackground(Color.red);
			playEnabled = false;
		}
		else if (!box[0][0].getLabel().equals("") && box[0][0].getLabel().equals(box[1][1].getLabel()) && box[1][1].getLabel().equals(box[2][2].getLabel()))
		{	
			box[0][0].setBackground(Color.red);
			box[1][1].setBackground(Color.red);
			box[2][2].setBackground(Color.red);
			playEnabled = false;
		}
		else if (!box[0][2].getLabel().equals("") && box[0][2].getLabel().equals(box[1][1].getLabel()) && box[1][1].getLabel().equals(box[2][0].getLabel()))
		{	
			box[0][2].setBackground(Color.red);
			box[1][1].setBackground(Color.red);
			box[2][0].setBackground(Color.red);
			playEnabled = false;
		}
		if(!playEnabled)
		{
			header.setText("Player " + box[y][x].getLabel() + " wins! Click to begin a new game!");
			if (!gameType)
			{
				if(box[y][x].getLabel().equals("X"))
				{
					score[0]++;
				}
				else
				{
					score[2]++;
				}
			}
		}
		else if(turnNum == 9)
		{
			header.setText("Cat's Game! Click to begin a new game!");
			playEnabled = false;
			if (!gameType)
			{
				score[1]++;
			}
		}
		else if (gameType)
		{
			header.setText("Player " + (box[y][x].getLabel().equals("O") ? "X" : "O") + " make your move!");
		}
	}
	public void newGame()
	{
		turnNum = 0;
		playEnabled = true;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				box[i][j].setLabel("");
				box[i][j].setBackground(null);
			}
		}
		if (gameType)
		{
			header.setText(firstPlayer ? "Player O make your move!" : "Player X make your move!");
		}
		else
		{
			header.setText("Player: " + Integer.toString(score[0]) + " Cat's: " + Integer.toString(score[1]) + " Computer: " + Integer.toString(score[2]));
		}
		firstPlayer = firstPlayer ? false : true;
		if (!gameType && !firstPlayer)
		{
			go(1,1);
		}
	}
}

