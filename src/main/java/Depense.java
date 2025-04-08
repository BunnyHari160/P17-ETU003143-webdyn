public class Depense {
    
    String libelle;
    String montant_dep;
    String date;

    Depense(String libelle, String montant, String date)
    {
        this.libelle = libelle;
        this.montant_dep = montant;
        this.date = date;
    }

    Depense(){}

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMontant_dep() {
        return montant_dep;
    }

    public void setMontant_dep(String montant_dep) {
        this.montant_dep = montant_dep;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}
