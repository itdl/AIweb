package org.dldev.aiweb.DTO;

public class ModelOperateBean {

    private String name;
    private String description;
    private String input;
    private String model;
    private String preProcess;
    private String process;



//    {
//           "name":"skin",
//           "description":"",
//           "input":"/data/web/raw/k8s.png",
//           "model":"/data/web/model/skin.cafemodel",
//           "preProcess":"/data/web/script/skin.py",
//           "process":"/data/web/script/skin2.py"
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPreProcess() {
        return preProcess;
    }

    public void setPreProcess(String preProcess) {
        this.preProcess = preProcess;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
