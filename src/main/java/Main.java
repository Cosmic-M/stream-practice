import data.generator.DataGenerator;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Customer;
import model.Order;
import model.Product;

public class Main {
    private static DataGenerator data;
    /*
    1. Obtain a list of products belongs to category "Books" with price > 100
    2. Obtain a list of orders with products belong to category "Baby" only
    3. Obtain a list of products with category = "Toys" and then apply 10% discount
    4. Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    5. Get the cheapest products of "Books" category
    6. Get the 3 most recent placed order
    7. Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
    8. Calculate total sum of all orders placed in Feb 2021
    9. Calculate order average payment placed on 15-Mar-2021
    10. Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category "Books"
    11. Obtain a data map with order id and order's product count
    12. Produce a data map with order records grouped by customer
    13. Produce a data map with order record and product total sum
    14. Obtain a data map with list of product name by category
    15. Get the most expensive product by category
     */
    public static void main(String[] args) {
        data = new DataGenerator();

        System.out.println("1 -> list of products belongs to category Books:");
        getProducts("Books", 100).forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("2 -> list of orders with products belong to category Baby");
        getOrders("Baby").forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("3 -> list of products with category = Toys and applied 10% discount");
        getProducts(0.9, "Toys").forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("4 -> list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021");
        getProducts(2L, LocalDate.of(2021, Month.FEBRUARY, 1),
                LocalDate.of(2021, Month.APRIL, 1)).forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("5 -> the cheapest products of Books category");
        System.out.println("Cheapest product: " + getCheapestProduct("Books"));
        System.out.println("==============================================");
        System.out.println("6 -> the 3 most recent placed order");
        System.out.println("Recent orders: ");
        getRecentOrders(3).forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("7 -> list of orders which were ordered on 15-Mar-2021");
        System.out.println("ALL ORDERS ON on 15-Mar-2021:");
        List<Order> products = getAllOrders(LocalDate.of(2021, Month.MARCH, 15));
        System.out.println("Quantity of orders:" + products.size());
        System.out.println("==============================================");
        System.out.println("8 -> total sum of all orders placed in Feb 2021");
        System.out.println("Sum of all orders in February: " + getTotalSum(
                LocalDate.of(2021, Month.FEBRUARY, 1),
                LocalDate.of(2021, Month.FEBRUARY, 28)));
        System.out.println("==============================================");
        System.out.println("9 -> order average payment placed on 15-Mar-2021");
        OptionalDouble averageOrderPayment = gertOrderAveragePayment(LocalDate.of(2021, Month.MARCH, 15));
        if (averageOrderPayment.isPresent()) {
            System.out.println("9 -> averageOrderPayment = " + averageOrderPayment.getAsDouble());
        } else {
            System.out.println("9 -> there is no one order on such data");
        }
        System.out.println("==============================================");
        System.out.println("10 -> collection of statistic figures (i.e. sum, average, max, min, count) for all products of category Books");
        String category = "Books";
        getStatistic(category).forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("11 -> DataMap:");
        HashMap<Long, Integer> dataMap = getDataMap();
        dataMap.entrySet().stream()
                .map(i -> "order Id=" + i.getKey() + " consist of " + i.getValue() + (i.getValue() == 1 ? " product" : " products"))
                .forEach(System.out::println);
        System.out.println("12 -> DataMap:");
        HashMap<Customer, List<Order>> clientOrders = new HashMap<>();
        clientOrders = (HashMap<Customer, List<Order>>) getCustomOrders();
        clientOrders.entrySet().stream()
                .map(i -> "client=" + i.getKey() + ", orders=" + i.getValue().toString())
                .forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("13 -> DataMap:");
        HashMap<Order, Double> totalSumOrders = (HashMap<Order, Double>) getTotalSumOrders();
        totalSumOrders.entrySet().stream()
                .map(i -> "order Id=" + i.getKey().getId() + ", total sum of order=" + i.getValue())
                .forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("14 -> DataMap (category = {names}):");
        HashMap<String, List<String>> categoryProductsMap = (HashMap<String, List<String>>) getCategoryProductsMap();
        categoryProductsMap.entrySet().stream().map(i -> "category=" + i.getKey() + ", names=" + i.getValue())
                .forEach(System.out::println);
        System.out.println("==============================================");
        System.out.println("15 -> The most expensive product by category:");
        category = "Books";
        Product product = getMostExpensiveProduct(category);
        System.out.println("Most expensive product from " + category + " - " + product.toString());

    }

    //1. Obtain a list of products belongs to category "Books" with price > 100
    private static List<Product> getProducts(String category, int price) {
        return data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .filter(i -> i.getPrice() > price)
                .toList();
    }

    //2. Obtain a list of orders with products belong to category "Baby" only
    private static List<Order> getOrders(String category) {
        return data.getOrders().stream()
                .filter(i -> ifBelongCategory(i, category))
                .toList();
    }

    private static boolean ifBelongCategory(Order order, String category) {
        return order.getProducts().stream()
                .map(Product::getCategory)
                .allMatch(i -> i.equals(category));
    }

     //3. Obtain a list of products with category = "Toys" and then apply 10% discount
    private static List<Product> getProducts(double discount, String category) {
        return data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .peek(i -> i.setPrice(i.getPrice() * discount))
                .toList();
    }

    //4. Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    private static List<Product> getProducts(Long customerId, LocalDate from, LocalDate to) {
        return data.getOrders().stream()
                .filter(i -> Objects.equals(i.getCustomer().getId(), customerId))
                .filter(i -> i.getOrderDate().isBefore(to) && i.getOrderDate().isAfter(from))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .toList();
    }

    //5. Get the cheapest products of "Books" category
    private static Product getCheapestProduct(String category) {
        Comparator<Product> costComparator = Comparator.comparing(Product::getPrice);
        return data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .min(costComparator)
                .get();
    }

    //6. Get the 3 most recent placed order
    private static List<Order> getRecentOrders(int quantity) {
        Comparator<Order> dateComparator = Comparator.comparing(Order::getOrderDate).reversed();
        return data.getOrders().stream()
                .sorted(dateComparator)
                .limit(3)
                .toList();
    }

    //7. Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
    private static List<Order> getAllOrders(LocalDate date) {
        return data.getOrders().stream()
                .filter(i -> i.getOrderDate().isEqual(date))
                .peek(System.out::println)
                .toList();
    }

    //8. Calculate total sum of all orders placed in Feb 2021
    private static double getTotalSum(LocalDate from, LocalDate to) {
        return data.getOrders().stream()
                .filter(i -> i.getOrderDate().isAfter(from) && i.getOrderDate().isBefore(to))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .sum();
    }

    //9. Calculate order average payment placed on 15-Mar-2021
    private static OptionalDouble gertOrderAveragePayment(LocalDate date) {
        return data.getOrders().stream()
                .filter(i -> i.getOrderDate().isEqual(date))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .average();
    }

     //10. Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category "Books"
    private static List<? extends Number> getStatistic(String category) {
        double sumPrice =  data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .sum();
        double averagePrice = data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .average()
                .getAsDouble();
        double maxPrice = data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .max()
                .getAsDouble();
        double minPrice = data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .min()
                .getAsDouble();
        long count = data.getProducts().stream()
                .filter(i -> i.getCategory().equals(category))
                .map(Product::getPrice)
                .mapToDouble(i -> i)
                .count();
        return Stream.of(sumPrice, averagePrice, maxPrice, minPrice, count).toList();
    }

        //11. Obtain a data map with order id and order's product count
    private static HashMap<Long, Integer> getDataMap() {
        HashMap<Long, Integer> result = new HashMap<>();
        data.getOrders().forEach(entry -> result.put(entry.getId(), entry.getProducts().size()));
        return result;
    }

    //12. Produce a data map with order records grouped by customer
    private static Map<Customer, List<Order>> getCustomOrders() {
        return data.getOrders().stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.toList()));
    }

    //13. Produce a data map with order record and product total sum
    private static Map<Order, Double> getTotalSumOrders() {
        Map<Order, Double> totalSumOrders = new HashMap<>();
        data.getOrders()
                .forEach(entry -> totalSumOrders.put(entry, entry.getProducts().stream()
                        .map(Product::getPrice)
                        .mapToDouble(i -> i)
                        .sum()));
        return totalSumOrders;
    }

    //14. Obtain a data map with list of product name by category
    private static Map<String, List<String>> getCategoryProductsMap() {
        return data.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));
    }

    //15. Get the most expensive product by category
    private static Product getMostExpensiveProduct(String category) {
        Comparator<Product> priceProductComparator = Comparator.comparing(Product::getPrice).reversed();
        return data.getProducts().stream()
                .sorted(priceProductComparator)
                .findFirst()
                .get();
    }
}
