package modele.metier;

public class CompteEpargne extends Compte {
	private static final double PLAFOND = 12000;
	private static final double tauxInteret = 0.05;
//	private double tauxInteret;

//	public CompteEpargne(String numero, String intitule, double solde, double tauxInteret) {
//		super(numero, intitule, solde);
//		this.tauxInteret = tauxInteret;
//	}

	public CompteEpargne(String numero, String intitule, double solde) {
		super(numero, intitule, solde);
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

//	public void setTauxInteret(double tauxInteret) {
//		this.tauxInteret = tauxInteret;
//	}

	@Override
	public void crediter(double montant) throws CompteException {
		if(getSolde() + montant > PLAFOND) {
			throw new CreditException();
		}
		super.crediter(montant);
	}

	@Override
	public String toString() {
		return String.format("CompteEpargne [tauxInteret=%s, getNumero()=%s, getIntitule()=%s, getSolde()=%s]",
				tauxInteret, getNumero(), getIntitule(), getSolde());
	}

	@Override
	protected double calculerDebitMaximum() {
		return getSolde();
	}
	
	
	
	

}
