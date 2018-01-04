package org.dldev.aiweb.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dldev.aiweb.DTO.ModelDTO;
import org.dldev.aiweb.DTO.ModelOperateBean;
import org.dldev.aiweb.util.ModelProperties;
import org.dldev.aiweb.util.UploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelProperties modelProperties;

    @Autowired
    UploadProperties uploadProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ModelDTO run(ModelDTO modelDTO) {

        //System.out.println(Paths.get(modelProperties.getLocation()).resolve(modelDTO.getModelName()+".json"));

        //#1 read the model definition json file, and convert the json file to ModelOperateBean
        ObjectMapper jsonMapper = new ObjectMapper();
        ModelOperateBean modelOperate = new ModelOperateBean();
        TypeReference<ModelOperateBean> mapType = new TypeReference<ModelOperateBean>() {
        };
        File jsonFile = Paths.get(modelProperties.getLocation()).resolve(modelDTO.getModelName() + ".json").toFile();
        try {
            modelOperate = jsonMapper.readValue(jsonFile, mapType);
        } catch (IOException e) {
            e.printStackTrace();
            modelDTO.setCode(2);
            modelDTO.setMessage("Model definition json file could not be loaded.");
            return modelDTO;
        }

//        System.out.println(modelOperate.getDescription());
//        System.out.println(modelOperate.getInput());
//        System.out.println(modelOperate.getModel());
//        System.out.println(modelOperate.getName());
//        System.out.println(modelOperate.getPreProcess());
//        System.out.println(modelOperate.getProcess());


        modelOperate.setInput(modelDTO.getInputFile());
        //#2 if there is the preProcess defined, run the preProcess script
        String modelFile = null;
        if (modelOperate.getPreProcess() != null && !modelOperate.getPreProcess().isEmpty()) {
            //TODO, run the python script, take modelDTO.getInput() as input, return the output file after process

        } else {
            modelDTO.setCode(2);
            modelDTO.setMessage("Invalid pre-process script file, please check the model definition json file.");
            return modelDTO;
        }


        //#3 run caffe model to process and return output
        String output = null;
        if (modelOperate.getModel() != null && modelOperate.getProcess() != null) {
            //TODO run the python script, take modelFile as input, return the output  after process

            modelDTO.setCode(0);
            modelDTO.setMessage("Model run successfully.");
            modelDTO.setOutput(output);
        } else {
            modelDTO.setCode(2);
            modelDTO.setMessage("Invalid model file or script, please check the model definition json file.");
            return modelDTO;
        }


        return modelDTO;
    }

    @Override
    public ModelDTO runSkinModel(ModelDTO modelDTO) {
        //String res=this.restTemplate.postForObject("http://127.0.0.1:8978/?pic_path=/data/gen_pic_data/img_05454.jpg", dto, String.class);
        try {
            String res = this.restTemplate.getForObject(modelProperties.getSkinurl() + "?pic_path=" + Paths.get(uploadProperties.getLocation()).resolve(modelDTO.getInputFile()).toString() + "&version=1", String.class);
            System.out.println(res);
            if (res == null || res.isEmpty()) {
                modelDTO.setOutput(res);
                modelDTO.setCode(2);
                modelDTO.setMessage("call skin model failed.");
                return modelDTO;
            }
            modelDTO.setOutput(res);
            modelDTO.setCode(0);
            modelDTO.setMessage("call skin model successfully.");
            return modelDTO;
        } catch (Exception e) {
            modelDTO.setOutput("");
            modelDTO.setCode(2);
            modelDTO.setMessage("call skin model failed.");
            return modelDTO;
        }
    }
}
