package Utilities;

import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String> {

    public Menu() {
        super();
    }

    void addMenuItem(String s) {
        this.add((this.size()) + ". " + s);
    }

    int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println();
        do {
            for (int i = 0; i < this.size(); i++) {
                System.out.println(i + 1 + ". " + this.get(i));
            }
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice <= 0 || choice >= this.size());
        } while (choice <= 0 || choice > this.size());

        return choice;
    }
}