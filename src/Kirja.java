
public class Kirja {
	//Muuttujar
	private String kirjanNimi;
	private String tekija;
	private String julkaisuvuosi;
	private String isbn;
	
	//konstruktorit
	public Kirja() {
		this.kirjanNimi ="tuntematon";
		this.tekija="tuntematon";
		this.julkaisuvuosi="ei tiedossa";
		this.isbn="ei tiedossa";
		
	}
	
	public Kirja(String kirjanNimi, String tekija, String julkaisuvuosi, String isbn) {
		super();
		this.kirjanNimi = kirjanNimi;
		this.tekija = tekija;
		this.julkaisuvuosi = julkaisuvuosi;
		this.isbn = isbn;
	}

	//accessorit
	
	public String getKirjanNimi() {
		return kirjanNimi;
	}

	public void setKirjanNimi(String kirjanNimi) {
		this.kirjanNimi = kirjanNimi;
	}

	public String getTekija() {
		return tekija;
	}

	public void setTekija(String tekija) {
		this.tekija = tekija;
	}

	public String getJulkaisuvuosi() {
		return julkaisuvuosi;
	}

	public void setJulkaisuvuosi(String julkaisuvuosi) {
		this.julkaisuvuosi = julkaisuvuosi;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void lisaaKirja() {
		
	}
	

}
