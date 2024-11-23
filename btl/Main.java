import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo dữ liệu bàn và thực đơn
        Booking.initializeTables();
        Booking.initializeMenu();

        while (true) {
            System.out.println("\n---- Quan ly nha hang ----");
            System.out.println("1. Hien thi danh sach hang");
            System.out.println("2. Dat ban");
            System.out.println("3.Huy ban");
            System.out.println("4. Hien thi thuc don");
            System.out.println("5. Them mon an");
            System.out.println("6. Cap nhatn mon an");
            System.out.println("7. Xoa mon an");
            System.out.println("8.Thoat");

            System.out.print("Chon chuc nang (1-8): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Booking.showTables();
                    break;
                case 2:
                    System.out.print("Nhap ID ban can dat ");
                    int tableIdToBook = scanner.nextInt();
                    Booking.bookTable(tableIdToBook);
                    break;
                case 3:
                    System.out.print("Nhap ID ban can huy: ");
                    int tableIdToFree = scanner.nextInt();
                    Booking.freeTable(tableIdToFree);
                    break;
                case 4:
                    Booking.showMenu();
                    break;
                case 5:
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    System.out.print("Nhap ten mon an: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap mo ta mon an: ");
                    String description = scanner.nextLine();
                    System.out.print("Nhap gia mon an: ");
                    double price = scanner.nextDouble();
                    Booking.addMenuItem(name, description, price);
                    break;
                case 6:
                    System.out.print("Nhap chi so mon an can nhap: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    System.out.print("Nhap ten mon an moi: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhap mo ta mon an moi: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Nhap gia mon an: ");
                    double newPrice = scanner.nextDouble();
                    Booking.updateMenuItem(updateIndex, newName, newDescription, newPrice);
                    break;
                case 7:
                    System.out.print("Nhap chi so mon can xoa: ");
                    int removeIndex = scanner.nextInt();
                    Booking.removeMenuItem(removeIndex);
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
