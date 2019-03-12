public class Prize {
    private int value;
    private int originalCount;
    private int remainingCount;
    private int totalRemainingValue;

    public Prize(int value, int originalCount, int remainingCount, int totalRemainingValue) {
        this.value = value;
        this.originalCount = originalCount;
        this.remainingCount = remainingCount;
        this.totalRemainingValue = totalRemainingValue;
    }

    public int getValue() {
        return value;
    }

    public int getOriginalCount() {
        return originalCount;
    }

    public int getRemainingPrizeCount() {
        return remainingCount;
    }

    public int getTotalRemainingValue() {
        return totalRemainingValue;
    }
}
