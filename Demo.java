import javax.naming.directory.InvalidAttributeIdentifierException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // اون کلاسی که ااوله و مین داره اجرا میشه
        // اصن کاری به این خط پایینی و اسم فایل نداره
        // اگه خط پایین رو پاک کنی بازم کلاس رابط کاربری اجرا میشه
        UserInterface.main(null);
        System.out.println(UserInterface.RESET); // reset color console

    }
}


class Human {
    private String firstName;
    private String lastName;
    private Integer age;
    private String nationalCode;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Car {
    private String nameModel;
    private Integer engineCapacity;
    private Owner owner;
    private Integer rentMoney;
    private String type;
    private Integer lifespan;
    private static final List<Car> carList = new ArrayList<>();
    private static final List<Car> rentedCarList = new ArrayList<>();

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public Integer getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(Integer rentMoney) {
        this.rentMoney = rentMoney;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    public static List<Car> getCarList() {
        return carList;
    }

    public static List<Car> getRentedCarList() {
        return rentedCarList;
    }
}

class Tenant extends Human {
    private Integer accountBalance;
    private Car rentedCar;
    private Owner rentedCarOwner;
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Tenant> tenantList = new ArrayList<>();

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Owner getRentedCarOwner() {
        return rentedCarOwner;
    }

    public void setRentedCarOwner(Owner rentedCarOwner) {
        this.rentedCarOwner = rentedCarOwner;
    }

    public Car getRentedCar() {
        return rentedCar;
    }

    public void setRentedCar(Car car) {
        this.rentedCar = car;
    }

    public static List<Tenant> getTenantList() {
        return tenantList;
    }

    public static void increaseAccountBalance(Tenant tenant) {
        System.out.print(UserInterface.YELLOW + "Please enter the desired amount : " + UserInterface.RESET);
        System.out.print(UserInterface.GREEN);
        int amount = scanner.nextInt();
        System.out.println(UserInterface.RESET);
        System.out.println(UserInterface.YELLOW + "Do you want to increase your account balance by " + UserInterface.GREEN + UserInterface.formattedNumber.format(amount) + UserInterface.RESET + UserInterface.YELLOW + " toman?" + UserInterface.RESET);
        System.out.println();
        UserInterface.showConfirmationPrompt();
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

}

class Owner extends Human {
    private int income;
    private int numberOfCars;
    private final List<Tenant> myTenantsList = new ArrayList<>();
    private static final List<Owner> ownerList = new ArrayList<>();
    private final List<Car> ownerCarList = new ArrayList<>();

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public List<Tenant> getMyTenantsList() {
        return myTenantsList;
    }

    public static List<Owner> getOwnerList() {
        return ownerList;
    }

    public List<Car> getOwnerCarList() {
        return ownerCarList;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public static void displayMyCars(Owner owner) {
        boolean running = true;
        while (running) {
            System.out.println(UserInterface.PURPLE + "\nThe list of your cars \n" + UserInterface.RESET);
            Agency.setIsCarOwner(false);
            Owner.displayOwnerCarsFiltered(owner);
            if (Agency.getIsCarOwner()) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + Car.getCarList().size() + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");
                UserInterface.getValidIndexes().add(Car.getCarList().size());
                int option = UserInterface.getUserOption();
                option = UserInterface.validateUserInput(option);
                if (option == Car.getCarList().size()) {
                    running = false;
                } else {
                    Car car = Agency.getCarByIndex(option);
                    Agency.printCar(car);
                    System.out.println("Is the car rented by a tenant? " + UserInterface.PURPLE + "[" + UserInterface.RESET + (Agency.isCarRented(car) ? UserInterface.GREEN + "Yes" + UserInterface.RESET : UserInterface.RED + "No" + UserInterface.RESET) + UserInterface.PURPLE + "]" + UserInterface.RESET);
                }
            } else {
                System.out.println(UserInterface.RED + "No cars are registered under your name :(" + UserInterface.RESET);
                running = false;
            }
        }
    }

    public static void displayOwnerCarsFiltered(Owner owner) {

        for (Car car : Car.getCarList()) {
            if (car.getOwner().equals(owner)) {
                Agency.setIsCarOwner(true);
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Car.getCarList().indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                UserInterface.getValidIndexes().add(Car.getCarList().indexOf(car));
            }
        }
    }

    public static void printMyTenantsList(Owner owner) {
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
}

class Agency extends UserInterface {
    // ArrayList --> https://www.youtube.com/watch?v=pruuvCVXIt8
    private static boolean rentedCarStatus = false;
    private static boolean carRentalStatus = false;
    private static final boolean hasCarStatus = false;
    private static boolean isCarOwner = false;
    private static int transactionCount;
    private static int removedOwnersCount;
    private static long totalTransactionValue;
    private static int removedTenantsCount;
    private static int removedCarsCount;
    private static long totalProfit;
    private static final Scanner scanner = new Scanner(System.in);

    public static int getRemovedTenantsCount() {
        return removedTenantsCount;
    }

    public static void setRemovedTenantsCount(int removedTenantsCount) {
        Agency.removedTenantsCount = removedTenantsCount;
    }

    public static int getRemovedCarsCount() {
        return removedCarsCount;
    }

    public static void setRemovedCarsCount(int removedCarsCount) {
        Agency.removedCarsCount = removedCarsCount;
    }

    public static long getTotalProfit() {
        return totalProfit;
    }

    public static void setTotalProfit(long totalProfit) {
        Agency.totalProfit = totalProfit;
    }

    public static long getTotalTransactionValue() {
        return totalTransactionValue;
    }

    public static void setTotalTransactionValue(long totalTransactionValue) {
        Agency.totalTransactionValue = totalTransactionValue;
    }

    public static int getTransactionCount() {
        return transactionCount;
    }

    public static void setTransactionCount(int transactionCount) {
        Agency.transactionCount = transactionCount;
    }

    public static int getRemovedOwnersCount() {
        return removedOwnersCount;
    }

    public static void setRemovedOwnersCount(int removedOwnersCount) {
        Agency.removedOwnersCount = removedOwnersCount;
    }

    public static Boolean getCarRentalStatus() {
        return carRentalStatus;
    }

    public static void setCarRentalStatus(boolean carRentalStatus) {
        Agency.carRentalStatus = carRentalStatus;
    }

    public static Boolean getRentedCarStatus() {
        return rentedCarStatus;
    }

    public static void setRentedCarStatus(boolean rentedCarStatus) {
        Agency.rentedCarStatus = rentedCarStatus;
    }

    public static Owner getOwnerByIndex(int index) {
        if (index >= 0 && index < Owner.getOwnerList().size()) {
            return Owner.getOwnerList().get(index);
        } else {
            System.out.println(RED + "\nOwner not found :(\n" + RESET);
            return null;
        }
    }

    public static Tenant getTenantByIndex(int index) {
        if (index >= 0 && index < Tenant.getTenantList().size()) {
            return Tenant.getTenantList().get(index);
        } else {
            System.out.println();
            System.out.println(RED + "\nTenant not found :(\n" + RESET);
            System.out.println();
            return null;
        }
    }

    public static Car getCarByIndex(int index) {
        if (index >= 0 && index < Car.getCarList().size()) {
            return Car.getCarList().get(index);
        } else {
            System.out.println();
            System.out.println("Car not found :(");
            System.out.println();
            return null;
        }
    }

    public static void addOwner(Owner owner) {
        Owner.getOwnerList().add(owner);
    }

    public static void addTenant(Tenant tenant) {
        Tenant.getTenantList().add(tenant);
    }

    public static void addCar(Car car) {
        Car.getCarList().add(car);
    }

    public static void addRentedCarList(Car car) {
        Car.getRentedCarList().add(car);
    }

    public static void removeCar(Car car) {
        Car.getCarList().remove(car);
    }

    public static void removeOwner(Owner owner) {
        Owner.getOwnerList().remove(owner);
    }

    public static void removeTenant(Tenant tenant) {
        Tenant.getTenantList().remove(tenant);
    }

    public static boolean getIsCarOwner() {
        return isCarOwner;
    }

    public static void setIsCarOwner(Boolean value) {
        isCarOwner = value;
    }

    public static void printOwners() {
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

    public static void printOwner(Owner owner) {
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

    public static void printTenants() {
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

    public static void printTenant(Tenant tenant) {
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

    public static void printCars() {
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

    public static void printCar(Car car) {
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

    public static void printOwnerList(String type) {
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

    public static void printCarList(boolean exception, Tenant user) {
        for (Car car : Car.getCarList()) {
            if (exception && user != null) {
                if (!Car.getRentedCarList().contains(car) && user.getAccountBalance() >= car.getRentMoney()) {
                    carRentalStatus = true;
                    System.out.println(PURPLE + "[" + RESET + Car.getCarList().indexOf(car) + PURPLE + "]" + RESET + " " + car.getNameModel());
                    getValidIndexes().add(Car.getCarList().indexOf(car));
                }
            } else {
                System.out.println(PURPLE + "[" + RESET + Car.getCarList().indexOf(car) + PURPLE + "]" + RESET + " " + car.getNameModel());
                getValidIndexes().add(Car.getCarList().indexOf(car));


            }
        }
    }

    public static Boolean isCarRented(Car car) {
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getRentedCar() != null) {
                if (tenant.getRentedCar().equals(car)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printTenantList(String type, boolean exception) {
        if (type.equalsIgnoreCase("username")) {
            for (Tenant tenant : Tenant.getTenantList()) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        rentedCarStatus = true;
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
                        rentedCarStatus = true;
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

    public static void removeFromTenantList() {
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println(PURPLE + "Please select the desired tenant : \n\n" + RESET);
            printTenantList("name", false);
            int option = getUserOption();
            option = validateUserInput(option);
            Tenant tenant = Agency.getTenantByIndex(option);
            Agency.printTenant(tenant);
            System.out.println();
            System.out.println(YELLOW + "Do you want to remove " + RESET + GREEN + tenant.getFirstName() +
                    ' ' + tenant.getLastName() + RESET + YELLOW + " from the list of tenants?" + RESET);
            showConfirmationPrompt();
            boolean running = true;
            while (running) {
                option = getUserOption();
                switch (option) {
                    case 1:
                        removeTenant(tenant);
                        try {
                            tenant.getRentedCarOwner().getMyTenantsList().remove(tenant);
                        } catch (java.lang.NullPointerException ignored) {
                        }
                        Agency.setRemovedTenantsCount(Agency.getRemovedTenantsCount() + 1);

                        System.out.println(GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET +
                                " has been " + RED + "removed " + RESET + "from the list of tenants\n\n");
                        running = false;
                        break;

                    case 2:
                        System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                        running = false;
                        break;
                    default:
                        System.out.println(RED + "Invalid input" + RESET);
                        break;
                }
            }
        } else {
            System.out.println(RED + "No tenant has been registered :(\n\n" + RESET);
        }

    }

    public static void removeFromOwnerList() {
        if (!Owner.getOwnerList().isEmpty()) {
            System.out.println(PURPLE + "Please select the desired owner : \n\n" + RESET);
            printOwnerList("name");
            int option = getUserOption();
            option = validateUserInput(option);
            Owner owner = Agency.getOwnerByIndex(option);
            Agency.printOwner(owner);
            System.out.println();
            System.out.println(YELLOW + "Do you want to remove " + RESET + GREEN + owner.getFirstName() +
                    ' ' + owner.getLastName() + RESET + YELLOW + " from the list of owners?" + RESET);
            System.out.println();
            setIsCarOwner(false);
            Owner.displayOwnerCarsFiltered(owner);
            System.out.println();
            if (getIsCarOwner()) {
                System.out.println(YELLOW + "Please note that by removing " + RESET + GREEN + owner.getFirstName() + ' ' +
                        owner.getLastName() + RESET + YELLOW + " from the list of owners of the above cars, they will be removed from the list" + RESET);
            } else {
                System.out.println(PURPLE + "This owner does not have any car with their name" + PURPLE);
            }
            showConfirmationPrompt();
            boolean running = true;
            while (running) {
                option = getUserOption();
                switch (option) {
                    case 1:
                        removeOwner(owner);
                        Car.getCarList().removeAll(owner.getOwnerCarList());
                        System.out.println(GREEN + owner.getFirstName() + ' ' + owner.getLastName() + RESET +
                                " has been " + RED + "removed" + RESET + " from the list of owners\n\n");
                        if (getIsCarOwner()) {
                            System.out.println("Furthermore, " + GREEN + owner.getOwnerCarList().size() + RESET + " cars owned by the mentioned owner have also been removed from the list of cars");
                            Agency.setRemovedCarsCount(Agency.getRemovedCarsCount() + owner.getOwnerCarList().size());
                        }
                        Agency.setRemovedOwnersCount(Agency.getRemovedOwnersCount() + 1);
                        System.out.println();
                        running = false;
                        break;
                    case 2:
                        setIsCarOwner(false);
                        System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                        running = false;
                        break;
                    default:
                        System.out.println(RED + "Invalid input" + RESET);
                        break;
                }
            }
        } else {
            System.out.println(RED + "No Owner has been registered :(" + RESET);
        }

    }

    public static void removeFromCarList() {
        if (!Car.getCarList().isEmpty()) {
            System.out.println("Please select the desired car : \n\n");
            printCarList(false, null);
            int option = getUserOption();
            option = validateUserInput(option);
            Car car = getCarByIndex(option);
            printCar(car);
            System.out.println();
            System.out.println(YELLOW + "Do you want to remove the " + RESET + PURPLE + car.getNameModel() + RESET +
                    YELLOW + " car from the list of cars?" + RESET);
            showConfirmationPrompt();
            boolean running = true;
            while (running) {
                option = getUserOption();
                switch (option) {
                    case 1:
                        removeCar(car);
                        car.getOwner().setNumberOfCars(car.getOwner().getNumberOfCars() - 1);
                        Agency.setRemovedCarsCount(Agency.getRemovedCarsCount() + 1);
                        System.out.println(PURPLE + car.getNameModel() + RESET + " has been" + RED + " removed " + RESET + "from the list of cars\n\n");
                        running = false;
                        break;

                    case 2:
                        System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                        running = false;
                        break;
                    default:
                        System.out.println(RED + "\nInvalid input" + RESET);
                        break;
                }

            }
        } else {
            System.out.println(RED + "No car has been registered :(" + RESET);
        }

    }

    public static void rent() {
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println(PURPLE + "Please select the desired tenant : \n\n" + RESET);
            printTenantList("name", true);
            if (getRentedCarStatus()) {
                int option = getUserOption();
                option = validateUserInput(option);
                setRentedCarStatus(false);
                Tenant tenant = getTenantByIndex(option);
                if (!Car.getCarList().isEmpty()) {
                    System.out.println(PURPLE + "Please select the desired car :\n\n" + RESET);
                    System.out.println(YELLOW + "Cars displayed based on " + RESET + GREEN + tenant.getFirstName() + ' '
                            + tenant.getLastName() + RESET + YELLOW + "'s account inventory\n\n" + RESET);
                    printCarList(true, tenant);
                    if (getCarRentalStatus()) {
                        option = getUserOption();
                        option = validateUserInput(option);
                        setCarRentalStatus(false);
                    } else {
                        System.out.println(YELLOW + "All cars have been rented out\n\n" + YELLOW);
                        return;
                    }

                } else {
                    System.out.println("No car has been registered :(");
                    return;
                }

                printTenant(tenant);
                Car car = getCarByIndex(option);
                System.out.println();
                printCar(car);
                System.out.println();
                int day = validateNumericInput("Please enter the rental period in days : ", GREEN);
                System.out.println();
                System.out.println(YELLOW + "Do you want to rent a " + RESET +
                        GREEN + car.getNameModel() + RESET + YELLOW + " car to " + RESET + GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET +
                        YELLOW + " for a duration of " + RESET + GREEN + day + RESET + YELLOW + " days?" + RESET);

                System.out.println();
                System.out.println(YELLOW + "With your confirmation, an amount of " + RESET + GREEN + formattedNumber.format(car.getRentMoney()) + RESET + YELLOW + " Toman will be deducted from " + RESET + GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET + YELLOW + "'s account\n\n" + RESET);
                showConfirmationPrompt();
                boolean running = true;
                while (running) {
                    option = getUserOption();
                    switch (option) {
                        case 1:
                            System.out.println(GREEN + "\n\nThe car has been successfully rented :)\n\n" + RESET);
                            Agency.setTransactionCount(Agency.getTransactionCount() + 1);
                            Agency.setTotalTransactionValue(Agency.getTotalTransactionValue() + car.getRentMoney());
                            Agency.setTotalProfit(Agency.getTotalProfit() + car.getRentMoney() / 10);
                            car.getOwner().getMyTenantsList().add(tenant);
                            car.getOwner().setIncome((car.getRentMoney() * 9 / 10) + (car.getOwner().getIncome()));
                            System.out.println(YELLOW + "A amount of " + RESET
                                    + GREEN + formattedNumber.format(car.getRentMoney()) + RESET + YELLOW + " Toman has been deducted from " + RESET + GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET +
                                    YELLOW + "'s account\n\n" + RESET);
                            tenant.setAccountBalance(tenant.getAccountBalance() - car.getRentMoney());
                            tenant.setRentedCar(car);
                            tenant.setRentedCarOwner(car.getOwner());
                            addRentedCarList(car);
                            running = false;
                            break;
                        case 2:
                            System.out.println(RED + "The operation has been canceled :(\n\n" + RESET);
                            running = false;
                            break;
                        default:
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

    public static void addOwner() {
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
        owner.setNationalCode(nationalCode);

        String phoneNumber = getAndValidatePhoneNumber("owner");
        owner.setPhoneNumber(phoneNumber);


        System.out.print("Enter the owner's address: ");
        System.out.print(PURPLE);
        owner.setAddress(scanner.nextLine());
        System.out.print(RESET);
        System.out.println(YELLOW + "\nAre you sure about adding " + GREEN + firstName + ' ' + lastName + RESET + YELLOW + " to the list of owners?" + RESET);
        showConfirmationPrompt();
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

    public static void addTenant() {
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
        tenant.setNationalCode(nationalCode);

        String phoneNumber = getAndValidatePhoneNumber("tenant");
        tenant.setPhoneNumber(phoneNumber);

        System.out.print("Enter the tenant's address: ");
        System.out.print(PURPLE);
        tenant.setAddress(scanner.nextLine());
        System.out.print(RESET);

        String errorText = YELLOW + "The minimum accountBalance amount must be " + RESET + RED + "1,500,000" + RESET + YELLOW + " toman" + RESET;
        String askText = "Enter the tenant's accountBalance : ";
        int accountBalance = getAndValidateMoney(askText, errorText);
        tenant.setAccountBalance(accountBalance);

        System.out.println(YELLOW + "\nAre you sure about adding " + GREEN + firstName + ' ' + lastName + RESET + YELLOW + " to the list of tenants?" + RESET);
        showConfirmationPrompt();
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

    public static void addCar() {
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
            showConfirmationPrompt();
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

    private static void nationalCodeOwnerSearch(String nationalCode) {
        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getNationalCode().equals(nationalCode)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void phoneNumberOwnerSearch(String phoneNumber) {
        boolean foundStatus = false;
        for (Owner owner : Owner.getOwnerList()) {
            if (owner.getPhoneNumber().equals(phoneNumber)) {
                Agency.printOwner(owner);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void usernameOwnerSearch(String userName) {
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

    private static void nationalCodeTenantSearch(String nationalCode) {
        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getNationalCode().equals(nationalCode)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }

    }

    private static void phoneNumberTenantSearch(String phoneNumber) {
        boolean foundStatus = false;
        for (Tenant tenant : Tenant.getTenantList()) {
            if (tenant.getPhoneNumber().equals(phoneNumber)) {
                Agency.printTenant(tenant);
                foundStatus = true;
            }
        }
        if (!foundStatus) {
            System.out.println();
            System.out.println(RED + "Not found :(" + RESET);
        }
    }

    private static void usernameTenantSearch(String userName) {
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
            displayOwnerSearchMenu();
            int option = getUserOption();
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

                    fullNameOwnerSearch(firstname, lastname);
                    break;
                case 2:
                    System.out.print("Enter the owner's first name : ");
                    System.out.print(PURPLE);
                    firstname = scanner.nextLine();
                    System.out.print(RESET);
                    firstNameOwnerSearch(firstname);
                    break;
                case 3:
                    System.out.print("Enter the owner's last name : ");
                    System.out.print(PURPLE);
                    lastname = scanner.nextLine();
                    System.out.print(RESET);
                    lastnameNameOwnerSearch(lastname);
                    break;
                case 4:
                    String nationalCode = getAndValidateNationalCode("owner");
                    nationalCodeOwnerSearch(nationalCode);
                    break;
                case 5:
                    String phoneNumber = getAndValidatePhoneNumber("owner");
                    phoneNumberOwnerSearch(phoneNumber);
                    break;
                case 6:
                    System.out.print("Enter the owner's username : ");
                    System.out.print(PURPLE);
                    String username = scanner.nextLine();
                    System.out.print(RESET);
                    usernameOwnerSearch(username);
                    break;

                case 7:
                    int age = getAndValidateAge("owner");
                    ageOwnerSearch(age);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }


    }

    private static void handleSearchTenantManager() {
        boolean running = true;
        while (running) {
            displayTenantSearchMenu();
            int option = getUserOption();
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
                    fullNameTenantSearch(firstname, lastname);
                    break;
                case 2:
                    System.out.print("Enter the tenant's first name : ");
                    System.out.print(PURPLE);
                    firstname = scanner.nextLine();
                    System.out.print(RESET);
                    firstNameTenantSearch(firstname);
                    break;
                case 3:
                    System.out.print("Enter the tenant's last name : ");
                    System.out.print(PURPLE);
                    lastname = scanner.nextLine();
                    System.out.print(RESET);
                    lastNameTenantSearch(lastname);
                    break;
                case 4:
                    String askText = "Enter the tenant's accountBalance : ";
                    String errorText = YELLOW + "The minimum accountBalance amount must be " + RESET + RED + "1,500,000" + RESET + YELLOW + " toman" + RESET;
                    int accountBalance = getAndValidateMoney(askText, errorText);
                    accountBalanceSearch(accountBalance);
                    break;
                case 5:
                    String nationalCode = getAndValidateNationalCode("tenant");
                    nationalCodeTenantSearch(nationalCode);
                    break;
                case 6:
                    String phoneNumber = getAndValidatePhoneNumber("tenant");
                    phoneNumberTenantSearch(phoneNumber);
                    break;
                case 7:
                    System.out.print("Enter the tenant's username : ");
                    System.out.print(PURPLE);
                    String username = scanner.nextLine();
                    System.out.print(RESET);
                    usernameTenantSearch(username);
                    break;
                case 8:
                    int age = getAndValidateAge("tenant");
                    ageTenantSearch(age);
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }

    }

    private static void handleSearchCarManager() {
        boolean running = true;
        while (running) {
            displayCarSearchMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    int engineCapacity = getAndValidateEngineCapacity();
                    engineCapacitySearch(engineCapacity);
                    break;
                case 2:
                    System.out.print("Enter the car name model : ");
                    System.out.print(PURPLE);
                    String nameModel = scanner.nextLine();
                    System.out.print(RESET);
                    nameModelSearch(nameModel);
                    break;
                case 3:
                    String askText = "Enter the car's rent money : ";
                    String errorText = YELLOW + "The entered rental amount must be above" + RESET + RED + " 1,500,000 " + RESET + YELLOW + "toman" + RESET;
                    int rentMoney = getAndValidateMoney(askText, errorText);
                    rentMoneySearch(rentMoney);
                    break;
                case 4:
                    int lifeSpan = validateNumericInput("Enter the car's lifespan: ", PURPLE);
                    lifeSpanSearch(lifeSpan);
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
                    carOwnerSearch(firstname, lastname);
                    break;
                case 6:
                    System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Sedan");
                    System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "High-riding");
                    System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Semi-high-riding");
                    System.out.println();
                    boolean running_type = true;
                    while (running_type) {
                        option = validateNumericInput("Enter the car type : ", PURPLE);
                        switch (option) {
                            case 1:
                                typeSearch("Sedan");
                                running_type = false;
                                break;
                            case 2:
                                typeSearch("High-riding");
                                running_type = false;
                                break;
                            case 3:
                                typeSearch("Semi-high-riding");
                                running_type = false;
                                break;
                            default:
                                System.out.println(RED + "Invalid option!" + RESET);
                        }
                    }
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }

    }

    public static void handleSearchMainMenuManager() {
        boolean running = true;
        while (running) {
            displaySearchMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    handleSearchOwnerManager();
                    break;
                case 2:
                    handleSearchTenantManager();
                    break;
                case 3:
                    handleSearchCarManager();
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(RED + "Invalid option!" + RESET);
            }
        }

    }

    public static void handleReportMenu() {
        boolean running = true;
        while (running) {
            displayReportMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    handlePrintOwnersList();
                    break;

                case 2:
                    handlePrintTenantsList();
                    break;

                case 3:
                    handlePrintCarsList();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(RED + "Invalid option!\n" + RESET);
                    break;


            }
        }
    }

    private static void handlePrintOwnersList() {
        boolean running = true;
        if (!Owner.getOwnerList().isEmpty()) {
            printOwners();
            System.out.println(PURPLE + "\n[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
            while (running) {
                int option = getUserOption();
                if (option == 0) {
                    running = false;
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
        if (!Tenant.getTenantList().isEmpty()) {
            printTenants();
            System.out.println(PURPLE + "\n[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
            while (running) {
                int option = getUserOption();
                if (option == 0) {
                    running = false;
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
        if (!Car.getCarList().isEmpty()) {
            printCars();
            System.out.println(PURPLE + "\n[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
            while (running) {
                int option = getUserOption();
                if (option == 0) {
                    running = false;
                } else {
                    System.out.println(RED + "Invalid option!" + RESET);
                }
            }

        } else {
            System.out.println(RED + "No car has been registered :(\n\n" + RESET);
        }
    }

    public static void handleAddMainMenuManager() {
        boolean running = true;
        while (running) {
            displayAddMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    displayOwnerBanner();
                    Agency.addOwner();
                    break;
                case 2:
                    displayTenantBanner();
                    Agency.addTenant();
                    break;
                case 3:
                    displayCarBanner();
                    Agency.addCar();
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
            }
        }
    }

    public static void handleRemoveMainMenuManager() {
        boolean running = true;
        while (running) {
            displayRemoveMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    displayOwnerBanner();
                    Agency.removeFromOwnerList();
                    break;
                case 2:
                    displayTenantBanner();
                    Agency.removeFromTenantList();
                    break;
                case 3:
                    displayCarBanner();
                    Agency.removeFromCarList();
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
            }
        }

    }
}

class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Integer> validIndexes = new ArrayList<>();

    public static List<Integer> getValidIndexes() {
        return validIndexes;
    }

    public static final DecimalFormat formattedNumber = new DecimalFormat("#,###,###");
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayHomeMenu();
            int option = getUserOption();
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
                    running = confirmLogout("System");
                    break;

                default:
                    System.out.println();
                    System.out.println(RED + "Invalid option! Please try again" + RESET);
            }
        }
        scanner.close();
        System.out.println(UserInterface.GREEN + "Successful logout!" + UserInterface.RESET);
    }

    public static void adminLogin() {
        String adminUsername = "admin";
        String adminPassword = "admin";
        System.out.print(YELLOW + "Enter Username : " + RESET);
        System.out.print(PURPLE);
        String username = scanner.nextLine();
        System.out.print(RESET);
        System.out.print(YELLOW + "Enter Password : " + RESET);
        System.out.print(PURPLE);
        String password = scanner.nextLine();
        System.out.print(RESET);
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println();
            System.out.println("Welcome, " + username + " :)");
            System.out.println();
            handleAgencyManagerMenu();
        } else {
            System.out.println(RED + "\nAccess denied :(\n" + RESET);

        }

    }

    public static void ownerLogin() {
        if (!Owner.getOwnerList().isEmpty()) {
            Agency.printOwnerList("username");
            int ownerUsernameIndex = validateNumericInput(YELLOW + "\nSelect Username : " + RESET, UserInterface.PURPLE);
            System.out.print(PURPLE);
            scanner.nextLine();
            System.out.print(RESET);
            Owner owner = Agency.getOwnerByIndex(ownerUsernameIndex);
            if (owner == null) {
                return;
            }
            getValidIndexes().clear();
            System.out.print(YELLOW + "Enter Password : " + RESET);
            System.out.print(PURPLE);
            String password = scanner.nextLine();
            System.out.print(RESET);
            if (password.equals(owner.getPassword())) {
                System.out.println();
                System.out.println("\nWelcome, " + owner.getFirstName() + " :)");
                handleOwnerPanelMenu(owner);
            } else {
                System.out.println();
                System.out.println(RED + "Access denied :(" + RESET);
                System.out.println();
            }
        } else {
            System.out.println(RED + "\n\nNo owner has been registered\n\n" + RESET);
        }

    }

    public static void tenantLogin() {
        if (!Tenant.getTenantList().isEmpty()) {
            Agency.printTenantList("username", false);
            int tenantUsernameIndex = validateNumericInput(YELLOW + "\nSelect Username : " + RESET, UserInterface.PURPLE);
            System.out.print(PURPLE);
            scanner.nextLine();
            System.out.print(RESET);
            Tenant tenant = Agency.getTenantByIndex(tenantUsernameIndex);
            if (tenant == null) {
                return;
            }
            getValidIndexes().clear();
            System.out.print(YELLOW + "Enter Password : " + RESET);
            System.out.print(PURPLE);
            String password = scanner.nextLine();
            System.out.print(RESET);
            if (password.equals(tenant.getPassword())) {
                System.out.println();
                System.out.println("\nWelcome, " + tenant.getFirstName() + " :)");
                handleTenantPanelMenu(tenant);
            } else {
                System.out.println();
                System.out.println(RED + "Access denied :(" + RESET);
                System.out.println();
            }
        } else {
            System.out.println(RED + "\n\nNo tenant has been registered\n\n" + RESET);
        }

    }

    private static void typingAnimation(String text, int delay) {
        try {
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i));
                Thread.sleep(delay);
            }
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }

    private static void displayOwnerPanelMenu(Owner owner) {
        System.out.println();
        String art = """
                   _____        ___   _ _____ ____     ____   _    _   _ _____ _    \s
                  / _ \\ \\      / / \\ | | ____|  _ \\   |  _ \\ / \\  | \\ | | ____| |   \s
                 | | | \\ \\ /\\ / /|  \\| |  _| | |_) |  | |_) / _ \\ |  \\| |  _| | |   \s
                 | |_| |\\ V  V / | |\\  | |___|  _ <   |  __/ ___ \\| |\\  | |___| |___\s
                  \\___/  \\_/\\_/  |_| \\_|_____|_| \\_\\  |_| /_/   \\_\\_| \\_|_____|_____|
                                                                                    \s
                """;
        printBanner(art);
        System.out.println();
        System.out.println("Number of your tenants                      " + PURPLE + "[" + WHITE + GREEN + owner.getMyTenantsList().size() + RESET + PURPLE + "] " + WHITE);
        System.out.println("Number of cars owned by you                 " + PURPLE + "[" + WHITE + GREEN + owner.getNumberOfCars() + RESET + PURPLE + "] " + WHITE);
        System.out.println("My income (with 90% profit per transaction) " + PURPLE + "[" + WHITE + GREEN + formattedNumber.format(owner.getIncome()) + RESET + PURPLE + "] " + WHITE);
        System.out.println();
        Agency.printOwner(owner);
        System.out.println();
        System.out.println(PURPLE + "Please select an option :\n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "My Cars ");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "My tenants");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Log out");
    }

    private static void displayTenantPanelMenu(Tenant tenant) {
        System.out.println();
        String art = """
                  _____ _____ _   _    _    _   _ _____    ____   _    _   _ _____ _    \s
                 |_   _| ____| \\ | |  / \\  | \\ | |_   _|  |  _ \\ / \\  | \\ | | ____| |   \s
                   | | |  _| |  \\| | / _ \\ |  \\| | | |    | |_) / _ \\ |  \\| |  _| | |   \s
                   | | | |___| |\\  |/ ___ \\| |\\  | | |    |  __/ ___ \\| |\\  | |___| |___\s
                   |_| |_____|_| \\_/_/   \\_\\_| \\_| |_|    |_| /_/   \\_\\_| \\_|_____|_____|
                                                                                        \s
                """;
        printBanner(art);
        System.out.println();
        System.out.println("My account balance " + PURPLE + "[" + WHITE + GREEN + formattedNumber.format(tenant.getAccountBalance()) + RESET + PURPLE + "] " + WHITE);
        System.out.println();
        Agency.printTenant(tenant);
        System.out.println();
        Car rentalCar = tenant.getRentedCar();
        if (rentalCar != null) {
            Agency.printCar(rentalCar);
        } else {
            System.out.println(PURPLE + "You did not rent a car" + RESET);
        }
        System.out.println();
        System.out.println(PURPLE + "Please select an option :\n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Increase Account Balance ");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Log out");
    }

    private static void displayDeveloperInfo() {
        String art = """
                 __        ___   _  ___       _    __  __    ___   ___\s
                 \\ \\      / / | | |/ _ \\     / \\  |  \\/  |  |_ _| |__ \\
                  \\ \\ /\\ / /| |_| | | | |   / _ \\ | |\\/| |   | |    / /
                   \\ V  V / |  _  | |_| |  / ___ \\| |  | |   | |   |_|\s
                    \\_/\\_/  |_| |_|\\___/  /_/   \\_\\_|  |_|  |___|  (_)\s
                                                                                                   
                """;

        printBanner(art);
        typingAnimation("\n\neverything is on " + PURPLE + "Principle" + RESET + ", everything is on " + PURPLE + "Discipline" + RESET, 90);
        typingAnimation(PURPLE + "\n======================================\n\n" + RESET, 30);
        typingAnimation(YELLOW + "I am " + RESET + GREEN + "Ali Dehghanpour\n" + RESET, 90);
        System.out.println();
        showProjectHours();
        System.out.println();
        typingAnimation("Email    " + PURPLE + "[" + WHITE + GREEN + "ali75847584@gmail.com" + RESET + PURPLE + "]" + RESET, 90);
        System.out.println();
        typingAnimation("GitHub   " + PURPLE + "[" + WHITE + GREEN + "AliHCl" + RESET + PURPLE + "]" + RESET, 90);
        System.out.println();
        typingAnimation("Telegram " + PURPLE + "[" + WHITE + GREEN + "@Ali_4201" + RESET + PURPLE + "]" + RESET, 90);
        System.out.println();
        typingAnimation(PURPLE + "\n======================================\n\n" + RESET, 30);
        System.out.println();


    }

    private static void handleAgencyManagerMenu() {
        boolean running = true;
        while (running) {
            displayAgencyManagerMenu();
            int option = getUserOption();
            switch (option) {
                case 1:
                    Agency.handleAddMainMenuManager();
                    break;
                case 2:
                    Agency.handleRemoveMainMenuManager();
                    break;
                case 3:
                    Agency.handleSearchMainMenuManager();
                    break;
                case 4:
                    displayRentBanner();
                    Agency.rent();
                    break;
                case 5:
                    Agency.handleReportMenu();
                    break;
                case 0:
                    running = confirmLogout("admin panel");
                    break;
                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
            }
        }
    }

    private static void handleOwnerPanelMenu(Owner owner) {
        boolean running = true;
        while (running) {
            System.out.println();
            displayOwnerPanelMenu(owner);
            int option = getUserOption();
            switch (option) {
                case 1:
                    Owner.displayMyCars(owner);
                    break;
                case 2:
                    Owner.printMyTenantsList(owner);
                    break;
                case 0:
                    running = confirmLogout("owner panel");
                    break;
                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
            }
        }
    }

    private static void handleTenantPanelMenu(Tenant tenant) {
        boolean running = true;
        while (running) {
            System.out.println();
            displayTenantPanelMenu(tenant);
            int option = getUserOption();
            switch (option) {
                case 1:
                    Tenant.increaseAccountBalance(tenant);
                    break;
                case 0:
                    running = confirmLogout("tenant panel");
                    break;
                default:
                    System.out.println(RED + "\n\nInvalid option! Please try again" + RESET);
            }
        }
    }

    private static void showProjectHours() {
        try {
            int animationSpeed = 90;
            int projectHours = 54;
            typingAnimation("\r" + YELLOW + "I worked on this project for " + RESET, 90);
            for (int i = 0; i <= projectHours; i++) {
                if (i < 10) {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + i);
                } else if (i < 25) {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + GREEN + i + RESET);
                } else if (i < 30) {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + YELLOW + i + RESET);

                } else {
                    System.out.print("\r" + YELLOW + "I worked on this project for " + RESET + RED + i + RESET);
                }
                Thread.sleep(animationSpeed);
            }
            typingAnimation(YELLOW + " hours" + RESET, 90);
            System.out.println();
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }

    public static void displayHomeMenu() {
        String art = """
                ╔═╗┌─┐┬─┐  ╦═╗┌─┐┌┐┌┌┬┐┌─┐┬    ╔═╗┌─┐┌─┐┌┐┌┌─┐┬ ┬
                ║  ├─┤├┬┘  ╠╦╝├┤ │││ │ ├─┤│    ╠═╣│ ┬├┤ ││││  └┬┘
                ╚═╝┴ ┴┴└─  ╩╚═└─┘┘└┘ ┴ ┴ ┴┴─┘  ╩ ╩└─┘└─┘┘└┘└─┘ ┴\s
                """;
        printBanner(art);
        System.out.println("Welcome to the Agency Management System\n");
        System.out.println(PURPLE + "Who are you:\n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Agency Manager");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Owner");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Tenant");
        System.out.println(PURPLE + "[" + WHITE + 4 + PURPLE + "] " + WHITE + "About me");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Exit");
    }

    public static void displayAgencyManagerMenu() {
        String art = """
                     _    ____  __  __ ___ _   _    ____   _    _   _ _____ _    \s
                    / \\  |  _ \\|  \\/  |_ _| \\ | |  |  _ \\ / \\  | \\ | | ____| |   \s
                   / _ \\ | | | | |\\/| || ||  \\| |  | |_) / _ \\ |  \\| |  _| | |   \s
                  / ___ \\| |_| | |  | || || |\\  |  |  __/ ___ \\| |\\  | |___| |___\s
                 /_/   \\_\\____/|_|  |_|___|_| \\_|  |_| /_/   \\_\\_| \\_|_____|_____|
                                                                                 \s
                """;
        printBanner(art);
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Add");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Remove");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Search");
        System.out.println(PURPLE + "[" + WHITE + 4 + PURPLE + "] " + WHITE + "Rent");
        System.out.println(PURPLE + "[" + WHITE + 5 + PURPLE + "] " + WHITE + "Print Report");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Log out");
    }

    public static void displaySearchMenu() {
        System.out.println();
        String art = """
                  ____                      _    \s
                 / ___|  ___  __ _ _ __ ___| |__ \s
                 \\___ \\ / _ \\/ _` | '__/ __| '_ \\\s
                  ___) |  __/ (_| | | | (__| | | |
                 |____/ \\___|\\__,_|_|  \\___|_| |_|
                                                 \s
                """;
        printBanner(art);
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Owners");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Tenants");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Cars");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
    }

    public static void displayReportMenu() {
        String art = """
                8888888b.  8888888888 8888888b.   .d88888b.  8888888b. 88888888888\s
                888   Y88b 888        888   Y88b d88P" "Y88b 888   Y88b    888    \s
                888    888 888        888    888 888     888 888    888    888    \s
                888   d88P 8888888    888   d88P 888     888 888   d88P    888    \s
                8888888P"  888        8888888P"  888     888 8888888P"     888    \s
                888 T88b   888        888        888     888 888 T88b      888    \s
                888  T88b  888        888        Y88b. .d88P 888  T88b     888    \s
                888   T88b 8888888888 888         "Y88888P"  888   T88b    888    \s
                                                                                  \s
                                                                                  \s
                                                                                  \s
                """;
        UserInterface.printBanner(art);
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
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Owners List");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Tenants List");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Cars List");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");


    }

    public static void displayAddMenu() {
        System.out.println();
        String art = """
                     _    ____  ____ \s
                    / \\  |  _ \\|  _ \\\s
                   / _ \\ | | | | | | |
                  / ___ \\| |_| | |_| |
                 /_/   \\_\\____/|____/\s
                                     \s
                """;
        printBanner(art);
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Add Owner");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Add Tenant");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Add Car");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
    }

    public static void displayRemoveMenu() {
        System.out.println();
        String art = """
                  ____  _____ __  __  _____     _______\s
                 |  _ \\| ____|  \\/  |/ _ \\ \\   / / ____|
                 | |_) |  _| | |\\/| | | | \\ \\ / /|  _| \s
                 |  _ <| |___| |  | | |_| |\\ V / | |___\s
                 |_| \\_\\_____|_|  |_|\\___/  \\_/  |_____|
                                                       \s
                """;
        printBanner(art);
        System.out.println();
        System.out.println(PURPLE + "Please select an option \n" + RESET);
        System.out.println(PURPLE + "[" + WHITE + 1 + PURPLE + "] " + WHITE + "Remove Owner");
        System.out.println(PURPLE + "[" + WHITE + 2 + PURPLE + "] " + WHITE + "Remove Tenant");
        System.out.println(PURPLE + "[" + WHITE + 3 + PURPLE + "] " + WHITE + "Remove Car");
        System.out.println(PURPLE + "[" + WHITE + 0 + PURPLE + "] " + WHITE + "Back");
    }

    public static void displayOwnerBanner() {
        System.out.println();
        String art = """
                   ___                          \s
                  / _ \\__      ___ __   ___ _ __\s
                 | | | \\ \\ /\\ / / '_ \\ / _ \\ '__|
                 | |_| |\\ V  V /| | | |  __/ |  \s
                  \\___/  \\_/\\_/ |_| |_|\\___|_|  \s
                                                \s
                """;
        printBanner(art);
        System.out.println();
    }

    public static void displayTenantBanner() {
        System.out.println();
        String art = """
                  _____                      _  \s
                 |_   _|__ _ __   __ _ _ __ | |_\s
                   | |/ _ \\ '_ \\ / _` | '_ \\| __|
                   | |  __/ | | | (_| | | | | |_\s
                   |_|\\___|_| |_|\\__,_|_| |_|\\__|
                                                \s
                """;
        printBanner(art);
        System.out.println();
    }

    public static void displayCarBanner() {
        System.out.println();
        String art = """
                   ____          \s
                  / ___|__ _ _ __\s
                 | |   / _` | '__|
                 | |__| (_| | |  \s
                  \\____\\__,_|_|  \s
                                 \s
                """;
        printBanner(art);
        System.out.println();
    }

    public static void displayRentBanner() {
        System.out.println();
        String art = """
                  ____  _____ _   _ _____\s
                 |  _ \\| ____| \\ | |_   _|
                 | |_) |  _| |  \\| | | | \s
                 |  _ <| |___| |\\  | | | \s
                 |_| \\_\\_____|_| \\_| |_| \s
                                         \s
                """;
        printBanner(art);
        System.out.println();
    }

    public static void displayOwnerSearchMenu() {
        System.out.println();
        String art = """
                   ___                          \s
                  / _ \\__      ___ __   ___ _ __\s
                 | | | \\ \\ /\\ / / '_ \\ / _ \\ '__|
                 | |_| |\\ V  V /| | | |  __/ |  \s
                  \\___/  \\_/\\_/ |_| |_|\\___|_|  \s
                                                \s
                """;
        printBanner(art);
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

    public static void displayTenantSearchMenu() {
        System.out.println();
        String art = """
                  _____                      _  \s
                 |_   _|__ _ __   __ _ _ __ | |_\s
                   | |/ _ \\ '_ \\ / _` | '_ \\| __|
                   | |  __/ | | | (_| | | | | |_\s
                   |_|\\___|_| |_|\\__,_|_| |_|\\__|
                                                \s
                """;
        printBanner(art);
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

    public static void displayCarSearchMenu() {
        System.out.println();
        String art = """
                   ____          \s
                  / ___|__ _ _ __\s
                 | |   / _` | '__|
                 | |__| (_| | |  \s
                  \\____\\__,_|_|  \s
                                 \s
                """;
        printBanner(art);
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

    public static void showConfirmationPrompt() {
        System.out.println();
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No");
    }

    public static int validateUserInput(int option) {
        while (!getValidIndexes().contains(option)) {
            System.out.println(RED + "The input is invalid. Please try again" + RESET);
            option = getUserOption();
        }
        getValidIndexes().clear();
        return option;
    }

    public static int validateNumericInput(String askText, String userInputColor) {
        System.out.print(askText);
        int inputNumber = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.print(userInputColor);
                inputNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print(RESET);
                isValidInput = true;
            } catch (InputMismatchException invalidInput) {
                scanner.nextLine();
                System.out.println(RED + "Invalid input. Please enter a valid integer." + RESET);
                System.out.print(askText);

            }
        }
        return inputNumber;
    }

    public static int getAndValidateAge(String type) {
        int age;
        do {
            age = UserInterface.validateNumericInput("Enter the " + type + "'s age : ", UserInterface.PURPLE);
            if (age < 18) {
                System.out.println(UserInterface.RED + "You have not reached the legal age" + UserInterface.RESET);
            } else if (age > 150) {
                System.out.println(UserInterface.RED + "Invalid age entered" + UserInterface.RESET);
            }
        } while (age < 18 || age > 150);
        return age;
    }

    public static String getAndValidateNationalCode(String type) {
        String nationalCode;
        do {
            System.out.print("Enter the " + type + "'s national code: ");
            System.out.print(UserInterface.PURPLE);
            nationalCode = scanner.nextLine();
            System.out.print(UserInterface.RESET);
            if (nationalCode.length() != 10) {
                System.out.println(UserInterface.RED + "Invalid national code entered" + UserInterface.RESET);
            }
        } while (nationalCode.length() != 10);
        return nationalCode;
    }

    public static String getAndValidatePhoneNumber(String type) {
        String phoneNumber;
        do {
            System.out.print("Enter the " + type + "'s phone number: ");
            System.out.print(UserInterface.PURPLE);
            phoneNumber = scanner.nextLine();
            System.out.print(UserInterface.RESET);
            if (phoneNumber.length() != 11) {
                System.out.println(UserInterface.RED + "Invalid phone number entered" + UserInterface.RESET);
            }
        } while (phoneNumber.length() != 11);
        return phoneNumber;
    }

    public static int getAndValidateEngineCapacity() {
        int engineCapacity;
        do {
            engineCapacity = UserInterface.validateNumericInput("Enter the car's engine capacity: ", UserInterface.PURPLE);
            if (engineCapacity < 700) {
                System.out.println(UserInterface.YELLOW + "Engine capacity must be above " + UserInterface.RESET + UserInterface.RED + " 700 cc" + UserInterface.RESET);
            }
        } while (engineCapacity < 700);

        return engineCapacity;
    }

    public static int getAndValidateMoney(String askText, String errorText) {
        int money;
        do {
            money = UserInterface.validateNumericInput(askText, UserInterface.PURPLE);
            if (money < 1_500_000) {
                System.out.println(errorText);
            }
        } while (money < 1_500_000);

        return money;
    }

    public static boolean confirmLogout(String location) {
        System.out.println(YELLOW + "Would you like to log out of the " + location + " ? \n" + RESET);
        showConfirmationPrompt();
        while (true) {
            int option = getUserOption();
            switch (option) {
                case 1:
                    return false;
                case 2:
                    return true;
                default:
                    System.out.println(UserInterface.RED + "\nInvalid input" + UserInterface.RESET);
                    break;
            }
        }
    }

    public static void printBanner(String art) {
        int num = art.length() / 2;
        for (int i = 0; i < num; i++) {
            System.out.print(PURPLE + art.charAt(i));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = num; i < art.length(); i++) {
            System.out.print(WHITE + art.charAt(i));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static int getUserOption() {
        boolean isValidInput = false;
        int option = 0;
        System.out.print(PURPLE + "\n\nEnter your option: " + RESET);
        while (!isValidInput) {
            try {
                option = scanner.nextInt();
                System.out.println();
                scanner.nextLine();
                isValidInput = true;
            } catch (InputMismatchException invalidInput) {
                scanner.nextLine();
                System.out.println(RED + "Invalid input. Please enter a valid integer." + RESET);
                System.out.print(PURPLE + "Enter your option: " + RESET);
            }
        }
        return option;

    }
}
