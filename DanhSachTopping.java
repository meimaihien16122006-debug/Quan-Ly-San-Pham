import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachTopping implements IOData {
    private final ArrayList<Topping> list = new ArrayList<>();

    public void add(Topping tp) {
        list.add(tp);
    }

    public ArrayList<Topping> getList() {
        return list;
    }

    @Override
    public void ghiFile(String fileName) {
        try {
            try (FileWriter fw = new FileWriter(fileName)) {
                for (Topping tp : list) {
                    fw.write(tp.toString() + "\n");
                }
            }
            System.out.println(" Da ghi danh sach topping vao file!");
        } catch (IOException e) {
            System.out.println(" Loi ghi file: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void docFile(String fileName) {
        try {
            File f = new File(fileName);
            if (!f.exists()) {
                System.out.println("⚠ File khong ton tai!");
                return;
            }

            try (Scanner sc = new Scanner(f)) {
                list.clear();
                
                while (sc.hasNextLine()) {
                    String[] t = sc.nextLine().trim().split(";");
                    list.add(new Topping(t[0], t[1], Integer.parseInt(t[2])));
                }
            }
            System.out.println("Da đoc danh sach topping tu file!");
        } catch (Exception e) {
            System.out.println(" Loi doc file: " + e.getMessage());
        }
    }

    public void xuat() {
        for (Topping tp : list)
            tp.inThongTin();
    }
}
