package fr.laerce.lights.impl;

import fr.laerce.lights.Eclairage;

import java.util.Random;

/**
 * Implémentation d'une ampoule à incandescence
 * 
 * @author Frederic Varni
 * 
 */
public class AmpouleIncandescente implements Eclairage {

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
        if (alea.nextInt(100) < 10) {
            return -1;
        }
        return 0;
    }

    /**
     * Constructeur
     */
    public AmpouleIncandescente() {
        etat = 0;
    }

    /**
     * Allume l'ampoule à pleine puissance
     */
    @Override
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
    @Override
    public void eteindre() {
        if (etat != -1) {
            etat = 0;
        }

    }

    /**
     * Augmente l'intensité lumineuse de l'ampoule
     */
    @Override
    public void intensifier() {
        if (etat != -1 && etat < 10) {
            etat++;
        }
    }

    /**
     * Diminuer l'intensité lumineuse de l'ampoule
     */
    @Override
    public void diminuer() {
        if ( etat > 0) {
            etat--;
        }
    }

    /**
     * Permet de connaître l'état de l'ampoule
     * 
     * @return l'état de la lampe 0..10 ou -1 si en panne
     */
    @Override
    public int etat() {
        return etat;
    }

    /**
     * @return l'état de l'objet sous la forme d'une chaîne de caractères
     */
    public String toString() {
        return this.getClass().getName()+" : "+etat;

    }

}





















