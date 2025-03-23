package RealEstateManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

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
	private static ArrayList<SearchCriteria> searchCriterias;
	
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
		searchCriterias = new ArrayList<SearchCriteria>();
		
		cities.add(new City("defaultCity", 10, 10));
		realEstateOwners.add(new RealEstateOwner("defaultOwner"));
		searchCriterias.add(new SearchCriteria());
		
		printMenu();
		command = getInput(scanner, 9);
		
		
		while(!exit) {
			
			System.out.println();
			switch (command) {
			case 1: 
				System.out.println("Creating");
				System.out.println("--------\n");
				creatingMenu(scanner);
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
				System.out.println("Renter method");
				System.out.println("--------\n");
				renterMenu(scanner);
				break;
			
			case 5: 
				System.out.println("RealEstateAgent method");
				System.out.println("--------\n");
				agentMenu(scanner);
				break;
			
			case 6: 
				System.out.println("House method");
				System.out.println("--------\n");
				houseMenu(scanner);
				break;
			case 7: 
				System.out.println("ApartmentBuilding method");
				System.out.println("--------\n");
				apartmentBuildingMenu(scanner);
				break;
			case 8: 
				System.out.println("Apartment method");
				System.out.println("--------\n");
				apartmentMenu(scanner);
				break;
			case 9: 
				System.out.println("SearchCriteria method");
				System.out.println("--------\n");
				searchCriteriaMenu(scanner);
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
			command = getInput(scanner, 9);
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
		return input.equals("exit");
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
		System.out.println("9. SearchCriteria");
	}

	private static void creatingMenu(Scanner scanner) {
		System.out.println("1. City");
		System.out.println("2. RealEstateOwner");
		System.out.println("3. Renter");
		System.out.println("4. RealEstateAgent");
		System.out.println("5. House");
		System.out.println("6. ApartmentBuilding");
		System.out.println("7. SearchCriteria");
		System.out.println("8. return to Main Menu");
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

				realEstateOwners.add(new RealEstateOwner(name));
				
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
				
				renters.add(new Renter(name));
				
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
			System.out.println("New SearchCriteria created");
			searchCriterias.add(new SearchCriteria());
			break;
		case 8: 
			System.out.println("returning to Main Menu");
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
		System.out.println("7. return to Main Menu");
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
			String input;
			try {
				input = scanner.nextLine();
				exit = checkIfExit(input);
				if(exit) {
					return;
				}
				int x = Integer.parseInt(input);
				if(x < 0) {
					throw new Exception();
				}
				
				input = scanner.nextLine();
				exit = checkIfExit(input);
				if(exit) {
					return;
				}
				int y = Integer.parseInt(input);
				if(y < 0) {
					throw new Exception();
				}
				if(i == 1) {
					if(houses.size() == 0) {
						System.out.println("Need to create a house first. Returning to Main Menu");
						break;
					}
					int size = houses.size();
					System.out.println("select index of house:");
					int k;
					int j = 1;
					int[] convertIndex = new int[size+1];
					for(k = 0; k<size; k++) {
						if(houses.get(k).getCity()==null) {
							System.out.println(j + ": " + houses.get(k));
							convertIndex[j] = k;
							j++;
						}
					}
					if(j == 1) {
						System.out.println("no houses available. Returning to Main Menu");
						break;
					}
					j = getInput(scanner, j-1);
					if(j == 0) { //fix for exit
						break;
					}
					House house = houses.get(convertIndex[j]);
					selectedCity.addProperty(house, x, y);
				}
				else if(i == 2) {
					if(apartmentBuildings.size() == 0) {
						System.out.println("Need to create a apartmentBuilding first. Returning to Main Menu");
						break;
					}
					int size = apartmentBuildings.size();
					System.out.println("select index of apartmentBuilding:");
					int k;
					int j = 1;
					int[] convertIndex = new int[size+1];
					for(k = 0; k<size; k++) {
						if(apartmentBuildings.get(k).getCity()==null) {
							System.out.println(j + ": " + apartmentBuildings.get(k));
							convertIndex[j] = k;
							j++;
						}
					}
					if(j == 1) {
						System.out.println("no apartmentBuildings available. Returning to Main Menu");
						break;
					}
					j = getInput(scanner, j-1);
					if(j == 0) { //fix for exit
						break;
					}
					ApartmentBuilding apartmentBuilding = apartmentBuildings.get(convertIndex[j]);
					selectedCity.addProperty(apartmentBuilding, x, y);
				}
				
			}
			catch (InvalidPropertyDimensionsException e){
				System.out.println(e);
			}
			catch (Exception e){
				System.out.println("Failed. An invalid integer was given");
			}
			
			break;
		
		case 2: 
			System.out.println("removing property");
			System.out.println("1. give x and y");
			System.out.println("2. select house");
			System.out.println("3. select apartmentBuilding");
			int way = getInput(scanner, 3);
			String in;
			boolean success = false;
			
			if(way == 1) {
				System.out.println("give the following: \nx\ny");
				try {
					in = scanner.nextLine();
					exit = checkIfExit(in);
					if(exit) {
						return;
					}
					int x = Integer.parseInt(in);
					if(x < 0) {
						throw new Exception();
					}
					
					in = scanner.nextLine();
					exit = checkIfExit(in);
					if(exit) {
						return;
					}
					int y = Integer.parseInt(in);
					if(y < 0) {
						throw new Exception();
					}
					success = selectedCity.removeProperty(x, y);
				}
				catch (Exception e){
					System.out.println("invalid x or y");
				}
				
			}
			else if(way == 2) {
				if(houses.size() == 0) {
					System.out.println("Need to create and add a house first. Returning to Main Menu");
					break;
				}
				int size = houses.size();
				System.out.println("select index of house:");
				int k;
				int j = 1;
				int[] convertIndex = new int[size+1];
				for(k = 0; k<size; k++) {
					if(houses.get(k).getCity()!=null) {
						System.out.println(j + ": " + houses.get(k));
						convertIndex[j] = k;
						j++;
					}
				}
				if(j == 1) {
					System.out.println("no houses available. Returning to Main Menu");
					break;
				}
				j = getInput(scanner, j-1);
				if(j == 0) { //fix for exit
					break;
				}
				House house = houses.get(convertIndex[j]);
				success = selectedCity.removeProperty(house);
			}
			else if(way == 3) {
				if(apartmentBuildings.size() == 0) {
					System.out.println("Need to create a apartmentBuilding first. Returning to Main Menu");
					break;
				}
				int size = apartmentBuildings.size();
				System.out.println("select index of apartmentBuilding:");
				int k;
				int j = 1;
				int[] convertIndex = new int[size+1];
				for(k = 0; k<size; k++) {
					if(apartmentBuildings.get(k).getCity()!=null) {
						System.out.println(j + ": " + apartmentBuildings.get(k));
						convertIndex[j] = k;
						j++;
					}
				}
				if(j == 1) {
					System.out.println("no apartmentBuildings available. Returning to Main Menu");
					break;
				}
				j = getInput(scanner, j-1);
				if(j == 0) { //fix for exit
					break;
				}
				ApartmentBuilding apartmentBuilding = apartmentBuildings.get(convertIndex[j]);
				success = selectedCity.removeProperty(apartmentBuilding);
			}
			if(success) {
				System.out.println("remove succeeded");
			}
			else {
				System.out.println("remove failed");
			}
			
			
			break;
		
		case 3: 
			selectedCity.displayGrid();
			System.out.println("hit enter/return to continue to Main Menu");
			exit = checkIfExit(scanner.nextLine());
			
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
			catch (PropertyNotFoundException e){
				System.out.println(e);
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
			System.out.println("searching Properties");
			SearchCriteria sc = selectObject(scanner, searchCriterias);
			Set<RealEstate> validEstates = selectedCity.searchProperties(sc);
			Iterator<RealEstate> iterator = validEstates.iterator();
			System.out.println("List of properties that meet the criteria:");
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			break;
		
		case 6: 
			System.out.println(selectedCity);
			break;
		case 7: 
			System.out.println("returning to Main Menu");
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
		System.out.println("1. expand");
		System.out.println("2. getRent");
		System.out.println("3. set");
		System.out.println("4. return to Main Menu");
		int i = getInput(scanner, 4);
		int j;
		
		if(i == 1) {
			try {
				System.out.println("give the following:\nx\ny");
				String input;
				input = scanner.nextLine();
				int x = Integer.parseInt(input);
				if(x < 0) {
					throw new Exception();
				}
				
				input = scanner.nextLine();
				exit = checkIfExit(input);
				if(exit) {
					return;
				}
				int y = Integer.parseInt(input);
				if(y < 0) {
					throw new Exception();
				}
				house.expand(x, y);
			}
			catch (InvalidPropertyDimensionsException e) {
				System.out.println(e);
			}
			catch (PropertyAlreadyExistsException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println("expand failed. Returning to Main Menu");
			}
		}
		if(i == 2) {
			System.out.println("This house's rent is $" + house.getRent());
		}
		if(i == 3) {
			boolean repeat = true;
			while(repeat) {
				System.out.println("Select an option\n--------");
				System.out.println("1. setIsForSale");
				System.out.println("2. setNotForSale");
				System.out.println("3. setIsForRent");
				System.out.println("4. setNotForRent");
				System.out.println("5. setAddress");
				System.out.println("6. setHasYard");
				System.out.println("7. setHasPool");
				System.out.println("8. setStyle");
				System.out.println("9. return to Main Menu");
				j = getInput(scanner, 9);
				
				String input;
				int bool;
				switch (j) {
				case 1:
					house.setIsForSale();
					break;
					
					
				case 2:
					house.setNotForSale();
					break;
				case 3:
					house.setIsForRent();
					break;
					
				case 4:
					house.setNotForRent();
					break;
				case 5:
					System.out.println("give new address:");
					String address = scanner.nextLine();
					exit = checkIfExit(address);
					if(exit) {
						return;
					}
					house.setStyle(address);
					break;
				case 6:
					System.out.println("set hasYard true(1) or false(2):");
					bool = getInput(scanner, 2);
					house.setHasYard(bool==1);
					break;
				case 7:
					System.out.println("set HasPool true(1) or false(2):");
					bool = getInput(scanner, 2);
					house.setHasPool(bool==1);
					break;
				case 8:
					System.out.println("give Style:");
					String style = scanner.nextLine();
					exit = checkIfExit(style);
					if(exit) {
						return;
					}
					house.setStyle(style);
					break;
				case 9:
					repeat = false;
					break;
				}
			}
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

	private static void searchCriteriaMenu(Scanner scanner) {
		SearchCriteria selectedCriteria = selectObject(scanner, searchCriterias);
		System.out.println("1. get");
		System.out.println("2. set");
		System.out.println("3. return to Main Menu");
		int i = getInput(scanner, 3);
		int j;
		
		if(i == 1) {
			System.out.println("Select criteria to get\n--------");
			System.out.println("1. maxPrice");
			System.out.println("2. minSize");
			System.out.println("3. forSale");
			System.out.println("4. forRent");
			System.out.println("5. hasYard");
			System.out.println("6. hasPool");
			System.out.println("7. style");
			j = getInput(scanner, 7);
			
			switch (j) {
			case 1:
				System.out.println("maxPrice: " + selectedCriteria.getMaxPrice());
				break;
			case 2:
				System.out.println("minSize: " + selectedCriteria.getMinSize());
				break;
			case 3:
				System.out.println("forSale: " + selectedCriteria.getForSale());
				break;
			case 4:
				System.out.println("forRent: " + selectedCriteria.getForRent());
				break;
			case 5:
				System.out.println("hasYard: " + selectedCriteria.getHasYard());
				break;
			case 6:
				System.out.println("hasPool: " + selectedCriteria.getHasPool());
				break;
			case 7:
				System.out.println("style: " + selectedCriteria.getStyle());
				break;
			}
		}
		if(i == 2) {
			boolean repeat = true;
			while(repeat) {
				System.out.println("Select criteria to set\n--------");
				System.out.println("1. maxPrice");
				System.out.println("2. minSize");
				System.out.println("3. forSale");
				System.out.println("4. forRent");
				System.out.println("5. hasYard");
				System.out.println("6. hasPool");
				System.out.println("7. style");
				System.out.println("8. return to Main Menu");
				j = getInput(scanner, 8);
				
				String input;
				int bool;
				switch (j) {
				case 1:
					System.out.println("give MaxPrice:");
					input = scanner.nextLine();
					exit = checkIfExit(input);
					if(exit) {
						return;
					}
					try {
						double price = Double.parseDouble(input);
						if(price < 0) {
							throw new Exception();
						}
						selectedCriteria.setMaxPrice(price);
					}
					catch (Exception e){
						System.out.println("not a valid double");
					}
					break;
					
					
				case 2:
					System.out.println("give minSize:");
					input = scanner.nextLine();
					exit = checkIfExit(input);
					if(exit) {
						return;
					}
					try {
						int size = Integer.parseInt(input);
						if(size <= 0) {
							throw new Exception();
						}
						selectedCriteria.setMinSize(size);
					}
					catch (Exception e){
						System.out.println("not a valid int");
					}
					break;
				case 3:
					System.out.println("set ForSale true(1) or false(2):");
					bool = getInput(scanner, 2);
					selectedCriteria.setForSale(bool==1);
					break;
					
				case 4:
					System.out.println("set ForRent true(1) or false(2):");
					bool = getInput(scanner, 2);
					selectedCriteria.setForRent(bool==1);
					break;
				case 5:
					System.out.println("set hasYard true(1) or false(2):");
					bool = getInput(scanner, 2);
					selectedCriteria.setHasYard(bool==1);
					break;
				case 6:
					System.out.println("set HasPool true(1) or false(2):");
					bool = getInput(scanner, 2);
					selectedCriteria.setHasPool(bool==1);
					break;
				case 7:
					System.out.println("give Style:");
					String style = scanner.nextLine();
					exit = checkIfExit(style);
					if(exit) {
						return;
					}
					selectedCriteria.setStyle(style);
					break;
				case 8:
					repeat = false;
					break;
					
				}
				
			}
		}
	}

	private static <T> T selectObject(Scanner scanner, ArrayList<T> list) {
		if(list.size() == 0) {
			System.out.println("Need to create another object first. Returning to Main Menu");
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

