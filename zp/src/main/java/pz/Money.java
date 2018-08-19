package pz;

public class Money {
public int money=100;

public String getText() {
	return new String("Sun: "+money);
	
}
public int getMoney() {
	return money;
}
public void addMoney(int x) {
	money += x;
}
}
