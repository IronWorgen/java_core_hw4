package org.example.store;

import exceptions.ProductNotFoundException;
import exceptions.UsrNotFoundException;
import exceptions.WrongQuantityException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.data.Order;
import org.example.data.Product;
import org.example.data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Store {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();


    public void createOrder(String user, String product, int quantity) {
        List<Product> productSearch = products.stream().filter(x -> x.getName().equals(product)).collect(Collectors.toList());
        if (productSearch.size() == 0) {
            throw new ProductNotFoundException("Нет товара с таким названием");
        }
        Product productToBuy = productSearch.get(0);
        List<User> userSearch = users.stream().filter(x -> x.getName().equals(user)).collect(Collectors.toList());
        if (userSearch.size() == 0) {
            throw new UsrNotFoundException("Нет пользователя с таким именем");
        }
        User userThatBuy = userSearch.get(0);
        if (quantity <= 0) {
            throw new WrongQuantityException("количество <=0");
        }
        orders.add(new Order(userThatBuy, productToBuy));
    }


}
