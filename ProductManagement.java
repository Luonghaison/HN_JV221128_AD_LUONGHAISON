package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Catalog> cataList = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần\n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                    "5. Thoát ");
            System.out.println("Nhap vao lua chon");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    createCatalog(cataList, input);
                    break;
                case 2:
                    createProduct(listProduct, input, cataList);
                    break;
                case 3:
                    sortProduct(listProduct);
                    break;
                case 4:
                    searchByProductName(listProduct,input);
                    break;
                case 5:
                    System.out.println("Thoát khỏi chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhap sai cmnr");
                    break;
            }
        }
    }

    public static void createCatalog(List<Catalog> list, Scanner scanner) {
        System.out.println("Nhập số lượng danh mục sản phẩm cần thêm: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập danh mục thứ: " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData(scanner, list);
            if (list.size() == 0) {
                newCatalog.setCatalogId(1);
            } else {
                newCatalog.setCatalogId(list.get(list.size() - 1).getCatalogId() + 1);
            }
            list.add(newCatalog);
        }
        System.out.println("Them thanh cong");
        displayListCatalog(list);
    }

    public static void displayListCatalog(List<Catalog> list) {
        for (Catalog catalog : list
        ) {
            catalog.displayData();
        }
    }

    public static void displayListProduct(List<Product> list) {
        for (Product product : list
        ) {
            product.displayData();
        }
    }

    public static void createProduct(List<Product> listProduct, Scanner scanner, List<Catalog> listCata) {
        System.out.println("Nhập số lượng sản phẩm cần thêm mới: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập sản phẩm thứ: " + (i + 1));
            Product newProduct = new Product();
            newProduct.inputData(scanner, listCata);
            if (listProduct.size() == 0) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(listProduct.get(listProduct.size() - 1).getProductId() + 1);
            }
            listProduct.add(newProduct);
        }

        System.out.println("Them thanh cong");
        displayListProduct(listProduct);
    }

    public static void sortProduct(List<Product> list) {
        Collections.sort(list);
        displayListProduct(list);

    }

    public static void searchByProductName(List<Product> list, Scanner scanner) {
        System.out.println("nhap ten danh mục sản phẩm cần tim kiem");
        String searchName = scanner.nextLine();
        List<Product> listSearch = new ArrayList<>();

        for (Product sP : list) {
            if (sP.getCatalog().getCatalogName().contains(searchName)) {
                listSearch.add(sP);
                System.out.println("Danh sach tim kiem la:");
                displayListProduct(listSearch);
            }
        }

    }
}
