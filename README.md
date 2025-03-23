# Real Estate Manager

## Overview
The Real Estate Manager program is designed to simulate and manage real estate properties like houses, apartment, and apartment buildings. Using a city grid, it allows the user to build, manage, and look for properties. The tool supports a variety of different ways to manage housing and their prices in the form of managing rentals and buying properties.

## Design
The project is organized into three basic object categories: city, people, and properties. Each representing their own entity and functionalities within the real estate management system, property is built to occupy the land "slots" of the city, and people buy and trade the properties between each other.

The key components of the project are:

- `City`: Represents a city with a grid layout where properties can be added.
- `RealEstate`: Abstract class representing a general real estate property.
- `House`, `Apartment`, `ApartmentBuilding`: More specific classes that extend `RealEstate`.
- `Person`: Abstract class representing a user's essential data, more particularly name and bank account. 
- `RealEstateOwner`, `Renter`: Person subclasses representing different roles when interacting with properties.
- `RealEstateAgent`: Utility class for Real Estate based transactions, taking a portion of said transactions.
- `BankAccount`: Manages financial transactions between all persons.
- `SearchCriteria`: Used to search for properties based on various parameters.
- `UI`: Provides a command-line interface for interacting with the system.

## Installation Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/CS151-Spring-2025-Real-Estate-Manager.git
   ```
2. Navigate to the project directory:
   ```sh
   cd CS151-Spring-2025-Real-Estate-Manager
   ```
3. Open the project in your preferred IDE (we used a combination of Visual Studio Code and Eclipse but any IDE should work).
4. Ensure that the JDK is properly configured in your IDE.
5. Run the `UI.java` file to open up the command-line interface.

## Usage
1. Run the `UI` class to start the command-line interface.
2. Follow the on-screen instructions to create cities, properties, and manage them.
3. Use the various menus to add properties, expand them, and manage rentals.
4. Example commands:
   - Create a new city: `1 -> 1`
   - Add a house to a city: `2 -> 1 -> 1`
   - Display the city grid: `2 -> 3`

## Contributions
- **Itai Hammer**: Worked on the design and implementation of the `City` class, including the `SearchCriteria` class and search functionality, the abstract `RealEstate` class, and all the City related classes such as `Land`, and `OccupiesLand` and the Exception classes including `InvalidPropertyDimensionsException`, `PropertyAlreadyExistsException`, and `PropertyNotFoundException`, created the tests in `CityTest`, and wrote the `README.md`.

- **Chase Potter**: Development of the `House`, `Apartment`, and `ApartmentBuilding` classes, the `Rentable` interface, and creation of the `UI` class and integration of the command-line interface.

- **Alden Nguyen**: Implementation of the `Person` related classes such as the `RealEstateOwner`, `Renter` and `RealEstateAgent` classes and was also responsible for the `BankAccount` class and its Exception `BankException`. Additionally contributed to writing the `README.md`.