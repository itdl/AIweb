package org.dldev.aiweb.service;

import org.dldev.aiweb.DTO.ModelDTO;
import org.dldev.aiweb.util.ModelProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Service
public class ModelServiceImpl implements ModelService{

    @Autowired
    ModelProperties modelProperties;

    @Override
    public ModelDTO run(ModelDTO modelDTO) {
        //TODO read modelDTO.modelName and retrieve the model definition json file
        //from the model definition file, get the model location, pre-process scripts, run model scripts
        //run the model
        System.out.println(modelProperties.getLocation()+modelDTO.getModelName());
        System.out.println(Paths.get(modelProperties.getLocation()).resolve(modelDTO.getModelName()+".json"));
        return null;
    }
}
