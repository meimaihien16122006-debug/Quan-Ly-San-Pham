import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachThucUong implements IOData {
    private final ArrayList<ThucUong> list = new ArrayList<>();

    public void add(ThucUong tu) {
        list.add(tu);
    }

    public ArrayList<ThucUong> getList() {
        return list;
    }

    @Override
    public void ghiFile(String fileName) {
        try {
            try (FileWriter fw = new FileWriter(fileName)) {
                for (ThucUong tu : list) {
                    fw.write(tu.toString() + "\n");
                }
            }
            System.out.println("Da ghi danh sach thuc uong vao file!");
        } catch (IOException e) {
            System.out.println(" Loi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void docFile(String fileName) {
        try {
            File f = new File(fileName);
            if (!f.exists()) {
                System.out.println(" File khong ton tai!");
                return;
            }

            try (Scanner sc = new Scanner(f)) {
                list.clear();
                
                while (sc.hasNextLine()) {
                    String[] t = sc.nextLine().trim().split(";");
                    list.add(new ThucUong(t[0], t[1], Integer.parseInt(t[2]), t[3]));
                }
            }
            System.out.println(" Đa doc danh sach thuc uong tu file!");
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(" Loi đoc file: " + e.getMessage());
        }
    }

    public void xuat() {
        for (ThucUong tu : list)
            tu.inThongTin();
    }
}
