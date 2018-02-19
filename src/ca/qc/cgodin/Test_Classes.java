/**	Test_Classes.java
*	Auteur: Pascal Surget
*	Créé le: Feb 15, 2018
*	DESCRIPTION: CLASS DE TEST UNITAIRE
*/

package ca.qc.cgodin;

import javax.swing.JOptionPane;


public class Test_Classes {
    // VARIABLES DE CLASSES
    static int nbJoueurs=2;
 /*================================*/   
    static String[] secret = new String[nbJoueurs];
    static String[] nom = new String[nbJoueurs];
    static Pendu[] p = new Pendu[nbJoueurs];
    static int tourJ;
    boolean gagne;
    boolean nouveau;
    // création d'un joueur
    public static void main(String[] args) {
	
	
		//nbJoueurs est fixe à 2 joueurs pour l'instant
		for(int i=0; i < nbJoueurs; i++) {
		    // Inscription des joueurs
		    nom[i] = JOptionPane.showInputDialog(null, "Entrez votre nom, joueur " + (i+1) + " ?", "Nouvelle partie", JOptionPane.QUESTION_MESSAGE);
		    secret[i] = JOptionPane.showInputDialog(null, nom[i] + ", entrez votre mot secret ?", "Mot secret", JOptionPane.QUESTION_MESSAGE);
		}// end for
		
		for(int i=0; i < nbJoueurs; i++) {
		    //  Création des Joueurs et de son Pendu
		    	if( nom[i].isEmpty() ){
		    	    p[i] = new Pendu( secret[i] );
		    	} else {
		    	    p[i] = new Pendu( nom[i], secret[i] );
		    	} // end if
		}// end for
		System.out.println(p);
		
    }
    

}
