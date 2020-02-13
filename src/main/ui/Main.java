package ui;

import model.GroceryItem;
import model.Inventory;
import model.InventoryItem;
import model.Recipes;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Recipes recipes = new Recipes();
        Inventory inventory = new Inventory();
        Scanner gamount = new Scanner(System.in);
        System.out.println("How many grocery items would you like to enter?");
        int gamountVal = gamount.nextInt();
        for (int i = 0; i < gamountVal; i++) {

            Scanner gname = new Scanner(System.in);
            Scanner gval = new Scanner(System.in);
            Scanner gtrue = new Scanner(System.in);
            Scanner gprice = new Scanner(System.in);
            System.out.println("Please enter the grocery that you purchased");
            String gi = gname.nextLine();
            System.out.println("How much did it cost");
            double gcost = gprice.nextDouble();
            System.out.println("Please enter quantity purchased");
            int gi1 = gval.nextInt();
            System.out.println("The item is perishable, true or false?");
            boolean gi2 = gtrue.nextBoolean();

            GroceryItem groceryItem = new GroceryItem(gi, gcost);
            inventory.addItemToInventory(groceryItem, gi1, gi2);


        }
        finalInput(recipes, inventory);
    }

    private static void finalInput(Recipes recipes, Inventory inventory) {
        System.out.println(inventory.viewInventory());
        System.out.println(inventory.sumToString());
        System.out.println("Total amount of perishable items are: " + inventory.perishableCount());
    }
}
