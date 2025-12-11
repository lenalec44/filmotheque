package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dal.ParticipantRepository;


import java.util.List;

public class ParticipantServiceImpl implements ParticipantService {


   public ParticipantRepository participantRepository;

   public ParticipantServiceImpl(ParticipantRepository participantRepository){
       this.participantRepository = participantRepository;
   }


    @Override
    public List<Participant> findAllParticipants() {
        return participantRepository.findAllParticipants();
    }

    @Override
    public Participant findParticipantById(int id) {
        return participantRepository.findParticipantById(id);
    }
}
