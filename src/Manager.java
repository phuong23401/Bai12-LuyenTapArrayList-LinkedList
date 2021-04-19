import java.util.*;

public class Manager {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> productList = new ArrayList<>();
    static {
        Product p1 = new Product(1, "a", 10);
        Product p2 = new Product(2, "b", 15);
        Product p3 = new Product(3, "c", 12);
        Product p4 = new Product(4, "d", 20);
        Product p5 = new Product(5, "e", 50);
        Product p6 = new Product(6, "f", 30);
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
    }

    public static void show() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public static void add() {
        int id = inputId();
        String name = inputName();
        int price = inputPrice();

        Product product = new Product(id, name, price);
        productList.add(product);
    }

    public static void edit(int id) {
        boolean isExisted = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                isExisted = true;
                productList.get(i).setName(inputName());
                productList.get(i).setPrice(inputPrice());
            }
        }
        if (!isExisted) {
            System.out.println("Không tìm thấy sản phẩm với id trên!");
        }
    }

    public static void delete(int id) {
        if (productList != null) {
            productList.remove(getProductById(id));
        } else {
            System.out.println("Không tìm thấy sản phẩm với id trên!");
        }
    }

    public static Product getProductById(int id) {
        Product product = null;
        for (Product product1 : productList) {
            if (product1.getId() == id) {
                product = product1;
                break;
            }
        }
        return product;
    }

    public static void searchByName(String name) {
        if (productList != null) {
            System.out.println(getProductByName(name));
        } else {
            System.out.println("Không tìm thấy sản phẩm với id trên!");
        }
    }

    public static Product getProductByName(String name) {
        Product product = null;
        for (Product product1 : productList) {
            if (product1.getName().equals(name)) {
                product = product1;
                break;
            }
        }
        return product;
    }

    public static void sortByPriceUp() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                }
                return -1;
            }
        });
        show();
    }

    public static void sortByPriceDown() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                }
                return -1;
            }
        });
        show();
    }

    public static int inputId() {
        System.out.print("Nhập id sản phẩm: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputName() {
        System.out.print("Nhập tên sản phẩm: ");
        return scanner.nextLine();
    }

    public static int inputPrice() {
        System.out.print("Nhập giá sản phẩm: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
