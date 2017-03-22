package org.hourly.core.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hourly.common.constants.Status;

public class ValidationResponseObject {
	
	private String boundToItem;
    private Status status = Status.SUCCESS;
    private List<String> messages;
    
    public ValidationResponseObject(){
    }

    public ValidationResponseObject(String boundToItem){
        this.boundToItem = boundToItem;
    }
    
    public String getBoundToItem() {
        return boundToItem;
    }

    public void setBoundToItem(String boundToItem) {
        this.boundToItem = boundToItem;
    }

    public List<String> getMessages() {
        if (messages==null) {
            messages = new ArrayList<String>();
        }
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public ValidationResponseObject registerERROR(String errorMsg){
        this.status = Status.FAILED;
        getMessages().add(errorMsg);
        return this;
    }
    
    public ValidationResponseObject registerERROR(String[] errorMsgs){
        this.status = Status.FAILED;
        messages.addAll(Arrays.asList(errorMsgs));
        return this;
    }
}
