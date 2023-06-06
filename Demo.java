import java.sql.Struct;
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
    private final List<Tenant> myTenantsList = new ArrayList<Tenant>();
    private int income;

    public void showMyCars() {
    }

    public List<Tenant> getMyTenantsList() {
        return myTenantsList;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}

class Agency {
    // ArrayList --> https://www.youtube.com/watch?v=pruuvCVXIt8
    private final List<Car> carList = new ArrayList<Car>();
    private final List<Owner> ownerList = new ArrayList<Owner>();
    private final List<Tenant> tenantList = new ArrayList<Tenant>();
    private final List<Car> rentedCarList = new ArrayList<Car>();
    private final List<Integer> validIndexes = new ArrayList<Integer>();
    private final List<Car> ownerCarList = new ArrayList<Car>();
    private boolean rentedCarStatus = false;
    private boolean carRentalStatus = false;
    private boolean hasCarStatus = false;
    private boolean isCarOwner;

    public void setCarRentalStatus(boolean carRentalStatus) {
        this.carRentalStatus = carRentalStatus;
    }

    public void setRentedCarStatus(boolean rentedCarStatus) {
        this.rentedCarStatus = rentedCarStatus;
    }

    public Owner getOwnerByIndex(int index) {
        if (index >= 0 && index < ownerList.size()) {
            return ownerList.get(index);
        } else {
            System.out.println(UserInterface.RED + "\n\nOwner not found :(\n\n" + UserInterface.RESET);
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
        carList.remove(car);
    }

    public void removeOwner(Owner owner) {
        ownerList.remove(owner);
    }

    public void removeTenant(Tenant tenant) {
        tenantList.remove(tenant);
    }


    public void printReport() {
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
        int totalCustomers = ownerList.size() + tenantList.size() + UserInterface.getRemovedTenantsCount() + UserInterface.getRemovedOwnersCount();
        System.out.println("The total number of customers                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + totalCustomers + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of tenants                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + tenantList.size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of owners                           " + UserInterface.PURPLE + "[" + UserInterface.WHITE + ownerList.size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of cars                             " + UserInterface.PURPLE + "[" + UserInterface.WHITE + carList.size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of tenants removed                              " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getRemovedTenantsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of owners removed                               " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getRemovedOwnersCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of cars removed                                 " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getRemovedCarsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The number of transactions today                       " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getTransactionCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The value of transactions conducted                    " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.formattedNumber.format(UserInterface.getTotalTransactionValue()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Agency profit (calculated at 10% for each transaction) " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.formattedNumber.format(UserInterface.getTotalProfit()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println();
        printOwners();
        System.out.println();
        printTenants();
        System.out.println();
        printCars();
        System.out.println();


    }

    public Boolean getCarRentalStatus() {
        return carRentalStatus;
    }

    public Boolean getRentedCarStatus() {
        return rentedCarStatus;
    }

    public boolean getIsCarOwner() {
        return isCarOwner;
    }

    public void setIsCarOwner(Boolean value) {
        isCarOwner = value;
    }

    public boolean getHasCarStatus() {
        return hasCarStatus;
    }

    public void printOwners() {
        if (!ownerList.isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Owners :\n" + UserInterface.WHITE);
            for (Owner owner : ownerList) {
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

    public void printOwner(Owner owner) {
        if (!ownerList.isEmpty()) {
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

    public void printTenants() {
        if (!tenantList.isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Tenants :\n" + UserInterface.WHITE);
            for (Tenant tenant : tenantList) {
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

    public void printTenant(Tenant tenant) {
        if (!tenantList.isEmpty()) {
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

    public void printCars() {
        if (!carList.isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Cars :\n" + UserInterface.WHITE);
            for (Car car : carList) {
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

    public void printCar(Car car) {
        if (!carList.isEmpty()) {
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

    public void printOwnerList(String type) {
        if (type.equalsIgnoreCase("username")) {
            for (Owner owner : ownerList) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + ownerList.indexOf(owner) + UserInterface.PURPLE + "] " + UserInterface.RESET + owner.getUsername());
                validIndexes.add(ownerList.indexOf(owner));

            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Owner owner : ownerList) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + ownerList.indexOf(owner) + UserInterface.PURPLE + "] " + UserInterface.RESET + owner.getFirstName() + ' ' + owner.getLastName());
                validIndexes.add(ownerList.indexOf(owner));
            }

        }
    }

    public void printCarList(boolean exception, Tenant user) {
        for (Car car : carList) {
            if (exception && user != null) {
                if (!rentedCarList.contains(car) && user.getAccountBalance() >= car.getRentMoney()) {
                    carRentalStatus = true;
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + carList.indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                    validIndexes.add(carList.indexOf(car));
                }
            } else {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + carList.indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                validIndexes.add(carList.indexOf(car));


            }
        }
    }

    public void printMyTenantsList(Owner owner) {
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

    public void printMyCarsList(Owner owner) {
        for (Car car : carList) {
            if (car.getOwner().equals(owner)) {
                hasCarStatus = true;
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + carList.indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                validIndexes.add(carList.indexOf(car));
            }
        }
    }


    public void showOwnerCars(Owner owner) {
        for (Car car : carList) {
            if (car.getOwner().equals(owner)) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + carList.indexOf(car) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + car.getNameModel());
                ownerCarList.add(car);
                isCarOwner = true;
            }
        }
    }

    public Boolean isCarRented(Car car) {
        for (Tenant tenant : tenantList) {
            if (tenant.getRentedCar() != null) {
                if (tenant.getRentedCar().equals(car)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printTenantList(String type, boolean exception) {
        if (type.equalsIgnoreCase("username")) {
            for (Tenant tenant : tenantList) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        rentedCarStatus = true;
                        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + tenantList.indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getUsername());
                        validIndexes.add(tenantList.indexOf(tenant));

                    }
                } else {
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + tenantList.indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getUsername());
                    validIndexes.add(tenantList.indexOf(tenant));

                }
            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Tenant tenant : tenantList) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        rentedCarStatus = true;
                        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + tenantList.indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
                        validIndexes.add(tenantList.indexOf(tenant));
                    }
                } else {
                    System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + tenantList.indexOf(tenant) + UserInterface.PURPLE + "]" + UserInterface.RESET + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
                    validIndexes.add(tenantList.indexOf(tenant));

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

    public List<Integer> getValidIndexes() {
        return validIndexes;
    }

    public List<Car> getOwnerCarList() {
        return ownerCarList;
    }
}


class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Agency agency = new Agency();
    private static int transactionCount;
    private static int removedOwnersCount;
    private static long totalTransactionValue;
    private static int removedTenantsCount;
    private static int removedCarsCount;
    private static long totalProfit;
    public static final DecimalFormat formattedNumber = new DecimalFormat("#,###,###");
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";

    public static int getTransactionCount() {
        return transactionCount;
    }

    public static int getRemovedCarsCount() {
        return removedCarsCount;
    }

    public static int getRemovedOwnersCount() {
        return removedOwnersCount;
    }

    public static int getRemovedTenantsCount() {
        return removedTenantsCount;
    }

    public static long getTotalTransactionValue() {
        return totalTransactionValue;
    }

    public static long getTotalProfit() {
        return totalProfit;
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int option = getUserOption();
            String username;
            String password;
            switch (option) {
                case 1:
                    System.out.print(UserInterface.YELLOW + "Enter Username : " + UserInterface.RESET);
                    System.out.print(UserInterface.PURPLE);
                    username = scanner.nextLine();
                    System.out.print(UserInterface.RESET);
                    System.out.print(UserInterface.YELLOW + "Enter Password : " + UserInterface.RESET);
                    System.out.print(UserInterface.PURPLE);
                    password = scanner.nextLine();
                    System.out.print(UserInterface.RESET);
                    if (username.equals("admin") && password.equals("admin")) {
                        System.out.println();
                        System.out.println("Welcome, " + UserInterface.GREEN + username + UserInterface.RESET + ":)");
                        System.out.println();
                        handleAgencyManager();
                    } else {
                        System.out.println();
                        System.out.println(RED + "Access denied :(" + RESET);
                        System.out.println();
                    }
                    break;
                case 2:
                    if (!agency.getOwnerList().isEmpty()) {
                        System.out.println();
                        agency.printOwnerList("username");
                        System.out.print(YELLOW + "\nSelect Username : " + RESET);
                        System.out.print(UserInterface.PURPLE);
                        int index_username_owner = scanner.nextInt();
                        System.out.print(UserInterface.RESET);
                        scanner.nextLine();
                        Owner owner = agency.getOwnerByIndex(index_username_owner);
                        if (owner == null) {
                            break;
                        }
                        agency.getValidIndexes().clear();
                        System.out.print(UserInterface.YELLOW + "Enter Password : " + UserInterface.RESET);
                        System.out.print(UserInterface.PURPLE);
                        password = scanner.nextLine();
                        System.out.print(UserInterface.RESET);
                        if (password.equals(owner.getPassword())) {
                            System.out.println();
                            System.out.println("\nWelcome, " + UserInterface.GREEN + owner.getFirstName() + ":)" + UserInterface.RESET);
                            handleOwnerPanel(owner);
                        } else {
                            System.out.println();
                            System.out.println(RED + "Access denied :(" + RESET);
                            System.out.println();
                        }
                    } else {
                        System.out.println(UserInterface.RED + "\n\nNo owner has been registered\n\n" + UserInterface.RESET);
                    }
                    break;

                case 3:
                    if (!agency.getTenantList().isEmpty()) {
                        System.out.println();
                        agency.printTenantList("username", false);
                        System.out.print(YELLOW + "\nSelect Username : " + RESET);
                        System.out.print(UserInterface.PURPLE);
                        int index_username_tenant = scanner.nextInt();
                        System.out.print(UserInterface.RESET);
                        scanner.nextLine();
                        Tenant tenant = agency.getTenantByIndex(index_username_tenant);
                        if (tenant == null) {
                            break;
                        }
                        agency.getValidIndexes().clear();
                        System.out.print(UserInterface.YELLOW + "Enter Password : " + UserInterface.RESET);
                        System.out.print(UserInterface.PURPLE);
                        password = scanner.nextLine();
                        System.out.print(UserInterface.RESET);
                        if (password.equals(tenant.getPassword())) {
                            System.out.println();
                            System.out.println("\nWelcome, " + UserInterface.GREEN + tenant.getFirstName() + ":)" + UserInterface.RESET);
                            handleTenantPanel(tenant);
                        } else {
                            System.out.println();
                            System.out.println(RED + "Access denied :(" + RESET);
                            System.out.println();
                        }
                    } else {
                        System.out.println(UserInterface.RED + "\n\nNo tenant has been registered\n\n" + UserInterface.RESET);
                    }
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

    private static void displayMainMenu() {
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

    private static void displayAgencyManagerMenu() {
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

    private static void displaySearchMenu() {
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

    private static void displayOwnerSearchMenu() {
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

    private static void displayTenantSearchMenu() {
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

    private static void displayCarSearchMenu() {
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
        agency.printOwner(owner);
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
        agency.printTenant(tenant);
        System.out.println();
        Car rentalCar = tenant.getRentedCar();
        if (rentalCar != null) {
            agency.printCar(rentalCar);
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
        typingAnimation("\n\nEverything is on " + GREEN + "Principle" + RESET + ", everything is on " + GREEN + "Discipline" + RESET, 90);
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
                    removeFromOwnerList();
                    break;
                case 5:
                    removeFromTenantList();
                    break;
                case 6:
                    removeFromCarList();
                    break;
                case 7:
                    rent();
                    break;
                case 8:
                    agency.printReport();
                    break;
                case 9:
                    handleSearchManager();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }
    }

    private static void handleOwnerPanel(Owner owner) {
        boolean running = true;
        while (running) {
            System.out.println();
            displayOwnerPanelMenu(owner);
            int option = getUserOption();
            switch (option) {
                case 1:
                    displayMyCars(owner);
                    break;
                case 2:
                    agency.printMyTenantsList(owner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }
    }

    private static void handleTenantPanel(Tenant tenant) {
        boolean running = true;
        while (running) {
            System.out.println();
            displayTenantPanelMenu(tenant);
            int option = getUserOption();
            switch (option) {
                case 1:
                    increaseAccountBalance(tenant);
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

                } else if (i >= 30) {
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

    private static void displayMyCars(Owner owner) {
        boolean running = true;
        while (running) {
            System.out.println(PURPLE + "\nThe list of your cars \n" + RESET);
            agency.printMyCarsList(owner);
            if (UserInterface.agency.getHasCarStatus()) {
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + agency.getCarList().size() + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Back");
                agency.getValidIndexes().add(agency.getCarList().size());
                int option = getUserOption();
                while (!agency.getValidIndexes().contains(option)) {
                    System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
                    option = getUserOption();
                }
                agency.getValidIndexes().clear();
                if (option == agency.getCarList().size()) {
                    running = false;
                } else {
                    Car car = agency.getCarByIndex(option);
                    agency.printCar(car);
                    System.out.println("Is the car rented by a tenant? " + UserInterface.PURPLE + "[" + UserInterface.RESET + (agency.isCarRented(car) ? UserInterface.GREEN + "Yes" + UserInterface.RESET : UserInterface.RED + "No" + UserInterface.RESET) + UserInterface.PURPLE + "]" + UserInterface.RESET);
                }
            } else {
                System.out.println(UserInterface.RED + "No cars are registered under your name :(" + UserInterface.RESET);
                running = false;
            }
        }

    }

    private static void increaseAccountBalance(Tenant tenant) {
        System.out.print(YELLOW + "Please enter the desired amount : " + RESET);
        System.out.print(GREEN);
        int amount = scanner.nextInt();
        System.out.println(RESET);
        System.out.println(YELLOW + "Do you want to increase your account balance by " + UserInterface.RESET + formattedNumber.format(amount) + UserInterface.RESET + " Toman?" + RESET);
        System.out.println();
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
        boolean running = true;
        while (running) {
            int option = getUserOption();
            switch (option) {
                case 1:
                    tenant.setAccountBalance(tenant.getAccountBalance() + amount);
                    System.out.println(YELLOW + "\n " + GREEN + formattedNumber.format(amount) + RESET + " toman deposited successfully to your account" + RESET);
                    System.out.println("\nBalance:  " + PURPLE + "[" + WHITE + GREEN + formattedNumber.format(tenant.getAccountBalance()) + RESET + PURPLE + "] " + WHITE);
                    running = false;
                    break;
                case 2:
                    System.out.println(RED + "\nThe operation has been canceled :(\n\n" + RESET);
                    running = false;
                    break;

                default:
                    System.out.println(UserInterface.RED + "\nInvalid input" + UserInterface.RESET);
                    break;
            }
        }
    }


    private static void fullNameOwnerSearch(String firstName, String lastName) {
        boolean foundStatus = false;
        for (Owner owner : agency.getOwnerList()) {
            if ((owner.getFirstName() + owner.getLastName()).equalsIgnoreCase(firstName + lastName)) {
                agency.printOwner(owner);
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
        for (Owner owner : agency.getOwnerList()) {
            if (owner.getFirstName().equalsIgnoreCase(firstName)) {
                agency.printOwner(owner);
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
        for (Owner owner : agency.getOwnerList()) {
            if (owner.getLastName().equalsIgnoreCase(lastName)) {
                agency.printOwner(owner);
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
        for (Owner owner : agency.getOwnerList()) {
            if (owner.getNationalCode().equals(nationalCode)) {
                agency.printOwner(owner);
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
        for (Owner owner : agency.getOwnerList()) {
            if (owner.getPhoneNumber().equals(phoneNumber)) {
                agency.printOwner(owner);
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
        for (Owner owner : agency.getOwnerList()) {
            if (owner.getUsername().equalsIgnoreCase(userName)) {
                agency.printOwner(owner);
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
        for (Owner owner : agency.getOwnerList()) {
            if (owner.getAge() <= age) {
                agency.printOwner(owner);
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
        for (Tenant tenant : agency.getTenantList()) {
            if ((tenant.getFirstName() + tenant.getLastName()).equalsIgnoreCase(firstName + lastName)) {
                agency.printTenant(tenant);
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
        for (Tenant tenant : agency.getTenantList()) {
            if (tenant.getFirstName().equalsIgnoreCase(firstName)) {
                agency.printTenant(tenant);
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
        for (Tenant tenant : agency.getTenantList()) {
            if (tenant.getLastName().equalsIgnoreCase(lastName)) {
                agency.printTenant(tenant);
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
        for (Tenant tenant : agency.getTenantList()) {
            if (tenant.getNationalCode().equals(nationalCode)) {
                agency.printTenant(tenant);
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
        for (Tenant tenant : agency.getTenantList()) {
            if (tenant.getPhoneNumber().equals(phoneNumber)) {
                agency.printTenant(tenant);
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
        for (Tenant tenant : agency.getTenantList()) {
            if (tenant.getUsername().equalsIgnoreCase(userName)) {
                agency.printTenant(tenant);
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
        for (Tenant tenant : agency.getTenantList()) {
            if (tenant.getAge() <= age) {
                agency.printTenant(tenant);
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
        for (Tenant tenant : agency.getTenantList()) {
            if (tenant.getAccountBalance() <= accountBalance) {
                agency.printTenant(tenant);
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
        for (Car car : agency.getCarList()) {
            if (car.getEngineCapacity() <= engineCapacity) {
                agency.printCar(car);
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
        for (Car car : agency.getCarList()) {
            if (car.getNameModel().equalsIgnoreCase(nameModel)) {
                agency.printCar(car);
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
        for (Car car : agency.getCarList()) {
            if (car.getRentMoney() <= rentMoney) {
                agency.printCar(car);
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
        for (Car car : agency.getCarList()) {
            if (car.getLifespan() <= lifeSpan) {
                agency.printCar(car);
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
        for (Car car : agency.getCarList()) {
            if ((car.getOwner().getFirstName() + car.getOwner().getLastName()).equalsIgnoreCase(firstName + lastName)) {
                agency.printCar(car);
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
        for (Car car : agency.getCarList()) {
            if (car.getType().equalsIgnoreCase(type)) {
                agency.printCar(car);
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
            displayOwnerSearchMenu();
            int option = getUserOption();
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

    private static void handleTenantManager() {
        boolean running = true;
        while (running) {
            displayTenantSearchMenu();
            int option = getUserOption();
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
            displayCarSearchMenu();
            int option = getUserOption();
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
                    String type = scanner.nextLine();
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(UserInterface.RED + "\n\nInvalid option! Please try again" + UserInterface.RESET);
            }
        }

    }

    private static void handleSearchManager() {
        boolean running = true;
        while (running) {
            displaySearchMenu();
            int option = getUserOption();
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

    private static int getUserOption() {
        System.out.println();
        System.out.print(UserInterface.GREEN + "Enter your option: " + UserInterface.RESET);
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    public static void removeFromTenantList() {
        if (!agency.getTenantList().isEmpty()) {
            System.out.println("Please select the desired tenant : \n\n");
            agency.printTenantList("name", false);
            int option = getUserOption();
            while (!agency.getValidIndexes().contains(option)) {
                System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
                option = getUserOption();
            }
            agency.getValidIndexes().clear();
            Tenant tenant = agency.getTenantByIndex(option);
            agency.printTenant(tenant);
            System.out.println();
            System.out.println("Do you want to remove " + UserInterface.PURPLE + tenant.getFirstName() +
                    ' ' + tenant.getLastName() + UserInterface.RESET + " from the list of tenants?");
            System.out.println();
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
            boolean running = true;
            while (running) {
                option = getUserOption();
                switch (option) {
                    case 1:
                        agency.removeTenant(tenant);
                        removedTenantsCount += 1;
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
        if (!agency.getOwnerList().isEmpty()) {
            System.out.println(UserInterface.PURPLE + "Please select the desired owner : \n\n" + UserInterface.RESET);
            agency.printOwnerList("name");
            int option = getUserOption();
            while (!agency.getValidIndexes().contains(option)) {
                System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
                option = getUserOption();
            }
            agency.getValidIndexes().clear();
            Owner owner = agency.getOwnerByIndex(option);
            agency.printOwner(owner);
            System.out.println();
            System.out.println("Do you want to remove " + UserInterface.PURPLE + owner.getFirstName() +
                    ' ' + owner.getLastName() + UserInterface.RESET + " from the list of owners?");
            System.out.println();
            agency.setIsCarOwner(false);
            agency.showOwnerCars(owner);
            System.out.println();
            if (agency.getIsCarOwner()) {
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
                option = getUserOption();
                switch (option) {
                    case 1:
                        agency.removeOwner(owner);
                        agency.getCarList().removeAll(agency.getOwnerCarList());
                        System.out.println(UserInterface.PURPLE + owner.getFirstName() + ' ' + owner.getLastName() + UserInterface.RESET +
                                " has been " + UserInterface.RED + "removed" + UserInterface.RESET + " from the list of owners\n\n");
                        if (agency.getIsCarOwner()) {
                            System.out.println("Furthermore, " + UserInterface.PURPLE + agency.getOwnerCarList().size() + UserInterface.RESET + " cars owned by the mentioned owner have also been" + UserInterface.RED + " removed " + UserInterface.RESET + "from the list of cars");
                            removedCarsCount += agency.getOwnerCarList().size();
                        }
                        removedOwnersCount += 1;
                        System.out.println();
                        agency.getOwnerCarList().clear();
                        running = false;
                        break;
                    case 2:
                        agency.setIsCarOwner(false);
                        System.out.println(UserInterface.RED + "The operation has been canceled :(\n\n" + UserInterface.RESET);
                        agency.getOwnerCarList().clear();
                        running = false;
                        break;
                    default:
                        System.out.println(UserInterface.RED + "Invalid input" + UserInterface.RESET);
                        agency.getOwnerCarList().clear();
                        break;
                }
            }
        } else {
            System.out.println(UserInterface.RED + "No Owner has been registered :(" + UserInterface.RESET);
        }

    }

    public static void removeFromCarList() {
        if (!agency.getCarList().isEmpty()) {
            System.out.println("Please select the desired car : ");
            agency.printCarList(false, null);
            int option = getUserOption();
            while (!agency.getValidIndexes().contains(option)) {
                System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
                option = getUserOption();
            }
            agency.getValidIndexes().clear();
            Car car = agency.getCarByIndex(option);
            agency.printCar(car);
            System.out.println();
            System.out.println("Do you want to remove the " + UserInterface.PURPLE + car.getNameModel() + UserInterface.RESET +
                    " car from the list of cars?");
            System.out.println();
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
            boolean runing = true;
            while (runing) {
                option = getUserOption();
                switch (option) {
                    case 1:
                        agency.removeCar(car);
                        removedCarsCount += 1;
                        System.out.println(UserInterface.PURPLE + car.getNameModel() + UserInterface.RESET + " has been" + UserInterface.RED + " removed " + UserInterface.RESET + "from the list of cars\n\n");
                        runing = false;
                        break;

                    case 2:
                        System.out.println(UserInterface.RED + "The operation has been canceled :(\n\n" + UserInterface.RESET);
                        runing = false;
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

    private static void rent() {
        if (!agency.getTenantList().isEmpty()) {
            System.out.println("Please select the desired tenant : \n\n");
            agency.printTenantList("name", true);
            if (agency.getRentedCarStatus()) {
                int option = getUserOption();

                while (!agency.getValidIndexes().contains(option)) {
                    System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
                    option = getUserOption();
                }

                agency.getValidIndexes().clear();
                agency.setRentedCarStatus(false);
                Tenant tenant = agency.getTenantByIndex(option);
                if (!agency.getCarList().isEmpty()) {
                    System.out.println(UserInterface.PURPLE + "Please select the desired car :\n\n" + UserInterface.RESET);
                    System.out.println("Cars displayed based on " + UserInterface.GREEN + tenant.getFirstName() + ' '
                            + tenant.getLastName() + UserInterface.RESET + "'s account inventory\n\n");
                    agency.printCarList(true, tenant);
                    if (agency.getCarRentalStatus()) {
                        option = getUserOption();
                        while (!agency.getValidIndexes().contains(option)) {
                            System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
                            option = getUserOption();
                        }
                        agency.getValidIndexes().clear();
                        agency.setCarRentalStatus(false);
                    } else {
                        System.out.println("All cars have been rented out");
                        return;
                    }

                } else {
                    System.out.println("No car has been registered :(");
                    return;
                }

                agency.printTenant(tenant);
                Car car = agency.getCarByIndex(option);
                System.out.println();
                agency.printCar(car);
                System.out.println();
                System.out.print("Please enter the rental period in days : ");
                int day = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                System.out.println("Do you want to rent a "
                        + UserInterface.PURPLE + car.getNameModel() + UserInterface.RESET + " car to " + UserInterface.PURPLE + tenant.getFirstName() + ' ' + tenant.getLastName() + UserInterface.RESET +
                        " for a duration of " + UserInterface.PURPLE + day + UserInterface.RESET + " days?");

                System.out.println();
                System.out.println("With your confirmation, an amount of " + PURPLE + formattedNumber.format(car.getRentMoney()) + RESET + " Toman will be deducted from " + PURPLE + tenant.getFirstName() + ' ' + tenant.getLastName() + RESET + "'s account\n\n");
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 1 + UserInterface.PURPLE + "]" + UserInterface.RESET + " Yes");
                System.out.println(UserInterface.PURPLE + "[" + UserInterface.RESET + 2 + UserInterface.PURPLE + "]" + UserInterface.RESET + " No\n");
                boolean runnig = true;
                while (runnig) {
                    option = getUserOption();
                    switch (option) {
                        case 1:
                            System.out.println(GREEN + "\n\nThe car has been successfully rented :)\n\n" + RESET);
                            transactionCount += 1;
                            totalTransactionValue += car.getRentMoney();
                            totalProfit += car.getRentMoney() / 10;
                            car.getOwner().getMyTenantsList().add(tenant);
                            car.getOwner().setIncome((car.getRentMoney() * 9 / 10) + (car.getOwner().getIncome()));
                            System.out.println("A amount of "
                                    + PURPLE + formattedNumber.format(car.getRentMoney()) + RESET + " Toman has been deducted from " + tenant.getFirstName() + ' ' + tenant.getLastName() +
                                    "'s account\n\n");
                            tenant.setAccountBalance(tenant.getAccountBalance() - car.getRentMoney());
                            tenant.setRentedCar(car);
                            agency.addRentedCarList(car);
                            runnig = false;
                            break;
                        case 2:
                            System.out.println(UserInterface.RED + "The operation has been canceled :(\n\n" + UserInterface.RESET);
                            runnig = false;
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

    private static void addOwner() {
        Owner owner = new Owner();

        System.out.print("Enter the owner's username: ");
        System.out.print(GREEN);
        owner.setUsername(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the owner's password: ");
        System.out.print(GREEN);
        owner.setPassword(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the owner's first name: ");
        System.out.print(GREEN);
        owner.setFirstName(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the owner's last name: ");
        System.out.print(GREEN);
        owner.setLastName(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the owner's age: ");
        System.out.print(GREEN);
        int age = scanner.nextInt();
        System.out.print(RESET);
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
        System.out.print(GREEN);
        String nationalCode = scanner.nextLine();
        System.out.print(RESET);
        if (nationalCode.length() == 10) {
            owner.setNationalCode(nationalCode);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid national code entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the owner's phone number: ");
        System.out.print(GREEN);
        String phoneNumber = scanner.nextLine();
        System.out.print(RESET);
        if (phoneNumber.length() == 11) {
            owner.setPhoneNumber(phoneNumber);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid phone number entered\n\n" + UserInterface.RESET);
            return;
        }


        System.out.print("Enter the owner's address: ");
        System.out.print(GREEN);
        owner.setAddress(scanner.nextLine());
        System.out.print(RESET);


        agency.addOwner(owner);
        System.out.println();
        System.out.println(UserInterface.GREEN + "Owner added successfully!" + UserInterface.RESET);
        System.out.println();
    }

    private static void addTenant() {
        Tenant tenant = new Tenant();

        System.out.print("Enter the tenant's username: ");
        System.out.print(GREEN);
        tenant.setUsername(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the tenant's password: ");
        System.out.print(GREEN);
        tenant.setPassword(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the tenant's first name: ");
        System.out.print(GREEN);
        tenant.setFirstName(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the tenant's last name: ");
        System.out.print(GREEN);
        tenant.setLastName(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the tenant's age: ");
        System.out.print(GREEN);
        int age = scanner.nextInt();
        System.out.print(RESET);
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
        System.out.print(GREEN);
        String nationalCode = scanner.nextLine();
        System.out.print(RESET);
        if (nationalCode.length() == 10) {
            tenant.setNationalCode(nationalCode);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid national code entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the tenant's phone number: ");
        System.out.print(GREEN);
        String phoneNumber = scanner.nextLine();
        System.out.print(RESET);
        if (phoneNumber.length() == 11) {
            tenant.setPhoneNumber(phoneNumber);
        } else {
            System.out.println(UserInterface.RED + "\n\nInvalid phone number entered\n\n" + UserInterface.RESET);
            return;
        }

        System.out.print("Enter the tenant's address: ");
        System.out.print(GREEN);
        tenant.setAddress(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the tenant's accountBalance: ");
        System.out.print(GREEN);
        int accountBalance = scanner.nextInt();
        scanner.nextLine();
        System.out.print(RESET);
        if (accountBalance >= 1_500_000) {
            tenant.setAccountBalance(accountBalance);
        } else {
            System.out.println();
            System.out.println(UserInterface.YELLOW + "The minimum accountBalance amount must be " + UserInterface.RESET + UserInterface.RED + "1,500,000" + UserInterface.RESET + UserInterface.YELLOW + " toman" + UserInterface.RESET);
            System.out.println();
            return;
        }

        agency.addTenant(tenant);
        System.out.println();
        System.out.println(UserInterface.GREEN + "Tenant added successfully!" + UserInterface.RESET);
        System.out.println();
    }

    private static void addCar() {
        Car car = new Car();

        System.out.print("Enter the car's Name Model: ");
        System.out.print(GREEN);
        car.setNameModel(scanner.nextLine());
        System.out.print(RESET);

        System.out.print("Enter the car's engine capacity: ");
        System.out.print(GREEN);
        int engineCapacity = scanner.nextInt();
        if (engineCapacity > 700) {
            car.setEngineCapacity(engineCapacity);
            scanner.nextLine();
            System.out.print(RESET);
            System.out.println();
        } else {
            System.out.print(RESET);
            System.out.println(UserInterface.YELLOW + "\n\nEngine capacity must be above " + UserInterface.RESET + UserInterface.RED + " 700 cc\n\n" + UserInterface.RESET);
            return;
        }
        if (!agency.getOwnerList().isEmpty()) {
            agency.printOwnerList("name");
            int option = getUserOption();
            while (!agency.getValidIndexes().contains(option)) {
                System.out.println(UserInterface.RED + "The input is invalid. Please try again" + UserInterface.RESET);
                option = getUserOption();
            }
            agency.getValidIndexes().clear();
            Owner owner = agency.getOwnerByIndex(option);
            if (owner == null) {
                return;
            }
            car.setOwner(owner);

            System.out.print("Enter the car's rent money: ");
            System.out.print(GREEN);
            int rentMoney = scanner.nextInt();
            if (rentMoney >= 1_500_000) {
                car.setRentMoney(rentMoney);
                scanner.nextLine();
                System.out.print(RESET);
            } else {
                System.out.print(RESET);
                System.out.println(UserInterface.YELLOW + "\n\nThe entered rental amount must be above" + UserInterface.RESET + UserInterface.RED + " 1,500,000 " + UserInterface.RESET + UserInterface.YELLOW + "toman\n\n" + UserInterface.RESET);
                return;
            }
            System.out.println();
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Sedan");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "High-riding");
            System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Semi-high-riding");
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
                        System.out.println(UserInterface.RED + "Invalid option! Please try again" + UserInterface.RESET);
                }
            }

            System.out.print("Enter the car's lifespan: ");
            System.out.print(GREEN);
            car.setLifespan(scanner.nextInt());
            scanner.nextLine();
            System.out.print(RESET);

            agency.addCar(car);
            System.out.println();
            System.out.println(UserInterface.GREEN + "Car added successfully!" + UserInterface.RESET);
            System.out.println();
        } else {
            System.out.println(UserInterface.RED + "\n\nNo owner has been registered\n\n" + UserInterface.RESET);
        }
    }
}

