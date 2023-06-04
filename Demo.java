import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

//این متد rent رو جوری تغییر بده که ماشین های در حد بودجه مستاجر رو نشان دهد
// مستاجر بتونه لیست تراکنش هااشو ببینه توی حسابش و مشخصاتش و موجدوی حسابش و قابلیت افزایش موجودی حسابش و ماشین هایی که تا الان اجرا کرده و ماشین فعلی که الان در حال اجاره داره و با چه کسانی تا حالا کار کرده
//مالک بتونه درامدشو ببینه توی حسابش و مشخصاتشو و ماشین هایه بنامشو و وضعیت در حال اجاره بودن یا نبودن ماشین ها و با چه کسانی تا حالا کار کرده

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
    private final List<Integer> validIndexes = new ArrayList<Integer>();
    private final List<Car> ownerCarList = new ArrayList<Car>();
    private boolean rentedCarStatus = false;
    private boolean carRentalStatus = false;
    private boolean isCarOwner = false;

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
        carList.remove(car);
    }

    public void removeOwner(Owner owner) {
        ownerList.remove(owner);
    }

    public void removeTenant(Tenant tenant) {
        tenantList.remove(tenant);
    }


    public void search() {
        // Searching logic
    }

    public void printReport() {
        String art = """
                8888888 888b    888 8888888888 .d88888b. \s
                  888   8888b   888 888       d88P" "Y88b\s
                  888   88888b  888 888       888     888\s
                  888   888Y88b 888 8888888   888     888\s
                  888   888 Y88b888 888       888     888\s
                  888   888  Y88888 888       888     888\s
                  888   888   Y8888 888       Y88b. .d88P\s
                8888888 888    Y888 888        "Y88888P" \s
                                                         \s
                                                         \s
                                                         \s
                """;

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
        DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
        int totalCustomers = ownerList.size() + tenantList.size() + UserInterface.getRemovedTenantsCount() + UserInterface.getRemovedOwnersCount();
        System.out.println("The total number of customers                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + totalCustomers + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of tenants                          " + UserInterface.PURPLE + "[" + UserInterface.WHITE + tenantList.size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of owners                           " + UserInterface.PURPLE + "[" + UserInterface.WHITE + ownerList.size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The current number of cars                             " + UserInterface.PURPLE + "[" + UserInterface.WHITE + carList.size() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of tenants removed                              " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getRemovedTenantsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of owners removed                               " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getRemovedOwnersCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Number of cars removed                                 " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getRemovedCarsCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The number of transactions today                       " + UserInterface.PURPLE + "[" + UserInterface.WHITE + UserInterface.getTransactionCount() + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("The value of transactions conducted                    " + UserInterface.PURPLE + "[" + UserInterface.WHITE + decimalFormat.format(UserInterface.getTotalTransactionValue()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
        System.out.println("Agency profit (calculated at 10% for each transaction) " + UserInterface.PURPLE + "[" + UserInterface.WHITE + decimalFormat.format(UserInterface.getTotalProfit()) + UserInterface.PURPLE + "]" + UserInterface.RESET);
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

    public void printOwners() {
        if (!ownerList.isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Owners :" + UserInterface.WHITE);
            for (Owner owner : ownerList) {
                System.out.println("Username       " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getUsername() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Password       " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getPassword() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("First Name     " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getFirstName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Last Name      " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Age            " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getAge() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("National Code  " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getNationalCode() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Phone Number   " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getPhoneNumber() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Address        " + UserInterface.PURPLE + "[" + UserInterface.RESET + owner.getAddress() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println();
            }
        }
    }

    public void printOwner(Owner owner) {
        if (!ownerList.isEmpty()) {
            System.out.println("Information of " + owner.getFirstName() + ' ' + owner.getLastName() + ": ");
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

    public void printTenants() {
        if (!tenantList.isEmpty()) {
            System.out.println(UserInterface.PURPLE + "List of Tenants :" + UserInterface.WHITE);
            for (Tenant tenant : tenantList) {
                System.out.println("Username        " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getUsername() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Password        " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getPassword() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("First Name      " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getFirstName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Last Name       " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Age             " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getAge() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("National Code   " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getNationalCode() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Phone Number    " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getPhoneNumber() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Address         " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getAddress() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Account Balance " + UserInterface.PURPLE + "[" + UserInterface.RESET + tenant.getAccountBalance() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println();
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
            System.out.println(UserInterface.PURPLE + "List of Cars :" + UserInterface.WHITE);
            for (Car car : carList) {
                System.out.println("Name Model      " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getNameModel() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Engine Capacity " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getEngineCapacity() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Owner           " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Rent Money      " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getRentMoney() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Type            " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getType() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println("Lifespan        " + UserInterface.PURPLE + "[" + UserInterface.RESET + car.getLifespan() + UserInterface.PURPLE + "]" + UserInterface.RESET);
                System.out.println();
            }
        }
    }

    public void printCar(Car car) {
        if (!carList.isEmpty()) {
            System.out.println("Information of " + car.getNameModel() + " car : ");
            System.out.println("Name Model: " + car.getNameModel());
            System.out.println("Engine Capacity: " + car.getEngineCapacity());
            System.out.println("Owner: " + car.getOwner().getFirstName() + ' ' + car.getOwner().getLastName());
            System.out.println("Rent Money: " + car.getRentMoney());
            System.out.println("Type: " + car.getType());
            System.out.println("Lifespan: " + car.getLifespan());
            System.out.println("-----------------------------------");
        }
    }

    public void printOwnerList(String type) {
        if (type.equalsIgnoreCase("username")) {
            for (Owner owner : ownerList) {
                System.out.println("[" + ownerList.indexOf(owner) + "]" + " " + owner.getUsername());
                validIndexes.add(ownerList.indexOf(owner));

            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Owner owner : ownerList) {
                System.out.println("[" + ownerList.indexOf(owner) + "]" + " " + owner.getFirstName() + ' ' + owner.getLastName());
                validIndexes.add(ownerList.indexOf(owner));

            }

        }
    }

    public void printCarList(boolean exception, Tenant user) {
        for (Car car : carList) {
            if (exception && user != null) {
                if (!rentedCarList.contains(car) && user.getAccountBalance() >= car.getRentMoney()) {
                    carRentalStatus = true;
                    System.out.println("[" + carList.indexOf(car) + "]" + " " + car.getNameModel());
                    validIndexes.add(carList.indexOf(car));
                }
            } else {
                System.out.println("[" + carList.indexOf(car) + "]" + " " + car.getNameModel());
                validIndexes.add(carList.indexOf(car));


            }
        }
    }

    public void showOwnerCars(Owner owner) {
        for (Car car : carList) {
            if (car.getOwner().equals(owner)) {
                System.out.println("[" + carList.indexOf(car) + "]" + " " + car.getNameModel());
                ownerCarList.add(car);
                isCarOwner = true;
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
                        validIndexes.add(tenantList.indexOf(tenant));

                    }
                } else {
                    System.out.println("[" + tenantList.indexOf(tenant) + "]" + " " + tenant.getUsername());
                    validIndexes.add(tenantList.indexOf(tenant));

                }
            }
        } else if (type.equalsIgnoreCase("name")) {
            for (Tenant tenant : tenantList) {
                if (exception) {
                    if (tenant.getRentedCar() == null) {
                        rentedCarStatus = true;
                        System.out.println("[" + tenantList.indexOf(tenant) + "]" + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
                        validIndexes.add(tenantList.indexOf(tenant));
                    }
                } else {
                    System.out.println("[" + tenantList.indexOf(tenant) + "]" + " " + tenant.getFirstName() + ' ' + tenant.getLastName());
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
                            System.out.println("Welcome, " + UserInterface.GREEN + owner.getFirstName() + ":)" + UserInterface.RESET);
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
        String art = """
                ╔═╗┌─┐┬─┐  ╦═╗┌─┐┌┐┌┌┬┐┌─┐┬    ╔═╗┌─┐┌─┐┌┐┌┌─┐┬ ┬
                ║  ├─┤├┬┘  ╠╦╝├┤ │││ │ ├─┤│    ╠═╣│ ┬├┤ ││││  └┬┘
                ╚═╝┴ ┴┴└─  ╩╚═└─┘┘└┘ ┴ ┴ ┴┴─┘  ╩ ╩└─┘└─┘┘└┘└─┘ ┴\s
                """;

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
        System.out.println("Welcome to the Agency Management System");
        System.out.println();
        System.out.println("Who are you:");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Agency Manager");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Owner");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Tenant");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Exit");
    }

    private static void displayAgencyManagerMenu() {
        System.out.println();
        System.out.println(UserInterface.PURPLE + "Please select an option :" + UserInterface.RESET);
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 1 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Add Owner");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 2 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Add Tenant");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 3 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Add Car");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 4 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Remove Owner");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 5 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Remove Tenant");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 6 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Remove Car");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 7 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Print Report");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 8 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Rent");
        System.out.println(UserInterface.PURPLE + "[" + UserInterface.WHITE + 0 + UserInterface.PURPLE + "] " + UserInterface.WHITE + "Exit");
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
                    agency.printReport();
                    break;
                case 8:
                    rent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid option! Please try again");
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
            System.out.println("Please select the desired tenant : ");
            agency.printTenantList("name", false);
            int option = getUserOption();
            while (!agency.getValidIndexes().contains(option)) {
                System.out.println("The input is invalid. Please try again");
                option = getUserOption();
            }
            agency.getValidIndexes().clear();
            Tenant tenant = agency.getTenantByIndex(option);
            agency.printTenant(tenant);
            System.out.println();
            System.out.println("Do you want to remove " + tenant.getFirstName() +
                    ' ' + tenant.getLastName() + " from the list of tenants?");
            System.out.println();
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.print("Enter : ");
            int status = scanner.nextInt();
            if (status == 1) {
                agency.removeTenant(tenant);
                removedTenantsCount += 1;
                System.out.println(tenant.getFirstName() + ' ' + tenant.getLastName() +
                        " has been removed from the list of tenants");

            } else if (status == 2) {
                System.out.println("The operation has been canceled :(");
            } else {
                System.out.println("Invalid input");
            }

        } else {
            System.out.println("No tenant has been registered :(");
        }

    }

    public static void removeFromOwnerList() {
        if (!agency.getOwnerList().isEmpty()) {
            System.out.println("Please select the desired owner : ");
            agency.printOwnerList("name");
            int option = getUserOption();
            while (!agency.getValidIndexes().contains(option)) {
                System.out.println("The input is invalid. Please try again");
                option = getUserOption();
            }
            agency.getValidIndexes().clear();
            Owner owner = agency.getOwnerByIndex(option);
            agency.printOwner(owner);
            System.out.println();
            System.out.println("Do you want to remove " + owner.getFirstName() +
                    ' ' + owner.getLastName() + " from the list of owners?");
            System.out.println();
            agency.showOwnerCars(owner);
            System.out.println();
            if (agency.getIsCarOwner()) {
                System.out.println("Please note that by removing " + owner.getFirstName() + ' ' +
                        owner.getLastName() + " from the list of owners of the above cars, they will be removed from the list");
            } else {
                System.out.println("This owner does not have any car with their name");
            }
            System.out.println();
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.print("Enter : ");
            int status = scanner.nextInt();
            if (status == 1) {
                agency.removeOwner(owner);
                agency.getCarList().removeAll(agency.getOwnerCarList());
                System.out.println(owner.getFirstName() + ' ' + owner.getLastName() +
                        " has been removed from the list of owners");
                if (agency.getIsCarOwner()) {
                    System.out.println("Furthermore, " + agency.getOwnerCarList().size() + " cars owned by the mentioned owner have also been removed from the list of cars");
                    removedCarsCount += agency.getOwnerCarList().size();
                    removedOwnersCount += 1;
                }
                System.out.println();
                agency.getOwnerCarList().clear();
            } else if (status == 2) {
                System.out.println("The operation has been canceled :(");
                agency.getOwnerCarList().clear();
            } else {
                System.out.println("Invalid input");
                agency.getOwnerCarList().clear();
            }

        } else {
            System.out.println("No tenant has been registered :(");
        }

    }

    public static void removeFromCarList() {
        if (!agency.getCarList().isEmpty()) {
            System.out.println("Please select the desired car : ");
            agency.printCarList(false, null);
            int option = getUserOption();
            while (!agency.getValidIndexes().contains(option)) {
                System.out.println("The input is invalid. Please try again");
                option = getUserOption();
            }
            agency.getValidIndexes().clear();
            Car car = agency.getCarByIndex(option);
            agency.printCar(car);
            System.out.println();
            System.out.println("Do you want to remove the " + car.getNameModel() +
                    " car from the list of cars?");
            System.out.println();
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.print("Enter : ");
            int status = scanner.nextInt();
            if (status == 1) {
                agency.removeCar(car);
                removedCarsCount += 1;
                System.out.println(car.getNameModel() + " has been removed from the list of cars");

            } else if (status == 2) {
                System.out.println("The operation has been canceled :(");
            } else {
                System.out.println("Invalid input");
            }

        } else {
            System.out.println("No tenant has been registered :(");
        }

    }

    private static void rent() {
        if (!agency.getTenantList().isEmpty()) {
            System.out.println("Please select the desired tenant : ");
            agency.printTenantList("name", true);
            if (agency.getRentedCarStatus()) {
                int option = getUserOption();

                while (!agency.getValidIndexes().contains(option)) {
                    System.out.println("The input is invalid. Please try again");
                    option = getUserOption();
                }

                agency.getValidIndexes().clear();
                agency.setRentedCarStatus(false);
                Tenant tenant = agency.getTenantByIndex(option);
                if (!agency.getCarList().isEmpty()) {
                    System.out.println("Please select the desired car : ");
                    System.out.println("Cars displayed based on " + tenant.getFirstName() + ' '
                            + tenant.getLastName() + "'s account inventory");
                    agency.printCarList(true, tenant);
                    if (agency.getCarRentalStatus()) {
                        option = getUserOption();
                        while (!agency.getValidIndexes().contains(option)) {
                            System.out.println("The input is invalid. Please try again");
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
                    transactionCount += 1;
                    totalTransactionValue += car.getRentMoney();
                    totalProfit += car.getRentMoney() / 10;
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

