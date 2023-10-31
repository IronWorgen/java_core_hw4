package org.example;

import exceptions.*;
import org.example.data.Product;
import org.example.data.User;
import org.example.store.Store;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("task1\n");//  task1
        boolean flag = true;
        while (flag) {
            flag = false;
            Scanner scanner = new Scanner(System.in);
            String login = scanner.nextLine().trim();
            String password = scanner.nextLine().trim();
            String confirmPassword = scanner.nextLine().trim();
            try {
                UserAuthentication.userCheck(login, password, confirmPassword);
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
                flag = true;
            } catch (WrongLoginException e) {
                e.printStackTrace();
                flag = true;
            }

        }

        System.out.println("\ntask2\n");// task 2

        Store store = new Store();
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("book", 10));
        productList.add(new Product("car", 100));

        List<User> users = new ArrayList<>();
        users.add(new User("ivan"));
        users.add(new User("stas"));
        store.setProducts(productList);
        store.setUsers(users);

        boolean flagTask2 = true;
        while (flagTask2) {
            flagTask2 = false;
            Scanner scanner = new Scanner(System.in);
            String user = scanner.nextLine().trim();
            String product = scanner.nextLine().trim();
            try {
                int quantity = scanner.nextInt();
                store.createOrder(user, product, quantity);
            } catch (ProductNotFoundException | WrongQuantityException e) {
                System.out.println(e.getMessage());
                flagTask2 = true;
            } catch (UsrNotFoundException e) {
                e.printStackTrace();
                flagTask2 = true;
            } catch (InputMismatchException e) {
                System.out.println("введите число");
                flagTask2 = true;
            }

        }


    }


}