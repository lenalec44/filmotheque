package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dto.FilmDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // Liste des films
    @GetMapping("/films")
    public String afficherFilms(Model model) {
        List<Film> films = filmService.consulterFilms();
        model.addAttribute("films", films);
        return "view-films";
    }

    // Détail d’un film
    @GetMapping("/films/detail")
    public String afficherUnFilm(@RequestParam("id") long id, Model model) {
        Film film = filmService.consulterFilmParId(id);
        model.addAttribute("film", film);
        return "view-film-detail";
    }

    // Formulaire création d’un film
    @GetMapping("/films/creer")
    public String afficherFormulaire(Model model) {
        model.addAttribute("filmDto", new FilmDto());
        model.addAttribute("genresEnSession", filmService.consulterGenres());
        model.addAttribute("participants", filmService.consulterParticipants());

        return "view-film-form";
    }

    // POST création d’un film
    @PostMapping("/films/creer")
    public String creerFilm(@Valid @ModelAttribute("filmDto") FilmDto filmDto,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("genresEnSession", filmService.consulterGenres());
            model.addAttribute("participants", filmService.consulterParticipants());
            return "view-film-form";
        }

        // Transformation FilmDto -> Film
        Film film = new Film();
        film.setTitre(filmDto.getTitre());
        film.setAnnee(filmDto.getAnnee());
        film.setDuree(filmDto.getDuree());
        film.setSynopsis(filmDto.getSynopsis());
        film.setGenre(filmService.consulterGenreParId(filmDto.getGenreId()));
        film.setRealisateur (filmService.consulterParticipantParId(filmDto.getRealisateurId()));
        List<Participant> acteurs = new ArrayList<>();
        for (long acteurId : filmDto.getActeursId()) {
            acteurs.add(filmService.consulterParticipantParId(acteurId));

        }
        film.setActeurs(acteurs);

        // Sauvegarde via le service bouchon
        filmService.creerFilm(film);

        return "redirect:/films";
    }


}


