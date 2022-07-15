package data.generator;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Order;
import model.Product;

public class DataGenerator {
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    {
        customers = createCustomers();
        products = createProducts();
        orders = createOrders(customers);
        addProductsToOrders(products, orders);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    private List<Customer> createCustomers() {
        List<Customer> customers = new ArrayList<>();
        addCustomerToList(customers, 1L, "Stefan Walker", 1);
        addCustomerToList(customers,2L, "Daija Von", 1);
        addCustomerToList(customers,3L, "Ariane Rodriguez", 1);
        addCustomerToList(customers,4L, "Marques Nikolaus", 2);
        addCustomerToList(customers,5L, "Rachelle Greenfelder", 0);
        addCustomerToList(customers,6L, "Larissa White", 2);
        addCustomerToList(customers,7L, "Fae Heidenreich", 1);
        addCustomerToList(customers,8L, "Dino Will", 2);
        addCustomerToList(customers,9L, "Eloy Stroman", 1);
        addCustomerToList(customers,10L, "Brisa O'Connell", 1);
        return customers;
    }

    private void addCustomerToList(List<Customer> customers, Long id, String name, Integer tier) {
        customers.add(new Customer(id, name, tier));
    }

    private List<Product> createProducts() {
        List<Product> products = new ArrayList<>();
        addProductToList(products, 1L, "omnis quod consequatur", "Games", 184.83);
        addProductToList(products, 2L, "vel libero suscipit", "Toys", 12.66);
        addProductToList(products, 3L, "non nemo iure", "Grocery", 498.02);
        addProductToList(products, 4L, "voluptatem voluptas aspernatur", "Toys", 536.80);
        addProductToList(products, 5L, "animi cum rem", "Games", 458.20);
        addProductToList(products, 6L, "dolorem porro debitis", "Toys", 146.52);
        addProductToList(products, 7L, "aspernatur rerum qui", "Books", 656.42);
        addProductToList(products, 8L, "deleniti earum et", "Baby", 41.46);
        addProductToList(products, 9L, "voluptas ut quidem", "Books", 697.57);
        addProductToList(products, 10L, "eos sed debitis", "Baby", 366.90);
        addProductToList(products, 11L, "laudantium sit nihil", "Toys", 95.50);
        addProductToList(products, 12L, "ut perferendis corporis", "Grocery", 302.19);
        addProductToList(products, 13L, "sint voluptatem ut", "Toys", 295.37);
        addProductToList(products, 14L, "quos sunt ipsam", "Grocery", 534.64);
        addProductToList(products, 15L, "qui illo error", "Baby", 623.58);
        addProductToList(products, 16L, "aut ex ducimus", "Books", 551.39);
        addProductToList(products, 17L, "accusamus repellendus minus", "Books", 240.58);
        addProductToList(products, 18L, "aut accusamus quia", "Baby", 881.38);
        addProductToList(products, 19L, "doloremque incidunt sed", "Games", 988.49);
        addProductToList(products, 20L, "libero omnis velit", "Baby", 177.61);
        addProductToList(products, 21L, "consectetur cupiditate sunt", "Toys", 95.46);
        addProductToList(products, 22L, "itaque ea qui", "Baby", 677.78);
        addProductToList(products, 23L, "non et nulla", "Grocery", 70.49);
        addProductToList(products, 24L, "veniam consequatur et", "Books", 893.44);
        addProductToList(products, 25L, "magnam adipisci voluptate", "Grocery", 366.13);
        addProductToList(products, 26L, "reiciendis consequuntur placeat", "Toys", 359.27);
        addProductToList(products, 27L, "dolores ipsum sit", "Toys", 786.99);
        addProductToList(products, 28L, "ut hic tempore", "Toys", 316.09);
        addProductToList(products, 29L, "quas quis deserunt", "Toys", 772.78);
        addProductToList(products, 30L, "excepturi nesciunt accusantium", "Toys", 911.46);
        return products;
    }

    private void addProductToList(List<Product> products, Long id, String name, String category, Double price) {
        products.add(new Product(id, name, category, price));
    }

    private List<Order> createOrders(List<Customer> customers) {
        List<Order> orders = new ArrayList<>();
        addOrderToList(customers, orders, 1, "2021-02-28", "2021-03-08", "NEW", 5);
        addOrderToList(customers, orders, 2, "2021-02-28", "2021-03-05", "NEW", 3);
        addOrderToList(customers, orders, 3, "2021-04-10", "2021-04-18", "DELIVERED", 5);
        addOrderToList(customers, orders, 4, "2021-03-22", "2021-03-27", "PENDING", 3);
        addOrderToList(customers, orders, 5, "2021-03-04", "2021-03-12", "NEW", 1);
        addOrderToList(customers, orders, 6, "2021-03-30", "2021-04-07", "DELIVERED", 9);
        addOrderToList(customers, orders, 7, "2021-03-05", "2021-03-09", "PENDING", 8);
        addOrderToList(customers, orders, 8, "2021-03-27", "2021-04-05", "NEW", 4);
        addOrderToList(customers, orders, 9, "2021-04-14", "2021-04-18", "NEW", 10);
        addOrderToList(customers, orders, 10, "2021-03-10", "2021-03-19", "NEW", 8);
        addOrderToList(customers, orders, 11, "2021-04-01", "2021-04-04", "DELIVERED", 1);
        addOrderToList(customers, orders, 12, "2021-02-24", "2021-02-28", "PENDING", 5);
        addOrderToList(customers, orders, 13, "2021-03-15", "2021-03-21", "NEW", 5);
        addOrderToList(customers, orders, 14, "2021-03-30", "2021-04-07", "PENDING", 4);
        addOrderToList(customers, orders, 15, "2021-03-13", "2021-03-14", "DELIVERED", 5);
        addOrderToList(customers, orders, 16, "2021-03-13", "2021-03-21", "NEW", 1);
        addOrderToList(customers, orders, 17, "2021-03-31", "2021-03-31", "DELIVERED", 6);
        addOrderToList(customers, orders, 18, "2021-03-25", "2021-03-31", "PENDING", 9);
        addOrderToList(customers, orders, 19, "2021-02-28", "2021-03-09", "DELIVERED", 9);
        addOrderToList(customers, orders, 20, "2021-03-23", "2021-03-30", "NEW", 5);
        addOrderToList(customers, orders, 21, "2021-03-19", "2021-03-24", "DELIVERED", 9);
        addOrderToList(customers, orders, 22, "2021-02-27", "2021-03-01", "NEW", 5);
        addOrderToList(customers, orders, 23, "2021-04-19", "2021-04-24", "PENDING", 4);
        addOrderToList(customers, orders, 24, "2021-03-24", "2021-03-24", "DELIVERED", 1);
        addOrderToList(customers, orders, 25, "2021-03-03", "2021-03-10", "NEW", 1);
        addOrderToList(customers, orders, 26, "2021-03-17", "2021-03-26", "NEW", 10);
        addOrderToList(customers, orders, 27, "2021-03-20", "2021-03-25", "NEW", 1);
        addOrderToList(customers, orders, 28, "2021-04-09", "2021-04-16", "DELIVERED", 2);
        addOrderToList(customers, orders, 29, "2021-04-06", "2021-04-08", "PENDING", 1);
        addOrderToList(customers, orders, 30, "2021-04-19", "2021-04-20", "DELIVERED", 1);
        addOrderToList(customers, orders, 31, "2021-03-03", "2021-03-04", "NEW", 3);
        addOrderToList(customers, orders, 32, "2021-03-15", "2021-03-24", "DELIVERED", 2);
        addOrderToList(customers, orders, 33, "2021-04-18", "2021-04-24", "PENDING", 1);
        addOrderToList(customers, orders, 34, "2021-03-28", "2021-03-28", "NEW", 6);
        addOrderToList(customers, orders, 35, "2021-03-15", "2021-03-17", "NEW", 1);
        addOrderToList(customers, orders, 36, "2021-03-04", "2021-03-08", "DELIVERED", 2);
        addOrderToList(customers, orders, 37, "2021-03-18", "2021-03-25", "NEW", 8);
        addOrderToList(customers, orders, 38, "2021-04-11", "2021-04-20", "NEW", 8);
        addOrderToList(customers, orders, 39, "2021-04-12", "2021-04-17", "NEW", 9);
        addOrderToList(customers, orders, 40, "2021-03-12", "2021-03-12", "PENDING", 3);
        addOrderToList(customers, orders, 41, "2021-02-24", "2021-02-26", "NEW", 5);
        addOrderToList(customers, orders, 42, "2021-04-08", "2021-04-14", "DELIVERED", 9);
        addOrderToList(customers, orders, 43, "2021-03-03", "2021-03-11", "NEW", 3);
        addOrderToList(customers, orders, 44, "2021-03-12", "2021-03-14", "DELIVERED", 4);
        addOrderToList(customers, orders, 45, "2021-04-01", "2021-04-06", "DELIVERED", 1);
        addOrderToList(customers, orders, 46, "2021-03-16", "2021-03-22", "NEW", 10);
        addOrderToList(customers, orders, 47, "2021-04-07", "2021-04-12", "PENDING", 2);
        addOrderToList(customers, orders, 48, "2021-04-05", "2021-04-06", "NEW", 2);
        addOrderToList(customers, orders, 49, "2021-04-10", "2021-04-13", "NEW", 7);
        addOrderToList(customers, orders, 50, "2021-03-18", "2021-03-21", "NEW", 9);
        return orders;
    }

    private void addOrderToList(List<Customer> customers, List<Order> orders,
                                int id, String orderDate, String deliveryDate,
                                String status, int customerId) {
        orders.add(new Order((long) id, orderDate, deliveryDate, status, customers.get(customerId - 1)));
    }

    private void addProductsToOrders(List<Product> products, List<Order> orders) {
        addProductToOrder(products, orders,  1, 19);
        addProductToOrder(products, orders,  1, 21);
        addProductToOrder(products, orders,  1, 5);
        addProductToOrder(products, orders,  2, 17);
        addProductToOrder(products, orders,  2, 11);
        addProductToOrder(products, orders,  2, 14);
        addProductToOrder(products, orders,  2, 13);
        addProductToOrder(products, orders,  3, 5);
        addProductToOrder(products, orders,  3, 3);
        addProductToOrder(products, orders,  3, 19);
        addProductToOrder(products, orders,  3, 13);
        addProductToOrder(products, orders,  3, 15);
        addProductToOrder(products, orders,  4, 22);
        addProductToOrder(products, orders,  4, 26);
        addProductToOrder(products, orders,  4, 12);
        addProductToOrder(products, orders,  5, 5);
        addProductToOrder(products, orders,  6, 5);
        addProductToOrder(products, orders,  6, 12);
        addProductToOrder(products, orders,  7, 8);
        addProductToOrder(products, orders,  7, 25);
        addProductToOrder(products, orders,  7, 21);
        addProductToOrder(products, orders,  7, 1);
        addProductToOrder(products, orders,  7, 13);
        addProductToOrder(products, orders,  7, 10);
        addProductToOrder(products, orders,  8, 12);
        addProductToOrder(products, orders,  8, 8);
        addProductToOrder(products, orders,  9, 8);
        addProductToOrder(products, orders,  10, 14);
        addProductToOrder(products, orders,  10, 8);
        addProductToOrder(products, orders,  11, 12);
        addProductToOrder(products, orders,  11, 6);
        addProductToOrder(products, orders,  11, 21);
        addProductToOrder(products, orders,  11, 22);
        addProductToOrder(products, orders,  11, 27);
        addProductToOrder(products, orders,  11, 11);
        addProductToOrder(products, orders,  12, 19);
        addProductToOrder(products, orders,  12, 13);
        addProductToOrder(products, orders,  12, 11);
        addProductToOrder(products, orders,  12, 6);
        addProductToOrder(products, orders,  13, 11);
        addProductToOrder(products, orders,  13, 24);
        addProductToOrder(products, orders,  13, 26);
        addProductToOrder(products, orders,  13, 23);
        addProductToOrder(products, orders,  14, 18);
        addProductToOrder(products, orders,  15, 16);
        addProductToOrder(products, orders,  15, 13);
        addProductToOrder(products, orders,  15, 7);
        addProductToOrder(products, orders,  16, 23);
        addProductToOrder(products, orders,  16, 29);
        addProductToOrder(products, orders,  16, 18);
        addProductToOrder(products, orders,  16, 16);
        addProductToOrder(products, orders,  16, 22);
        addProductToOrder(products, orders,  16, 26);
        addProductToOrder(products, orders,  17, 18);
        addProductToOrder(products, orders,  17, 4);
        addProductToOrder(products, orders,  18, 13);
        addProductToOrder(products, orders,  18, 3);
        addProductToOrder(products, orders,  18, 27);
        addProductToOrder(products, orders,  18, 2);
        addProductToOrder(products, orders,  19, 26);
        addProductToOrder(products, orders,  19, 22);
        addProductToOrder(products, orders,  19, 18);
        addProductToOrder(products, orders,  19, 14);
        addProductToOrder(products, orders,  19, 15);
        addProductToOrder(products, orders,  19, 13);
        addProductToOrder(products, orders,  20, 22);
        addProductToOrder(products, orders,  21, 21);
        addProductToOrder(products, orders,  21, 26);
        addProductToOrder(products, orders,  22, 7);
        addProductToOrder(products, orders,  22, 6);
        addProductToOrder(products, orders,  23, 27);
        addProductToOrder(products, orders,  23, 7);
        addProductToOrder(products, orders,  23, 11);
        addProductToOrder(products, orders,  23, 5);
        addProductToOrder(products, orders,  24, 24);
        addProductToOrder(products, orders,  24, 2);
        addProductToOrder(products, orders,  24, 6);
        addProductToOrder(products, orders,  24, 28);
        addProductToOrder(products, orders,  24, 4);
        addProductToOrder(products, orders,  25, 28);
        addProductToOrder(products, orders,  25, 17);
        addProductToOrder(products, orders,  25, 2);
        addProductToOrder(products, orders,  25, 29);
        addProductToOrder(products, orders,  25, 19);
        addProductToOrder(products, orders,  26, 4);
        addProductToOrder(products, orders,  27, 6);
        addProductToOrder(products, orders,  27, 15);
        addProductToOrder(products, orders,  27, 24);
        addProductToOrder(products, orders,  28, 22);
        addProductToOrder(products, orders,  28, 9);
        addProductToOrder(products, orders,  29, 22);
        addProductToOrder(products, orders,  29, 10);
        addProductToOrder(products, orders,  30, 29);
        addProductToOrder(products, orders,  30, 6);
        addProductToOrder(products, orders,  30, 8);
        addProductToOrder(products, orders,  31, 16);
        addProductToOrder(products, orders,  31, 12);
        addProductToOrder(products, orders,  31, 28);
        addProductToOrder(products, orders,  32, 8);
        addProductToOrder(products, orders,  32, 5);
        addProductToOrder(products, orders,  33, 12);
        addProductToOrder(products, orders,  33, 26);
        addProductToOrder(products, orders,  33, 21);
        addProductToOrder(products, orders,  33, 23);
        addProductToOrder(products, orders,  33, 29);
        addProductToOrder(products, orders,  33, 13);
        addProductToOrder(products, orders,  34, 1);
        addProductToOrder(products, orders,  34, 6);
        addProductToOrder(products, orders,  34, 22);
        addProductToOrder(products, orders,  34, 19);
        addProductToOrder(products, orders,  34, 13);
        addProductToOrder(products, orders,  34, 27);
        addProductToOrder(products, orders,  35, 5);
        addProductToOrder(products, orders,  35, 11);
        addProductToOrder(products, orders,  35, 26);
        addProductToOrder(products, orders,  35, 9);
        addProductToOrder(products, orders,  36, 28);
        addProductToOrder(products, orders,  36, 7);
        addProductToOrder(products, orders,  37, 15);
        addProductToOrder(products, orders,  37, 11);
        addProductToOrder(products, orders,  38, 18);
        addProductToOrder(products, orders,  38, 11);
        addProductToOrder(products, orders,  38, 14);
        addProductToOrder(products, orders,  38, 20);
        addProductToOrder(products, orders,  38, 7);
        addProductToOrder(products, orders,  39, 1);
        addProductToOrder(products, orders,  39, 21);
        addProductToOrder(products, orders,  40, 12);
        addProductToOrder(products, orders,  40, 10);
        addProductToOrder(products, orders,  40, 11);
        addProductToOrder(products, orders,  40, 29);
        addProductToOrder(products, orders,  40, 1);
        addProductToOrder(products, orders,  41, 13);
        addProductToOrder(products, orders,  41, 19);
        addProductToOrder(products, orders,  41, 5);
        addProductToOrder(products, orders,  41, 29);
        addProductToOrder(products, orders,  41, 14);
        addProductToOrder(products, orders,  41, 4);
        addProductToOrder(products, orders,  42, 2);
        addProductToOrder(products, orders,  43, 6);
        addProductToOrder(products, orders,  44, 20);
        addProductToOrder(products, orders,  44, 18);
        addProductToOrder(products, orders,  44, 8);
        addProductToOrder(products, orders,  44, 24);
        addProductToOrder(products, orders,  44, 26);
        addProductToOrder(products, orders,  44, 13);
        addProductToOrder(products, orders,  45, 23);
        addProductToOrder(products, orders,  45, 1);
        addProductToOrder(products, orders,  45, 25);
        addProductToOrder(products, orders,  45, 15);
        addProductToOrder(products, orders,  46, 16);
        addProductToOrder(products, orders,  46, 24);
        addProductToOrder(products, orders,  46, 19);
        addProductToOrder(products, orders,  46, 13);
        addProductToOrder(products, orders,  46, 11);
        addProductToOrder(products, orders,  47, 23);
        addProductToOrder(products, orders,  47, 28);
        addProductToOrder(products, orders,  47, 20);
        addProductToOrder(products, orders,  47, 21);
        addProductToOrder(products, orders,  48, 15);
        addProductToOrder(products, orders,  48, 3);
        addProductToOrder(products, orders,  48, 26);
        addProductToOrder(products, orders,  48, 7);
        addProductToOrder(products, orders,  48, 19);
        addProductToOrder(products, orders,  48, 10);
        addProductToOrder(products, orders,  49, 5);
        addProductToOrder(products, orders,  49, 13);
        addProductToOrder(products, orders,  49, 29);
        addProductToOrder(products, orders,  49, 3);
        addProductToOrder(products, orders,  49, 12);
        addProductToOrder(products, orders,  49, 17);
        addProductToOrder(products, orders,  50, 15);
        addProductToOrder(products, orders,  50, 16);
    }

    private void addProductToOrder(List<Product> products, List<Order> orders, int orderId, int productId) {
        orders.get(orderId - 1).getProducts().add(products.get(productId - 1));
    }
}
