package eu.grigoriev.antigate.client.responses;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:48
 */
public class GetBalanceResponse implements Response {
    private double balance;

    public GetBalanceResponse(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
