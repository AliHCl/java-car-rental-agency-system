import org.w3c.dom.html.HTMLAnchorElement;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Human {
    private String firstName;
    private String lastName;
    private Integer age;
    private String nationalCode;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


class Car {
    private Integer engineCapacity;
    private Owner owner;
    private Integer rentMoney;
    private String type;
    private Integer lifespan;

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setRentMoney(Integer rentMoney) {
        this.rentMoney = rentMoney;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public Owner getOwner() {
        return owner;
    }

    public Integer getRentMoney() {
        return rentMoney;
    }

    public String getType() {
        return type;
    }

    public Integer getLifespan() {
        return lifespan;
    }
}

class Tenant extends Human {
    private Integer budget;

    public void rentCar() {
        // Renting car logic
    }

    public void findSuitableCar() {
        // Finding suitable car logic
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getBudget() {
        return budget;
    }
}

class Owner extends Human {
    private final List<String> myCars = new ArrayList<String>();

    public void showMyCars() {
        // Displaying owner's cars logic
    }

    public void showIncome() {
        // Displaying owner's income logic
    }
}

class Agency {
    // ArrayList --> https://www.youtube.com/watch?v=pruuvCVXIt8
    private final List<Car> carList = new ArrayList<Car>();
    private final List<Owner> ownerList = new ArrayList<Owner>();
    private final List<Tenant> tenantList = new ArrayList<Tenant>();
    private final List<Car> rentedCarList = new ArrayList<Car>();

    public Owner getOwnerByIndex(int index) {
        if (index >= 0 && index < ownerList.size()) {
            return ownerList.get(index);
        } else {
            System.out.println();
            System.out.println("Owner not found :(");
            System.out.println();
            return null;
        }
    }

    public Tenant getTenantByIndex(int index) {
        if (index >= 0 && index < tenantList.size()) {
            return tenantList.get(index);
        } else {
            System.out.println();
            System.out.println("Tenant not found :(");
            System.out.println();
            return null;
        }
    }

    public void addOwner(Owner owner) {
        ownerList.add(owner);
    }

    public void addTenant(Tenant tenant) {
        tenantList.add(tenant);
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void addRentedCarList(Car car) {
    }

    public void removeCar(Car car) {
        // Removing car logic
    }

    public void removeOwner(Owner owner) {
        // Removing owner logic
    }

    public void removeTenant(Tenant tenant) {
        // Removing tenant logic
    }

    public void search() {
        // Searching logic
    }

    public void printReport() {

    }

    public void printOwners() {
        if (!ownerList.isEmpty()) {
            System.out.println("List of Owners:");
            for (Owner owner : ownerList) {
                System.out.println("First Name: " + owner.getFirstName());
                System.out.println("Last Name: " + owner.getLastName());
                System.out.println("Age: " + owner.getAge());
                System.out.println("National Code: " + owner.getNationalCode());
                System.out.println("Phone Number: " + owner.getPhoneNumber());
                System.out.println("Address: " + owner.getAddress());
                System.out.println("-----------------------------------");
            }
        }
    }

    public void printTenants() {
        if (!tenantList.isEmpty()) {
            System.out.println("List of Tenants:");
            for (Tenant tenant : tenantList) {
                System.out.println("First Name: " + tenant.getFirstName());
                System.out.println("Last Name: " + tenant.getLastName());
                System.out.println("Age: " + tenant.getAge());
                System.out.println("National Code: " + tenant.getNationalCode());
                System.out.println("Phone Number: " + tenant.getPhoneNumber());
                System.out.println("Address: " + tenant.getAddress());
                System.out.println("Budget: " + tenant.getBudget());
                System.out.println("-----------------------------------");
            }
        }
    }

    public void printCars() {
        if (!carList.isEmpty()) {
            System.out.println("List of Cars:");
            for (Car car : carList) {
                System.out.println("Engine Capacity: " + car.getEngineCapacity());
                System.out.println("Owner: " + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName());
                System.out.println("Rent Money: " + car.getRentMoney());
                System.out.println("Type: " + car.getType());
                System.out.println("Lifespan: " + car.getLifespan());
                System.out.println("-----------------------------------");
            }
        }
    }
}

class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Agency agency = new Agency();
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int option = getUserOption();
            String username;
            String password;
            switch (option) {
                case 1:
                    System.out.print("Enter Username : ");
                    username = scanner.nextLine();
                    System.out.print("Enter Password : ");
                    password = scanner.nextLine();
                    if (username.equals("admin") && password.equals("admin")) {
                        System.out.println();
                        System.out.println("Welcome, " + username + ":)");
                        handleAgencyManager();
                    } else {
                        System.out.println();
                        System.out.println("Access denied :(");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Select Username : ");
                    int index_username_owner = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Password : ");
                    password = scanner.nextLine();
                    Owner owner = agency.getOwnerByIndex(index_username_owner);
                    if (password.equals(owner.getPassword())) {
                        System.out.println();
                        System.out.println("Welcome, " + owner.getFirstName() + ":)");
                        System.out.println("handleOwner");
                    } else {
                        System.out.println();
                        System.out.println("Access denied :(");
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Select Username : ");
                    int index_username_tenant = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Password : ");
                    password = scanner.nextLine();
                    Tenant tenant = agency.getTenantByIndex(index_username_tenant);
                    if (password.equals(tenant.getPassword())) {
                        System.out.println();
                        System.out.println("Welcome, " + tenant.getFirstName() + ":)");
                        System.out.println("handleTenant");
                    } else {
                        System.out.println();
                        System.out.println("Access denied :(");
                        System.out.println();
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid option! Please try again.");
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }

    private static void displayMainMenu() {
        System.out.println("Welcome to the Agency Management System");
        System.out.println();
        System.out.println("Who are you:");
        System.out.println("1. Agency Manager");
        System.out.println("2. Owner");
        System.out.println("3. Tenant");
        System.out.println("0. Exit");
    }

    private static void handleAgencyManager() {
        boolean running = true;
        while (running) {
            displayAgencyManagerMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    addOwner();
                    break;
                case 2:
                    addTenant();
                    break;
                case 3:
                    addCar();
                    break;
                case 4:
                    agency.printOwners();
                    agency.printTenants();
                    agency.printCars();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void displayAgencyManagerMenu() {

        System.out.println("Please select an option:");
        System.out.println("1. Add Owner");
        System.out.println("2. Add Tenant");
        System.out.println("3. Add Car");
        System.out.println("4. Print Report");
        System.out.println("0. Exit");
    }

    private static int getUserOption() {
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    private static void addOwner() {
        Owner owner = new Owner();

        System.out.print("Enter the owner's username: ");
        owner.setUsername(scanner.nextLine());

        System.out.print("Enter the owner's password: ");
        owner.setPassword(scanner.nextLine());

        System.out.print("Enter the owner's first name: ");
        owner.setFirstName(scanner.nextLine());

        System.out.print("Enter the owner's last name: ");
        owner.setLastName(scanner.nextLine());

        System.out.print("Enter the owner's age: ");
        int age = scanner.nextInt();
        if (age >= 18 && age <= 250) {
            owner.setAge(age);
            scanner.nextLine();
        } else if (age < 18) {
            System.out.println();
            System.out.println("You have not reached the legal age :(");
            System.out.println();
            return;
        } else {
            System.out.println();
            System.out.println("Invalid age entered :(");
            System.out.println();
            return;
        }

        System.out.print("Enter the owner's national code: ");
        String nationalCode = scanner.nextLine();
        if (nationalCode.length() == 10) {
            owner.setNationalCode(nationalCode);
        } else {
            System.out.println();
            System.out.println("Invalid national code entered :(");
            System.out.println();
            return;
        }

        System.out.print("Enter the owner's phone number: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.length() == 11) {
            owner.setPhoneNumber(phoneNumber);
        } else {
            System.out.println();
            System.out.println("Invalid phone number entered :(");
            System.out.println();
            return;
        }


        System.out.print("Enter the owner's address: ");
        owner.setAddress(scanner.nextLine());


        agency.addOwner(owner);
        System.out.println();
        System.out.println("Owner added successfully!");
        System.out.println();
    }

    private static void addTenant() {
        Tenant tenant = new Tenant();

        System.out.print("Enter the tenant's username: ");
        tenant.setUsername(scanner.nextLine());

        System.out.print("Enter the tenant's password: ");
        tenant.setPassword(scanner.nextLine());

        System.out.print("Enter the tenant's first name: ");
        tenant.setFirstName(scanner.nextLine());

        System.out.print("Enter the tenant's last name: ");
        tenant.setLastName(scanner.nextLine());

        System.out.print("Enter the tenant's age: ");
        int age = scanner.nextInt();
        if (age >= 18 && age <= 250) {
            tenant.setAge(age);
            scanner.nextLine();
        } else if (age < 18) {
            System.out.println();
            System.out.println("You have not reached the legal age :(");
            System.out.println();
            return;
        } else {
            System.out.println();
            System.out.println("Invalid age entered :(");
            System.out.println();
            return;
        }

        System.out.print("Enter the tenant's national code: ");
        String nationalCode = scanner.nextLine();
        if (nationalCode.length() == 10) {
            tenant.setNationalCode(nationalCode);
        } else {
            System.out.println();
            System.out.println("Invalid national code entered :(");
            System.out.println();
            return;
        }

        System.out.print("Enter the tenant's phone number: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.length() == 11) {
            tenant.setPhoneNumber(phoneNumber);
        } else {
            System.out.println();
            System.out.println("Invalid phone number entered :(");
            System.out.println();
            return;
        }

        System.out.print("Enter the tenant's address: ");
        tenant.setAddress(scanner.nextLine());

        System.out.print("Enter the tenant's budget: ");
        int budget = scanner.nextInt();
        scanner.nextLine();
        if (budget >= 1_500_000) {
            tenant.setBudget(budget);
        } else {
            System.out.println();
            System.out.println("The minimum budget amount must be 1,500,000 toman :(");
            System.out.println();
            return;
        }

        agency.addTenant(tenant);
        System.out.println();
        System.out.println("Tenant added successfully!");
        System.out.println();
    }

    private static void addCar() {
        Car car = new Car();

        System.out.print("Enter the car's engine capacity: ");
        int engineCapacity = scanner.nextInt();
        if (engineCapacity > 700) {
            car.setEngineCapacity(engineCapacity);
            scanner.nextLine();
        } else {
            System.out.println();
            System.out.println("Engine capacity must be above 700 cc");
            System.out.println();
            return;
        }

        System.out.print("Enter the car's owner index: ");
        int ownerIndex = scanner.nextInt();
        scanner.nextLine();
        Owner owner = agency.getOwnerByIndex(ownerIndex);
        if (owner == null) {
            return;
        }
        car.setOwner(owner);

        System.out.print("Enter the car's rent money: ");
        int rentMoney = scanner.nextInt();
        if (rentMoney >= 1_500_000) {
            car.setRentMoney(rentMoney);
            scanner.nextLine();
        } else {
            System.out.println();
            System.out.println("The entered rental amount must be above 1,500,000 toman :(");
            System.out.println();
            return;
        }

        System.out.print("Enter the car's type: ");
        car.setType(scanner.nextLine());

        System.out.print("Enter the car's lifespan: ");
        car.setLifespan(scanner.nextInt());
        scanner.nextLine();

        agency.addCar(car);
        System.out.println();
        System.out.println("Car added successfully!");
        System.out.println();
    }
}


public class Demo {
    public static void main(String[] args) {
        UserInterface ss = new UserInterface();
    }
}
