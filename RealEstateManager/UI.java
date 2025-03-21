package RealEstateManager;

import java.util.Scanner;

public class UI {
	
	static boolean exit = false;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int command = 0;
		
		printMenu();
		command = getInput(scanner, 6);
		
		
		while(!exit) {
			
			System.out.println();
			switch (command) {
			case 1: 
				System.out.println("Creating");
				System.out.println("--------\n");
				creatingMenu(scanner);
				System.out.println("done creating");
				break;
			
			case 2: 
				System.out.println("City method");
				System.out.println("--------\n");
				//cityMenu();
				break;
			
			case 3: 
				System.out.println("RealEsateOwner method");
				System.out.println("--------\n");
				//ownerMenu();
				break;
			
			case 4: 
				System.out.println("Renter");
				System.out.println("--------\n");
				//renterMenu();
				break;
			
			case 5: 
				System.out.println("RealEsateAgent");
				System.out.println("--------\n");
				//agentMenu();
				break;
			
			case 6: 
				System.out.println("choose RealEstate");
				System.out.println("--------\n");
				break;
			default:
				System.out.println("error: how did this happen");
				break;
			}
			
			if(exit) {
				break;
			}
			System.out.println("here");
			printMenu();
			command = getInput(scanner, 6);
		}
		
		System.out.println("closing program");
		
		scanner.close();

	}
	
	
	
	
	//returns a valid input. Recursively calls itself until a valid input is given.
	//Also stops if input is "exit", and sets exit to true.
	private static int getInput(Scanner scanner, int max) {
		
		System.out.println("\nEnter a choice (1-" + max + "):");
		String input = scanner.nextLine();
		exit = checkIfExit(input);
		if(exit) {
			return 0;
		}
		int i = 0;
		try {
			i = Integer.parseInt(input);
		}
		catch (NumberFormatException e) {
			System.out.println("invalid input: not an integer");
			return getInput(scanner, max);
		}
		
		if(i > max || i < 1) {
			System.out.println("invalid input: not 1-" + max);
			return getInput(scanner, max);
			
		}
		return i;
		
	}




	private static boolean checkIfExit(String input) {
		input = input.toLowerCase();
		if(input.equals("exit")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void printMenu() {
		System.out.println("Main Menu");
		System.out.println("------------------------------\n");
		System.out.println("1. Create");
		System.out.println("2. City");
		System.out.println("3. RealEsateOwner");
		System.out.println("4. Renter");
		System.out.println("5. RealEsateAgent");
		System.out.println("6. RealEstate");
		
		
	}

	private static void creatingMenu(Scanner scanner) {
		System.out.println("1. City");
		System.out.println("2. RealEsateOwner");
		System.out.println("3. Renter");
		System.out.println("4. RealEsateAgent");
		System.out.println("5. house");
		System.out.println("6. ApartmentBuilding");
		System.out.println("7. return to main Menu");
		int command = getInput(scanner, 7);
		if(exit) {
			return;
		}
		
		switch (command) {
		case 1: 
			System.out.println("Creating City. Give details in the following format:");
			System.out.println("name\nwidth\nheight");
			try {
				String name = scanner.nextLine();
				exit = checkIfExit(name);
				if(exit) {
					System.out.println("stopping");
					return;
				}
				int width = scanner.nextInt();
				
				int height = scanner.nextInt();
				
				City city = new City(name, width, height);
				System.out.println("city has been created");
				
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			scanner.nextLine();
			break;
		
		case 2: 
			System.out.println("City method");
			System.out.println("--------\n");
			//cityMenu();
			break;
		
		case 3: 
			System.out.println("RealEsateOwner method");
			System.out.println("--------\n");
			//ownerMenu();
			break;
		
		case 4: 
			System.out.println("Renter");
			System.out.println("--------\n");
			//renterMenu();
			break;
		
		case 5: 
			System.out.println("RealEsateAgent");
			System.out.println("--------\n");
			//agentMenu();
			break;
		
		case 6: 
			System.out.println("choose RealEstate");
			System.out.println("--------\n");
			break;
		case 7: 
			System.out.println("returning to main menu");
			break;
		default:
			System.out.println("error: how did this happen");
			break;
		}
		
	}
	
}

