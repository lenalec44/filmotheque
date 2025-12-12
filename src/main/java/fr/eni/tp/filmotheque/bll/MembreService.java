package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Membre;

public interface MembreService {
    Membre inscrire(Membre membre);

    Membre trouverParPseudo(String pseudo);

    Membre trouverParId(int id);
}
