/**
 * Pendu.java
 * Description:
 *
 * Créé le Feb 10, 2018
 * Par Pascal Surget
 */
package ca.qc.cgodin;

public class Pendu {
    // VARIABLES
    private int idJoueur;
    private String nom;
    private String motSecret;
    private String motTrouve;
    static String lettresTest;
    
    // CONSTRUCTOR
    public Pendu(int idJoueur, String nom, String motSecret) {
	this.idJoueur = idJoueur;
	this.nom = nom;
	for(int i=0; i< motSecret.length(); i++){
	    this.motTrouve += "_";
	}
    }
    
    public Pendu(int idJoueur, String motSecret) {
	for(int i=0; i< motSecret.length(); i++){
	    this.motTrouve += "_";
	}
    }
    
    
   // METHODS 
  public void essai(String lettre){
      setLettresTest(lettre);
      this.motTrouve = this.motTrouve.replaceAll("_",lettre);
  }
  
  public String getStatutMotTrouve(){
      String test = this.getLettresTest(); 
      return this.motTrouve + "Lettres testées: \"" + test + "\"";
  }
  
  public Boolean EstTrouve(){
      Boolean trouve = motSecret.equals(motTrouve);
      return trouve;
  }
  
  public String toString(){
      return idJoueur + ", " + motSecret + " " + motTrouve + lettresTest;
  }
  
  // GETTTERS
  
  public int getIdJoueur() {
      return idJoueur;
  }
  
  public String getMotSecret(){
      return motSecret;
  }
  
  public String getMotTrouve(){
      return motTrouve;
  }
  
  public String getLettresTest() {
      return lettresTest;
  }
  
  public String getNomPendu() {
      return nom;
  }
  
  //SETTERS
  public void ResetALL(){
      motTrouve = null;
      motSecret = null;
  }
  
  public void setNom(int idJoueur, String nom) {
      idJoueur = this.idJoueur;
      nom = this.nom;
  }
  
  public void resetMotTrouve(){
      motTrouve = null;
  }
  
  public void setLettresTest(String lettre){
      lettresTest += lettre;
  }
  
  
}
