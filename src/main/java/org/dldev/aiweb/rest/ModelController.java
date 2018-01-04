package org.dldev.aiweb.rest;

import org.dldev.aiweb.DTO.ModelDTO;
import org.dldev.aiweb.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

    @Autowired
    ModelService modelService;

    @PostMapping("/model/run")
    public ModelDTO runModel(@RequestBody ModelDTO modelDTO) {
        return modelService.run(modelDTO);
    }

    @PostMapping("/model/run/skin")
    public ModelDTO runSkinModel(@RequestBody ModelDTO modelDTO) {
        return modelService.runSkinModel(modelDTO);
    }
}
