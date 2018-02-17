/**	Test_Classes.java
*	Auteur: Pascal Surget
*	Créé le: Feb 15, 2018
*	DESCRIPTION: CLASS DE TEST UNITAIRE
*/

package ca.qc.cgodin;
public class Test_Classes {

    // création d'un joueur
    public void main(String[] args) {
	// TODO Auto-generated method stub
	GoPendu.creerJoueurs();
	int id = Pendu.getIdPendu( GoPendu.nom[1] );
	System.out.println(id);
    }

}
