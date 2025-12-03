public class Topping extends SanPham {
    public Topping(String ma, String ten, int gia) {
        super(ma, ten, gia);
    }

    @Override
    public void inThongTin() {
        System.out.println("Topping: " + ten + " - Giá: " + gia + "đ");
    }

    @Override
    public String toString() {
        return ma + ";" + ten + ";" + gia;
    }
}
