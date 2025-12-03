public abstract class SanPham {
    protected String ma;
    protected String ten;
    protected int gia;

    public SanPham(String ma, String ten, int gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public int getGia() { return gia; }

    public abstract void inThongTin(); // đa hình
}
