package xyz.mlhmz.mcserverinformation.serverinformationconsumer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mlhmz.mcserverinformation.serverinformationconsumer.Information;
import xyz.mlhmz.mcserverinformation.serverinformationconsumer.services.InformationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/msi/informations")
public class InformationController {
    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping
    public List<Information> getAllInformations() {
        return informationService.readAllInformation();
    }
}
