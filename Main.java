import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            DanhSachThucUong dsTU = new DanhSachThucUong();
            DanhSachTopping dsTP = new DanhSachTopping();

            dsTU.docFile("thucuong.txt");
            dsTP.docFile("topping.txt");

            int chon;
            do {
                System.out.println("\n===== QUAN LY QUAN TRA SUA =====");
                System.out.println("1. Them thuc uong");
                System.out.println("2. Them topping");
                System.out.println("3. Luu du lieu");
                System.out.println("4. Xem danh sach");
                System.out.println("5. Lap hoa don");
                System.out.println("0. Thoat");
                System.out.print("Chon: ");
                chon = sc.nextInt();
                sc.nextLine();
                switch (chon) {
                    case 1 -> {
                        System.out.print("Ma: "); String ma = sc.nextLine();
                        System.out.print("Ten: "); String ten = sc.nextLine();
                        System.out.print("Gia: "); int gia = sc.nextInt(); sc.nextLine();
                        System.out.print("Size: "); String size = sc.nextLine();
                        dsTU.add(new ThucUong(ma, ten, gia, size));
                    }

                    case 2 -> {
                        System.out.print("Ma: "); String ma2 = sc.nextLine();
                        System.out.print("Ten: "); String ten2 = sc.nextLine();
                        System.out.print("Gia: "); int gia2 = sc.nextInt();
                        dsTP.add(new Topping(ma2, ten2, gia2));
                    }

                    case 3 -> {
                        dsTU.ghiFile("thucuong.txt");
                        dsTP.ghiFile("topping.txt");
                    }

                    case 4 -> {
                        System.out.println("\n--- Danh sach thuc uong ---");
                        dsTU.xuat();
                        System.out.println("\n--- Danh sach topping ---");
                        dsTP.xuat();
                    }

                    case 5 -> {
                        System.out.print("Ma hoa đon: ");
                        String mahd = sc.nextLine();

                        System.out.println("Chon thuc uong:");
                        for (int i = 0; i < dsTU.getList().size(); i++)
                            System.out.println((i+1) + ". " + dsTU.getList().get(i).getTen());
                        int chonTU = sc.nextInt(); sc.nextLine();
                        HoaDon hd = new HoaDon(mahd, dsTU.getList().get(chonTU-1));

                        System.out.println("Chon topping (0 de dung):");
                        for (int i = 0; i < dsTP.getList().size(); i++)
                            System.out.println((i+1) + ". " + dsTP.getList().get(i).getTen());

                        while (true) {
                            int c = sc.nextInt();
                            if (c == 0) break;
                            hd.themTopping(dsTP.getList().get(c-1));
                        }

                        hd.inHoaDon();
                    }
                }
            } while (chon != 0);
        }
    }
}