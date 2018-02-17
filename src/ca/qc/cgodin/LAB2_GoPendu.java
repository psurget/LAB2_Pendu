/**
 * LAB2_GoPendu.java
 * Description:
 *
 * Créé le Feb 10, 2018
 * Par Pascal Surget
 */
package ca.qc.cgodin;
import javax.swing.JOptionPane;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LAB2_GoPendu {
    // VARIABLES DE CLASSES
    static int[] tourJ;
    static Joueur[] j;
    static String[] nom, secret;
    static boolean gagne, nouveau;
    static int nbJoueurs;

    
    public static void main(String[] args) {
	//Nb de joueurs
	String tmp = JOptionPane.showInputDialog("À combien de joueurs voulez-vous jouer ?");
	nbJoueurs = Integer.parseInt(tmp);
	
	//variables	
	secret = new String[nbJoueurs];
	nom = new String[nbJoueurs];
	
	for(int i=1; i< nbJoueurs; i++) {
	    // Inscription des joueurs
	    nom[i] = JOptionPane.showInputDialog("Joueur " + i + ": Quel est votre nom ?");
	    secret[i] = JOptionPane.showInputDialog( nom[i] + ", entrez votre mot secret ?");
	    //  Création du Joueur 1 et de son Pendu
	    	if(nom[i]==""){
	    	    j[i] = new Joueur();
	    	}else{
	    	    j[i] = new Joueur(nom[i]);
	    	};
	    	int idJ = j[i].getIdJoueur();
	    	p[i] = new Pendu(idJ,secret[i]);
		}
	// Début DO-WHILE-1 Autre Partie
	do {
	    // Création des 2 joueurs et des 2 pendus
	    
	    int idJ2 = j2.getIdJoueur();	    
	    //Pendu (Int idJoueur, String motSecret, String motTrouve)
	    Pendu p1 = new Pendu(idJ1, secret[nbJoueurs], null);
	    
	    
	    	j2 = new Joueur(nom[nbJoueurs]);
	    
	    Pendu p2 = new Pendu(idJ2, secret[nbJoueurs], null);	    
	    
	// Tirage au sort
	    int[] TabJoueurs = new int[]{ idJ1, idJ2 };
	    String[] TabPendu = new String[]{"p1","p2"};
	    Random rnd = new Random();
	    int tour = rnd.nextInt();
	    String nomChoisi = nom[tour];
	    JOptionPane.showMessageDialog( null, nomChoisi + " a été sélectionné pour commencer la partie." );
	    	    
	// RESET de l'affichage des lettres VUES
	    Map<String,Joueur> j = new HashMap<>();
	    for(int i=1; i<nbJoueurs; i++) {
		j.put("j"+ i, resetScore());
	     }

	
	// Début DO-WHILE-2 ( Gagnant? )
	    int count=0;
	    String[] test = new String[nbJoueurs];
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
    
    public void multiJoueursPendu(int nbJoueurs, String[] nom, String[] secret){
	int[] idJrs = new int[nbJoueurs];
	Map<String,Joueur> j = new HashMap<>();
	Map<String,Pendu> p = new HashMap<>();
	Map<String,Pendu> idJoueurs = new HashMap<>();
	
	for(int i=0; i < nbJoueurs; i++){
	    nom[i] = JOptionPane.showInputDialog("Joueur "+i+": Quel est votre nom ?");
	    secret[i] = JOptionPane.showInputDialog( nom[i] + ", entrez votre mot secret ?");
	   
	    //  Création des Joueurs et de leur Pendu
	    if(nom[i]==""){
		j.put( "j" + i, new Joueur());
		idJrs[i]= idJoueurs.put( "j"+i, Pendu.getIdPendu( nom[i]) );
	    }else{
		j.put( "j" + i, new Joueur(nom[i]));
	    };
	    
	}
    }
    
}

