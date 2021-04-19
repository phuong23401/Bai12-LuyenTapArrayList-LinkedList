import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;

        while (true) {
            System.out.println("-----Menu-----");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Sắp xếp theo giá tăng dần");
            System.out.println("7. Sắp xếp theo giá giảm dần");
            System.out.println("0. Thoát");
            System.out.println("Mời nhập chức năng: ");

            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    Manager.show();
                    break;
                case 2:
                    Manager.add();
                    System.out.println("Đã thêm sản phẩm!");
                    break;
                case 3:
                    id = Manager.inputId();
                    Manager.edit(id);
                    System.out.println("Đã sửa sản phẩm!");
                    break;
                case 4:
                    id = Manager.inputId();
                    Manager.delete(id);
                    System.out.println("Đã xóa sẩn phẩm!");
                    break;
                case 5:
                    name = Manager.inputName();
                    Manager.searchByName(name);
                    break;
                case 6:
                    Manager.sortByPriceUp();
                    break;
                case 7:
                    Manager.sortByPriceDown();
                    break;
                case 0:
                    System.out.println("Đã thoát!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời chọn chức năng trong menu!");
                    break;
            }
        }
    }
}
