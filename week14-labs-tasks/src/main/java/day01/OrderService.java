package day01;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .count();

    }

    public List<Order> getOrdersBetweenDates(LocalDate start, LocalDate end) {
        return orders.stream()
                .filter(order -> order.getOrderDate().isBefore(end))
                .filter((order -> order.getOrderDate().isAfter(start)))
                .collect(Collectors.toList());
    }

    public boolean isOrderWithLessProductThan(int number) {
        return orders.stream()
                .anyMatch(order -> order.getProducts().size() < number);
    }

    public Order getOrderWithMaxNumberOfProducts() {
        return orders.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(order -> order.getProducts().size())))
                .findFirst()
                .orElseThrow();

    }

    public List<Order> getOrdersWithProductInCategory(String category) {
        return orders.stream()
                .filter(order -> order.getProducts()
                        .stream().anyMatch(product -> product.getCategory().equals(category)))
                        .collect(Collectors.toList());
    }


}
