package kuliahsemester2;
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayList4 {

	public static void main(String[] args) {
try (Scanner scanner = new Scanner(System.in)) {
	ArrayList<String> daftarKota = new ArrayList<>();
	daftarKota.add("Sukabumi");
	daftarKota.add("Cianjur");
	daftarKota.add("Bandung");
	daftarKota.add("Garut");
	daftarKota.add("Tasik");
	daftarKota.add("Ciamis");
	daftarKota.add("Banjar");
	
	int diskon = 0;
	int tarif = 0;
	
	System.out.print("Masukan Kota Keberangkatan : ");
	String kotaBerangkat = scanner.nextLine();
	System.out.print("Masukan Kota Tujuan : ");
	String kotaTujuan = scanner.nextLine();
	System.out.print("Apakah Seorang Polisi / TNI [Y/N] :");
	String polisi = scanner.nextLine();
	
	if (kotaBerangkat.equals("Sukabumi") && kotaTujuan.equals("Banjar")) {
	    diskon = 5;
	}
	
	// Validasi
	if (!daftarKota.contains(kotaBerangkat)) {
	    System.out.println("Kota berangkat tidak sesuai");
	    System.exit(0);
	}
	
	if (!daftarKota.contains(kotaTujuan)) {
	    System.out.println("Kota tujuan tidak sesuai");
	    System.exit(0);
	}
	
	boolean isPulang = daftarKota.indexOf(kotaBerangkat) > daftarKota.indexOf(kotaTujuan);
	
	boolean startHitungTarif = false;
	for (int i=0; i<daftarKota.size(); i++) {
	    String kota = "";
	    
	    if (isPulang) {
	        kota = daftarKota.get(daftarKota.size() - i - 1);
	    } else {
	        kota = daftarKota.get(i);
	    }
	    
	    if (kota.equals(kotaBerangkat)) {
	        startHitungTarif = true;
	    }
	    
	    if (kota.equals(kotaTujuan)) {
	        break;
	    }
	    
	    if (startHitungTarif) {
	        if (isPulang) {
	            tarif += switch (kota) {
	                case "Cianjur":
	                    yield 10000;
	                case "Bandung":
	                    yield 15000;
	                case "Garut":
	                    yield 7500;
	                case "Tasik":
	                    yield 5000;
	                case "Ciamis":
	                    yield 7500;
	                case "Banjar":
	                    yield 6000;
	                default:
	                    yield 0;
	            };
	        } else {
	            tarif += switch (kota) {
	                case "Sukabumi":
	                    yield 10000;
	                case "Cianjur":
	                    yield 15000;
	                case "Bandung":
	                    yield 7500;
	                case "Garut":
	                    yield 5000;
	                case "Tasik":
	                    yield 7500;
	                case "Ciamis":
	                    yield 6000;
	                default:
	                    yield 0;
	                    
	            };
	        }
	    } 
	}
	
	
	System.out.println("Tarif Awal : " + tarif);
	
	if (polisi.toLowerCase().equals("y"))
	    diskon += 10;
	
	tarif = tarif - (diskon * tarif / 100);
	
	System.out.println("Total : " + tarif);
}
    }
	}


