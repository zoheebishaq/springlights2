package fr.laerce.lights.impl;

import fr.laerce.lights.Eclairage;

import java.util.ArrayList;


/**
 * @author fred
 *
 */
public class Luminaire implements Eclairage {

    private ArrayList<Eclairage> ampoules;

    public void setAmpoules(ArrayList<Eclairage> ampoules) {
        this.ampoules = ampoules;
    }

    public Luminaire() {
//        ampoule1 = new AmpouleIncandescente();
//        ampoule2 = new AmpouleIncandescente();
//        ampoule3 = new AmpouleIncandescente();
//        ampoule4 = new AmpouleIncandescente();

    }



    @Override
    public void allumer() {
        for (Eclairage uneAmpoule:ampoules){
            uneAmpoule.allumer();
        }

    }

    @Override
    public void eteindre() {
        for (Eclairage uneAmpoule:ampoules){
            uneAmpoule.eteindre();
        }

    }

    @Override
    public void intensifier() {
        for (Eclairage uneAmpoule:ampoules){
            uneAmpoule.intensifier();
        }
    }

    @Override
    public void diminuer() {
        for (Eclairage uneAmpoule:ampoules){
            uneAmpoule.diminuer();
        }

    }

    /**
     * Retourne l'état du luminaire dans l'intervalle [0..10] ou -1 si il est en
     * panne. L'état résultant est la plus grande valeur des états des 4
     * ampoules du luminaire
     *
     * @return l'état du luminaire
     */
    @Override
    public int etat() {
        int etat=-1;
        for (Eclairage uneAmpoule:ampoules
        ) {
            if(etat<uneAmpoule.etat())
            {
                etat=uneAmpoule.etat();
            }
        }
        return etat;
    }

    public String toString() {
        String resultat="Classe : " + this.getClass().getSimpleName() + " etat :"
                + this.etat()+"\n";
        for (int i=1;i<=ampoules.size();i++)
        {
            resultat+="Ampoule "+i+" etat = "+ampoules.get(i-1).etat()+"\n";
        }
        return resultat;

    }

}
