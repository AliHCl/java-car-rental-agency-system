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
    private String nameModel;
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

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
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

    public String getNameModel() {
        return nameModel;
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
    private Integer accountBalance;
    private Car rentedCar;

    public void rentCar() {
        // Renting car logic
    }

    public void findSuitableCar() {
        // Finding suitable car logic
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setRentedCar(Car car) {
        this.rentedCar = car;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public Car getRentedCar() {
        return rentedCar;
    }
}

class Owner extends Human {
    private final List<String> myCars = new ArrayList<String>();

    public void showMyCars() {
    }

    public void showIncome() {
    }
}

class Agency {
    // ArrayList --> https://www.youtube.com/watch?v=pruuvCVXIt8
    private final List<Car> carList = new ArrayList<Car>();
    private final List<Owner> ownerList = new ArrayList<Owner>();
    private final List<Tenant> tenantList = new ArrayList<Tenant>();
    private final List<Car> rentedCarList = new ArrayList<Car>();
    private boolean rentedCarStatus = true;
    private boolean carRentalStatus = true;


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

    public Car getCarByIndex(int index) {
        if (index >= 0 && index < carList.size()) {
            return carList.get(index);
        } else {
            System.out.println();
            System.out.println("Car not found :(");
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
        rentedCarList.add(car);
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

    public Boolean getCarRentalStatus() {
        return carRentalStatus;
    }

    public Boolean getRentedCarStatus() {
        return rentedCarStatus;
    }

    public void printOwners() {
        if (!ownerList.isEmpty()) {
            System.out.println("List of Owners:");
            for (Owner owner : ownerList) {
                System.out.println("Username: " + owner.getUsername());
                System.out.println("Password: " + owner.getPassword());
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
                System.out.println("Username: " + tenant.getUsername());
                System.out.println("Password: " + tenant.getPassword());
                System.out.println("First Name: " + tenant.getFirstName());
                System.out.println("Last Name: " + tenant.getLastName());
                System.out.println("Age: " + tenant.getAge());
                System.out.println("National Code: " + tenant.getNationalCode());
                System.out.println("Phone Number: " + tenant.getPhoneNumber());
                System.out.println("Address: " + tenant.getAddress());
                System.out.println("Account Balance: " + tenant.getAccountBalance());
                System.out.println("-----------------------------------");
            }
        }
    }

    public void printTenant(Tenant tenant) {
        if (!tenantList.isEmpty()) {
            System.out.println("Information of " + tenant.getFirstName() + ' ' + tenant.getLastName() + ": ");
            System.out.println("Username: " + tenant.getUsername());
            System.out.println("Password: " + tenant.getPassword());
            System.out.println("First Name: " + tenant.getFirstName());
            System.out.println("Last Name: " + tenant.getLastName());
            System.out.println("Age: " + tenant.getAge());
            System.out.println("National Code: " + tenant.getNationalCode());
            System.out.println("Phone Number: " + tenant.getPhoneNumber());
            System.out.println("Address: " + tenant.getAddress());
            System.out.println("Account Balance: " + tenant.getAccountBalance());
            System.out.println("-----------------------------------");
        }
    }

    public void printCars() {
        if (!carList.isEmpty()) {
            System.out.println("List of Cars:");
            for (Car car : carList) {
                System.out.println("Name Model: " + car.getNameModel());
                System.out.println("Engine Capacity: " + car.getEngineCapacity());
                System.out.println("Owner: " + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName());
                System.out.println("Rent Money: " + car.getRentMoney());
                System.out.println("Type: " + car.getType());
                System.out.println("Lifespan: " + car.getLifespan());
                System.out.println("-----------------------------------");
            }
        }
    }

    public void printOwnerList(String type) {
        if (type.equalsIgnoreCase("username")) {
            for (Owner owner : ownerList) {
                System.out.println("[" + ownerList.indexOf(owner) + "]" + " " + owner.getUsername());

            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Owner owner : ownerList) {
                System.out.println("[" + ownerList.indexOf(owner) + "]" + " " + owner.getFirstName() + ' ' + owner.getLastName());

            }

        }
    }

    public void printCarList(boolean exception) {
        for (Car car : carList) {
            if (exception) {
                if (!rentedCarList.contains(car)) {
                    carRentalStatus = true;
                    System.out.println("[" + carList.indexOf(car) + "]" + " " + car.getNameModel());

                } else {
                    carRentalStatus = false;
                }
            } else {
                System.out.println("[" + carList.indexOf(car) + "]" + " " + car.getNameModel());


            }
        }
    }


    public void printTenantList(String type, boolean exception) {
        if (type.equalsIgnoreCase("username")) {
            for (Tenant tenant : tenantList) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        rentedCarStatus = true;
                        System.out.println("[" + tenantList.indexOf(tenant) + "]" + " " + tenant.getUsername());

                    } else {
                        rentedCarStatus = false;
                    }
                } else {
                    System.out.println("[" + tenantList.indexOf(tenant) + "]" + " " + tenant.getUsername());

                }
            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Tenant tenant : tenantList) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        rentedCarStatus = true;
                        System.out.println("[" + tenantList.indexOf(tenant) + "]" + " " + tenant.getFirstName() + ' ' + tenant.getLastName());

                    } else {
                        rentedCarStatus = false;
                    }
                } else {
                    System.out.println("[" + tenantList.indexOf(tenant) + "]" + " " + tenant.getFirstName() + ' ' + tenant.getLastName());

                }

            }
        }
    }

    public List<Tenant> getTenantList() {
        return tenantList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getRentedCarList() {
        return rentedCarList;
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
                    if (!agency.getOwnerList().isEmpty()) {
                        System.out.println();
                        agency.printOwnerList("username");
                        System.out.print("Select Username : ");
                        int index_username_owner = scanner.nextInt();
                        scanner.nextLine();
                        Owner owner = agency.getOwnerByIndex(index_username_owner);
                        if (owner == null) {
                            break;
                        }
                        System.out.print("Enter Password : ");
                        password = scanner.nextLine();
                        if (password.equals(owner.getPassword())) {
                            System.out.println();
                            System.out.println("Welcome, " + owner.getFirstName() + ":)");
                            System.out.println("handleOwner");
                        } else {
                            System.out.println();
                            System.out.println("Access denied :(");
                            System.out.println();
                        }
                    } else {
                        System.out.println();
                        System.out.println("No owner has been registered :(");
                        System.out.println();
                    }
                    break;

                case 3:
                    if (!agency.getTenantList().isEmpty()) {
                        System.out.println();
                        agency.printTenantList("username", false);
                        System.out.print("Select Username : ");
                        int index_username_tenant = scanner.nextInt();
                        scanner.nextLine();
                        Tenant tenant = agency.getTenantByIndex(index_username_tenant);
                        if (tenant == null) {
                            break;
                        }
                        System.out.print("Enter Password : ");
                        password = scanner.nextLine();
                        if (password.equals(tenant.getPassword())) {
                            System.out.println();
                            System.out.println("Welcome, " + tenant.getFirstName() + ":)");
                            System.out.println("handleTenant");
                        } else {
                            System.out.println();
                            System.out.println("Access denied :(");
                            System.out.println();
                        }
                    } else {
                        System.out.println();
                        System.out.println("No tenant has been registered :(");
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
        System.out.println("[1] Agency Manager");
        System.out.println("[2] Owner");
        System.out.println("[3] Tenant");
        System.out.println("[0] Exit");
    }

    private static void displayAgencyManagerMenu() {

        System.out.println("Please select an option:");
        System.out.println("[1] Add Owner");
        System.out.println("[2] Add Tenant");
        System.out.println("[3] Add Car");
        System.out.println("[4] Print Report");
        System.out.println("[5] Rent");
        System.out.println("[0] Exit");
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
                case 5:
                    rent();
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

    private static int getUserOption() {
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    private static void rent() {
        if (!agency.getTenantList().isEmpty()) {
            System.out.println("Please select the desired tenant : ");
            agency.printTenantList("name", true);
            if (agency.getRentedCarStatus()) {
                int option = getUserOption();
                Tenant tenant = agency.getTenantByIndex(option);


                if (!agency.getCarList().isEmpty()) {
                    System.out.println("Please select the desired car : ");
                    agency.printCarList(true);
                    if (agency.getCarRentalStatus()) {
                        option = getUserOption();
                    } else {
                        System.out.println("All cars have been rented out");
                    }

                } else {
                    System.out.println("No car has been registered :(");
                }

                agency.printTenant(tenant);
                Car car = agency.getCarByIndex(option);
                if (car.getRentMoney() < tenant.getAccountBalance()) {
                    System.out.print("Please enter the rental period in days : ");
                    int day = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Do you want to rent a "
                            + car.getNameModel() + " car to " + tenant.getFirstName() + ' ' + tenant.getLastName() +
                            " for a duration of " + day + " days?");
                    System.out.println();
                    System.out.println("[1] Yes");
                    System.out.println("[2] No");
                    System.out.print("Enter : ");
                    int status = scanner.nextInt();
                    if (status == 1) {
                        System.out.println("The car has been successfully rented :)");
                        System.out.println("A amount of "
                                + car.getRentMoney() + " Toman has been deducted from " + tenant.getFirstName() + ' ' + tenant.getLastName() +
                                "'s account.");
                        tenant.setAccountBalance(tenant.getAccountBalance() - car.getRentMoney());
                        tenant.setRentedCar(car);
                        agency.addRentedCarList(car);
                    } else if (status == 2) {
                        System.out.println("The operation has been canceled :(");
                    } else {
                        System.out.println("Invalid input");
                    }
                } else {
                    System.out.println("The user's account balance is insufficient :(");
                }

            } else {
                System.out.println("All tenants have rented a car");

            }
        } else {
            System.out.println("No tenant has been registered :(");
        }
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

        System.out.print("Enter the tenant's accountBalance: ");
        int accountBalance = scanner.nextInt();
        scanner.nextLine();
        if (accountBalance >= 1_500_000) {
            tenant.setAccountBalance(accountBalance);
        } else {
            System.out.println();
            System.out.println("The minimum accountBalance amount must be 1,500,000 toman :(");
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

        System.out.print("Enter the car's Name Model: ");
        car.setNameModel(scanner.nextLine());

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
        if (!agency.getOwnerList().isEmpty()) {
            agency.printOwnerList("name");
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
        } else {
            System.out.println("No owner has been registered :(");
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        // اون کلاسی که ااوله و مین داره اجرا میشه
        // اصن کاری به این خط پایینی و اسم فایل نداره
        // اگه خط پایین رو پاک کنی بازم کلاس رابط کاربری اجرا میشه
        UserInterface ss = new UserInterface();
    }
}
