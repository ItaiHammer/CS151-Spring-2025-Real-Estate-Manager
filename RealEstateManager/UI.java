package RealEstateManager;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	
	private static boolean exit = false;
	private static ArrayList<City> cities; 
	private static ArrayList<RealEstateOwner> realEstateOwners;
	private static ArrayList<Renter> renters;
	private static ArrayList<RealEstateAgent> realEstateAgents;
	private static ArrayList<House> houses;
	private static ArrayList<ApartmentBuilding> apartmentBuildings;
	private static ArrayList<Apartment> apartments;
	private static ArrayList<BankAccount> bankAccounts;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int command = 0;
		cities = new ArrayList<City>();
		realEstateOwners = new ArrayList<RealEstateOwner>();
		renters = new ArrayList<Renter>();
		realEstateAgents = new ArrayList<RealEstateAgent>();
		houses = new ArrayList<House>();
		apartmentBuildings = new ArrayList<ApartmentBuilding>();
		apartments = new ArrayList<Apartment>();
		bankAccounts = new ArrayList<BankAccount>();
		
		printMenu();
		command = getInput(scanner, 8);
		
		
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
				cityMenu(scanner);
				break;
			
			case 3: 
				System.out.println("RealEstateOwner method");
				System.out.println("--------\n");
				ownerMenu(scanner);
				break;
			
			case 4: 
				System.out.println("Renter");
				System.out.println("--------\n");
				renterMenu(scanner);
				break;
			
			case 5: 
				System.out.println("RealEstateAgent");
				System.out.println("--------\n");
				agentMenu(scanner);
				break;
			
			case 6: 
				System.out.println("House");
				System.out.println("--------\n");
				houseMenu(scanner);
				break;
			case 7: 
				System.out.println("ApartmentBuilding");
				System.out.println("--------\n");
				apartmentBuildingMenu(scanner);
				break;
			case 8: 
				System.out.println("Apartment");
				System.out.println("--------\n");
				apartmentMenu(scanner);
				break;
			default:
				System.out.println("error: how did this happen");
				break;
			}
			
			if(exit) {
				break;
			}
			System.out.println();
			printMenu();
			command = getInput(scanner, 8);
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
		System.out.println("3. RealEstateOwner");
		System.out.println("4. Renter");
		System.out.println("5. RealEstateAgent");
		System.out.println("6. House");
		System.out.println("7. ApartmentBuilding");
		System.out.println("8. Apartment");
		
		
	}

	private static void creatingMenu(Scanner scanner) {
		System.out.println("1. City");
		System.out.println("2. RealEstateOwner");
		System.out.println("3. Renter");
		System.out.println("4. RealEstateAgent");
		System.out.println("5. House");
		System.out.println("6. ApartmentBuilding");
		System.out.println("7. BankAccount");
		System.out.println("8. return to main Menu");
		int command = getInput(scanner, 8);
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
					return;
				}
				int width = scanner.nextInt();
				
				int height = scanner.nextInt();
				
				cities.add(new City(name, width, height));
				System.out.println("city has been created");
				
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			scanner.nextLine();
			break;
		
		case 2: 
			System.out.println("Creating RealEstateOwner. Give name:");
			try {
				String name = scanner.nextLine();
				exit = checkIfExit(name);
				if(exit) {
					return;
				}
				BankAccount bankAccount = selectObject(scanner, bankAccounts);
				if(bankAccount == null) {
					return;
				}
				realEstateOwners.add(new RealEstateOwner(name, bankAccount));
				
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			break;
		
		case 3: 
			System.out.println("Creating Renter. Give name");
			try {
				String name = scanner.nextLine();
				exit = checkIfExit(name);
				if(exit) {
					return;
				}
				BankAccount bankAccount = selectObject(scanner, bankAccounts);
				renters.add(new Renter(name, bankAccount));
				
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			break;
		
		case 4: 
			System.out.println("Creating RealEstateAgent. Give the commission rate:");
			try {
				String input = scanner.nextLine();
				exit = checkIfExit(input);
				if(exit) {
					return;
				}
				double rate = Double.parseDouble(input);
				
				System.out.println("Select person. Is the person a:");
				System.out.println("1: RealEstateOwner");
				System.out.println("2: Renter");
				int i = getInput(scanner, 2);
				if(i == 1) {
					RealEstateOwner person = selectObject(scanner, realEstateOwners);
					if(person == null) {
						return;
					}
					realEstateAgents.add(new RealEstateAgent(rate, person));
				}
				else {
					Renter person = selectObject(scanner, renters);
					if(person == null) {
						return;
					}
					realEstateAgents.add(new RealEstateAgent(rate, person));
				}
				
				
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			break;
		
		case 5: 
			System.out.println("Creating House.");
			RealEstateOwner owner = selectObject(scanner, realEstateOwners);
			if(owner == null) {
				return;
			}
			System.out.println("Give remaining details in the following format:");
			System.out.println("address\nprice\nwidth\nheight");
			try {
				String address = scanner.nextLine();
				exit = checkIfExit(address);
				if(exit) {
					return;
				}
				double price = scanner.nextInt();
				
				int width = scanner.nextInt();
				
				int height = scanner.nextInt();
				
				houses.add(new House(address, price, width, height, owner));
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			scanner.nextLine();
			break;
		
		case 6: 
			System.out.println("Creating ApartmentBuilding.");
			RealEstateOwner aOwner = selectObject(scanner, realEstateOwners);
			if(aOwner == null) {
				return;
			}
			System.out.println("Give remaining details in the following format:");
			System.out.println("address\nprice\nwidth\nheight\nfloors\nunitsPerFloor");
			try {
				String address = scanner.nextLine();
				exit = checkIfExit(address);
				if(exit) {
					return;
				}
				double price = scanner.nextDouble();
				
				int width = scanner.nextInt();
				
				int height = scanner.nextInt();

				int floors = scanner.nextInt();
				
				int unitsPerFloor = scanner.nextInt();
				
				if(floors <= 0 || unitsPerFloor <= 0) {
					System.out.println("create failed. Invalid floor or unit count");
					return;
				}
				
				ApartmentBuilding building = new ApartmentBuilding(address, price, width, height, aOwner, floors, unitsPerFloor);
				
				apartmentBuildings.add(building);
				for(int i = 0; i < floors; i++) {
					for(int j = 0; j < unitsPerFloor; j++) {
						apartments.add(building.getApartment(i, j));
					}
				}
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			scanner.nextLine();
			break;
			
		case 7: 
			System.out.println("Creating BankAccount. Give the balance:");
			try {
				String input = scanner.nextLine();
				exit = checkIfExit(input);
				if(exit) {
					return;
				}
				double balance = Double.parseDouble(input);
				bankAccounts.add(new BankAccount(balance));
				
			}
			catch (Exception e){
				System.out.println("create failed. Invalid details");
			}
			break;
			
		case 8: 
			System.out.println("returning to main menu");
			break;
		default:
			System.out.println("error: how did this happen");
			break;
		}
		
	}
	
	
	private static void cityMenu(Scanner scanner) {
		
		City selectedCity = selectObject(scanner, cities);
		if(selectedCity == null) {
			return;
		}
		
		System.out.println("Select Method");
		System.out.println("1. addProperty");
		System.out.println("2. removeProperty");
		System.out.println("3. displayGrid");
		System.out.println("4. findProperty");
		System.out.println("5. searchProperties");
		System.out.println("6. print toString");
		System.out.println("7. return to main Menu");
		int command = getInput(scanner, 7);
		if(exit) {
			return;
		}
		
		switch (command) {
		case 1: 
			System.out.println("adding property. Select type of property:");
			
			System.out.println("1. House");
			System.out.println("2. apartmentBuilding");
			
			int i = getInput(scanner, 2);
			
			System.out.println("Input location in the following format: ");
			System.out.println("\nx\ny");
			try {
				int x = scanner.nextInt();
				
				int y = scanner.nextInt();
				scanner.nextLine();
				
				if(i == 1) {
					House house = selectObject(scanner, houses);
					selectedCity.addProperty(house, x, y);
				}
				else if(i == 2) {
					ApartmentBuilding apartmentBuilding = selectObject(scanner, apartmentBuildings);
					selectedCity.addProperty(apartmentBuilding, x, y);
				}
				
			}
			catch (Exception e){
				System.out.println("create failed. Invalid x or y");
			}
			break;
		
		case 2: 
			System.out.println("removing property");
			//todo
			break;
		
		case 3: 
			selectedCity.displayGrid();
			break;
		
		case 4: 
			System.out.println("finding property. Give details in the following format:");
			System.out.println("x\ny");
			System.out.println("OR in the following format:");
			System.out.println("address");
			try {
				int x = scanner.nextInt();
				
				int y = scanner.nextInt();
				
				RealEstate property = selectedCity.findProperty(x, y);
				System.out.println(property);
				scanner.nextLine();
			}
			catch (Exception e){
				try {
					String address = scanner.nextLine();
					exit = checkIfExit(address);
					if(exit) {
						return;
					}
					RealEstate property = selectedCity.findProperty(address);
					System.out.println(property);
				}
				catch (Exception e2) {
					System.out.println("create failed. Invalid details");
				}
				
			}
			break;
		
		case 5: 
			System.out.println("searchProperties");
			//todo
			break;
		
		case 6: 
			System.out.println(selectedCity);
			break;
		case 7: 
			System.out.println("returning to main menu");
			break;
		default:
			System.out.println("error: how did this happen");
			break;
		}
		
	}

	private static void ownerMenu(Scanner scanner) {
		RealEstateOwner owner = selectObject(scanner, realEstateOwners);
		if(owner == null) {
			return;
		}
	}
	
	private static void renterMenu(Scanner scanner) {
		Renter renter = selectObject(scanner, renters);
		if(renter == null) {
			return;
		}
		
	}
	
	private static void agentMenu(Scanner scanner) {
		RealEstateAgent realEstateAgent = selectObject(scanner, realEstateAgents);
		if(realEstateAgent == null) {
			return;
		}
		
	}
	private static void houseMenu(Scanner scanner) {
		House house = selectObject(scanner, houses);
		if(house == null) {
			return;
		}
		
	}
	private static void apartmentBuildingMenu(Scanner scanner) {
		ApartmentBuilding apartmentBuilding = selectObject(scanner, apartmentBuildings);
		if(apartmentBuilding == null) {
			return;
		}
		
	}
	
	private static void apartmentMenu(Scanner scanner) {
		Apartment apartment = selectObject(scanner, apartments);
		if(apartment == null) {
			return;
		}
	}




	private static <T> T selectObject(Scanner scanner, ArrayList<T> list) {
		if(list.size() == 0) {
			System.out.println("Need to create another object first. Returning to main menu");
			return null;
		}
		int size = list.size();
		System.out.println("select index of object");
		int i;
		for(i = 1; i<=size; i++) {
			System.out.println(i + ": " + list.get(i-1));
		}
		i = getInput(scanner, i-1);
		if(i == 0) { //fix for exit
			return null;
		}
		return list.get(i-1);
	}
	
}

