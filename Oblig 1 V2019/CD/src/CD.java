package no.hvl.dat102;

public class CD {

	private int cdNr;
	private String artist;
	private String tittel;
	private int aar; 				// Lanseringsår
	private Sjanger sjanger;
	private String plateselskap;
	

	public CD() {
		this(0, "","",0, null,"");
	
	}
	
	public CD(int cdNr, String artist, String tittel, int aar,Sjanger sjanger, String plateselskap) {
		this.cdNr = cdNr;
		this.artist = artist;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public int getCdNr() {
		return cdNr;
	}

	public void setNummer(int cdNr) {
		this.cdNr = cdNr;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public String getPlateselskap() {
		return plateselskap;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
}
