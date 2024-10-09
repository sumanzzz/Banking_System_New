public class Account {
    private String name;
    private String number;
    private double deposit;

    public Account(String name, String number, double deposit) {
        this.name = name;
        this.number = number;
        this.deposit = deposit;
    }
    public String getName(){return name;}
    public String getNumber(){return number;}
    public double getDeposit(){return deposit;}
}
