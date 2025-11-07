package oopmodelingExam;

public interface Payment {
    boolean process(double amount);
    String getReceipt();
}
