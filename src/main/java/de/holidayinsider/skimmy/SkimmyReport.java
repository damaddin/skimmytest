package de.holidayinsider.skimmy;

import java.util.ArrayList;
import java.util.List;

/**
 * User: martinstolz
 * Date: 11.07.12
 */
public class SkimmyReport {

    private String suiteName;
    private String hostName;

    private List<SkimmyReportItem> items = new ArrayList<SkimmyReportItem>();

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public List<SkimmyReportItem> getItems() {
        return items;
    }

    public void setItems(List<SkimmyReportItem> items) {
        this.items = items;
    }
}
