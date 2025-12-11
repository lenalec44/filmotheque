package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dal.FilmRepository;
import fr.eni.tp.filmotheque.dal.ParticipantRepository;
import fr.eni.tp.filmotheque.dal.ParticipantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("filmService")
@Primary
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;
    @Autowired
    private  ParticipantRepository participantRepository;

    public FilmServiceImpl(FilmRepository filmRepository, ParticipantRepository participantRepository) {
        this.filmRepository = filmRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public List<Film> consulterFilms() {
        List<Film> films = filmRepository.findAllFilms();
        return films;
    }

    @Override
    public Film consulterFilmParId(Integer id) {
        return filmRepository.findFilmById(id);
    }

    @Override
    public List<Participant> consulterParticipants() {
        return participantRepository.findAllParticipants();
    }

    @Override
    public Participant consulterParticipantParId(long id) {
        return participantRepository.findParticipantById((int)id);
    }


    @Override
    public void creerFilm(Film film) {
        filmRepository.saveFilm(film);
    }
}
