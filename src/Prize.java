public class Prize {
    private double value;
    private int originalCount;
    private int remainingCount;
    private double totalRemainingValue;

    public Prize(double value, int originalCount, int remainingCount, double totalRemainingValue) {
        this.value = value;
        this.originalCount = originalCount;
        this.remainingCount = remainingCount;
        this.totalRemainingValue = totalRemainingValue;
    }

    public double getValue() {
        return value;
    }

    public int getOriginalCount() {
        return originalCount;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public double getTotalRemainingValue() {
        return totalRemainingValue;
    }
}
