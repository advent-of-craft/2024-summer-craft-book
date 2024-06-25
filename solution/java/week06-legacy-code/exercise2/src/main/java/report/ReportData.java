package report;

public class ReportData {
    private final int id;
    private final double value;
    private final String description;

    public ReportData(int id, double value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
