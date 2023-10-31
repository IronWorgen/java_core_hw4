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
            System.out.print("логин: ");
            String login = scanner.nextLine().trim();
            System.out.print("пароль: ");
            String password = scanner.nextLine().trim();
            System.out.print("подтверждение пароля: ");
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

            Scanner scanner = new Scanner(System.in);
            System.out.print("Имя пользователя: ");
            String user = scanner.nextLine().trim();
            System.out.print("Название продукта: ");
            String product = scanner.nextLine().trim();
            try {
                System.out.print("Количество продукта: ");
                int quantity = scanner.nextInt();
                store.createOrder(user, product, quantity);
            } catch (ProductNotFoundException | WrongQuantityException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (UsrNotFoundException e) {
                e.printStackTrace();
                continue;
            } catch (InputMismatchException e) {
                System.out.println("введите число");
                continue;
            }

            boolean continueInputFlag = true;
            while (continueInputFlag) {
                continueInputFlag = false;
                System.out.println("Продолжить?(y/n)");

                String continueInput = new Scanner(System.in).nextLine();
                switch (continueInput){
                    case "y":
                        break;
                    case "n":
                        flagTask2 = false;
                        break;
                    default:
                        System.out.println("y-продолжить / n - завершить работу");
                        continueInputFlag = true;
                        break;
                }
            }
            System.out.println();
        }
        System.out.println("Совершено: "+store.getOrders().size()+" покупок");


    }


}