package com.jxd.follow_sys.model;

/**
 * @author ：humengting
 * @description：TODO
 * @date ：2020/11/16 12:25
 */
public class JobEvlOption {
    private int optionId;
    private String optionName;
    private int optionState;

    public JobEvlOption() {
    }

    public JobEvlOption(String optionName) {
        this.optionName = optionName;
    }

    public JobEvlOption(int optionId, String optionName) {
        this.optionId = optionId;
        this.optionName = optionName;
    }

    public JobEvlOption(int optionId, String optionName, int optionState) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionState = optionState;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionState() {
        return optionState;
    }

    public void setOptionState(int optionState) {
        this.optionState = optionState;
    }
}
