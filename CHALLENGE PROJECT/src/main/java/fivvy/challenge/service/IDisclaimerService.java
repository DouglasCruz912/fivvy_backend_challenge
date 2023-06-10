package fivvy.challenge.service;

import fivvy.challenge.entity.DisclaimerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IDisclaimerService {
    void edit(DisclaimerEntity disclaimerEntity, Long id);
    void patch(DisclaimerEntity disclaimerEntity, Long id);
    DisclaimerEntity get(Long id);
    void deleteById(Long id);
    void save(DisclaimerEntity disclaimerEntity);
    List<DisclaimerEntity> findAllDisclaimers(String text);

}
