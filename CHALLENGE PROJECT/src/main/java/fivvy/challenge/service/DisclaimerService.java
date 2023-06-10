package fivvy.challenge.service;

import fivvy.challenge.entity.DisclaimerEntity;
import fivvy.challenge.repository.DisclaimerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class DisclaimerService implements IDisclaimerService{

    private final DisclaimerRepository disclaimerRepository;

    public DisclaimerService(DisclaimerRepository disclaimerRepository) {
        this.disclaimerRepository = disclaimerRepository;
    }

    @Transactional
    public void edit(DisclaimerEntity disclaimerEntity, Long id) {
        disclaimerRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        disclaimerRepository.save(disclaimerEntity);
    }

    @Transactional
    public void patch(DisclaimerEntity disclaimerEntity, Long id) {
        disclaimerRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        disclaimerRepository.save(disclaimerEntity);
    }

    @Override
    public DisclaimerEntity get(Long id) {
        return disclaimerRepository.findDisclaimerById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        disclaimerRepository.deleteById(id);
    }

    @Transactional
    public void save(DisclaimerEntity disclaimerEntity) {
        disclaimerRepository.save(disclaimerEntity);
    }

    @Override
    public List<DisclaimerEntity> findAllDisclaimers(String text) {
        if(text == null || text.equals("")){
            return disclaimerRepository.findAll();
        }else{
            return disclaimerRepository.findDisclaimerByText(text);
        }
    }
}
