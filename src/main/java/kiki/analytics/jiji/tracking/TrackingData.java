package kiki.analytics.jiji.tracking;

import java.io.Serializable;

public class TrackingData implements Serializable{
    private String apiKey;
    private Object scrambledData;

    public TrackingData(String apiKey, Object scrambledData) {
        this.apiKey = apiKey;
        this.scrambledData = scrambledData;
    }

    /**
     * @return the apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @param apiKey the apiKey to set
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * @return the scrambledData
     */
    public Object getScrambledData() {
        return scrambledData;
    }

    /**
     * @param scrambledData the scrambledData to set
     */
    public void setScrambledData(Object scrambledData) {
        this.scrambledData = scrambledData;
    }
}