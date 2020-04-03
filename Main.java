import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner inp = new Scanner(System.in);

        try {
            File file = new File("../out/out.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String data = read.nextLine();
                String splitter[] = data.split(":");
                ll.add(splitter[0]);

                if(ll.searchData(splitter[0]) != null){
                    ll.searchData(splitter[0]).getData().addJudul(splitter[1]);
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        ll.sort();
        // tampilan program        
        while (true) {
            System.out.print("\n--------LinkedList Program--------\n\n");
            System.out.print("1. Cari Nama Editor\n");
            System.out.print("2. Tampilkan Seluruh Data Editor\n");
            System.out.print("3. Tampilkan Semua Nama Editor + Judul Artikel\n");
            System.out.print("4. Exit\n");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = Integer.parseInt(inp.nextLine());
            if (pilihan == 1) {
                System.out.print("Masukkan nama editor : ");
                String editor = inp.nextLine();
                ll.searchContainsEditor(editor);
            } else if (pilihan == 2) {
                ll.display();
                System.out.println("");
            } else if (pilihan == 3) {
                System.out.print("Masukkan nama editor : ");
                String editor = inp.nextLine();
                ll.menubaru(editor);
            } else if (pilihan == 4) {
                System.exit(1);
            } else {
                System.out.println("Pilihan tidak ditemukan\n");
            }

        }
    }
}