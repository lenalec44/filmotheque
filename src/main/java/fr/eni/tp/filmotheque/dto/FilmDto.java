package fr.eni.tp.filmotheque.dto;

import fr.eni.tp.filmotheque.bo.Participant;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FilmDto {

    @NotNull(message = "Le genre est obligatoire")
    private Long genreId;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    @NotNull(message = "L' année est obligatoire")
    @Min(value = 1900, message = "L' année doit être supérieure à 1900")
    private Integer annee;

    @NotNull(message = "La durée est obligatoire")
    @Min(value = 1, message = "La durée doit être supérieure à 0")
    private Integer duree;

    @NotBlank(message = "Le synopsis est obligatoire")
    private String synopsis;


    private long realisateurId;

    private List<Long> acteursId = new ArrayList<>();


    public FilmDto() {
    }

    public FilmDto(Long genreId, String titre, Integer annee, Integer duree, String synopsis, long realisateurId, List acteurId) {
        this.genreId = genreId;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.realisateurId = realisateurId;
        this.acteursId = acteurId;
    }

    public long getRealisateurId() {
        return realisateurId;
    }
    public void setRealisateurId(long realisateurId) {
        this.realisateurId = realisateurId;
    }

    public List<Long> getActeursId() {
        return acteursId;
    }
    public void setActeursId(List<Long> acteursId) {
        this.acteursId = acteursId;
    }

    // Getters et setters
    public Long getGenreId() { return genreId; }
    public void setGenreId(Long genreId) { this.genreId = genreId; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public Integer getAnnee() { return annee; }
    public void setAnnee(Integer annee) { this.annee = annee; }

    public Integer getDuree() { return duree; }
    public void setDuree(Integer duree) { this.duree = duree; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
}






