package fr.laerce.lights.impl;

import java.util.Random;

import fr.laerce.lights.Eclairage;

/**
 * Implémentation et simulation d'une "ampoule" de type tube néon dont la durée
 * de vie est est longue mais qui ne supporte pas les variations d'intensité.
 * 
 * @author fred
 * 
 */
public class AmpouleTube implements Eclairage {
    /**
     * etat de la lampe : 0 éteinte, 10 allumée pleine intensité
     */
    private int etat;

    /**
     * Calcule la probabilité qu'une ampoule tombe en panne
     * 
     * @return 0 l'ampoule fonctione, -1 l'ampoule est en panne
     */
    private int probaPanne() {
        Random alea = new Random();
        if (alea.nextInt(100) < 3) {
            return -1;
        }
        return 0;

    }

    /**
     * Constructeur
     */
    public AmpouleTube() {
        etat = 0;
    }

    /**
     * Allume l'ampoule à pleine puissance
     */
    public void allumer() {
        if (etat != -1 && probaPanne() != -1) {
            etat = 10;
        } else {
            etat = -1;
        }
    }

    /**
     * Eteint l'ampoule
     */
    public void eteindre() {
        if (etat != -1) {
            etat = 0;
        }
    }

    /**
     * Augmente l'intensité lumineuse de l'ampoule
     */
    public void intensifier() {
        allumer();
    }

    /**
     * Diminuer l'intensité lumineuse de l'ampoule
     */
    public void diminuer() {
        eteindre();
    }

    /**
     * Permet de connaître l'état de l'ampoule
     * 
     * @return l'état de la lampe 0..10 ou -1 si en panne
     */
    public int etat() {
        return etat;
    }

    /**
     * @return l'état de l'objet sous la forme d'une chaîne de caractères
     */
    public String toString() {
        return this.getClass().getName() + " : " + etat;
    }

}
