package fivvy.challenge.controller;

import fivvy.challenge.bo.Disclaimer;
import fivvy.challenge.entity.DisclaimerEntity;
import fivvy.challenge.service.DisclaimerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DisclaimerREST {

    private final static Logger logger = LoggerFactory.getLogger(DisclaimerREST.class);

    @Autowired
    private DisclaimerService disclaimerService;

    @RequestMapping(value = "/getDisclaimer", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Disclaimer> getDisclaimer(
            @RequestParam Long id
    ){

        final DisclaimerEntity disclaimerEntity = disclaimerService.get(id);
        if(disclaimerEntity == null){
            return new ResponseEntity<>(new Disclaimer(), HttpStatus.BAD_REQUEST);
        }
        final Disclaimer disclaimer = new Disclaimer(disclaimerEntity);
        return new ResponseEntity<>(disclaimer, HttpStatus.OK);

    }

    @RequestMapping(value = "/getDisclaimers", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Disclaimer>> getDisclaimers(
            @RequestParam(value = "text", required = false) String text
    ){
        List<Disclaimer> disclaimers = new ArrayList<>();
        final List<DisclaimerEntity> disclaimersEntity = disclaimerService.findAllDisclaimers(text);
        disclaimersEntity.forEach(disclaimerEntity -> {
            Disclaimer disclaimer = new Disclaimer(disclaimerEntity);
            disclaimers.add(disclaimer);
        });
        return new ResponseEntity<>(disclaimers, HttpStatus.OK);
    }

    @RequestMapping(value = "/editDisclaimer", method= RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public  ResponseEntity<String> editDisclaimer(
            @RequestParam Long id,
            @RequestBody DisclaimerEntity disclaimer
    ){

        try {
            disclaimerService.edit(disclaimer, id);
        }catch (HttpClientErrorException e){
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Disclaimer Updated Succefully", HttpStatus.OK);

    }

    @RequestMapping(value = "/patchDisclaimer", method= RequestMethod.PATCH, produces = "application/json")
    @ResponseBody
    public  ResponseEntity<String> patchDisclaimer(
            @RequestParam Long id,
            @RequestBody DisclaimerEntity disclaimer
    ){

        try {
            disclaimerService.patch(disclaimer, id);
        }catch (HttpClientErrorException e){
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Disclaimer Updated Succefully", HttpStatus.OK);

    }

    @RequestMapping(value = "/createDisclaimer", method= RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public  ResponseEntity<String> createDisclaimer(
            @RequestBody DisclaimerEntity disclaimer
    ){

        disclaimerService.save(disclaimer);
        return new ResponseEntity<>("Disclaimer Created Succefully", HttpStatus.OK);

    }

    @RequestMapping(value = "/deleteDisclaimer", method= RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public  ResponseEntity<String> deleteDisclaimer(
            @RequestParam Long id
    ){

        disclaimerService.deleteById(id);
        return new ResponseEntity<>("Disclaimer Deleted Succefully", HttpStatus.OK);

    }

}
