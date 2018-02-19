/**
 * Pendu.java
 * Description:
 *
 * Créé le Feb 10, 2018
 * Par Pascal Surget
 */
package ca.qc.cgodin;

public class Pendu extends Joueur {
    
    // VARIABLES
    private String motSecret;
    private String motTrouve;
    static String lettresTest;
    
    // CONSTRUCTOR
    public Pendu(String nom, String motSecret) {
	super(nom);
	for(int i=0; i< motSecret.length(); i++){
	    this.motTrouve += "_";
	}
    }
    
    public Pendu(String motSecret) {
	super();
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
      return motSecret.equals(motTrouve);
  }
  
  public String toString(){
      return super.getIdJoueur() + ", " + motSecret + " " + motTrouve + lettresTest;
  }
  
  // GETTTERS
  
  public Integer getIdJoueur() {
      return super.getIdJoueur();
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
      return super.getNomComplet();
  }
  
  //SETTERS
  public void ResetALL(){
      motTrouve = null;
      motSecret = null;
  }
  
  
  public void resetMotTrouve(){
      motTrouve = null;
  }
  
  public static void setLettresTest(String lettre){
      lettresTest += lettre;
  }
  
  
}
