/**
 * LAB2_GoPendu.java
 * Description:
 *
 * Créé le Feb 10, 2018
 * Par Pascal Surget
 */
package ca.qc.cgodin;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class GoPendu {
    // VARIABLES DE CLASSES
    static int nbJoueurs=2;
 /*================================*/   
    static Map <Integer, Joueur> j = new HashMap<Integer, Joueur>();
    static Map <Integer, Pendu> p = new HashMap<Integer, Pendu>();
    static String[] secret = new String[nbJoueurs];
    static String[] nom = new String[nbJoueurs];
    static int[] tourJ;
    static boolean gagne;
    static boolean nouveau;

    
    public static void main(String[] args) {	
	
	// Création des Joueurs et de leur Pendu
	creerJoueursPendu();
	
	
	// Début DO-WHILE-1
	do {
	    
	// Tirage au sort
	    int rnd = ((int) (Math.random()*0.5));
	    String nomChoisi = nom[rnd];
	    tourJ[0]= p.get(rnd).getIdJoueur();
	    String tit1 = "Tirage au sort";
	    String msg1 = nomChoisi + " a été sélectionné pour commencer la partie.";
	    JOptionPane.showInternalMessageDialog(null, msg1 , tit1, JOptionPane.INFORMATION_MESSAGE);
	    	    
	// RESET de l'affichage des lettres VUES
	    for(int i=1; i <= nbJoueurs; i++) {
		j.get(i).resetScore();
	     }
	
	// Début DO-WHILE-2 ( Gagnant? )
	    int i=0;
	    String[] test = new String[nbJoueurs];
	    
	    do {
		test[i] = JOptionPane.showInputDialog("Entrez une lettre à découvrir: ");
	// 	Lire la tentative
		String lettre = test[i].substring(0,1);
		Pendu curP = p.get(i);
		p.get(i).essai(lettre);
		gagne = p.get(nom[i]) .EstTrouve();
		if (gagne) {
		    String tit2 = "État des mots trouvés";
		    String msg2 = p.get(i).getStatutMotTrouve();	    
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
	
	// AFFICHAGE DES SCORES
	String score="";
	for(int i=1; i<=nbJoueurs ; i++) {
	    score += j.get(i).getScore()+"\n";
	}
	 JOptionPane.showMessageDialog(null, score, "Pointage", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //  INITIALISATION DE LA CRÉATION DES JOUEURS ET DE LEUR PENDU
    public static void creerJoueursPendu(){
	//nbJoueurs est fixe à 2 joueurs pour l'instant
	for(int i=1; i <= nbJoueurs; i++) {
	    // Inscription des joueurs
	    nom[i] = JOptionPane.showInputDialog(null, "Entrez votre nom, joueur " + i + " ?", "Nouvelle partie", JOptionPane.QUESTION_MESSAGE);
	    secret[i] = JOptionPane.showInputDialog(null, nom[i] + ", entrez votre mot secret ?", "Mot secret", JOptionPane.QUESTION_MESSAGE);
	    //  Création des Joueurs et de son Pendu
	    	if(nom[i].isEmpty()){
	    	    j.put( i, new Joueur() );
	    	}else{
	    	    j.put( i, new Joueur(nom[i]) );
	    	    p.put( i,  
	    		    new Pendu( j.get(i).getIdJoueur(), 
	    				nom[i], 
	    				secret[i] 
	    			    )
	    		    );
	    	} // end if
	}// end for
    }// end creerJoueursPendu()
    
}

