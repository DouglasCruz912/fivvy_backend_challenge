package fivvy.challenge.service;

import fivvy.challenge.entity.AcceptanceEntity;
import fivvy.challenge.entity.DisclaimerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAcceptanceService {
    void edit(AcceptanceEntity acceptanceEntity, Long id);
    void patch(AcceptanceEntity acceptanceEntity, Long id);
    AcceptanceEntity get(Long id);
    void deleteById(Long id);
    void save(AcceptanceEntity acceptanceEntity);
    List<AcceptanceEntity> findAllAcceptance(Long userId);
}
