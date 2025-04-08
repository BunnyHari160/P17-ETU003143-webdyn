public class Prevision {

    String libelle;
    String montant_prev;

    Prevision(String libelle, String montant)
    {
        this.libelle = libelle;
        this.montant_prev = montant;
    }

    Prevision(){}

    public Prevision(String string, int int1) {
        //TODO Auto-generated constructor stub
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMontant_prev() {
        return montant_prev;
    }

    public void setMontant_prev(String montant_prev) {
        this.montant_prev = montant_prev;
    }

    
}