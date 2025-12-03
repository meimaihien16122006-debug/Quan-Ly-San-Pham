import java.util.ArrayList;

public class HoaDon {
    private final String maHD;
    private final ThucUong thucUong;
    private final ArrayList<Topping> dsTopping = new ArrayList<>();

    public HoaDon(String maHD, ThucUong thucUong) {
        this.maHD = maHD;
        this.thucUong = thucUong;
    }

    public void themTopping(Topping tp) {
        dsTopping.add(tp);
    }

    public int tinhTong() {
        int tong = thucUong.getGia();
        for (Topping tp : dsTopping)
            tong += tp.getGia();
        return tong;
    }

    public void inHoaDon() {
        System.out.println("\n===== HOA DON " + maHD + " =====");
        thucUong.inThongTin(); // đa hình: gọi theo kiểu SanPham
        System.out.println("Topping:");
        for (Topping tp : dsTopping)
            tp.inThongTin();
        System.out.println("TONG TIEN: " + tinhTong() + "đ");
    }
}
