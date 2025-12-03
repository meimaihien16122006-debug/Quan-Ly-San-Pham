public class ThucUong extends SanPham {
    private final String size;

    public ThucUong(String ma, String ten, int gia, String size) {
        super(ma, ten, gia);
        this.size = size;
    }

    public String getSize() { return size; }

    @Override
    public void inThongTin() {
        System.out.println("Thức uống: " + ten + " | Giá: " + gia + " | Size: " + size);
    }
}
