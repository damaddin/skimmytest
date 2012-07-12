package de.holidayinsider.skimmy;

import java.util.Date;

/**
 * User: martinstolz
 * Date: 11.07.12
 */
public class SkimmyReportItem {

    private long timestamp;

    private String key;
    private String url;
    private String wantedImgPath;
    private String currentImgPath;

    private boolean failed;
    private String failedImgPath;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWantedImgPath() {
        return wantedImgPath;
    }

    public void setWantedImgPath(String wantedImgPath) {
        this.wantedImgPath = wantedImgPath;
    }

    public String getCurrentImgPath() {
        return currentImgPath;
    }

    public void setCurrentImgPath(String currentImgPath) {
        this.currentImgPath = currentImgPath;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public String getFailedImgPath() {
        return failedImgPath;
    }

    public void setFailedImgPath(String failedImgPath) {
        this.failedImgPath = failedImgPath;
    }
}
