import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class QLND {
    static ArrayList<GiaoDich> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void addGiaoDichNha(){
        System.out.println("Nhập mã giao dịch");
        int maGiaoDich= Integer.parseInt(sc.nextLine());
        System.out.println("Nhập ngày giao dich");
        String ngayGiaoDich=sc.nextLine();
        System.out.println("Nhập đơn giá");
        int donGia=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập loại nhà (caocap hoặc thuong");
        int dienTich=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập địa chỉ");
        String diaChi=sc.nextLine();
        System.out.println("Nhập diện tích");
        String loaiNha=sc.nextLine();
        GiaoDichNha giaoDichNha = new GiaoDichNha( maGiaoDich,  ngayGiaoDich,  donGia,  dienTich,  loaiNha,  diaChi);
        list.add(giaoDichNha);
    }
    public static void addGiaoDichDat(){
        System.out.println("Nhập mã giao dịch");
        int maGiaoDich= Integer.parseInt(sc.nextLine());
        System.out.println("Nhập ngày giao dich");
        String ngayGiaoDich=sc.nextLine();
        System.out.println("Nhập đơn giá");
        int donGia=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập diện tích");
        int dienTich=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập loại đất(A , B hoặc C");
        String loaiDat=sc.nextLine();
        GiaoDichDat giaoDichDat = new GiaoDichDat( maGiaoDich,  ngayGiaoDich,  donGia,  dienTich,  loaiDat);
        list.add(giaoDichDat);
    }
    public static void addGiaoDich(){
        while (true){
        System.out.println("1.Thêm giao dịch đất");
        System.out.println("2.Thêm giao dịch nhà");
        System.out.println("3.Thoát");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                addGiaoDichDat();
                break;
            case 2:
                addGiaoDichNha();
                break;
            default:
                System.out.println("Nhập ko đúng");
                break;
        }if (choice==3) break;
        }

    }
    public static void sumGiaoDichNha(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains("diaChi")){
                sum++;
            }
        }
        System.out.println("Tổng giao dịch nhà là " + sum);
    }
    public static void sumGiaoDichDat(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains("loaiDat")){
                sum++;
            }
        }
        System.out.println("Tổng giao dịch đất là " + sum);
    }
    public static void sumGiaoDich(){
        while (true){
            System.out.println("1.Tổng số lượng giao dịch nhà");
            System.out.println("2.Tổng số lượng giao dịch đất");
            System.out.println("3.Thoát");
            int choicee=Integer.parseInt(sc.nextLine());
            switch (choicee){
                case 1:
                    sumGiaoDichNha();
                    break;
                case 2:
                    sumGiaoDichDat();
                    break;
                case 3:
                    break;
            }if (choicee==3) break;
        }
    }
    public static  void removeGiaoDichTheoNgay(){
        System.out.println("Nhập ngày cần xóa giao dịch");
        String ngayCanXoa= sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNgayGiaoDich().equals(ngayCanXoa)){
                list.remove(i);
            }
        }
    }
    public static void sortTheoMaGiaoDich(){
        list.sort(Comparator.comparing(o->((GiaoDich)o).getMaGiaoDich()));
    }
    public static double tienGiaoDichNha(String ngay){
        double sum=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains("loaiNha='caocap'")&&list.get(i).getNgayGiaoDich().equals(ngay)){
                sum=sum+list.get(i).getDienTich()*list.get(i).getDonGia();
            } else if (list.get(i).toString().contains("loaiNha='thuong")){
                sum=sum+list.get(i).getDienTich()*list.get(i).getDonGia()*0.9;
            }
        }
        return sum;
    }
    public static double tienGiaoDichDat(String ngay){
        double sum=0;
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).toString().contains("loaiDat='B'")||list.get(i).toString().contains("loaiDat='C'"))&&list.get(i).getNgayGiaoDich().equals(ngay) ){
                sum=sum+list.get(i).getDienTich()*list.get(i).getDonGia();
            } else if (list.get(i).toString().contains("loaiDat='B")){
                sum=sum+list.get(i).getDienTich()*list.get(i).getDonGia()*1.5;
            }
        }
        return sum;
    }
    public static int binarySearch(ArrayList<GiaoDich> array, int left, int right, int value) {
        int middle;
        while (array.get(left).getMaGiaoDich() <= array.get(right).getMaGiaoDich()) {
            middle = (left+right) / 2;
            if(array.get(middle).getMaGiaoDich() == value){
                return middle;
            }
            if(value > array.get(middle).getMaGiaoDich()){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return -1;
    }
    public static void findGiaoDichByID(){
        System.out.println("Nhập mã giao dịch");
        int idGiaoDich= Integer.parseInt(sc.nextLine());
        sortTheoMaGiaoDich();
        int index=binarySearch(list,0, list.size() -1,idGiaoDich);
        System.out.println(list.get(index));
    }
    public static void menu(){
        while (true){
            System.out.println("1.Thêm giao dịch");
            System.out.println("2.Tính tổng số lượng");
            System.out.println("3.Xóa giao dịch theo ngày");
            System.out.println("4.Tính tiền giao dịch theo ngày");
            System.out.println("5.Tìm kiếm giao dịch theo ngày bằng nhị phân");
            System.out.println("6.Sắp xếp giao dịch theo mã giao dịch");
            System.out.println("7.Thoát");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    addGiaoDich();
                    break;
                case 2:
                    sumGiaoDich();
                    break;
                case 3:
                    removeGiaoDichTheoNgay();
                    break;
                case 4:
                    System.out.println("Nhập ngày cần tính");
                    String date=sc.nextLine();
                    double tienDat=tienGiaoDichDat(date);
                    double tienNha=tienGiaoDichNha(date);
                    System.out.println("Tổng tiền giao dịch theo ngày là "+(tienDat+tienNha));
                    break;
                case 5:
                    findGiaoDichByID();
                    break;
                case 6:
                    sortTheoMaGiaoDich();
                    break;
                case 7:
                    break;
            }
        }
    }



}
