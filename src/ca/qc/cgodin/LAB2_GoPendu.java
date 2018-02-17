/**
 * LAB2_GoPendu.java
 * Description:
 *
 * Créé le Feb 10, 2018
 * Par Pascal Surget
 */
package ca.qc.cgodin;
import javax.swing.JOptionPane;
import java.util.Random;

public class LAB2_GoPendu {
    
    // VARIABLES DE CLASSES
    static int[] tourJ = new int[2];
    static String[] nom = new String[2];
    static boolean gagne, nouveau;
    static Joueur j1, j2;
    static int nbJoueurs; 

    public static void main(String[] args) {
	//variables
	String[] secret = new String[2];
	
	// Inscription des joueurs
	String tmp=JOptionPane.showInputDialog("À combien de Joueurs voulez-vous jouer?");
	nbJoueurs = Integer.parseInt(tmp);
	
	nom[nbJoueurs] = JOptionPane.showInputDialog("Joueur "+i+": Quel est votre nom ?");
	secret[nbJoueurs] = JOptionPane.showInputDialog( nom[nbJoueurs] + ", entrez votre mot secret ?");
	//  Création du Joueur 1 et de son Pendu
	    if(nom[1]==""){
		j1 = new Joueur();
	    }else{
		j1 = new Joueur(nom[2]);
	    };
	    int idJ1 = j1.getIdJoueur();
	
	nom[2] = JOptionPane.showInputDialog("Joueur 2: Quel est votre nom ?");
	secret[2] = JOptionPane.showInputDialog( nom[2] + ", entrez votre mot secret ?");
	
	// Début DO-WHILE-1 Autre Partie
	do {
	// Création des 2 joueurs et des 2 pendus
	    
	    int idJ2 = j2.getIdJoueur();	    
	    //Pendu (Int idJoueur, String motSecret, String motTrouve)
	    Pendu p1 = new Pendu(idJ1, secret[2], null);
	    
	    
	    	j2 = new Joueur(nom[2]);
	    
	    Pendu p2 = new Pendu(idJ2, secret[2], null);	    
	    
	// Tirage au sort
	    int[] TabJoueurs = new int[]{ idJ1, idJ2 };
	    String[] TabPendu = new String[]{"p1","p2"};
	    Random rnd = new Random();
	    int tour = rnd.nextInt();
	    String nomChoisi = nom[tour];
	    JOptionPane.showMessageDialog( null, nomChoisi + " a été sélectionné pour commencer la partie." );
	    	    
	// RESET de l'affichage des lettres VUES
	    j1.resetScore();
	    j2.resetScore();
	
	// Début DO-WHILE-2 ( Gagnant? )
	    int count=0;
	    String[] test = new String[2];
	    int tourJoueur;
	    
	    do {
		test[count] = JOptionPane.showInputDialog("Entrez une lettre à découvrir: ");
	// 	Lire la tentative
		String lettre = test[count].substring(0,1);
		String curP = TabPendu[count];
		p1.essai(lettre);
		gagne = p1.EstTrouve();
		if(gagne!=false) {
		    String msg1 = p1.getStatutMotTrouve();
		    //	Afficher l'état des mots à trouver
		    JOptionPane.showMessageDialog(null, msg1);  
		}
		++count;
		//END WHILE-2 ( C'est le tour de l'autre joueur SI personne n'a gagné )
	    } while(gagne==false);
	// Affichage de félicitation au gagnant et on augmente son score.
	
	    
	//END WHILE-1 ( On demande si on veut jouer une autre partie)
	} while(nouveau==true);
	// Affichage des scores.

    }
    
    public void tousJoueurPendu(int nb){
	String[] nom = new String[nb];
	String[] secret = new String[nb];
	for(int i=0; i < nb; i++){
	    nom[i] = JOptionPane.showInputDialog("Joueur "+i+": Quel est votre nom ?");
	    secret[i] = JOptionPane.showInputDialog( nom[i] + ", entrez votre mot secret ?");
	    //  Création du Joueur et de son Pendu
	    if(nom[i]==""){
		j1 = new Joueur();
	    }else{
		j1 = new Joueur(nom[i]);
	    }
	}
    }
    
}

