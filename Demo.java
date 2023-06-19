/**
 * ====================================================
 * Created by Ali dehghanpour on 1402 - 03 - 07 with ❤
 * ====================================================
 * (\__/) ||
 * (•ㅅ•) ||
 * / 　 づ
 * This project is a simulation of a car rental agency
 */

/* References
 *
 *  Colors            --> https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 *  ArrayList         --> https://www.youtube.com/watch?v=pruuvCVXIt8
 *  print ASCII art   --> https://www.dideo.ir/v/yt/EDDJZ4dWM5c/%D8%AA%D9%85%D8%A7%D8%B4%D8%A7%DB%8C-%D9%88%DB%8C%D8%AF%D8%A6%D9%88-%D8%A7%D8%B2-%D8%AF%DB%8C%D8%AF%D8%A6%D9%88-watch-video-from-dideo
 *  Number validation --> https://stackoverflow.com/questions/15111420/how-to-check-if-a-string-contains-only-digits-in-java
 *  Typing effect     --> https://stackoverflow.com/questions/35673302/java-typewriter-effect
 *
 */


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

abstract class Login extends UserInterface {
    //  Users can log in as an admin, owner, or tenant

    private static final Scanner scanner = new Scanner(System.in);

    private static void adminLogin() {
        String adminUsername = "admin";
        String adminPassword = "admin";

        // Prompt for username
        System.out.print(YELLOW + "Enter Username: " + RESET);
        System.out.print(PURPLE);
        String username = scanner.nextLine();
        System.out.print(RESET);

        // Prompt for password
        System.out.print(YELLOW + "Enter Password: " + RESET);
        System.out.print(PURPLE);
        String password = scanner.nextLine();
        System.out.print(RESET);

        // Check username and password
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println();
            System.out.println("Welcome, " + username + " :)");
            System.out.println();
            Agency.handleAgencyManagerMenu();
        } else {
            System.out.println(RED + "\nAccess denied :(\n" + RESET);
        }
    }

    private static void ownerLogin() {
        if (!Owner.getOwnerList().isEmpty()) {
            // Print list of owners
            Agency.printOwnerList("username");

            // Prompt for owner username
            int ownerUsernameIndex = validateNumericInput(YELLOW + "\nSelect Username: " + RESET, PURPLE);

            // Retrieve owner by index
            Owner owner = Agency.getOwnerByIndex(ownerUsernameIndex);
            if (owner == null) {
                return;
            }

            // Clear valid indexes list
            getValidIndexes().clear();

            // Prompt for owner password
            System.out.print(YELLOW + "Enter Password: " + RESET);
            System.out.print(PURPLE);
            String password = scanner.nextLine();
            System.out.print(RESET);

            // Check owner password
            if (password.equals(owner.getPassword())) {
                System.out.println();
                System.out.println("\nWelcome, " + owner.getFirstName() + " :)");
                Owner.handleOwnerPanelMenu(owner);
            } else {
                System.out.println();
                System.out.println(RED + "Access denied :(" + RESET);
                System.out.println();
            }
        } else {
            System.out.println(RED + "\n\nNo owner has been registered\n\n" + RESET);
        }
    }

    private static void tenantLogin() {
        if (!Tenant.getTenantList().isEmpty()) {
            // Print list of tenants
            Agency.printTenantList("username", false);

            // Prompt for tenant username
            int tenantUsernameIndex = validateNumericInput(YELLOW + "\nSelect Username: " + RESET, PURPLE);

            // Retrieve tenant by index
            Tenant tenant = Agency.getTenantByIndex(tenantUsernameIndex);
            if (tenant == null) {
                return;
            }

            // Clear valid indexes list
            getValidIndexes().clear();

            // Prompt for tenant password
            System.out.print(YELLOW + "Enter Password: " + RESET);
            System.out.print(PURPLE);
            String password = scanner.nextLine();
            System.out.print(RESET);

            // Check tenant password
            if (password.equals(tenant.getPassword())) {
                System.out.println();
                System.out.println("\nWelcome, " + tenant.getFirstName() + " :)");
                Tenant.handleTenantPanelMenu(tenant);
            } else {
                System.out.println();
                System.out.println(RED + "Access denied :(" + RESET);
                System.out.println();
            }
        } else {
            System.out.println(RED + "\n\nNo tenant has been registered\n\n" + RESET);
        }
    }

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            displayHomeMenu(); // display home banner menu
            int option = getUserOption(); // Receiving a numerical input option from the user
            switch (option) {
                case 1:
                    adminLogin();
                    break;

                case 2:
                    ownerLogin();
                    break;

                case 3:
                    tenantLogin();
                    break;

                case 4:
                    displayDeveloperInfo();
                    break;

                case 0:
                    // Getting system confirmation for logout from the user with a corresponding message print
                    running = confirmLogout("System");
                    break;

                default:
                    System.out.println(RED + "\nInvalid option!" + RESET);
            }
        }
        System.out.println(GREEN + "Successful logout!" + RESET);
    }

}


abstract class Human {

    /**
     * The Human class represents a basic model for a human entity. It encapsulates
     * properties such as first name, last name, age, national code, phone number, address, username, and password
     * It provides getter and setter methods for accessing and modifying these properties.
     */

    private String firstName;
    private String lastName;
    private Integer age;
    private String nationalCode;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;

    protected String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected Integer getAge() {
        return age;
    }

    protected void setAge(Integer age) {
        this.age = age;
    }

    protected String getNationalCode() {
        return nationalCode;
    }

    protected void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }
}

class Car {

    /**
     * The Car class represents a car object with various properties such as the model name,
     * engine capacity, owner, rent money, type, and lifespan
     * It provides getter and setter methods for accessing and modifying these properties
     */

    private String nameModel;
    private Integer engineCapacity;
    private Owner owner;
    private Integer rentMoney;
    private String type;
    private Integer lifespan;
    private static final List<Car> carList = new ArrayList<>(); // A list of all available cars
    private static final List<Car> rentedCarList = new ArrayList<>(); // A list of cars that are currently rented

    Integer getEngineCapacity() {
        return engineCapacity;
    }

    void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    Owner getOwner() {
        return owner;
    }

    void setOwner(Owner owner) {
        this.owner = owner;
    }

    String getNameModel() {
        return nameModel;
    }

    void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    Integer getRentMoney() {
        return rentMoney;
    }

    void setRentMoney(Integer rentMoney) {
        this.rentMoney = rentMoney;
    }

    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    Integer getLifespan() {
        return lifespan;
    }

    void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    static List<Car> getCarList() {
        return carList;
    }

    static List<Car> getRentedCarList() {
        return rentedCarList;
    }
}

class Tenant extends Human {
    /*

     The Tenant class represents a tenant, which is a subclass of the Human class
     It extends the Human class to inherit its properties and methods
     In addition to the inherited properties,
     the Tenant class has specific properties such as accountBalance,
     rentedCar, rentedCarOwner, scanner, and tenantList

     */
    private Integer accountBalance; // Maintaining the account balance of the tenant
    private Car rentedCar; // Maintaining the details of the rented car by the tenant
    private Owner rentedCarOwner; // Maintaining the details of the owner of the car rented by the tenant
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Tenant> tenantList = new ArrayList<>(); // Maintaining a list of all existing tenants

    Integer getAccountBalance() {
        return accountBalance;
    }

    void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    Owner getRentedCarOwner() {
        return rentedCarOwner;
    }

    void setRentedCarOwner(Owner rentedCarOwner) {
        this.rentedCarOwner = rentedCarOwner;
    }

    Car getRentedCar() {
        return rentedCar;
    }

    void setRentedCar(Car car) {
        this.rentedCar = car;
    }

    static List<Tenant> getTenantList() {
        return tenantList;
    }

    static void increaseAccountBalance(Tenant tenant) {

        // this method to allow tenants to increase their account balance

        System.out.print(UserInterface.YELLOW + "Please enter the desired amount : " + UserInterface.RESET);
        System.out.print(UserInterface.GREEN);
        int amount = scanner.nextInt();
        System.out.println(UserInterface.RESET);
        System.out.println(UserInterface.YELLOW + "Do you want to increase your account balance by " + UserInterface.GREEN + UserInterface.formattedNumber.format(amount) + UserInterface.RESET + UserInterface.YELLOW + " toman?" + UserInterface.RESET);
        System.out.println();
        UserInterface.showYesNoOptions();
        boolean running = true;
        while (running) {
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    tenant.setAccountBalance(tenant.getAccountBalance() + amount);
                    System.out.println(UserInterface.YELLOW + "\n" + UserInterface.GREEN + UserInterface.formattedNumber.format(amount) + UserInterface.RESET + UserInterface.YELLOW + " toman deposited successfully to your account" + UserInterface.RESET);
                    System.out.println("\nBalance:  " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.GREEN + UserInterface.formattedNumber.format(tenant.getAccountBalance()) + UserInterface.RESET + UserInterface.PURPLE + "] " + UserInterface.WHITE);
                    running = false;
                    break;
                case 2:
                    System.out.println(UserInterface.RED + "\nThe operation has been canceled :(\n\n" + UserInterface.RESET);
                    running = false;
                    break;

                default:
                    System.out.println(UserInterface.RED + "\nInvalid input" + UserInterface.RESET);
                    break;
            }
        }
    }

    // TENANT PANEL
    static void handleTenantPanelMenu(Tenant tenant) {
        boolean running = true;
        while (running) {
            System.out.println();
            UserInterface.displayTenantPanelMenu(tenant);
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    // Increase the account balance for the tenant
                    Tenant.increaseAccountBalance(tenant);
                    break;
                case 0:
                    // Confirm logout from tenant panel
                    running = UserInterface.confirmLogout("tenant panel");
                    break;
                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }
    }

}

class Owner extends Human {

    /*
            The Owner class represents an owner, which is a subclass of the Human class
            It extends the Human class to inherit its properties and methods
            In addition to the inherited properties, the Owner class has specific properties such as income,
            isCarOwner, numberOfCars, myTenantsList, ownerList, and ownerCarList
            It provides getter and setter methods for accessing and modifying the numberOfCars and income properties
            It also provides methods to display the owner's cars, filtered owner cars, and the list of tenants

     */

    private int income; // Maintaining the income from rented cars for the owner
    private int numberOfCars; // Maintaining the number of cars owned by the owner
    private final List<Tenant> myTenantsList = new ArrayList<>(); // Maintaining the list of tenants belonging to the owner
    private static final List<Owner> ownerList = new ArrayList<>(); // Maintaining the list of all existing owners
    private final List<Car> ownerCarList = new ArrayList<>(); // Maintaining the list of cars owned by the owner
    private boolean isCarOwner = false; // Determines whether the owner has any cars or not


    int getNumberOfCars() {
        return numberOfCars;
    }

    void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    List<Tenant> getMyTenantsList() {
        return myTenantsList;
    }

    static List<Owner> getOwnerList() {
        return ownerList;
    }

    List<Car> getOwnerCarList() {
        return ownerCarList;
    }

    int getIncome() {
        return income;
    }

    void setIncome(int income) {
        this.income = income;
    }

    boolean getIsCarOwner() {
        return isCarOwner;
    }

    void setIsCarOwner(Boolean value) {
        isCarOwner = value;
    }

    static void displayMyCars(Owner owner) {

        // Displays the list of all cars owned by the owner

        boolean running = true;
        while (running) {
            System.out.println(UserInterface.PURPLE + "\nThe list of your cars \n" + UserInterface.RESET);
            owner.setIsCarOwner(false);
            Owner.displayOwnerCarsFiltered(owner); // Finds the cars owned by the specified owner among all cars
            if (owner.getIsCarOwner()) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + Car.getCarList().size() + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");
                // Consider the last element of the car list as the "Back" option and add it to the list of valid choices that the user can enter, so that the "Back" option works
                UserInterface.getValidIndexes().add(Car.getCarList().size());
                int option = UserInterface.getUserOption();
                option = UserInterface.validateUserInput(option);
                if (option == Car.getCarList().size()) {
                    running = false;
                } else {
                    Car car = Agency.getCarByIndex(option);
                    // Displaying the list of cars owned by the owner
                    Agency.printCar(car);
                    System.out.println("Is the car rented by a tenant? " + UserInterface.PURPLE + "[" + UserInterface.RESET + (Agency.isCarRented(car) ? UserInterface.GREEN + "Yes" + UserInterface.RESET : UserInterface.RED + "No" + UserInterface.RESET) + UserInterface.PURPLE + "]" + UserInterface.RESET);
                }
            } else {
                System.out.println(UserInterface.RED + "No cars are registered under your name :(" + UserInterface.RESET);
                running = false;
            }
        }
    }

    static void displayOwnerCarsFiltered(Owner owner) {

        /*

           This method displays the filtered list of cars owned by the owner
           It iterates through the Car objects in the Car.getCarList() and checks if the owner of each car matches the given owner
           If a match is found, the car's information is printed along with an index for selection
           The valid indexes are added to the UserInterface.getValidIndexes() for user input validation

         */

        for (Car car : Car.getCarList()) {
            if (car.getOwner().equals(owner)) {
                owner.setIsCarOwner(true);
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Car.getCarList().indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                UserInterface.getValidIndexes().add(Car.getCarList().indexOf(car));
            }
        }
    }

    static void printMyTenantsList(Owner owner) {

        /*
             This method prints the list of tenants belonging to the owner
             It iterates through the owner.getMyTenantsList() and prints the first name and last name of each tenant along with an index for selection
             The counter variable is used to keep track of the index
             If no tenants are found, it displays a message indicating that the owner doesn't have any tenants
         */

        int counter = 1;
        for (Tenant tenant : owner.getMyTenantsList()) {
            System.out.println(UserInterface.PURPLE + "[" + counter + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
            counter += 1;
        }
        if (counter == 1) {
            System.out.println();
            System.out.println(UserInterface.RED + "You don't have any tenants :(" + UserInterface.RESET);
        }
    }

    // OWNER PANEL
    static void handleOwnerPanelMenu(Owner owner) {
        boolean running = true;
        while (running) {
            System.out.println();
            UserInterface.displayOwnerPanelMenu(owner);
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    // Display the cars owned by the owner
                    Owner.displayMyCars(owner);
                    break;
                case 2:
                    // Print the list of tenants for the owner
                    Owner.printMyTenantsList(owner);
                    break;
                case 0:
                    // Confirm logout from owner panel
                    running = UserInterface.confirmLogout("owner panel");
                    break;
                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }
    }

}

abstract class Agency extends UserInterface {

    /*

        This class manages all the items inside the admin panel,
        including adding tenants, owners, cars, and deleting them,
        performing car rental operations, search operations, and more.

     */

    private static boolean unrentedTenants = false; // Indicates whether the list of unrented tenants is empty or not
    private static boolean isAffordableCarsListEmpty = false; // Indicates whether the list of affordable cars is empty or not
    private static int transactionCount; // private static integer variable to keep track of the transaction count
    private static int removedOwnersCount; // variable to keep track of the count of removed owners
    private static long totalTransactionValue; // variable to store the total transaction value
    private static int removedTenantsCount; // variable to keep track of the count of removed tenants
    private static int removedCarsCount; // variable to keep track of the count of removed cars
    private static long totalProfit; // variable to store the total profit
    private static final Scanner scanner = new Scanner(System.in);

    static int getRemovedTenantsCount() {
        return removedTenantsCount;
    }

    static void setRemovedTenantsCount(int removedTenantsCount) {
        Agency.removedTenantsCount = removedTenantsCount;
    }

    static int getRemovedCarsCount() {
        return removedCarsCount;
    }

    static void setRemovedCarsCount(int removedCarsCount) {
        Agency.removedCarsCount = removedCarsCount;
    }

    static long getTotalProfit() {
        return totalProfit;
    }

    static void setTotalProfit(long totalProfit) {
        Agency.totalProfit = totalProfit;
    }

    static long getTotalTransactionValue() {
        return totalTransactionValue;
    }

    static void setTotalTransactionValue(long totalTransactionValue) {
        Agency.totalTransactionValue = totalTransactionValue;
    }

    static int getTransactionCount() {
        return transactionCount;
    }

    static void setTransactionCount(int transactionCount) {
        Agency.transactionCount = transactionCount;
    }

    static int getRemovedOwnersCount() {
        return removedOwnersCount;
    }

    static void setRemovedOwnersCount(int removedOwnersCount) {
        Agency.removedOwnersCount = removedOwnersCount;
    }

    static Boolean getIsAffordableCarsListEmpty() {
        return isAffordableCarsListEmpty;
    }

    static void setIsAffordableCarsListEmpty(boolean isAffordableCarsListEmpty) {
        Agency.isAffordableCarsListEmpty = isAffordableCarsListEmpty;
    }

    static Boolean getUnrentedTenants() {
        return unrentedTenants;
    }

    static void setUnrentedTenants(boolean unrentedTenants) {
        Agency.unrentedTenants = unrentedTenants;
    }


    static void addOwner(Owner owner) {
        Owner.getOwnerList().add(owner);
    }

    static void addTenant(Tenant tenant) {
        Tenant.getTenantList().add(tenant);
    }

    static void addCar(Car car) {
        Car.getCarList().add(car);
    }

    static void addRentedCarList(Car car) {
        Car.getRentedCarList().add(car);
    }

    static void removeCar(Car car) {
        Car.getCarList().remove(car);
    }

    static void removeOwner(Owner owner) {
        Owner.getOwnerList().remove(owner);
    }

    static void removeTenant(Tenant tenant) {
        Tenant.getTenantList().remove(tenant);
    }

    static Owner getOwnerByIndex(int index) {
        // This method for to find an owner object using the entered index
        if (index >= 0 && index < Owner.getOwnerList().size()) {
            return Owner.getOwnerList().get(index);
        } else {
            System.out.println(RED + "\nOwner not found :(\n" + RESET);
            return null;
        }
    }

    static Tenant getTenantByIndex(int index) {
        // This method for to find a tenant object using the entered index
        if (index >= 0 && index < Tenant.getTenantList().size()) {
            return Tenant.getTenantList().get(index);
        } else {
            System.out.println();
            System.out.println(RED + "\nTenant not found :(\n" + RESET);
            System.out.println();
            return null;
        }
    }

    static Car getCarByIndex(int index) {
        // This method for to find a car object using the entered index
        if (index >= 0 && index < Car.getCarList().size()) {
            return Car.getCarList().get(index);
        } else {
            System.out.println();
            System.out.println("Car not found :(");
            System.out.println();
            return null;
        }
    }

    static void printOwners() {
        // This method is used to display information of all owners
        if (!Owner.getOwnerList().isEmpty()) {
            System.out.println(PURPLE + "\nList of Owners :\n" + WHITE);
            for (Owner owner : Owner.getOwnerList()) {
                System.out.println();
                System.out.println("Username       " + PURPLE + "[" + RESET + owner.getUsername() + PURPLE + "]" + RESET);
                System.out.println("Password       " + PURPLE + "[" + RESET + owner.getPassword() + PURPLE + "]" + RESET);
                System.out.println("First Name     " + PURPLE + "[" + RESET + owner.getFirstName() + PURPLE + "]" + RESET);
                System.out.println("Last Name      " + PURPLE + "[" + RESET + owner.getLastName() + PURPLE + "]" + RESET);
                System.out.println("Age            " + PURPLE + "[" + RESET + owner.getAge() + PURPLE + "]" + RESET);
                System.out.println("National Code  " + PURPLE + "[" + RESET + owner.getNationalCode() + PURPLE + "]" + RESET);
                System.out.println("Phone Number   " + PURPLE + "[" + RESET + owner.getPhoneNumber() + PURPLE + "]" + RESET);
                System.out.println("Address        " + PURPLE + "[" + RESET + owner.getAddress() + PURPLE + "]" + RESET);
            }
        }
    }

    static void printOwner(Owner owner) {
        // This method is used to display information of the given owner
        if (!Owner.getOwnerList().isEmpty()) {
            System.out.println();
            System.out.println("Information of " + GREEN + owner.getFirstName() + ' ' + owner.getLastName() + RESET + " \n");
            System.out.println("Username       " + PURPLE + "[" + RESET + owner.getUsername() + PURPLE + "]" + RESET);
            System.out.println("Password       " + PURPLE + "[" + RESET + owner.getPassword() + PURPLE + "]" + RESET);
            System.out.println("First Name     " + PURPLE + "[" + RESET + owner.getFirstName() + PURPLE + "]" + RESET);
            System.out.println("Last Name      " + PURPLE + "[" + RESET + owner.getLastName() + PURPLE + "]" + RESET);
            System.out.println("Age            " + PURPLE + "[" + RESET + owner.getAge() + PURPLE + "]" + RESET);
            System.out.println("National Code  " + PURPLE + "[" + RESET + owner.getNationalCode() + PURPLE + "]" + RESET);
            System.out.println("Phone Number   " + PURPLE + "[" + RESET + owner.getPhoneNumber() + PURPLE + "]" + RESET);
            System.out.println("Address        " + PURPLE + "[" + RESET + owner.getAddress() + PURPLE + "]" + RESET);
        }
    }

    static void printTenants() {
        // This method is used to display information of all tenants
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println(PURPLE + "\nList of Tenants :\n" + WHITE);
            for (Tenant tenant : Tenant.getTenantList()) {
                System.out.println();
                System.out.println("Username            " + PURPLE + "[" + RESET + tenant.getUsername() + PURPLE + "]" + RESET);
                System.out.println("Password            " + PURPLE + "[" + RESET + tenant.getPassword() + PURPLE + "]" + RESET);
                System.out.println("First Name          " + PURPLE + "[" + RESET + tenant.getFirstName() + PURPLE + "]" + RESET);
                System.out.println("Last Name           " + PURPLE + "[" + RESET + tenant.getLastName() + PURPLE + "]" + RESET);
                System.out.println("Age                 " + PURPLE + "[" + RESET + tenant.getAge() + PURPLE + "]" + RESET);
                System.out.println("National Code       " + PURPLE + "[" + RESET + tenant.getNationalCode() + PURPLE + "]" + RESET);
                System.out.println("Phone Number        " + PURPLE + "[" + RESET + tenant.getPhoneNumber() + PURPLE + "]" + RESET);
                System.out.println("Address             " + PURPLE + "[" + RESET + tenant.getAddress() + PURPLE + "]" + RESET);
                System.out.println("Account Balance     " + PURPLE + "[" + RESET + formattedNumber.format(tenant.getAccountBalance()) + PURPLE + "]" + RESET);
                System.out.println("Tenant has car now? " + PURPLE + "[" + RESET + (tenant.getRentedCar() != null ? GREEN + "Yes" + RESET : RED + "No" + RESET) + PURPLE + "]" + RESET);


            }
        }
    }

    static void printTenant(Tenant tenant) {
        // This method is used to display information of the given tenant
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println();
            System.out.println("Information of " + GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET + " \n");
            System.out.println("Username            " + PURPLE + "[" + RESET + tenant.getUsername() + PURPLE + "]" + RESET);
            System.out.println("Password            " + PURPLE + "[" + RESET + tenant.getPassword() + PURPLE + "]" + RESET);
            System.out.println("First Name          " + PURPLE + "[" + RESET + tenant.getFirstName() + PURPLE + "]" + RESET);
            System.out.println("Last Name           " + PURPLE + "[" + RESET + tenant.getLastName() + PURPLE + "]" + RESET);
            System.out.println("Age                 " + PURPLE + "[" + RESET + tenant.getAge() + PURPLE + "]" + RESET);
            System.out.println("National Code       " + PURPLE + "[" + RESET + tenant.getNationalCode() + PURPLE + "]" + RESET);
            System.out.println("Phone Number        " + PURPLE + "[" + RESET + tenant.getPhoneNumber() + PURPLE + "]" + RESET);
            System.out.println("Address             " + PURPLE + "[" + RESET + tenant.getAddress() + PURPLE + "]" + RESET);
            System.out.println("Account Balance     " + PURPLE + "[" + RESET + formattedNumber.format(tenant.getAccountBalance()) + PURPLE + "]" + RESET);
            System.out.println("Tenant has car now? " + PURPLE + "[" + RESET + (tenant.getRentedCar() != null ? GREEN + "Yes" + RESET : RED + "No" + RESET) + PURPLE + "]" + RESET);


        }
    }

    static void printCars() {
        // This method is used to display information of all cars
        if (!Car.getCarList().isEmpty()) {
            System.out.println(PURPLE + "\nList of Cars :\n" + WHITE);
            for (Car car : Car.getCarList()) {
                System.out.println();
                System.out.println("Name Model      " + PURPLE + "[" + RESET + car.getNameModel() + PURPLE + "]" + RESET);
                System.out.println("Engine Capacity " + PURPLE + "[" + RESET + car.getEngineCapacity() + " cc" + PURPLE + "]" + RESET);
                System.out.println("Owner           " + PURPLE + "[" + RESET + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName() + PURPLE + "]" + RESET);
                System.out.println("Rent Money      " + PURPLE + "[" + RESET + formattedNumber.format(car.getRentMoney()) + PURPLE + "]" + RESET);
                System.out.println("Type            " + PURPLE + "[" + RESET + car.getType() + PURPLE + "]" + RESET);
                System.out.println("Lifespan        " + PURPLE + "[" + RESET + car.getLifespan() + PURPLE + "]" + RESET);
            }
        }
    }

    static void printCar(Car car) {
        // This method is used to display information of the given car
        if (!Car.getCarList().isEmpty()) {
            System.out.println();
            System.out.println("Information of  " + GREEN + car.getNameModel() + RESET + " car  \n");
            System.out.println("Name Model      " + PURPLE + "[" + RESET + car.getNameModel() + PURPLE + "]" + RESET);
            System.out.println("Engine Capacity " + PURPLE + "[" + RESET + car.getEngineCapacity() + " cc" + PURPLE + "]" + RESET);
            System.out.println("Owner           " + PURPLE + "[" + RESET + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName() + PURPLE + "]" + RESET);
            System.out.println("Rent Money      " + PURPLE + "[" + RESET + formattedNumber.format(car.getRentMoney()) + PURPLE + "]" + RESET);
            System.out.println("Type            " + PURPLE + "[" + RESET + car.getType() + PURPLE + "]" + RESET);
            System.out.println("Lifespan        " + PURPLE + "[" + RESET + car.getLifespan() + PURPLE + "]" + RESET);
        }
    }

    static void printOwnerList(String type) {
        /*

              Prints the owner list based on the specified type.
              param type The type of information to display ("username" or "name")

         */

        if (type.equalsIgnoreCase("username")) {
            for (Owner owner : Owner.getOwnerList()) {
                System.out.println(PURPLE + "[" + RESET + Owner.getOwnerList().indexOf(owner) + PURPLE + "] " + RESET + owner.getUsername());
                getValidIndexes().add(Owner.getOwnerList().indexOf(owner));

            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Owner owner : Owner.getOwnerList()) {
                System.out.println(PURPLE + "[" + RESET + Owner.getOwnerList().indexOf(owner) + PURPLE + "] " + RESET + owner.getFirstName() + ' ' + owner.getLastName());
                getValidIndexes().add(Owner.getOwnerList().indexOf(owner));
            }

        }
    }

    static void printCarList(Tenant user) {

        // This method prints the list of available cars, but if a tenant object is provided,
        // it displays only the cars that the tenant has the financial capability to rent.

        for (Car car : Car.getCarList()) {
            if (user != null) {
                if (!Car.getRentedCarList().contains(car) && user.getAccountBalance() >= car.getRentMoney()) {
                    isAffordableCarsListEmpty = true;
                    System.out.println(PURPLE + "[" + RESET + Car.getCarList().indexOf(car) + PURPLE + "]" + RESET + " " + car.getNameModel());
                    getValidIndexes().add(Car.getCarList().indexOf(car));
                }
            } else {
                System.out.println(PURPLE + "[" + RESET + Car.getCarList().indexOf(car) + PURPLE + "]" + RESET + " " + car.getNameModel());
                getValidIndexes().add(Car.getCarList().indexOf(car));


            }
        }
    }

    static Boolean isCarRented(Car car) {
        /*
            Checks if a car is currently rented
            param car The car object to check
            return True if the car is rented, False otherwise

         */
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getRentedCar() != null) {
                if (tenant.getRentedCar().equals(car)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void printTenantList(String type, boolean exception) {

    /*
            Prints the tenant list based on the specified type
            param type The type of information to display ("username" or "name")

     */

        if (type.equalsIgnoreCase("username")) {
            for (Tenant tenant : Tenant.getTenantList()) {
                // By specifying the exception, only tenants who have not rented a car will be printed
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        unrentedTenants = true;
                        System.out.println(PURPLE + "[" + RESET + Tenant.getTenantList().indexOf(tenant) + PURPLE + "]" + RESET + " " + tenant.getUsername());
                        getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));

                    }
                } else {
                    System.out.println(PURPLE + "[" + RESET + Tenant.getTenantList().indexOf(tenant) + PURPLE + "]" + RESET + " " + tenant.getUsername());
                    getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));

                }
            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Tenant tenant : Tenant.getTenantList()) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        unrentedTenants = true;
                        System.out.println(PURPLE + "[" + RESET + Tenant.getTenantList().indexOf(tenant) + PURPLE + "]" + RESET + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
                        getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));
                    }
                } else {
                    System.out.println(PURPLE + "[" + RESET + Tenant.getTenantList().indexOf(tenant) + PURPLE + "]" + RESET + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
                    getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));

                }

            }
        }
    }

    static void removeFromTenantList() {
        if (!Tenant.getTenantList().isEmpty()) { // Check if the list of tenants is not empty
            System.out.println(PURPLE + "Please select the desired tenant : \n\n" + RESET);
            printTenantList("name", false); // Print the list of tenants
            int option = getUserOption(); // Get user's choice
            option = validateUserInput(option); // Validate the user's input
            Tenant tenant = Agency.getTenantByIndex(option); // Get the selected tenant from the Agency
            Agency.printTenant(tenant); // Print the details of the selected tenant
            System.out.println();
            System.out.println(YELLOW + "Do you want to remove " + RESET + GREEN + tenant.getFirstName() +
                    ' ' + tenant.getLastName() + RESET + YELLOW + " from the list of tenants?" + RESET);
            showYesNoOptions(); // Ask for confirmation

            boolean running = true;
            while (running) {
                option = getUserOption(); // Get user's choice
                switch (option) {
                    case 1: // User confirmed removal
                        removeTenant(tenant); // Remove the tenant from the list of tenants
                        try {
                            tenant.getRentedCarOwner().getMyTenantsList().remove(tenant); // Remove the tenant from the list of the owner's tenants
                        } catch (java.lang.NullPointerException ignored) {
                        }
                        Agency.setRemovedTenantsCount(Agency.getRemovedTenantsCount() + 1); // Increment the count of removed tenants

                        System.out.println(GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET +
                                " has been " + RED + "removed " + RESET + "from the list of tenants\n\n");
                        running = false; // Exit the loop
                        break;

                    case 2: // User canceled the operation
                        System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                        running = false; // Exit the loop
                        break;

                    default: // Invalid input
                        System.out.println(RED + "Invalid input" + RESET);
                        break;
                }
            }
        } else {
            System.out.println(RED + "No tenant has been registered :(\n\n" + RESET);
        }
    }

    static void removeFromOwnerList() {
        if (!Owner.getOwnerList().isEmpty()) { // Check if the list of owners is not empty
            System.out.println(PURPLE + "Please select the desired owner : \n\n" + RESET);
            printOwnerList("name"); // Print the list of owners
            int option = getUserOption(); // Get user's choice
            option = validateUserInput(option); // Validate the user's input
            Owner owner = Agency.getOwnerByIndex(option); // Get the selected owner from the Agency
            Agency.printOwner(owner); // Print the details of the selected owner
            System.out.println();
            System.out.println(YELLOW + "Do you want to remove " + RESET + GREEN + owner.getFirstName() +
                    ' ' + owner.getLastName() + RESET + YELLOW + " from the list of owners?" + RESET);
            System.out.println();
            owner.setIsCarOwner(false); // Set the owner's car ownership status to false
            Owner.displayOwnerCarsFiltered(owner); // Display the cars owned by the owner
            System.out.println();
            if (owner.getIsCarOwner()) {
                System.out.println(YELLOW + "Please note that by removing " + RESET + GREEN + owner.getFirstName() + ' ' +
                        owner.getLastName() + RESET + YELLOW + " from the list of owners of the above cars, they will be removed from the list" + RESET);
            } else {
                System.out.println(PURPLE + "This owner does not have any car with their name" + PURPLE);
            }
            showYesNoOptions(); // Ask for confirmation

            boolean running = true;
            while (running) {
                option = getUserOption(); // Get user's choice
                switch (option) {
                    case 1: // User confirmed removal
                        removeOwner(owner); // Remove the owner from the list of owners
                        Car.getCarList().removeAll(owner.getOwnerCarList()); // Remove all cars owned by the owner from the list of cars
                        System.out.println(GREEN + owner.getFirstName() + ' ' + owner.getLastName() + RESET +
                                " has been " + RED + "removed" + RESET + " from the list of owners\n\n");
                        if (owner.getIsCarOwner()) {
                            System.out.println("Furthermore, " + GREEN + owner.getOwnerCarList().size() + RESET + " cars owned by the mentioned owner have also been removed from the list of cars");
                            Agency.setRemovedCarsCount(Agency.getRemovedCarsCount() + owner.getOwnerCarList().size()); // Increment the count of removed cars
                        }
                        Agency.setRemovedOwnersCount(Agency.getRemovedOwnersCount() + 1); // Increment the count of removed owners
                        System.out.println();
                        running = false; // Exit the loop
                        break;

                    case 2: // User canceled the operation
                        System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                        running = false; // Exit the loop
                        break;

                    default: // Invalid input
                        System.out.println(RED + "Invalid input" + RESET);
                        break;
                }
            }
        } else {
            System.out.println(RED + "No Owner has been registered :(" + RESET);
        }
    }

    static void removeFromCarList() {
        if (!Car.getCarList().isEmpty()) { // Check if the list of cars is not empty
            System.out.println("Please select the desired car : \n\n");
            printCarList(null); // Print the list of cars
            int option = getUserOption(); // Get user's choice
            option = validateUserInput(option); // Validate the user's input
            Car car = getCarByIndex(option); // Get the selected car
            printCar(car); // Print the details of the selected car
            System.out.println();
            System.out.println(YELLOW + "Do you want to remove the " + RESET + PURPLE + car.getNameModel() + RESET +
                    YELLOW + " car from the list of cars?" + RESET);
            showYesNoOptions(); // Ask for confirmation

            boolean running = true;
            while (running) {
                option = getUserOption(); // Get user's choice
                switch (option) {
                    case 1: // User confirmed removal
                        removeCar(car); // Remove the car from the list of cars
                        car.getOwner().setNumberOfCars(car.getOwner().getNumberOfCars() - 1); // Decrease the car count for the owner
                        Agency.setRemovedCarsCount(Agency.getRemovedCarsCount() + 1); // Increment the count of removed cars
                        System.out.println(PURPLE + car.getNameModel() + RESET + " has been" + RED + " removed " + RESET + "from the list of cars\n\n");
                        running = false; // Exit the loop
                        break;

                    case 2: // User canceled the operation
                        System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                        running = false; // Exit the loop
                        break;

                    default: // Invalid input
                        System.out.println(RED + "\nInvalid input" + RESET);
                        break;
                }
            }
        } else {
            System.out.println(RED + "No car has been registered :(" + RESET);
        }
    }

    static void rent() {
        if (!Tenant.getTenantList().isEmpty()) { // Check if the list of tenants is not empty
            System.out.println(PURPLE + "Please select the desired tenant : \n\n" + RESET);
            printTenantList("name", true); // Display the list of tenants who have not rented a car yet

            if (getUnrentedTenants()) { // Check whether the list of tenants who have not rented a car is empty or not
                int option = getUserOption(); // Get user's choice
                option = validateUserInput(option); // Validate the user's input
                setUnrentedTenants(false); // Reset the status of the list of tenants who have not rented a car to its default state
                Tenant tenant = getTenantByIndex(option); // Get the selected tenant

                if (!Car.getCarList().isEmpty()) { // Check if the list of cars is not empty
                    System.out.println(PURPLE + "Please select the desired car :\n\n" + RESET);
                    System.out.println(YELLOW + "Cars displayed based on " + RESET + GREEN + tenant.getFirstName() + ' '
                            + tenant.getLastName() + RESET + YELLOW + "'s account inventory\n\n" + RESET);
                    printCarList(tenant); // Print the list of cars that the tenant has the financial capability to rent

                    if (getIsAffordableCarsListEmpty()) { // Check if there are available cars to rent for the tenant
                        option = getUserOption(); // Get user's choice
                        option = validateUserInput(option); // Validate the user's input
                        setIsAffordableCarsListEmpty(false); // Return the list of cost-effective cars to their default state
                    } else {
                        System.out.println(YELLOW + "All cars have been rented out\n\n" + YELLOW);
                        return;
                    }
                } else {
                    System.out.println("No car has been registered :(");
                    return;
                }

                printTenant(tenant); // Print the details of the selected tenant
                Car car = getCarByIndex(option); // Get the selected car
                System.out.println();
                printCar(car); // Print the details of the selected car

                int day = validateNumericInput("Please enter the rental period in days : ", GREEN); // Get the rental period in days from the user
                System.out.println();
                System.out.println(YELLOW + "Do you want to rent a " + RESET +
                        GREEN + car.getNameModel() + RESET + YELLOW + " car to " + RESET + GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET +
                        YELLOW + " for a duration of " + RESET + GREEN + day + RESET + YELLOW + " days?" + RESET);

                System.out.println();
                System.out.println(YELLOW + "With your confirmation, an amount of " + RESET + GREEN + formattedNumber.format(car.getRentMoney()) + RESET + YELLOW + " Toman will be deducted from " + RESET + GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET + YELLOW + "'s account\n\n" + RESET);
                showYesNoOptions(); // Ask for confirmation

                boolean running = true;
                while (running) {
                    option = getUserOption(); // Get user's choice
                    switch (option) {
                        case 1: // User confirmed the rental
                            System.out.println(GREEN + "\n\nThe car has been successfully rented :)\n\n" + RESET);
                            Agency.setTransactionCount(Agency.getTransactionCount() + 1); // Increment the transaction count
                            Agency.setTotalTransactionValue(Agency.getTotalTransactionValue() + car.getRentMoney()); // Update the total transaction value
                            Agency.setTotalProfit(Agency.getTotalProfit() + car.getRentMoney() / 10); // Update the total profit
                            car.getOwner().getMyTenantsList().add(tenant); // Add the tenant to the owner's list of tenants
                            car.getOwner().setIncome((car.getRentMoney() * 9 / 10) + (car.getOwner().getIncome())); // Update the owner's income
                            System.out.println(YELLOW + "An amount of " + RESET
                                    + GREEN + formattedNumber.format(car.getRentMoney()) + RESET + YELLOW + " Toman has been deducted from " + RESET + GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET +
                                    YELLOW + "'s account\n\n" + RESET);
                            tenant.setAccountBalance(tenant.getAccountBalance() - car.getRentMoney()); // Update the tenant's account balance
                            tenant.setRentedCar(car); // Set the rented car for the tenant
                            tenant.setRentedCarOwner(car.getOwner()); // Set the owner of the rented car for the tenant
                            addRentedCarList(car); // Add the rented car to the rented car list
                            running = false; // Exit the loop
                            break;
                        case 2: // User canceled the operation
                            System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                            running = false; // Exit the loop
                            break;
                        default: // Invalid input
                            System.out.println(RED + "Invalid input" + RESET);
                            break;
                    }
                }
            } else {
                System.out.println(GREEN + "All tenants have rented a car\n\n" + RESET);
            }
        } else {
            System.out.println(RED + "No tenant has been registered :(\n\n" + RESET);
        }
    }

    static void addOwner() {

        /*
         * Prompts the user to add a new owner to the system.
         * Collects the owner's details such as username, password, first name, last name, age, national code, phone number, and address.
         * Displays a confirmation message and allows the user to confirm or cancel the addition.
         * If confirmed, the owner is added to the list of owners.
         */

        Owner owner = new Owner();

        System.out.print("Enter the owner's username: ");
        System.out.print(PURPLE);
        owner.setUsername(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the owner's password: ");
        System.out.print(PURPLE);
        owner.setPassword(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the owner's first name: ");
        System.out.print(PURPLE);
        String firstName = scanner.nextLine();
        System.out.print(RESET);
        owner.setFirstName(firstName);

        System.out.print("Enter the owner's last name: ");
        System.out.print(PURPLE);
        String lastName = scanner.nextLine();
        System.out.print(RESET);
        owner.setLastName(lastName);

        int age = getAndValidateAge("owner");
        owner.setAge(age);

        String nationalCode = getAndValidateNationalCode("owner");
        if (nationalCodeOwnerSearch(nationalCode)) {
            System.out.println(RED + "The entered national code has already been registered in the list of owners" + RESET);
            return;
        } else {
            owner.setNationalCode(nationalCode);
        }


        String phoneNumber = getAndValidatePhoneNumber("owner");
        if (phoneNumberOwnerSearch(phoneNumber)) {
            System.out.println(RED + "The entered phone number has already been registered in the list of owners" + RESET);
            return;
        } else {
            owner.setPhoneNumber(phoneNumber);
        }


        System.out.print("Enter the owner's address: ");
        System.out.print(PURPLE);
        owner.setAddress(scanner.nextLine());
        System.out.print(RESET);
        System.out.println(YELLOW + "\nAre you sure about adding " + GREEN + firstName + ' ' + lastName + RESET + YELLOW + " to the list of owners?" + RESET);
        showYesNoOptions();
        boolean running = true;
        while (running) {
            int option = getUserOption();
            switch (option) {
                case 1:
                    addOwner(owner);
                    System.out.println(GREEN + "\nOwner added successfully!" + RESET);
                    running = false;
                    break;
                case 2:
                    System.out.println(RED + "\nThe operation has been canceled" + RESET);
                    running = false;
                    break;
                default:
                    System.out.println(RED + "Invalid input" + RESET);
                    break;
            }
        }
    }

    static void addTenant() {

        /*
         * Prompts the user to add a new tenant to the system.
         * Collects the tenant's details such as username, password, first name, last name, age, national code, phone number, address, and account balance.
         * Displays a confirmation message and allows the user to confirm or cancel the addition.
         * If confirmed, the tenant is added to the list of tenants.
         */

        Tenant tenant = new Tenant();

        System.out.print("Enter the tenant's username: ");
        System.out.print(PURPLE);
        tenant.setUsername(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the tenant's password: ");
        System.out.print(PURPLE);
        tenant.setPassword(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the tenant's first name: ");
        System.out.print(PURPLE);
        String firstName = scanner.nextLine();
        System.out.print(RESET);
        tenant.setFirstName(firstName);

        System.out.print("Enter the tenant's last name: ");
        System.out.print(PURPLE);
        String lastName = scanner.nextLine();
        System.out.print(RESET);
        tenant.setLastName(lastName);

        int age = getAndValidateAge("tenant");
        tenant.setAge(age);


        String nationalCode = getAndValidateNationalCode("tenant");
        if (nationalCodeTenantSearch(nationalCode)) {
            System.out.println(RED + "The entered national code has already been registered in the list of tenants" + RESET);
            return;
        } else {
            tenant.setNationalCode(nationalCode);
        }


        String phoneNumber = getAndValidatePhoneNumber("tenant");
        if (phoneNumberTenantSearch(phoneNumber)) {
            System.out.println(RED + "The entered phone number has already been registered in the list of tenants" + RESET);
            return;
        } else {
            tenant.setPhoneNumber(phoneNumber);
        }


        System.out.print("Enter the tenant's address: ");
        System.out.print(PURPLE);
        tenant.setAddress(scanner.nextLine());
        System.out.print(RESET);

        String errorText = YELLOW + "The minimum accountBalance amount must be " + RESET + RED + "1,500,000" + RESET + YELLOW + " toman" + RESET;
        String askText = "Enter the tenant's accountBalance : ";
        int accountBalance = getAndValidateMoney(askText, errorText);
        tenant.setAccountBalance(accountBalance);

        System.out.println(YELLOW + "\nAre you sure about adding " + GREEN + firstName + ' ' + lastName + RESET + YELLOW + " to the list of tenants?" + RESET);
        showYesNoOptions();
        boolean running = true;
        while (running) {
            int option = getUserOption();
            switch (option) {
                case 1:
                    addTenant(tenant);
                    System.out.println(GREEN + "Tenant added successfully!" + RESET);
                    running = false;
                    break;
                case 2:
                    System.out.println(RED + "\nThe operation has been canceled" + RESET);
                    running = false;
                    break;
                default:
                    System.out.println(RED + "Invalid input" + RESET);
                    break;
            }
        }
    }

    static void addCar() {

        /*
         * Prompts the user to add a new car to the system.
         * Collects the car's details such as name model, engine capacity, owner, rent money, type, and lifespan.
         * Displays a list of available owners and allows the user to select an owner for the car.
         * Asks for the car's rent money and type (sedan, high-riding, semi-high-riding).
         * Asks for the car's lifespan.
         * Displays a confirmation message and allows the user to confirm or cancel the addition.
         * If confirmed, the car is added to the list of cars and associated with the selected owner.
         */

        Car car = new Car();

        System.out.print("Enter the car's Name Model: ");
        System.out.print(PURPLE);
        String carName = scanner.nextLine();
        System.out.print(RESET);
        car.setNameModel(carName);

        int engineCapacity = getAndValidateEngineCapacity();
        car.setEngineCapacity(engineCapacity);

        if (!Owner.getOwnerList().isEmpty()) {
            System.out.println(PURPLE + "\nPlease select the car owner\n" + RESET);
            printOwnerList("name");
            int option = getUserOption();
            option = validateUserInput(option);
            Owner owner = getOwnerByIndex(option);
            if (owner == null) {
                return;
            }
            car.setOwner(owner);


            String askText = "Enter the car's rent money : ";
            String errorText = YELLOW + "The entered rental amount must be above" + RESET + RED + " 1,500,000 " + RESET + YELLOW + "toman" + RESET;
            int rentMoney = getAndValidateMoney(askText, errorText);
            car.setRentMoney(rentMoney);


            System.out.println();
            System.out.println(PURPLE + "Please select the type of car\n" + RESET);
            System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Sedan");
            System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "High-riding");
            System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Semi-high-riding");
            boolean running = true;
            while (running) {
                option = getUserOption();
                switch (option) {
                    case 1:
                        car.setType("Sedan");
                        running = false;
                        break;
                    case 2:
                        car.setType("High-riding");
                        running = false;
                        break;
                    case 3:
                        car.setType("Semi-high-riding");
                        running = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println(RED + "Invalid option! Please try again" + RESET);
                }
            }

            int lifespan = validateNumericInput("Enter the car's lifespan: ", PURPLE);
            car.setLifespan(lifespan);

            System.out.println(YELLOW + "\nAre you sure about adding the " + GREEN + carName + RESET + YELLOW + " car to the list of cars?" + RESET);
            showYesNoOptions();
            running = true;
            while (running) {
                option = getUserOption();
                switch (option) {
                    case 1:
                        addCar(car);
                        owner.setNumberOfCars(owner.getNumberOfCars() + 1);
                        owner.getOwnerCarList().add(car);
                        System.out.println(GREEN + "Car added successfully!" + RESET);
                        running = false;
                        break;
                    case 2:
                        System.out.println(RED + "\nThe operation has been canceled" + RESET);
                        running = false;
                        break;
                    default:
                        System.out.println(RED + "Invalid input" + RESET);
                        break;
                }
            }


        } else {
            System.out.println(RED + "\n\nNo owner has been registered\n\n" + RESET);
        }
    }

    private static void fullNameOwnerSearch(String firstName, String lastName) {

        /*
         * Searches for owners based on their full name (combination of first name and last name).
         * Prints the details of the matching owners if found.
         * If no matching owners are found, displays a "Not found" message.
         *
         * param firstName The first name of the owner to search for.
         * param lastName  The last name of the owner to search for.
         */

        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if ((owner.getFirstName() + owner.getLastName()).equalsIgnoreCase(firstName + lastName)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void firstNameOwnerSearch(String firstName) {

        /*
         * Searches for owners based on their first name.
         * Prints the details of the matching owners if found.
         * If no matching owners are found, displays a "Not found" message.
         *
         * param firstName The first name of the owner to search for.
         */

        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getFirstName().equalsIgnoreCase(firstName)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void lastnameNameOwnerSearch(String lastName) {

        /*
         * Searches for owners based on their last name.
         * Prints the details of the matching owners if found.
         * If no matching owners are found, displays a "Not found" message.
         *
         * param lastName The last name of the owner to search for.
         */

        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getLastName().equalsIgnoreCase(lastName)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static boolean nationalCodeOwnerSearch(String nationalCode) {

        /*
         * Searches for owners based on their national code.
         * Prints the details of the matching owners if found.
         *
         * param nationalCode The national code of the owner to search for.
         */

        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getNationalCode().equals(nationalCode)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        return foundStatus;
    }

    private static boolean phoneNumberOwnerSearch(String phoneNumber) {

        /*
         * Searches for owners based on their phone number.
         * Prints the details of the matching owners if found.
         *
         * param phoneNumber The phone number of the owner to search for.
         */

        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getPhoneNumber().equals(phoneNumber)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        return foundStatus;

    }

    private static void usernameOwnerSearch(String userName) {

        /*
         * Searches for owners based on their username.
         * Prints the details of the matching owners if found.
         * If no matching owners are found, displays a "Not found" message.
         *
         * param userName The username of the owner to search for.
         */

        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getUsername().equalsIgnoreCase(userName)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void ageOwnerSearch(int age) {

        /*
         * Searches for owners based on their age.
         * Prints the details of the owners whose age is less than or equal to the specified age.
         * If no matching owners are found, displays a "Not found" message.
         *
         * param age The maximum age to search for.
         */

        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getAge() <= age) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void fullNameTenantSearch(String firstName, String lastName) {

        /*
         * Searches for tenants based on their full name.
         * Prints the details of the tenants whose full name matches the specified first name and last name.
         * If no matching tenants are found, displays a "Not found" message.
         *
         * param firstName The first name to search for.
         * param lastName  The last name to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if ((tenant.getFirstName() + tenant.getLastName()).equalsIgnoreCase(firstName + lastName)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void firstNameTenantSearch(String firstName) {

        /*
         * Searches for tenants based on their first name.
         * Prints the details of the tenants whose first name matches the specified first name.
         * If no matching tenants are found, displays a "Not found" message.
         *
         * param firstName The first name to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getFirstName().equalsIgnoreCase(firstName)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void lastNameTenantSearch(String lastName) {

        /*
         * Searches for tenants based on their last name.
         * Prints the details of the tenants whose last name matches the specified last name.
         * If no matching tenants are found, displays a "Not found" message.
         *
         * param lastName The last name to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getLastName().equalsIgnoreCase(lastName)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static boolean nationalCodeTenantSearch(String nationalCode) {

        /*
         * Searches for tenants based on their national code.
         * Prints the details of the tenants whose national code matches the specified national code.
         *
         * param nationalCode The national code to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getNationalCode().equals(nationalCode)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        return foundStatus;
    }

    private static boolean phoneNumberTenantSearch(String phoneNumber) {

        /*
         * Searches for tenants based on their phone number.
         * Prints the details of the tenants whose phone number matches the specified phone number.
         *
         * param phoneNumber The phone number to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getPhoneNumber().equals(phoneNumber)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        return foundStatus;
    }

    private static void usernameTenantSearch(String userName) {

        /*
         * Searches for tenants based on their username.
         * Prints the details of the tenants whose username matches the specified username.
         * If no matching tenants are found, displays a "Not found" message.
         *
         * param userName The username to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getUsername().equalsIgnoreCase(userName)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void ageTenantSearch(int age) {

        /*
         * Searches for tenants based on their age.
         * Prints the details of the tenants whose age is less than or equal to the specified age.
         * If no matching tenants are found, displays a "Not found" message.
         *
         * param age The maximum age to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getAge() <= age) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void accountBalanceSearch(int accountBalance) {

        /*
         * Searches for tenants based on their account balance.
         * Prints the details of the tenants whose account balance is less than or equal to the specified amount.
         * If no matching tenants are found, displays a "Not found" message.
         *
         * param accountBalance The maximum account balance to search for.
         */

        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getAccountBalance() <= accountBalance) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void engineCapacitySearch(int engineCapacity) {

        /*
         * Searches for cars based on their engine capacity.
         * Prints the details of the cars whose engine capacity is less than or equal to the specified amount.
         * If no matching cars are found, displays a "Not found" message.
         *
         * param engineCapacity The maximum engine capacity to search for.
         */

        boolean foundStatus = false;
        for (Car car : Car.getCarList()) {
            if (car.getEngineCapacity() <= engineCapacity) {
                Agency.printCar(car);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void nameModelSearch(String nameModel) {

        /*
         * Searches for cars based on their name model.
         * Prints the details of the cars whose name model matches the specified value.
         * If no matching cars are found, displays a "Not found" message.
         *
         * param nameModel The name model to search for.
         */

        boolean foundStatus = false;
        for (Car car : Car.getCarList()) {
            if (car.getNameModel().equalsIgnoreCase(nameModel)) {
                Agency.printCar(car);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void rentMoneySearch(int rentMoney) {

        /*
         * Searches for cars based on their rent money.
         * Prints the details of the cars whose rent money is less than or equal to the specified value.
         * If no matching cars are found, displays a "Not found" message.
         *
         * param rentMoney The rent money to search for.
         */

        boolean foundStatus = false;
        for (Car car : Car.getCarList()) {
            if (car.getRentMoney() <= rentMoney) {
                Agency.printCar(car);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void lifeSpanSearch(int lifeSpan) {

        /*
         * Searches for cars based on their lifespan.
         * Prints the details of the cars whose lifespan is less than or equal to the specified value.
         * If no matching cars are found, displays a "Not found" message.
         *
         * param lifeSpan The lifespan to search for.
         */

        boolean foundStatus = false;
        for (Car car : Car.getCarList()) {
            if (car.getLifespan() <= lifeSpan) {
                Agency.printCar(car);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void carOwnerSearch(String firstName, String lastName) {

        /*
         * Searches for cars based on the owner's full name.
         * Prints the details of the cars owned by a person with the specified first name and last name.
         * If no matching cars are found, displays a "Not found" message.
         *
         * param firstName The first name of the owner.
         * param lastName  The last name of the owner.
         */

        boolean foundStatus = false;
        for (Car car : Car.getCarList()) {
            if ((car.getOwner().getFirstName() + car.getOwner().getLastName()).equalsIgnoreCase(firstName + lastName)) {
                Agency.printCar(car);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void typeSearch(String type) {

        /*
         * Searches for cars based on the car type.
         * Prints the details of the cars that match the specified car type.
         * If no matching cars are found, displays a "Not found" message.
         *
         * param type The car type to search for.
         */

        boolean foundStatus = false;
        for (Car car : Car.getCarList()) {
            if (car.getType().equalsIgnoreCase(type)) {
                Agency.printCar(car);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void handleSearchOwnerManager() {
        boolean running = true;
        while (running) {
            displayOwnerSearchMenu(); // Display the owner search menu
            int option = getUserOption(); // Get the user input option
            String firstname;
            String lastname;
            switch (option) {
                case 1:
                    System.out.print("Enter the owner's first name : ");
                    System.out.print(PURPLE);
                    firstname = scanner.nextLine();
                    System.out.print(RESET);

                    System.out.print("Enter the owner's last name : ");
                    System.out.print(PURPLE);
                    lastname = scanner.nextLine();
                    System.out.print(RESET);

                    fullNameOwnerSearch(firstname, lastname); // Perform a search by full name
                    break;
                case 2:
                    System.out.print("Enter the owner's first name : ");
                    System.out.print(PURPLE);
                    firstname = scanner.nextLine();
                    System.out.print(RESET);
                    firstNameOwnerSearch(firstname); // Perform a search by first name
                    break;
                case 3:
                    System.out.print("Enter the owner's last name : ");
                    System.out.print(PURPLE);
                    lastname = scanner.nextLine();
                    System.out.print(RESET);
                    lastnameNameOwnerSearch(lastname); // Perform a search by last name
                    break;
                case 4:
                    String nationalCode = getAndValidateNationalCode("owner");
                    nationalCodeOwnerSearch(nationalCode); // Perform a search by national code
                    if (!nationalCodeOwnerSearch(nationalCode)) {
                        System.out.println(RED + "Not found :(" + RESET);
                    }
                    break;
                case 5:
                    String phoneNumber = getAndValidatePhoneNumber("owner");
                    phoneNumberOwnerSearch(phoneNumber); // Perform a search by phone number
                    if (!phoneNumberOwnerSearch(phoneNumber)) {
                        System.out.println(RED + "Not found :(" + RESET);
                    }

                    break;
                case 6:
                    System.out.print("Enter the owner's username : ");
                    System.out.print(PURPLE);
                    String username = scanner.nextLine();
                    System.out.print(RESET);
                    usernameOwnerSearch(username); // Perform a search by username
                    break;
                case 7:
                    int age = getAndValidateAge("owner");
                    ageOwnerSearch(age); // Perform a search by age
                    break;
                case 0:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }
    }

    private static void handleSearchTenantManager() {
        boolean running = true;
        while (running) {
            displayTenantSearchMenu(); // Display the tenant search menu
            int option = getUserOption(); // Get the user input option
            String firstname;
            String lastname;
            switch (option) {
                case 1:
                    System.out.print("Enter the tenant's first name : ");
                    System.out.print(PURPLE);
                    firstname = scanner.nextLine();
                    System.out.print(RESET);
                    System.out.print("Enter the tenant's last name : ");
                    System.out.print(PURPLE);
                    lastname = scanner.nextLine();
                    System.out.print(RESET);
                    fullNameTenantSearch(firstname, lastname); // Perform a search by full name
                    break;
                case 2:
                    System.out.print("Enter the tenant's first name : ");
                    System.out.print(PURPLE);
                    firstname = scanner.nextLine();
                    System.out.print(RESET);
                    firstNameTenantSearch(firstname); // Perform a search by first name
                    break;
                case 3:
                    System.out.print("Enter the tenant's last name : ");
                    System.out.print(PURPLE);
                    lastname = scanner.nextLine();
                    System.out.print(RESET);
                    lastNameTenantSearch(lastname); // Perform a search by last name
                    break;
                case 4:
                    String askText = "Enter the tenant's accountBalance : ";
                    String errorText = YELLOW + "The minimum accountBalance amount must be " + RESET + RED + "1,500,000" + RESET + YELLOW + " toman" + RESET;
                    int accountBalance = getAndValidateMoney(askText, errorText);
                    accountBalanceSearch(accountBalance); // Perform a search by account balance
                    break;
                case 5:
                    String nationalCode = getAndValidateNationalCode("tenant");
                    nationalCodeTenantSearch(nationalCode); // Perform a search by national code
                    if (!nationalCodeTenantSearch(nationalCode)) {
                        System.out.println(RED + "Not found :(" + RESET);
                    }
                    break;
                case 6:
                    String phoneNumber = getAndValidatePhoneNumber("tenant");
                    phoneNumberTenantSearch(phoneNumber); // Perform a search by phone number
                    if (!phoneNumberTenantSearch(phoneNumber)) {
                        System.out.println(RED + "Not found :(" + RESET);
                    }
                    break;
                case 7:
                    System.out.print("Enter the tenant's username : ");
                    System.out.print(PURPLE);
                    String username = scanner.nextLine();
                    System.out.print(RESET);
                    usernameTenantSearch(username); // Perform a search by username
                    break;
                case 8:
                    int age = getAndValidateAge("tenant");
                    ageTenantSearch(age); // Perform a search by age
                    break;
                case 0:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }
    }

    private static void handleSearchCarManager() {
        boolean running = true;
        while (running) {
            displayCarSearchMenu(); // Display the car search menu
            int option = getUserOption(); // Get the user input option
            switch (option) {
                case 1:
                    int engineCapacity = getAndValidateEngineCapacity(); // Get and validate the engine capacity
                    engineCapacitySearch(engineCapacity); // Perform a search by engine capacity
                    break;
                case 2:
                    System.out.print("Enter the car name model : ");
                    System.out.print(PURPLE);
                    String nameModel = scanner.nextLine();
                    System.out.print(RESET);
                    nameModelSearch(nameModel); // Perform a search by car name model
                    break;
                case 3:
                    String askText = "Enter the car's rent money : ";
                    String errorText = YELLOW + "The entered rental amount must be above" + RESET + RED + " 1,500,000 " + RESET + YELLOW + "toman" + RESET;
                    int rentMoney = getAndValidateMoney(askText, errorText); // Get and validate the rent money
                    rentMoneySearch(rentMoney); // Perform a search by rent money
                    break;
                case 4:
                    int lifeSpan = validateNumericInput("Enter the car's lifespan: ", PURPLE); // Validate the car's lifespan
                    lifeSpanSearch(lifeSpan); // Perform a search by lifespan
                    break;
                case 5:
                    System.out.print("Enter the owner's first name : ");
                    System.out.print(PURPLE);
                    String firstname = scanner.nextLine();
                    System.out.print(RESET);
                    System.out.print("Enter the owner's last name : ");
                    System.out.print(PURPLE);
                    String lastname = scanner.nextLine();
                    System.out.print(RESET);
                    carOwnerSearch(firstname, lastname); // Perform a search by car owner
                    break;
                case 6:
                    System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Sedan");
                    System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "High-riding");
                    System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Semi-high-riding");
                    System.out.println();
                    boolean running_type = true;
                    while (running_type) {
                        option = validateNumericInput("Enter the car type : ", PURPLE); // Validate the car type
                        switch (option) {
                            case 1:
                                typeSearch("Sedan"); // Perform a search by car type Sedan
                                running_type = false;
                                break;
                            case 2:
                                typeSearch("High-riding"); // Perform a search by car type High-riding
                                running_type = false;
                                break;
                            case 3:
                                typeSearch("Semi-high-riding"); // Perform a search by car type Semi-high-riding
                                running_type = false;
                                break;
                            default:
                                System.out.println(RED + "Invalid option!" + RESET);
                        }
                    }
                    break;
                case 0:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }
    }

    static void handleSearchMainMenuManager() {
        boolean running = true;
        while (running) {
            displaySearchMenu(); // Display the search menu
            int option = getUserOption(); // Get the user input option
            switch (option) {
                case 1:
                    handleSearchOwnerManager(); // Handle the owner search manager
                    break;
                case 2:
                    handleSearchTenantManager(); // Handle the tenant search manager
                    break;
                case 3:
                    handleSearchCarManager(); // Handle the car search manager
                    break;
                case 0:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }
    }

    static void handleReportMenu() {
        boolean running = true;
        while (running) {
            displayReportMenu(); // Display the report menu
            int option = getUserOption(); // Get the user input option
            switch (option) {
                case 1:
                    handlePrintOwnersList(); // Handle printing the owners list
                    break;
                case 2:
                    handlePrintTenantsList(); // Handle printing the tenants list
                    break;
                case 3:
                    handlePrintCarsList(); // Handle printing the cars list
                    break;
                case 0:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println(RED + "Invalid option!\n" + RESET);
                    break;
            }
        }
    }

    private static void handlePrintOwnersList() {
        boolean running = true;
        if (!Owner.getOwnerList().isEmpty()) { // Check if the owner list is not empty
            printOwners(); // Print the owners list
            System.out.println(PURPLE + "\n[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");

            while (running) {
                int option = getUserOption(); // Get the user input option
                if (option == 0) {
                    running = false; // Exit the loop
                } else {
                    System.out.println(RED + "Invalid option!" + RESET);
                }
            }
        } else {
            System.out.println(RED + "No owner has been registered :(\n\n" + RESET);
        }
    }

    private static void handlePrintTenantsList() {
        boolean running = true;
        if (!Tenant.getTenantList().isEmpty()) { // Check if the tenant list is not empty
            printTenants(); // Print the tenants list
            System.out.println(PURPLE + "\n[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");

            while (running) {
                int option = getUserOption(); // Get the user input option
                if (option == 0) {
                    running = false; // Exit the loop
                } else {
                    System.out.println(RED + "Invalid option!" + RESET);
                }
            }
        } else {
            System.out.println(RED + "No tenant has been registered :(\n\n" + RESET);
        }
    }

    private static void handlePrintCarsList() {
        boolean running = true;
        if (!Car.getCarList().isEmpty()) { // Check if the car list is not empty
            printCars(); // Print the cars list
            System.out.println(PURPLE + "\n[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");

            while (running) {
                int option = getUserOption(); // Get the user input option
                if (option == 0) {
                    running = false; // Exit the loop
                } else {
                    System.out.println(RED + "Invalid option!" + RESET);
                }
            }
        } else {
            System.out.println(RED + "No car has been registered :(\n\n" + RESET);
        }
    }

    static void handleAddMainMenuManager() {
        boolean running = true;
        while (running) {
            displayAddMenu(); // Display the add menu options
            int option = getUserOption(); // Get the user input option
            switch (option) {
                case 1:
                    displayOwnerBanner(); // Display the owner banner
                    Agency.addOwner(); // Add a new owner
                    break;
                case 2:
                    displayTenantBanner(); // Display the tenant banner
                    Agency.addTenant(); // Add a new tenant
                    break;
                case 3:
                    displayCarBanner(); // Display the car banner
                    Agency.addCar(); // Add a new car
                    break;
                case 0:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
                    // Display an invalid option message
            }
        }
    }

    static void handleRemoveMainMenuManager() {
        boolean running = true;
        while (running) {
            displayRemoveMenu(); // Display the remove menu options
            int option = getUserOption(); // Get the user input option
            switch (option) {
                case 1:
                    displayOwnerBanner(); // Display the owner banner
                    Agency.removeFromOwnerList(); // Remove an owner from the list
                    break;
                case 2:
                    displayTenantBanner(); // Display the tenant banner
                    Agency.removeFromTenantList(); // Remove a tenant from the list
                    break;
                case 3:
                    displayCarBanner(); // Display the car banner
                    Agency.removeFromCarList(); // Remove a car from the list
                    break;
                case 0:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
                    // Display an invalid option message
            }
        }
    }

    // ADMIN PANEL
    static void handleAgencyManagerMenu() {
        boolean running = true;
        while (running) {
            displayAgencyManagerMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    // Handle adding main menu for managers
                    Agency.handleAddMainMenuManager();
                    break;
                case 2:
                    // Handle removing main menu for managers
                    Agency.handleRemoveMainMenuManager();
                    break;
                case 3:
                    // Handle searching main menu for managers
                    Agency.handleSearchMainMenuManager();
                    break;
                case 4:
                    // Display rent banner
                    displayRentBanner();
                    // Perform rent operation
                    Agency.rent();
                    break;
                case 5:
                    // Handle report menu
                    Agency.handleReportMenu();
                    break;
                case 0:
                    // Confirm logout from admin panel
                    running = confirmLogout("admin panel");
                    break;
                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
            }
        }
    }


}

abstract class UserInterface {

    /*
        This class handles printing banners, colors, validations, logins, user options,
        user authentication, as well as validating all user inputs such as age,
        national ID, phone number, motor capacity, and monetary value

     */

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Integer> validIndexes = new ArrayList<>(); // Initializes an empty list to store valid indexes

    protected static List<Integer> getValidIndexes() {
        return validIndexes;
    }

    // Creating an instance of the DecimalFormat class to separate monetary values into groups of three digits
    protected static final DecimalFormat formattedNumber = new DecimalFormat("#,###,###");

    // Colors
    protected static final String RESET = "\u001B[0m";
    protected static final String RED = "\u001B[31m";
    protected static final String GREEN = "\u001B[32m";
    protected static final String YELLOW = "\u001B[33m";
    protected static final String PURPLE = "\u001B[35m";
    protected static final String WHITE = "\u001B[37m";

    private static void typingAnimation(String text, int delay) {

        /*
         * Displays the text in a typing animation with a specified delay.
         *
         * param text  The text to display.
         * param delay The delay between each character in milliseconds.
         */

        try {
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i)); // Print the current character
                Thread.sleep(delay); // Pause for the specified delay
            }
        } catch (InterruptedException error) {
            error.printStackTrace(); // Ignoring the error
        }
    }

    static void displayOwnerPanelMenu(Owner owner) {

        // Print the banner
        System.out.println();
        String art = """
                   _____        ___   _ _____ ____     ____   _    _   _ _____ _ \s
                  / _ \\ \\      / / \\ | | ____|  _ \\   |  _ \\ / \\  | \\ | | ____| | \s
                 | | | \\ \\ /\\ / /|  \\| |  _| | |_) |  | |_) / _ \\ |  \\| |  _| | | \s
                 | |_| |\\ V  V / | |\\  | |___|  _ <   |  __/ ___ \\| |\\  | |___| |___
                  \\___/  \\_/\\_/  |_| \\_|_____|_| \\_\\  |_| /_/   \\_\\_| \\_|_____|_____|

                """;
        printBanner(art);
        System.out.println();

        // Display owner information
        System.out.println("Number of your tenants                      " + PURPLE + "[" + WHITE + GREEN + owner.getMyTenantsList().size() + RESET + PURPLE + "] " + WHITE);
        System.out.println("Number of cars owned by you                 " + PURPLE + "[" + WHITE + GREEN + owner.getNumberOfCars() + RESET + PURPLE + "] " + WHITE);
        System.out.println("My income (with 90% profit per transaction) " + PURPLE + "[" + WHITE + GREEN + formattedNumber.format(owner.getIncome()) + RESET + PURPLE + "] " + WHITE);
        System.out.println();

        // Print owner details
        Agency.printOwner(owner);
        System.out.println();

        // Display menu options
        System.out.println(PURPLE + "Please select an option :\n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "My Cars ");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "My tenants");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Log out");
    }

    static void displayTenantPanelMenu(Tenant tenant) {

        // Print the banner
        System.out.println();
        String art = """
                  _____ _____ _   _    _    _   _ _____    ____   _    _   _ _____ _
                 |_   _| ____| \\ | |  / \\  | \\ | |_   _|  |  _ \\ / \\  | \\ | | ____| |
                   | | |  _| |  \\| | / _ \\ |  \\| | | |    | |_) / _ \\ |  \\| |  _| | |
                   | | | |___| |\\  |/ ___ \\| |\\  | | |    |  __/ ___ \\| |\\  | |___| |___
                   |_| |_____|_| \\_/_/   \\_\\_| \\_| |_|    |_| /_/   \\_\\_| \\_|_____|_____|

                """;
        printBanner(art);
        System.out.println();

        // Display account balance
        System.out.println("My account balance " + PURPLE + "[" + WHITE + GREEN + formattedNumber.format(tenant.getAccountBalance()) + RESET + PURPLE + "] " + WHITE);
        System.out.println();

        // Print tenant details
        Agency.printTenant(tenant);
        System.out.println();

        // Display rented car information
        Car rentalCar = tenant.getRentedCar();
        if (rentalCar != null) {
            Agency.printCar(rentalCar);
        } else {
            System.out.println(PURPLE + "You did not rent a car" + RESET);
        }
        System.out.println();

        // Display menu options
        System.out.println(PURPLE + "Please select an option :\n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Increase Account Balance ");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Log out");
    }

    static void displayDeveloperInfo() {
        String art = """
                 __        ___   _  ___       _    __  __    ___   ___
                 \\ \\      / / | | |/ _ \\     / \\  |  \\/  |  |_ _| |__ \\
                  \\ \\ /\\ / /| |_| | | | |   / _ \\ | |\\/| |   | |    / /
                   \\ V  V / |  _  | |_| |  / ___ \\| |  | |   | |   |_|
                    \\_/\\_/  |_| |_|\\___/  /_/   \\_\\_|  |_|  |___|  (_)

                """;

        printBanner(art); // Display the banner using ASCII art
        typingAnimation("\n\neverything is on " + PURPLE + "Principle" + RESET + ", everything is on " + PURPLE + "Discipline" + RESET, 90); // Typing animation for a message
        typingAnimation(PURPLE + "\n======================================\n\n" + RESET, 30);
        typingAnimation(YELLOW + "I am " + RESET + GREEN + "Ali Dehghanpour\n" + RESET, 90); // Typing animation for the developer's name
        System.out.println();
        showProjectHours(); // Display project hours
        System.out.println();
        typingAnimation("Email    " + PURPLE + "[" + WHITE + GREEN + "ali75847584@gmail.com" + RESET + PURPLE + "]" + RESET, 90); // Typing animation for the developer's email
        System.out.println();
        typingAnimation("GitHub   " + PURPLE + "[" + WHITE + GREEN + "AliHCl" + RESET + PURPLE + "]" + RESET, 90); // Typing animation for the developer's GitHub username
        System.out.println();
        typingAnimation("Telegram " + PURPLE + "[" + WHITE + GREEN + "@Ali_4201" + RESET + PURPLE + "]" + RESET, 90); // Typing animation for the developer's Telegram username
        System.out.println();
        typingAnimation(PURPLE + "\n======================================\n\n" + RESET, 30);
        System.out.println();
    }

    private static void showProjectHours() {
        try {
            int animationSpeed = 90;
            int projectHours = 63;
            typingAnimation("\r" + YELLOW + "I worked on this project for " + RESET, 90); // Typing animation for the initial message
            for (int i = 0; i <= projectHours; i++) {
                if (i < 10) {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + i); // Displaying the hours with color formatting
                } else if (i < 25) {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + GREEN + i + RESET);
                } else if (i < 30) {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + YELLOW + i + RESET);
                } else {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + RED + i + RESET);
                }
                Thread.sleep(animationSpeed);
            }
            typingAnimation(YELLOW + " hours" + RESET, 90); // Typing animation for displaying "hours"
            System.out.println();
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }

    static void displayHomeMenu() {
        String art = """
                ╔═╗┌─┐┬─┐  ╦═╗┌─┐┌┐┌┌┬┐┌─┐┬    ╔═╗┌─┐┌─┐┌┐┌┌─┐┬ ┬
                ║  ├─┤├┬┘  ╠╦╝├┤ │││ │ ├─┤│    ╠═╣│ ┬├┤ ││││  └┬┘
                ╚═╝┴ ┴┴└─  ╩╚═└─┘┘└┘ ┴ ┴ ┴┴─┘  ╩ ╩└─┘└─┘┘└┘└─┘ ┴
                """;
        printBanner(art); // Display the banner art
        System.out.println("Welcome to the Agency Management System\n");
        System.out.println(PURPLE + "Who are you:\n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Agency Manager"); // Option for Agency Manager
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Owner"); // Option for Owner
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Tenant"); // Option for Tenant
        System.out.println(PURPLE + "[" + WHITE + 4 + PURPLE + "] " + WHITE + "About me"); // Option for About me
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Exit"); // Option to Exit the system
    }

    protected static void displayAgencyManagerMenu() {
        String art = """
                     _    ____  __  __ ___ _   _    ____   _    _   _ _____ _
                    / \\  |  _ \\|  \\/  |_ _| \\ | |  |  _ \\ / \\  | \\ | | ____| |
                   / _ \\ | | | | |\\/| || ||  \\| |  | |_) / _ \\ |  \\| |  _| | |
                  / ___ \\| |_| | |  | || || |\\  |  |  __/ ___ \\| |\\  | |___| |___
                 /_/   \\_\\____/|_|  |_|___|_| \\_|  |_| /_/   \\_\\_| \\_|_____|_____|
                                                                                 
                """;
        printBanner(art); // Display the banner art
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Add"); // Option to add
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Remove"); // Option to remove
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Search"); // Option to search
        System.out.println(PURPLE + "[" + WHITE + 4 + PURPLE + "] " + WHITE + "Rent"); // Option to rent
        System.out.println(PURPLE + "[" + WHITE + 5 + PURPLE + "] " + WHITE + "Print Report"); // Option to print report
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Log out"); // Option to log out
    }

    protected static void displaySearchMenu() {
        System.out.println();
        String art = """
                  ____                      _
                 / ___|  ___  __ _ _ __ ___| |__
                 \\___ \\ / _ \\/ _` | '__/ __| '_ \\
                  ___) |  __/ (_| | | | (__| | | |
                 |____/ \\___|\\__,_|_|  \\___|_| |_|
                                                 
                """;
        printBanner(art); // Display the banner art
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Owners"); // Option to search for owners
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Tenants"); // Option to search for tenants
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Cars"); // Option to search for cars
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back"); // Option to go back
    }

    protected static void displayReportMenu() {
        String art = """
                8888888b.  8888888888 8888888b.   .d88888b.  8888888b. 88888888888
                888   Y88b 888        888   Y88b d88P" "Y88b 888   Y88b    888
                888    888 888        888    888 888     888 888    888    888
                888   d88P 8888888    888   d88P 888     888 888   d88P    888
                8888888P"  888        8888888P"  888     888 8888888P"     888
                888 T88b   888        888        888     888 888 T88b      888
                888  T88b  888        888        Y88b. .d88P 888  T88b     888
                888   T88b 8888888888 888         "Y88888P"  888   T88b    888
                                                                           
                """;
        UserInterface.printBanner(art); // Display the banner art
        int totalCustomers = Owner.getOwnerList().size() + Tenant.getTenantList().size() + Agency.getRemovedTenantsCount() + Agency.getRemovedOwnersCount();
        System.out.println("The total number of customers                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + totalCustomers + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of tenants                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Tenant.getTenantList().size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of owners                           " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Owner.getOwnerList().size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of cars                             " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Car.getCarList().size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of tenants removed                              " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Agency.getRemovedTenantsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of owners removed                               " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Agency.getRemovedOwnersCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of cars removed                                 " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Agency.getRemovedCarsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The number of transactions today                       " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Agency.getTransactionCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The value of transactions conducted                    " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.formattedNumber.format(Agency.getTotalTransactionValue()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Agency profit (calculated at 10% for each transaction) " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.formattedNumber.format(Agency.getTotalProfit()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println();
        System.out.println();
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Owners List"); // Option to view owners list
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Tenants List"); // Option to view tenants list
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Cars List"); // Option to view cars list
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back"); // Option to go back
    }

    protected static void displayAddMenu() {
        System.out.println();
        String art = """
                     _    ____  ____
                    / \\  |  _ \\|  _ \\
                   / _ \\ | | | | | | |
                  / ___ \\| |_| | |_| |
                 /_/   \\_\\____/|____/
                                     
                """;
        printBanner(art); // Display the banner art
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Add Owner"); // Option to add an owner
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Add Tenant"); // Option to add a tenant
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Add Car"); // Option to add a car
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back"); // Option to go back
    }

    protected static void displayRemoveMenu() {
        System.out.println();
        String art = """
                  ____  _____ __  __  _____     _______
                 |  _ \\| ____|  \\/  |/ _ \\ \\   / / ____|
                 | |_) |  _| | |\\/| | | | \\ \\ / /|  _|
                 |  _ <| |___| |  | | |_| |\\ V / | |___
                 |_| \\_\\_____|_|  |_|\\___/  \\_/  |_____|
                                                       
                """;
        printBanner(art); // Display the banner art
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Remove Owner"); // Option to remove an owner
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Remove Tenant"); // Option to remove a tenant
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Remove Car"); // Option to remove a car
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back"); // Option to go back
    }

    protected static void displayOwnerBanner() {
        System.out.println();
        String art = """
                   ___
                  / _ \\__      ___ __   ___ _ __
                 | | | \\ \\ /\\ / / '_ \\ / _ \\ '__|
                 | |_| |\\ V  V /| | | |  __/ |
                  \\___/  \\_/\\_/ |_| |_|\\___|_|
                                               
                """;
        printBanner(art); // Display the owner banner art
        System.out.println();
    }

    protected static void displayTenantBanner() {
        System.out.println();
        String art = """
                  _____                      _
                 |_   _|__ _ __   __ _ _ __ | |_
                   | |/ _ \\ '_ \\ / _` | '_ \\| __|
                   | |  __/ | | | (_| | | | | |_
                   |_|\\___|_| |_|\\__,_|_| |_|\\__|
                                               
                """;
        printBanner(art); // Display the tenant banner art
        System.out.println();
    }

    protected static void displayCarBanner() {
        System.out.println();
        String art = """
                   ____
                  / ___|__ _ _ __
                 | |   / _` | '__|
                 | |__| (_| | |
                  \\____\\__,_|_|
                                 
                """;
        printBanner(art); // Display the car banner art
        System.out.println();
    }

    protected static void displayRentBanner() {
        System.out.println();
        String art = """
                  ____  _____ _   _ _____
                 |  _ \\| ____| \\ | |_   _|
                 | |_) |  _| |  \\| | | |
                 |  _ <| |___| |\\  | | |
                 |_| \\_\\_____|_| \\_| |_|
                                         
                """;
        printBanner(art); // Display the rent banner art
        System.out.println();
    }

    protected static void displayOwnerSearchMenu() {
        System.out.println();
        String art = """
                   ___
                  / _ \\__      ___ __   ___ _ __
                 | | | \\ \\ /\\ / / '_ \\ / _ \\ '__|
                 | |_| |\\ V  V /| | | |  __/ |
                  \\___/  \\_/\\_/ |_| |_|\\___|_|
                                                
                """;
        printBanner(art); // Display the owner search menu banner art
        System.out.println();
        System.out.println(PURPLE + "Which of the following options do you intend to search within? \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "First/Last Name");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "First Name");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Last Name");
        System.out.println(PURPLE + "[" + WHITE + 4 + PURPLE + "] " + WHITE + "National Code");
        System.out.println(PURPLE + "[" + WHITE + 5 + PURPLE + "] " + WHITE + "Phone Number");
        System.out.println(PURPLE + "[" + WHITE + 6 + PURPLE + "] " + WHITE + "Username");
        System.out.println(PURPLE + "[" + WHITE + 7 + PURPLE + "] " + WHITE + "Age");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
    }

    protected static void displayTenantSearchMenu() {
        System.out.println();
        String art = """
                  _____                      _
                 |_   _|__ _ __   __ _ _ __ | |_
                   | |/ _ \\ '_ \\ / _` | '_ \\| __|
                   | |  __/ | | | (_| | | | | |_
                   |_|\\___|_| |_|\\__,_|_| |_|\\__|
                                                
                """;
        printBanner(art); // Display the tenant search menu banner art
        System.out.println();
        System.out.println(PURPLE + "Which of the following options do you intend to search within? \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "First/Last Name");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "First Name");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Last Name");
        System.out.println(PURPLE + "[" + WHITE + 4 + PURPLE + "] " + WHITE + "Account Balance");
        System.out.println(PURPLE + "[" + WHITE + 5 + PURPLE + "] " + WHITE + "National Code");
        System.out.println(PURPLE + "[" + WHITE + 6 + PURPLE + "] " + WHITE + "Phone Number");
        System.out.println(PURPLE + "[" + WHITE + 7 + PURPLE + "] " + WHITE + "Username");
        System.out.println(PURPLE + "[" + WHITE + 8 + PURPLE + "] " + WHITE + "Age");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
    }

    protected static void displayCarSearchMenu() {
        System.out.println();
        String art = """
                   ____
                  / ___|__ _ _ __
                 | |   / _` | '__|
                 | |__| (_| | |
                  \\____\\__,_|_|
                                
                """;
        printBanner(art); // Display the car search menu banner art
        System.out.println();
        System.out.println(PURPLE + "Which of the following options do you intend to search within? \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Engine Capacity");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Name Model");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Rent Money");
        System.out.println(PURPLE + "[" + WHITE + 4 + PURPLE + "] " + WHITE + "Life Span");
        System.out.println(PURPLE + "[" + WHITE + 5 + PURPLE + "] " + WHITE + "Owner");
        System.out.println(PURPLE + "[" + WHITE + 6 + PURPLE + "] " + WHITE + "Type");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
    }

    protected static void showYesNoOptions() {
        System.out.println();
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No");
    }

    protected static int validateUserInput(int option) {
        // Check if the option is valid by comparing it with the valid indexes
        while (!getValidIndexes().contains(option)) {
            System.out.println(RED + "The input is invalid. Please try again" + RESET);
            // Prompt the user again to enter a valid option
            option = getUserOption();
        }
        // Clear the valid indexes for the next validation
        getValidIndexes().clear();
        // Return the validated option
        return option;
    }

    protected static int validateNumericInput(String askText, String userInputColor) {
        // Print the askText to prompt the user for input
        System.out.print(askText);

        // Initialize variables
        int inputNumber = 0; // Variable to store the user input
        boolean isValidInput = false; // Flag to track if the input is valid

        // Continue looping until a valid input is entered
        while (!isValidInput) {
            try {
                System.out.print(userInputColor); // Set the color for user input
                inputNumber = scanner.nextInt(); // Read the user input as an integer
                scanner.nextLine(); // Consume the remaining newline character
                System.out.print(RESET); // Reset the color

                isValidInput = true; // Set the flag to indicate a valid input
            } catch (InputMismatchException invalidInput) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println(RED + "Invalid input. Please enter a valid integer." + RESET);
                System.out.print(askText); // Print the askText again to prompt for valid input
            }
        }

        return inputNumber; // Return the validated input number
    }

    protected static int getAndValidateAge(String type) {
        int age;

        // Continue looping until a valid age is entered
        do {
            age = UserInterface.validateNumericInput("Enter the " + type + "'s age: ", UserInterface.PURPLE);

            // Check if the age is below 18
            if (age < 18) {
                System.out.println(UserInterface.RED + "You have not reached the legal age" + UserInterface.RESET);
            }
            // Check if the age is above 150
            else if (age > 150) {
                System.out.println(UserInterface.RED + "Invalid age entered" + UserInterface.RESET);
            }
        } while (age < 18 || age > 150);

        return age; // Return the validated age
    }

    protected static String getAndValidateNationalCode(String type) {
        String nationalCode;
        // The number 10 here indicates that the previous range should be repeated 10 times, and no character should be used in between
        String pattern = "[0-9]{10}";

        // Continue looping until a valid national code is entered
        do {
            System.out.print("Enter the " + type + "'s national code: ");
            System.out.print(UserInterface.PURPLE);
            nationalCode = scanner.nextLine();
            System.out.print(UserInterface.RESET);

            if (!nationalCode.matches(pattern)) {
                System.out.println(UserInterface.RED + "Invalid national code entered" + UserInterface.RESET);
            }
        } while (!nationalCode.matches(pattern));

        return nationalCode; // Return the validated national code
    }

    protected static String getAndValidatePhoneNumber(String type) {
        String phoneNumber;
        // The number 11 here indicates that the previous range should be repeated 11 times, and no character should be used in between
        String pattern = "[0-9]{11}";

        // Continue looping until a valid phone number is entered
        do {
            System.out.print("Enter the " + type + "'s phone number: ");
            System.out.print(UserInterface.PURPLE);
            phoneNumber = scanner.nextLine();
            System.out.print(UserInterface.RESET);

            if (!phoneNumber.matches(pattern)) {
                System.out.println(UserInterface.RED + "Invalid phone number entered" + UserInterface.RESET);
            }
        } while (!phoneNumber.matches(pattern));

        return phoneNumber; // Return the validated phone number
    }

    protected static int getAndValidateEngineCapacity() {
        int engineCapacity;

        // Continue looping until a valid engine capacity is entered
        do {
            engineCapacity = UserInterface.validateNumericInput("Enter the car's engine capacity: ", UserInterface.PURPLE);

            // Check if the engine capacity is less than 700 cc
            if (engineCapacity < 700) {
                System.out.println(UserInterface.YELLOW + "Engine capacity must be above " + UserInterface.RESET + UserInterface.RED + " 700 cc" + UserInterface.RESET);
            }
        } while (engineCapacity < 700);

        return engineCapacity; // Return the validated engine capacity
    }

    protected static int getAndValidateMoney(String askText, String errorText) {
        int money;

        // Continue looping until a valid amount of money is entered
        do {
            money = UserInterface.validateNumericInput(askText, UserInterface.PURPLE);

            // Check if the money is less than 1,500,000
            if (money < 1_500_000) {
                System.out.println(errorText);
            }
        } while (money < 1_500_000);

        return money; // Return the validated amount of money
    }

    static boolean confirmLogout(String location) {
        System.out.println(YELLOW + "Would you like to log out of " + location + "?\n" + RESET);
        showYesNoOptions();

        while (true) {
            int option = getUserOption();

            // Check the user's option and return the corresponding boolean value
            switch (option) {
                case 1:
                    return false; // User chose "No", so return false to indicate not logging out
                case 2:
                    return true; // User chose "Yes", so return true to indicate logging out
                default:
                    System.out.println(UserInterface.RED + "\nInvalid input" + UserInterface.RESET);
                    break;
            }
        }
    }

    private static void printBanner(String art) {
        int num = art.length() / 2;

        // Print the first half of the banner with purple color
        for (int i = 0; i < num; i++) {
            System.out.print(PURPLE + art.charAt(i));
            try {
                Thread.sleep(2); // Pause for a short period of time to create an effect
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Print the second half of the banner with white color
        for (int i = num; i < art.length(); i++) {
            System.out.print(WHITE + art.charAt(i));
            try {
                Thread.sleep(2); // Pause for a short period of time to create an effect
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected static int getUserOption() {
        // Initialize variables
        boolean isValidInput = false;
        int option = 0;

        // Display prompt for user input
        System.out.print(PURPLE + "\n\nEnter your option: " + RESET);

        // Loop until a valid input is provided
        while (!isValidInput) {
            try {
                // Read the user's input as an integer
                option = scanner.nextInt();
                System.out.println();
                scanner.nextLine();
                isValidInput = true; // Set the flag to true to exit the loop
            } catch (InputMismatchException invalidInput) {
                // Handle invalid input (non-integer)
                scanner.nextLine();
                System.out.println(RED + "Invalid input. Please enter a valid integer." + RESET);
                System.out.print(PURPLE + "Enter your option: " + RESET);
            }
        }

        // Return the valid option chosen by the user
        return option;
    }

}
