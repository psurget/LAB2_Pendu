/**
 * LAB2_GoPendu.java
 * Description:
 *
 * Créé le Feb 10, 2018
 * Par Pascal Surget
 */
package ca.qc.cgodin;
import javax.swing.JOptionPane;

public class GoPendu {
    // VARIABLES DE CLASSES
    static int nbJoueurs=2;
 /*================================*/   
    static int[] tourJ;
    static Joueur[] j;
    static Pendu[] p;
    static String[] secret = new String[nbJoueurs];
    static String[] nom = new String[nbJoueurs];
    static boolean gagne;
    static boolean nouveau;

    
    public static void main(String[] args) {		
	
	// Création des Joueurs et de leur Pendu
	creerJoueurs();
	
	
	// Début DO-WHILE-1
	do {
	    
	// Tirage au sort
	   int rnd = ((int) (Math.random()*0.5));
	    String nomChoisi = nom[rnd];
	    String tit1 = "Tirage au sort";
	    String msg1 = nomChoisi + " a été sélectionné pour commencer la partie.";
	    JOptionPane.showInternalMessageDialog(null, msg1 , tit1, JOptionPane.INFORMATION_MESSAGE);
	    	    
	// RESET de l'affichage des lettres VUES
	    for(int i=1; i<nbJoueurs; i++) {
		j[i].resetScore();
	     }
	
	// Début DO-WHILE-2 ( Gagnant? )
	    int i=0;
	    String[] test = new String[2];
	    int tourJoueur;
	    
	    do {
		test[i] = JOptionPane.showInputDialog("Entrez une lettre à découvrir: ");
	// 	Lire la tentative
		String lettre = test[i].substring(0,1);
		Pendu curP = p[i];
		p[i].essai(lettre);
		gagne = p[i].EstTrouve();
		if (gagne) {
		    String tit2 = "État des mots trouvés";
		    String msg2 = p[i].getStatutMotTrouve();	    
		    //	Afficher l'état des mots à trouver
		    JOptionPane.showInternalMessageDialog(null, msg2, tit2, JOptionPane.INFORMATION_MESSAGE); 
		}
		++i;
		//END WHILE-2 ( FIN DU TOUR  --- >  C'est le tour de l'autre joueur SI personne n'a gagné )
	    } while (!gagne);
	    
	    
	// Affichage de félicitation au gagnant et on augmente son score.
	    String nomGagnant="test";
	    String tit3 = "État des mots trouvés";
	    String msg3 = "Félicitation " + nomGagnant + ", vous avez gagné la partie."; 
	    JOptionPane.showInternalMessageDialog(null, msg3, tit3, JOptionPane.INFORMATION_MESSAGE);
	    
	//END WHILE-1 ( FIN DE LA PARTIE --> On demande si on veut jouer une autre partie)
	} while(nouveau);
	// Affichage des scores.

    }
    
    public static void creerJoueurs(){
	//nbJoueurs est fixe à 2 joueurs pour l'instant
	for(int i=1; i< nbJoueurs; i++) {
	    // Inscription des joueurs
	    nom[i] = JOptionPane.showInputDialog("Entrez votre nom, joueur " + i + " ?");
	    secret[i] = JOptionPane.showInputDialog( nom[i] + ", entrez votre mot secret ?");
	    //  Création des Joueurs et de son Pendu
	    	if(nom[i].isEmpty()){
	    	    j[i] = new Joueur();
	    	}else{
	    	    j[i] = new Joueur(nom[i]);
	    	}
	    	p[i] = new Pendu( j[i].getIdJoueur(), nom[i], secret[i] );
	}// end for
	
    }
    
}

