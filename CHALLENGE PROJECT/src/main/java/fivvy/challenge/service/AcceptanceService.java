package fivvy.challenge.service;

import fivvy.challenge.entity.AcceptanceEntity;
import fivvy.challenge.repository.AcceptanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class AcceptanceService implements IAcceptanceService {
    private final AcceptanceRepository acceptanceRepository;

    public AcceptanceService(AcceptanceRepository acceptanceRepository) {
        this.acceptanceRepository = acceptanceRepository;
    }

    @Transactional
    public void edit(AcceptanceEntity acceptanceEntity, Long id) {
        acceptanceRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        acceptanceRepository.save(acceptanceEntity);
    }

    @Transactional
    public void patch(AcceptanceEntity acceptanceEntity, Long id) {
        acceptanceRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        acceptanceRepository.save(acceptanceEntity);
    }

    @Override
    public AcceptanceEntity get(Long id) {
        return acceptanceRepository.findAcceptanceById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        acceptanceRepository.deleteById(id);
    }

    @Transactional
    public void save(AcceptanceEntity acceptanceEntity) {
        acceptanceRepository.save(acceptanceEntity);
    }

    @Override
    public List<AcceptanceEntity> findAllAcceptance(Long userId) {
        if(userId == null || userId.equals(0L)){
            return acceptanceRepository.findAll();
        }else{
            return acceptanceRepository.findAcceptanceByUserId(userId);
        }
    }
}
