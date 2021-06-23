public class GiaoDichDat extends GiaoDich{
    private String loaiDat;

    public GiaoDichDat(int maGiaoDich, String ngayGiaoDich, int donGia, int dienTich, String loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    public String getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }

    @Override
    public String toString() {
        return "" + super.toString()+
                "loaiDat='" + loaiDat + '\'' +
                "} " + super.toString();
    }
}
