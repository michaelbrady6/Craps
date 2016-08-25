import java.util.Scanner;

public class crapsSimulation
	{
		static int dice1;
		static int dice2;
		static int total;
		static int point;
		static int money;
		static int wager;
		public static void main(String[] args)
			{
				money = 10000;
				boolean stillRolling = true;
				Scanner input2 = new Scanner(System.in);
				Scanner input = new Scanner(System.in);
				System.out.println("What is your name?");
				String name = input.nextLine();
				System.out.println("Hello " + name);
				System.out.println("You have $" + money + ". How much are you willing to wager?");
				wager = input2.nextInt();
				if(wager > money)
					{
						System.out.println("that is too much");
					}
				System.out.println("Press enter to roll");
				String roll = input.nextLine();
				rollDice();
				if (total == 2 || total == 12)
					{
						lose();
						System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + total
								+ ". You lose! You have $" + money);
						stillRolling = false;
					} 
				else if (total == 7 || total == 11)
					{
						win();
						System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + total
								+ ". You win! You have $" + money);
						stillRolling = false;
					} 
					else
					{
						System.out.println("You rolled a " + dice1 + " and a " + dice2 + ". Your point is " + total + ". Roll again");
					}
				point = total;
				while (stillRolling == true)
					{
						String roll2 = input.nextLine();
						rollDice();
						if (total == 7)
							{
								lose();
								System.out.println("Your point is " + point + ". But you rolled a " + dice1 + " and a "
										+ dice2 + " for a total of " + total + ". You lose! You have $" + money);
								stillRolling = false;
							} 
						else if (total == point)
							{
								win();
								System.out.println("Your point is " + point + " and you rolled a " + dice1 + " and a "
										+ dice2 + " for a total of " + total + ". You win! You have $" + money);
								stillRolling = false;
							} 
							else
							{
								System.out.println("Your point is " + point + ". But you rolled a " + dice1 + " and a "
										+ dice2 + " for a total of " + total + ". Roll again");
							}
					}
			}
		public static int rollDice()
		{
			dice1 = (int) (Math.random() * 6 + 1);
			dice2 = (int) (Math.random() * 6 + 1);
			total = dice1 + dice2;
			return total;
		}
		public static int win()
		{
			money = money + wager;
			return money;
		}
		public static int lose()
			{
				money = money - wager;
				return money;
			}
	}
