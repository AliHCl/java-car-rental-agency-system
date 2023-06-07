import java.text.DecimalFormat;
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
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Tenant> tenantList = new ArrayList<>();
    public Integer getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
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
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
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
    private final List<Tenant> myTenantsList = new ArrayList<>();
    private static final List<Owner> ownerList = new ArrayList<>();
    private static final List<Car> ownerCarList = new ArrayList<>();
    public List<Tenant> getMyTenantsList() {
        return myTenantsList;
    }
    public static List<Owner> getOwnerList() {
        return ownerList;
    }
    public static List<Car> getOwnerCarList() {
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
            Agency.setHasCarStatus(false);
            Owner.printMyCarsList(owner);
            if (Agency.getHasCarStatus()) {
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
    public static void printMyCarsList(Owner owner) {
        for (Car car : Car.getCarList()) {
            if (car.getOwner().equals(owner)) {
                Agency.setHasCarStatus(true);
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Car.getCarList().indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                UserInterface.getValidIndexes().add(Car.getCarList().indexOf(car));
            }
        }
    }
    public static void showOwnerCars(Owner owner) {
        for (Car car : Car.getCarList()) {
            if (car.getOwner().equals(owner)) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Car.getCarList().indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                Owner.getOwnerCarList().add(car);
                Agency.setIsCarOwner(true);
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
class Agency {
    // ArrayList --> https://www.youtube.com/watch?v=pruuvCVXIt8
    private static boolean rentedCarStatus = false;
    private static boolean carRentalStatus = false;
    private static boolean hasCarStatus = false;
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
    public static boolean getHasCarStatus() {
        return hasCarStatus;
    }
    public static void setHasCarStatus(boolean hasCarStatus) {
        Agency.hasCarStatus = hasCarStatus;
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
            System.out.println(UserInterface.RED + "\n\nOwner not found :(\n\n" + UserInterface.RESET);
            return null;
        }
    }
    public static Tenant getTenantByIndex(int index) {
        if (index >= 0 && index < Tenant.getTenantList().size()) {
            return Tenant.getTenantList().get(index);
        } else {
            System.out.println();
            System.out.println("Tenant not found :(");
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
    public static void printReport() {
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
        int totalCustomers = Owner.getOwnerList().size() + Tenant.getTenantList().size() + getRemovedTenantsCount() + getRemovedOwnersCount();
        System.out.println("The total number of customers                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + totalCustomers + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of tenants                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Tenant.getTenantList().size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of owners                           " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Owner.getOwnerList().size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of cars                             " + UserInterface.PURPLE + "[" + UserInterface.WHITE + Car.getCarList().size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of tenants removed                              " + UserInterface.PURPLE + "[" + UserInterface.WHITE + getRemovedTenantsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of owners removed                               " + UserInterface.PURPLE + "[" + UserInterface.WHITE + getRemovedOwnersCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of cars removed                                 " + UserInterface.PURPLE + "[" + UserInterface.WHITE + getRemovedCarsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The number of transactions today                       " + UserInterface.PURPLE + "[" + UserInterface.WHITE + getTransactionCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The value of transactions conducted                    " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.formattedNumber.format(getTotalTransactionValue()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Agency profit (calculated at 10% for each transaction) " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.formattedNumber.format(getTotalProfit()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println();
        Agency.printOwners();
        System.out.println();
        Agency.printTenants();
        System.out.println();
        Agency.printCars();
        System.out.println();


    }
    public static boolean getIsCarOwner() {
        return isCarOwner;
    }
    public static void setIsCarOwner(Boolean value) {
        isCarOwner = value;
    }
    public static void printOwners() {
        if (!Owner.getOwnerList().isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Owners :\n" + UserInterface.WHITE);
            for (Owner owner : Owner.getOwnerList()) {
                System.out.println();
                System.out.println("Username       " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getUsername() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Password       " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getPassword() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("First Name     " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getFirstName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Last Name      " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Age            " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getAge() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("National Code  " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getNationalCode() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Phone Number   " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getPhoneNumber() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Address        " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getAddress() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            }
        }
    }
    public static void printOwner(Owner owner) {
        if (!Owner.getOwnerList().isEmpty()) {
            System.out.println();
            System.out.println("Information of " + UserInterface.GREEN + owner.getFirstName() + ' ' + owner.getLastName() + UserInterface.RESET + " \n");
            System.out.println("Username       " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getUsername() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Password       " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getPassword() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("First Name     " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getFirstName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Last Name      " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Age            " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getAge() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("National Code  " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getNationalCode() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Phone Number   " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getPhoneNumber() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Address        " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getAddress() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        }
    }
    public static void printTenants() {
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Tenants :\n" + UserInterface.WHITE);
            for (Tenant tenant : Tenant.getTenantList()) {
                System.out.println();
                System.out.println("Username            " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getUsername() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Password            " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getPassword() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("First Name          " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getFirstName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Last Name           " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Age                 " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getAge() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("National Code       " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getNationalCode() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Phone Number        " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getPhoneNumber() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Address             " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getAddress() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Account Balance     " + UserInterface.PURPLE + "[" + UserInterface.RESET + UserInterface.formattedNumber.format(tenant.getAccountBalance()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Tenant has car now? " + UserInterface.PURPLE + "[" + UserInterface.RESET + (tenant.getRentedCar() != null ? UserInterface.GREEN + "Yes" + UserInterface.RESET : UserInterface.RED + "No" + UserInterface.RESET) + UserInterface.PURPLE + "]" + UserInterface.RESET);


            }
        }
    }
    public static void printTenant(Tenant tenant) {
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println();
            System.out.println("Information of " + UserInterface.GREEN + tenant.getFirstName() + ' ' + tenant.getLastName() + UserInterface.RESET + " \n");
            System.out.println("Username            " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getUsername() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Password            " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getPassword() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("First Name          " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getFirstName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Last Name           " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Age                 " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getAge() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("National Code       " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getNationalCode() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Phone Number        " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getPhoneNumber() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Address             " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getAddress() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Account Balance     " + UserInterface.PURPLE + "[" + UserInterface.RESET + UserInterface.formattedNumber.format(tenant.getAccountBalance()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Tenant has car now? " + UserInterface.PURPLE + "[" + UserInterface.RESET + (tenant.getRentedCar() != null ? UserInterface.GREEN + "Yes" + UserInterface.RESET : UserInterface.RED + "No" + UserInterface.RESET) + UserInterface.PURPLE + "]" + UserInterface.RESET);


        }
    }
    public static void printCars() {
        if (!Car.getCarList().isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Cars :\n" + UserInterface.WHITE);
            for (Car car : Car.getCarList()) {
                System.out.println();
                System.out.println("Name Model      " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getNameModel() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Engine Capacity " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getEngineCapacity() + " cc" + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Owner           " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Rent Money      " + UserInterface.PURPLE + "[" + UserInterface.RESET + UserInterface.formattedNumber.format(car.getRentMoney()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Type            " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getType() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Lifespan        " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getLifespan() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            }
        }
    }
    public static void printCar(Car car) {
        if (!Car.getCarList().isEmpty()) {
            System.out.println();
            System.out.println("Information of  " + UserInterface.GREEN + car.getNameModel() + UserInterface.RESET + " car  \n");
            System.out.println("Name Model      " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getNameModel() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Engine Capacity " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getEngineCapacity() + " cc" + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Owner           " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Rent Money      " + UserInterface.PURPLE + "[" + UserInterface.RESET + UserInterface.formattedNumber.format(car.getRentMoney()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Type            " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getType() + UserInterface.PURPLE + "]" + UserInterface.RESET);
            System.out.println("Lifespan        " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getLifespan() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        }
    }
    public static void printOwnerList(String type) {
        if (type.equalsIgnoreCase("username")) {
            for (Owner owner : Owner.getOwnerList()) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Owner.getOwnerList().indexOf(owner) + UserInterface.PURPLE + "] " + UserInterface.RESET + owner.getUsername());
                UserInterface.getValidIndexes().add(Owner.getOwnerList().indexOf(owner));

            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Owner owner : Owner.getOwnerList()) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Owner.getOwnerList().indexOf(owner) + UserInterface.PURPLE + "] " + UserInterface.RESET + owner.getFirstName() + ' ' + owner.getLastName());
                UserInterface.getValidIndexes().add(Owner.getOwnerList().indexOf(owner));
            }

        }
    }
    public static void printCarList(boolean exception, Tenant user) {
        for (Car car : Car.getCarList()) {
            if (exception && user != null) {
                if (!Car.getRentedCarList().contains(car) && user.getAccountBalance() >= car.getRentMoney()) {
                    carRentalStatus = true;
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Car.getCarList().indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                    UserInterface.getValidIndexes().add(Car.getCarList().indexOf(car));
                }
            } else {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Car.getCarList().indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                UserInterface.getValidIndexes().add(Car.getCarList().indexOf(car));


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
                        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Tenant.getTenantList().indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getUsername());
                        UserInterface.getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));

                    }
                } else {
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Tenant.getTenantList().indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getUsername());
                    UserInterface.getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));

                }
            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Tenant tenant : Tenant.getTenantList()) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        rentedCarStatus = true;
                        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Tenant.getTenantList().indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
                        UserInterface.getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));
                    }
                } else {
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + Tenant.getTenantList().indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
                    UserInterface.getValidIndexes().add(Tenant.getTenantList().indexOf(tenant));

                }

            }
        }
    }
    public static void removeFromTenantList() {
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println("Please select the desired tenant : \n\n");
            printTenantList("name", false);
            int option = UserInterface.getUserOption();
            option = UserInterface.validateUserInput(option);
            Tenant tenant = Agency.getTenantByIndex(option);
            Agency.printTenant(tenant);
            System.out.println();
            System.out.println("Do you want to remove " + UserInterface.PURPLE + tenant.getFirstName() +
                    ' ' + tenant.getLastName() + UserInterface.RESET + " from the list of tenants?");
            System.out.println();
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
            boolean running = true;
            while (running) {
                option = UserInterface.getUserOption();
                switch (option) {
                    case 1:
                        removeTenant(tenant);
                        Agency.setRemovedTenantsCount(Agency.getRemovedTenantsCount() + 1);

                        System.out.println(UserInterface.PURPLE + tenant.getFirstName() + ' ' + tenant.getLastName() + UserInterface.RESET +
                                " has been " + UserInterface.RED + "removed " + UserInterface.RESET + "from the list of tenants\n\n");
                        running = false;
                        break;

                    case 2:
                        System.out.println(UserInterface.RED + "The operation has been canceled :(\n\n" + UserInterface.RESET);
                        running = false;
                        break;
                    default:
                        System.out.println(UserInterface.RED + "Invalid input" + UserInterface.RESET);
                        break;
                }
            }
        } else {
            System.out.println(UserInterface.RED + "No tenant has been registered :(" + UserInterface.RESET);
        }

    }
    public static void removeFromOwnerList() {
        if (!Owner.getOwnerList().isEmpty()) {
            System.out.println(UserInterface.PURPLE + "Please select the desired owner : \n\n" + UserInterface.RESET);
            printOwnerList("name");
            int option = UserInterface.getUserOption();
            option = UserInterface.validateUserInput(option);
            Owner owner = Agency.getOwnerByIndex(option);
            Agency.printOwner(owner);
            System.out.println();
            System.out.println("Do you want to remove " + UserInterface.PURPLE + owner.getFirstName() +
                    ' ' + owner.getLastName() + UserInterface.RESET + " from the list of owners?");
            System.out.println();
            setIsCarOwner(false);
            Owner.showOwnerCars(owner);
            System.out.println();
            if (getIsCarOwner()) {
                System.out.println("Please note that by removing " + UserInterface.PURPLE + owner.getFirstName() + ' ' +
                        owner.getLastName() + UserInterface.RESET + " from the list of owners of " + UserInterface.RED + "the above cars, they will be removed from the list" + UserInterface.RESET);
            } else {
                System.out.println(UserInterface.PURPLE + "This owner does not have any car with their name" + UserInterface.PURPLE);
            }
            System.out.println();
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
            boolean running = true;
            while (running) {
                option = UserInterface.getUserOption();
                switch (option) {
                    case 1:
                        removeOwner(owner);
                        Car.getCarList().removeAll(Owner.getOwnerCarList());
                        System.out.println(UserInterface.PURPLE + owner.getFirstName() + ' ' + owner.getLastName() + UserInterface.RESET +
                                " has been " + UserInterface.RED + "removed" + UserInterface.RESET + " from the list of owners\n\n");
                        if (getIsCarOwner()) {
                            System.out.println("Furthermore, " + UserInterface.PURPLE + Owner.getOwnerCarList().size() + UserInterface.RESET + " cars owned by the mentioned owner have also been" + UserInterface.RED + " removed " + UserInterface.RESET + "from the list of cars");
                            Agency.setRemovedCarsCount(Agency.getRemovedCarsCount() + Owner.getOwnerCarList().size());
                        }
                        Agency.setRemovedOwnersCount(Agency.getRemovedOwnersCount() + 1);
                        System.out.println();
                        Owner.getOwnerCarList().clear();
                        running = false;
                        break;
                    case 2:
                        setIsCarOwner(false);
                        System.out.println(UserInterface.RED + "The operation has been canceled :(\n\n" + UserInterface.RESET);
                        Owner.getOwnerCarList().clear();
                        running = false;
                        break;
                    default:
                        System.out.println(UserInterface.RED + "Invalid input" + UserInterface.RESET);
                        Owner.getOwnerCarList().clear();
                        break;
                }
            }
        } else {
            System.out.println(UserInterface.RED + "No Owner has been registered :(" + UserInterface.RESET);
        }

    }
    public static void removeFromCarList() {
        if (!Car.getCarList().isEmpty()) {
            System.out.println("Please select the desired car : ");
            printCarList(false, null);
            int option = UserInterface.getUserOption();
            option = UserInterface.validateUserInput(option);
            Car car = getCarByIndex(option);
            printCar(car);
            System.out.println();
            System.out.println("Do you want to remove the " + UserInterface.PURPLE + car.getNameModel() + UserInterface.RESET +
                    " car from the list of cars?");
            System.out.println();
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
            boolean running = true;
            while (running) {
                option = UserInterface.getUserOption();
                switch (option) {
                    case 1:
                        removeCar(car);
                        Agency.setRemovedCarsCount(Agency.getRemovedCarsCount() + 1);
                        System.out.println(UserInterface.PURPLE + car.getNameModel() + UserInterface.RESET + " has been" + UserInterface.RED + " removed " + UserInterface.RESET + "from the list of cars\n\n");
                        running = false;
                        break;

                    case 2:
                        System.out.println(UserInterface.RED + "The operation has been canceled :(\n\n" + UserInterface.RESET);
                        running = false;
                        break;
                    default:
                        System.out.println(UserInterface.RED + "\nInvalid input" + UserInterface.RESET);
                        break;
                }

            }
        } else {
            System.out.println(UserInterface.RED + "No car has been registered :(" + UserInterface.RESET);
        }

    }
    public static void rent() {
        if (!Tenant.getTenantList().isEmpty()) {
            System.out.println("Please select the desired tenant : \n\n");
            printTenantList("name", true);
            if (getRentedCarStatus()) {
                int option = UserInterface.getUserOption();
                option = UserInterface.validateUserInput(option);
                setRentedCarStatus(false);
                Tenant tenant = getTenantByIndex(option);
                if (!Car.getCarList().isEmpty()) {
                    System.out.println(UserInterface.PURPLE + "Please select the desired car :\n\n" + UserInterface.RESET);
                    System.out.println("Cars displayed based on " + UserInterface.GREEN + tenant.getFirstName() + ' '
                            + tenant.getLastName() + UserInterface.RESET + "'s account inventory\n\n");
                    printCarList(true, tenant);
                    if (getCarRentalStatus()) {
                        option = UserInterface.getUserOption();
                        option = UserInterface.validateUserInput(option);
                        setCarRentalStatus(false);
                    } else {
                        System.out.println(UserInterface.YELLOW+"All cars have been rented out\n\n"+UserInterface.YELLOW);
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
                System.out.print("Please enter the rental period in days : ");
                int day = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                System.out.println("Do you want to rent a "
                        + UserInterface.PURPLE + car.getNameModel() + UserInterface.RESET + " car to " + UserInterface.PURPLE + tenant.getFirstName() + ' ' + tenant.getLastName() + UserInterface.RESET +
                        " for a duration of " + UserInterface.PURPLE + day + UserInterface.RESET + " days?");

                System.out.println();
                System.out.println("With your confirmation, an amount of " + UserInterface.PURPLE + UserInterface.formattedNumber.format(car.getRentMoney()) + UserInterface.RESET + " Toman will be deducted from " + UserInterface.PURPLE + tenant.getFirstName() + ' ' + tenant.getLastName() + UserInterface.RESET + "'s account\n\n");
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
                boolean running = true;
                while (running) {
                    option = UserInterface.getUserOption();
                    switch (option) {
                        case 1:
                            System.out.println(UserInterface.GREEN + "\n\nThe car has been successfully rented :)\n\n" + UserInterface.RESET);
                            Agency.setTransactionCount(Agency.getTransactionCount() + 1);
                            Agency.setTotalTransactionValue(Agency.getTotalTransactionValue() + car.getRentMoney());
                            Agency.setTotalProfit(car.getRentMoney() / 10);
                            car.getOwner().getMyTenantsList().add(tenant);
                            car.getOwner().setIncome((car.getRentMoney() * 9 / 10) + (car.getOwner().getIncome()));
                            System.out.println("A amount of "
                                    + UserInterface.PURPLE + UserInterface.formattedNumber.format(car.getRentMoney()) + UserInterface.RESET + " Toman has been deducted from " + tenant.getFirstName() + ' ' + tenant.getLastName() +
                                    "'s account\n\n");
                            tenant.setAccountBalance(tenant.getAccountBalance() - car.getRentMoney());
                            tenant.setRentedCar(car);
                            addRentedCarList(car);
                            running = false;
                            break;
                        case 2:
                            System.out.println(UserInterface.RED + "The operation has been canceled :(\n\n" + UserInterface.RESET);
                            running = false;
                            break;
                        default:
                            System.out.println(UserInterface.RED + "Invalid input" + UserInterface.RESET);
                            break;
                    }

                }
            } else {
                System.out.println(UserInterface.GREEN + "All tenants have rented a car\n\n" + UserInterface.RESET);
            }
        } else {
            System.out.println(UserInterface.RED + "No tenant has been registered :(" + UserInterface.RESET);
        }

    }
    public static void addOwner() {
        Owner owner = new Owner();

        System.out.print("Enter the owner's username: ");
        System.out.print(UserInterface.GREEN);
        owner.setUsername(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the owner's password: ");
        System.out.print(UserInterface.GREEN);
        owner.setPassword(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the owner's first name: ");
        System.out.print(UserInterface.GREEN);
        owner.setFirstName(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the owner's last name: ");
        System.out.print(UserInterface.GREEN);
        owner.setLastName(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the owner's age: ");
        System.out.print(UserInterface.GREEN);
        int age = scanner.nextInt();
        System.out.print(UserInterface.RESET);
        if (age >= 18 && age <= 250) {
            owner.setAge(age);
            scanner.nextLine();
        } else if (age < 18) {
            System.out.println(UserInterface.RED + "\n\nYou have not reached the legal age\n\n" + UserInterface.RESET);
            return;
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid age entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the owner's national code: ");
        System.out.print(UserInterface.GREEN);
        String nationalCode = scanner.nextLine();
        System.out.print(UserInterface.RESET);
        if (nationalCode.length() == 10) {
            owner.setNationalCode(nationalCode);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid national code entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the owner's phone number: ");
        System.out.print(UserInterface.GREEN);
        String phoneNumber = scanner.nextLine();
        System.out.print(UserInterface.RESET);
        if (phoneNumber.length() == 11) {
            owner.setPhoneNumber(phoneNumber);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid phone number entered\n\n" + UserInterface.RESET);
            return;
        }


        System.out.print("Enter the owner's address: ");
        System.out.print(UserInterface.GREEN);
        owner.setAddress(scanner.nextLine());
        System.out.print(UserInterface.RESET);


        addOwner(owner);
        System.out.println();
        System.out.println(UserInterface.GREEN + "Owner added successfully!" + UserInterface.RESET);
        System.out.println();
    }
    public static void addTenant() {
        Tenant tenant = new Tenant();

        System.out.print("Enter the tenant's username: ");
        System.out.print(UserInterface.GREEN);
        tenant.setUsername(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the tenant's password: ");
        System.out.print(UserInterface.GREEN);
        tenant.setPassword(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the tenant's first name: ");
        System.out.print(UserInterface.GREEN);
        tenant.setFirstName(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the tenant's last name: ");
        System.out.print(UserInterface.GREEN);
        tenant.setLastName(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the tenant's age: ");
        System.out.print(UserInterface.GREEN);
        int age = scanner.nextInt();
        System.out.print(UserInterface.RESET);
        if (age >= 18 && age <= 250) {
            tenant.setAge(age);
            scanner.nextLine();
        } else if (age < 18) {
            System.out.println(UserInterface.RED + "\n\nYou have not reached the legal age\n\n" + UserInterface.RESET);
            return;
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid age entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the tenant's national code: ");
        System.out.print(UserInterface.GREEN);
        String nationalCode = scanner.nextLine();
        System.out.print(UserInterface.RESET);
        if (nationalCode.length() == 10) {
            tenant.setNationalCode(nationalCode);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid national code entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the tenant's phone number: ");
        System.out.print(UserInterface.GREEN);
        String phoneNumber = scanner.nextLine();
        System.out.print(UserInterface.RESET);
        if (phoneNumber.length() == 11) {
            tenant.setPhoneNumber(phoneNumber);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid phone number entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the tenant's address: ");
        System.out.print(UserInterface.GREEN);
        tenant.setAddress(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the tenant's accountBalance: ");
        System.out.print(UserInterface.GREEN);
        int accountBalance = scanner.nextInt();
        scanner.nextLine();
        System.out.print(UserInterface.RESET);
        if (accountBalance >= 1_500_000) {
            tenant.setAccountBalance(accountBalance);
        } else {
            System.out.println();
            System.out.println(UserInterface.YELLOW + "The minimum accountBalance amount must be " + UserInterface.RESET + UserInterface.RED + "1,500,000" + UserInterface.RESET + UserInterface.YELLOW + " toman" + UserInterface.RESET);
            System.out.println();
            return;
        }

        addTenant(tenant);
        System.out.println();
        System.out.println(UserInterface.GREEN + "Tenant added successfully!" + UserInterface.RESET);
        System.out.println();
    }
    public static void addCar() {
        Car car = new Car();

        System.out.print("Enter the car's Name Model: ");
        System.out.print(UserInterface.GREEN);
        car.setNameModel(scanner.nextLine());
        System.out.print(UserInterface.RESET);

        System.out.print("Enter the car's engine capacity: ");
        System.out.print(UserInterface.GREEN);
        int engineCapacity = scanner.nextInt();
        if (engineCapacity > 700) {
            car.setEngineCapacity(engineCapacity);
            scanner.nextLine();
            System.out.print(UserInterface.RESET);
            System.out.println();
        } else {
            System.out.print(UserInterface.RESET);
            System.out.println(UserInterface.YELLOW + "\n\nEngine capacity must be above " + UserInterface.RESET + UserInterface.RED + " 700 cc\n\n" + UserInterface.RESET);
            return;
        }
        if (!Owner.getOwnerList().isEmpty()) {
            printOwnerList("name");
            int option = UserInterface.getUserOption();
            option = UserInterface.validateUserInput(option);
            Owner owner = getOwnerByIndex(option);
            if (owner == null) {
                return;
            }
            car.setOwner(owner);

            System.out.print("Enter the car's rent money: ");
            System.out.print(UserInterface.GREEN);
            int rentMoney = scanner.nextInt();
            if (rentMoney >= 1_500_000) {
                car.setRentMoney(rentMoney);
                scanner.nextLine();
                System.out.print(UserInterface.RESET);
            } else {
                System.out.print(UserInterface.RESET);
                System.out.println(UserInterface.YELLOW + "\n\nThe entered rental amount must be above" + UserInterface.RESET + UserInterface.RED + " 1,500,000 " + UserInterface.RESET + UserInterface.YELLOW + "toman\n\n" + UserInterface.RESET);
                return;
            }
            System.out.println();
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Sedan");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "High-riding");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Semi-high-riding");
            boolean running = true;
            while (running) {
                option = UserInterface.getUserOption();
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
                        System.out.println(UserInterface.RED + "Invalid option! Please try again" + UserInterface.RESET);
                }
            }

            System.out.print("Enter the car's lifespan: ");
            System.out.print(UserInterface.GREEN);
            car.setLifespan(scanner.nextInt());
            scanner.nextLine();
            System.out.print(UserInterface.RESET);

            addCar(car);
            System.out.println();
            System.out.println(UserInterface.GREEN + "Car added successfully!" + UserInterface.RESET);
            System.out.println();
        } else {
            System.out.println(UserInterface.RED + "\n\nNo owner has been registered\n\n" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
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
            System.out.println(UserInterface.RED + "Not found :(" + UserInterface.RESET);
        }

    }
    private static void handleOwnerManager() {
        boolean running = true;
        while (running) {
            UserInterface.displayOwnerSearchMenu();
            int option = UserInterface.getUserOption();
            String firstname;
            String lastname;
            switch (option) {
                case 1:
                    System.out.print("Enter First Name : ");
                    firstname = scanner.nextLine();
                    System.out.print("Enter Last Name : ");
                    lastname = scanner.nextLine();
                    fullNameOwnerSearch(firstname, lastname);
                    break;
                case 2:
                    System.out.print("Enter First Name : ");
                    firstname = scanner.nextLine();
                    firstNameOwnerSearch(firstname);
                    break;
                case 3:
                    System.out.print("Enter Last Name : ");
                    lastname = scanner.nextLine();
                    lastnameNameOwnerSearch(lastname);
                    break;
                case 4:
                    System.out.print("Enter National Code : ");
                    String nationalCode = scanner.nextLine();
                    nationalCodeOwnerSearch(nationalCode);
                    break;
                case 5:
                    System.out.print("Enter Phone Number : ");
                    String phoneNumber = scanner.nextLine();
                    phoneNumberOwnerSearch(phoneNumber);
                    break;
                case 6:
                    System.out.print("Enter Username : ");
                    String username = scanner.nextLine();
                    usernameOwnerSearch(username);
                    break;
                case 7:
                    System.out.print("Enter Age : ");
                    int age = scanner.nextInt();
                    ageOwnerSearch(age);
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }


    }
    private static void handleTenantManager(){
        boolean running = true;
        while (running) {
            UserInterface.displayTenantSearchMenu();
            int option = UserInterface.getUserOption();
            String firstname;
            String lastname;
            switch (option) {
                case 1:
                    System.out.print("Enter First Name : ");
                    firstname = scanner.nextLine();
                    System.out.print("Enter Last Name : ");
                    lastname = scanner.nextLine();
                    fullNameTenantSearch(firstname, lastname);
                    break;
                case 2:
                    System.out.print("Enter First Name : ");
                    firstname = scanner.nextLine();
                    firstNameTenantSearch(firstname);
                    break;
                case 3:
                    System.out.print("Enter Last Name : ");
                    lastname = scanner.nextLine();
                    lastNameTenantSearch(lastname);
                    break;
                case 4:
                    System.out.print("Enter Account Balance : ");
                    int accountBalance = scanner.nextInt();
                    accountBalanceSearch(accountBalance);
                    break;
                case 5:
                    System.out.print("Enter National Code : ");
                    String nationalCode = scanner.nextLine();
                    nationalCodeTenantSearch(nationalCode);
                    break;
                case 6:
                    System.out.print("Enter Phone Number : ");
                    String phoneNumber = scanner.nextLine();
                    phoneNumberTenantSearch(phoneNumber);
                    break;
                case 7:
                    System.out.print("Enter Username : ");
                    String username = scanner.nextLine();
                    usernameTenantSearch(username);
                    break;
                case 8:
                    System.out.print("Enter Age : ");
                    int age = scanner.nextInt();
                    ageTenantSearch(age);
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }

    }
    private static void handleCarManager() {
        boolean running = true;
        while (running) {
            UserInterface.displayCarSearchMenu();
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    System.out.print("Enter Engine Capacity : ");
                    int engineCapacity = scanner.nextInt();
                    engineCapacitySearch(engineCapacity);
                    break;
                case 2:
                    System.out.print("Enter Name Model : ");
                    String nameModel = scanner.nextLine();
                    nameModelSearch(nameModel);
                    break;
                case 3:
                    System.out.print("Enter Rent Money : ");
                    int rentMoney = scanner.nextInt();
                    rentMoneySearch(rentMoney);
                    break;
                case 4:
                    System.out.print("Enter Life Span : ");
                    int lifeSpan = scanner.nextInt();
                    lifeSpanSearch(lifeSpan);
                    break;
                case 5:
                    System.out.print("Enter First Name : ");
                    String firstname = scanner.nextLine();
                    System.out.print("Enter Last Name : ");
                    String lastname = scanner.nextLine();
                    carOwnerSearch(firstname, lastname);
                    break;
                case 6:
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Sedan");
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "High-riding");
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Semi-high-riding");
                    System.out.println();
                    System.out.print("Enter Type : ");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            typeSearch("Sedan");
                            break;
                        case 2:
                            typeSearch("High-riding");
                            break;
                        case 3:
                            typeSearch("Semi-high-riding");
                            break;
                        default:
                            System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
                    }
                    scanner.nextLine();
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }

    }
    public static void handleSearchManager() {
        boolean running = true;
        while (running) {
            UserInterface.displaySearchMenu();
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    handleOwnerManager();
                    break;
                case 2:
                    handleTenantManager();
                    break;
                case 3:
                    handleCarManager();
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
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
            displayMainMenu();
            int option = UserInterface.getUserOption();
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
                    running = false;
                    break;

                default:
                    System.out.println();
                    System.out.println(UserInterface.RED + "Invalid option! Please try again" + UserInterface.RESET);
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
    public static void adminLogin() {
        String adminUsername = "admin";
        String adminPassword = "admin";
        System.out.print(UserInterface.YELLOW + "Enter Username : " + UserInterface.RESET);
        System.out.print(UserInterface.PURPLE);
        String username = scanner.nextLine();
        System.out.print(UserInterface.RESET);
        System.out.print(UserInterface.YELLOW + "Enter Password : " + UserInterface.RESET);
        System.out.print(UserInterface.PURPLE);
        String password = scanner.nextLine();
        System.out.print(UserInterface.RESET);
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println();
            System.out.println("Welcome, " + UserInterface.GREEN + username + UserInterface.RESET + ":)");
            System.out.println();
            runAgencyManagerMenu();
        } else {
            System.out.println();
            System.out.println(RED + "Access denied :(" + RESET);
            System.out.println();
        }

    }
    public static void ownerLogin() {
        if (!Owner.getOwnerList().isEmpty()) {
            Agency.printOwnerList("username");
            System.out.print(YELLOW + "\nSelect Username : " + RESET);
            System.out.print(UserInterface.PURPLE);
            int ownerUsernameIndex = scanner.nextInt();
            System.out.print(UserInterface.RESET);
            scanner.nextLine();
            Owner owner = Agency.getOwnerByIndex(ownerUsernameIndex);
            if (owner == null) {
                return;
            }
            UserInterface.getValidIndexes().clear();
            System.out.print(UserInterface.YELLOW + "Enter Password : " + UserInterface.RESET);
            System.out.print(UserInterface.PURPLE);
            String password = scanner.nextLine();
            System.out.print(UserInterface.RESET);
            if (password.equals(owner.getPassword())) {
                System.out.println();
                System.out.println("\nWelcome, " + UserInterface.GREEN + owner.getFirstName() + ":)" + UserInterface.RESET);
                runOwnerPanelMenu(owner);
            } else {
                System.out.println();
                System.out.println(RED + "Access denied :(" + RESET);
                System.out.println();
            }
        } else {
            System.out.println(UserInterface.RED + "\n\nNo owner has been registered\n\n" + UserInterface.RESET);
        }

    }
    public static void tenantLogin() {
        if (!Tenant.getTenantList().isEmpty()) {
            Agency.printTenantList("username", false);
            System.out.print(YELLOW + "\nSelect Username : " + RESET);
            System.out.print(UserInterface.PURPLE);
            int tenantUsernameIndex = scanner.nextInt();
            System.out.print(UserInterface.RESET);
            scanner.nextLine();
            Tenant tenant = Agency.getTenantByIndex(tenantUsernameIndex);
            if (tenant == null) {
                return;
            }
            UserInterface.getValidIndexes().clear();
            System.out.print(UserInterface.YELLOW + "Enter Password : " + UserInterface.RESET);
            System.out.print(UserInterface.PURPLE);
            String password = scanner.nextLine();
            System.out.print(UserInterface.RESET);
            if (password.equals(tenant.getPassword())) {
                System.out.println();
                System.out.println("\nWelcome, " + UserInterface.GREEN + tenant.getFirstName() + ":)" + UserInterface.RESET);
                runTenantPanelMenu(tenant);
            } else {
                System.out.println();
                System.out.println(RED + "Access denied :(" + RESET);
                System.out.println();
            }
        } else {
            System.out.println(UserInterface.RED + "\n\nNo tenant has been registered\n\n" + UserInterface.RESET);
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
        System.out.println("My income (with 90% profit per transaction) " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.GREEN + UserInterface.formattedNumber.format(owner.getIncome()) + UserInterface.RESET + UserInterface.PURPLE + "] " + UserInterface.WHITE);
        System.out.println();
        Agency.printOwner(owner);
        System.out.println();
        System.out.println(UserInterface.PURPLE + "Please select an option :\n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "My Cars ");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "My tenants");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Log out");
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
        System.out.println("My account balance " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.GREEN + UserInterface.formattedNumber.format(tenant.getAccountBalance()) + UserInterface.RESET + UserInterface.PURPLE + "] " + UserInterface.WHITE);
        System.out.println();
        Agency.printTenant(tenant);
        System.out.println();
        Car rentalCar = tenant.getRentedCar();
        if (rentalCar != null) {
            Agency.printCar(rentalCar);
        } else {
            System.out.println(UserInterface.PURPLE + "You did not rent a car" + UserInterface.RESET);
        }
        System.out.println();
        System.out.println(UserInterface.PURPLE + "Please select an option :\n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Increase Account Balance ");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Log out");
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
        typingAnimation("\n\neverything is on " + GREEN + "Principle" + RESET + ", everything is on " + GREEN + "Discipline" + RESET, 90);
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
    private static void runAgencyManagerMenu() {
        boolean running = true;
        while (running) {
            displayAgencyManagerMenu();
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    Agency.addOwner();
                    break;
                case 2:
                    Agency.addTenant();
                    break;
                case 3:
                    Agency.addCar();
                    break;
                case 4:
                    Agency.removeFromOwnerList();
                    break;
                case 5:
                    Agency.removeFromTenantList();
                    break;
                case 6:
                    Agency.removeFromCarList();
                    break;
                case 7:
                    Agency.rent();
                    break;
                case 8:
                    Agency.printReport();
                    break;
                case 9:
                    Agency.handleSearchManager();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }
    }
    private static void runOwnerPanelMenu(Owner owner) {
        boolean running = true;
        while (running) {
            System.out.println();
            displayOwnerPanelMenu(owner);
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    Owner.displayMyCars(owner);
                    break;
                case 2:
                    Owner.printMyTenantsList(owner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }
    }
    private static void runTenantPanelMenu(Tenant tenant) {
        boolean running = true;
        while (running) {
            System.out.println();
            displayTenantPanelMenu(tenant);
            int option = UserInterface.getUserOption();
            switch (option) {
                case 1:
                    Tenant.increaseAccountBalance(tenant);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
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
    public static void displayMainMenu() {
        String art = """
                ╔═╗┌─┐┬─┐  ╦═╗┌─┐┌┐┌┌┬┐┌─┐┬    ╔═╗┌─┐┌─┐┌┐┌┌─┐┬ ┬
                ║  ├─┤├┬┘  ╠╦╝├┤ │││ │ ├─┤│    ╠═╣│ ┬├┤ ││││  └┬┘
                ╚═╝┴ ┴┴└─  ╩╚═└─┘┘└┘ ┴ ┴ ┴┴─┘  ╩ ╩└─┘└─┘┘└┘└─┘ ┴\s
                """;
        printBanner(art);
        System.out.println("Welcome to the Agency Management System\n");
        System.out.println(UserInterface.PURPLE + "Who are you:\n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Agency Manager");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Owner");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Tenant");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 4 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "About me");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Exit");
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
        System.out.println(UserInterface.PURPLE + "Please select an option :\n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Add Owner");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Add Tenant");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Add Car");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 4 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Remove Owner");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 5 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Remove Tenant");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 6 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Remove Car");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 7 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Rent");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 8 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Print Report");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 9 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Search");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Log out");
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
        System.out.println(UserInterface.PURPLE + "Which of the following options do you intend to search within? \n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Owners");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Tenants");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Cars");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");
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
        System.out.println(UserInterface.PURPLE + "Which of the following options do you intend to search within? \n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "First/Last Name");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "First Name");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Last Name");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 4 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "National Code");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 5 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Phone Number");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 6 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Username");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 7 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Age");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");

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
        System.out.println(UserInterface.PURPLE + "Which of the following options do you intend to search within? \n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "First/Last Name");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "First Name");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Last Name");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 4 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Account Balance");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 5 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "National Code");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 6 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Phone Number");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 7 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Username");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 8 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Age");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");

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
        System.out.println(UserInterface.PURPLE + "Which of the following options do you intend to search within? \n" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Engine Capacity");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Name Model");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Rent Money");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 4 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Life Span");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 5 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Owner");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 6 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Type");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");
    }
    public static int validateUserInput(int option) {
        while (!UserInterface.getValidIndexes().contains(option)) {
            System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
            option = UserInterface.getUserOption();
        }
        UserInterface.getValidIndexes().clear();
        return option;
    }
    public static void printBanner(String art) {
        int num = art.length() / 2;
        for (int i = 0; i < num; i++) {
            System.out.print(UserInterface.PURPLE + art.charAt(i));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = num; i < art.length(); i++) {
            System.out.print(UserInterface.WHITE + art.charAt(i));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static int getUserOption() {
        System.out.println();
        System.out.print(UserInterface.GREEN + "Enter your option: " + UserInterface.RESET);
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
}

