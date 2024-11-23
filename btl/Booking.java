import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    private static List<Table> tables = new ArrayList<>();
    private static List<MenuItem> menu = new ArrayList<>();

    // Khởi tạo bàn ăn
    public static void initializeTables() {
        for (int i = 1; i <= 5; i++) { // Giả sử có 5 bàn
            tables.add(new Table(i));
        }
    }

    // Khởi tạo thực đơn
    public static void initializeMenu() {
        menu.add(new MenuItem("Pho", "Mon Pho Truyen Thong", 30000));
        menu.add(new MenuItem("Bun Cha", "Bun Cha Truyen Thong", 35000));
        menu.add(new MenuItem("Com Tam", "Com Tam Suon Bi", 40000));
        menu.add(new MenuItem("Goi Cuon", "Goi Cuon Tom Thit", 25000));
        menu.add(new MenuItem("Banh Mi", "Banh Mi Thit Nuong", 20000));
    }

    // Hiển thị danh sách bàn
    public static void showTables() {
        if (tables.isEmpty()) {
            System.out.println("No tables available.");
        } else {
            for (Table table : tables) {
                System.out.println(table);
            }
        }
    }

    // Đặt bàn
    public static void bookTable(int tableId) {
        Table table = getTableById(tableId);
        if (table != null) {
            if (table.isBooked()) {
                System.out.println("Ban Nay Da Duoc Dat.");
            } else {
                table.book();
                System.out.println("Dat ban " + tableId + " thanh cong.");
                logToFile("Dat ban:ban " + tableId + " da duoc dat.");
            }
        } else {
            System.out.println("Ban khong hop le.");
        }
    }

    // Giải phóng bàn
    public static void freeTable(int tableId) {
        Table table = getTableById(tableId);
        if (table != null) {
            if (!table.isBooked()) {
                System.out.println("Ban nay chua duoc dat.");
            } else {
                table.free();
                System.out.println("Giai phong ban " + tableId + " thanh cong.");
                logToFile("Giai phong ban: Ban " + tableId + " da duoc giai phong.");
            }
        } else {
            System.out.println("Ban khong hop le.");
        }
    }

    // Hiển thị thực đơn
    public static void showMenu() {
        if (menu.isEmpty()) {
            System.out.println("Thuc don rong.");
        } else {
            for (MenuItem item : menu) {
                System.out.println(item);
            }
        }
    }

    // Thêm món ăn vào thực đơn
    public static void addMenuItem(String name, String description, double price) {
        menu.add(new MenuItem(name, description, price));
        logToFile("Them may: " + name + " Vao thuc don.");
    }

    // Cập nhật món ăn trong thực đơn
    public static void updateMenuItem(int index, String name, String description, double price) {
        if (index >= 0 && index < menu.size()) {
            MenuItem item = menu.get(index);
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);
            logToFile("Cap nhat mon " + name + " trong thuc don.");
        } else {
            System.out.println("Mon khong hop le.");
        }
    }

    // Xóa món ăn khỏi thực đơn
    public static void removeMenuItem(int index) {
        if (index >= 0 && index < menu.size()) {
            MenuItem item = menu.get(index);
            menu.remove(index);
            logToFile("Xoa mon: " + item.toString() + "Khoi thuc don.");
        } else {
            System.out.println("Mon khong hop le");
        }
    }

    // Tìm bàn theo ID
    private static Table getTableById(int tableId) {
        for (Table table : tables) {
            if (table.getId() == tableId) {
                return table;
            }
        }
        return null;
    }

    // Ghi thông tin vào file với thời gian
    private static void logToFile(String message) {
        try {
            File file = new File("restaurant_log.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Get current time and format it
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            bufferedWriter.write("[" + timeStamp + "] " + message);
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Loi khi vao file: " + e.getMessage());
        }
    }
}