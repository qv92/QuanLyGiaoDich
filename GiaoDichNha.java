public class GiaoDichNha extends GiaoDich{
    private String loaiNha;
    private String diaChi;

    public GiaoDichNha(int maGiaoDich, String ngayGiaoDich, int donGia, int dienTich, String loaiNha, String diaChi) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "" + super.toString()+
                "loaiNha='" + loaiNha + '\'' +
                ", diaChi='" + diaChi + '\'' +
                "} " ;
    }
}
