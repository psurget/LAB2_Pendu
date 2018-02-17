/**
 * Joueur.java
 * Description:
 *
 * Créé le Feb 10, 2018
 * Par Pascal Surget
 */
package ca.qc.cgodin;

public class Joueur {
    
    // VARIABLES ET CONSTANTES DE CLASSE
    private static int count=0;
    private int idJoueur;
    private String nom;
    private int score=0;
    
    // CONSTRUCTEUR
    public Joueur(String nom) {
	this.idJoueur = ++count;
	this.nom = nom;
	this.score = 0;
    }
    
    public Joueur(){
	this ("Individus");
    }
    
       
    public String toString(){
	return nom + ": " + score;
    }
    
    // GETTERS
    public Integer getIdJoueur(){
	return idJoueur;
    }
    
    public String getNom(){
   	return nom;
    }
    
    public String getNom(int idJoueur){
   	return nom;
    }
    
    public Integer getScore(){
   	return score;
    }
    
    //SETTERS
    public void setNom(String nom){
	this.nom=nom;
    }
    
    public void resetScore() {
	this.score=0;
    }
    
    
}
