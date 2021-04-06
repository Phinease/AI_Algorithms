package iialib.stateSpace.algs;


public class SearchStats {

    // ---------------------- Attributes ---------------------
    /**
     * The number of states visited / nodes created
     */
    private int numberOfVisitedStates = 0;

    /**
     * The number of states/nodes developed
     */
    private int numberOfDevelopedStates = 0;

    public void resetStatistics() {
        numberOfVisitedStates = 0;
        numberOfDevelopedStates = 0;
    }

    public int getNumberOfVisitedStates() {
        return numberOfVisitedStates;
    }

    public int getNumberOfDevelopedStates() {
        return numberOfDevelopedStates;
    }

    public void increaseVisited() {
        numberOfVisitedStates++;
    }

	public void increaseVisited(int n) {
        numberOfVisitedStates = numberOfVisitedStates + n;
    }

	public void increaseDeveloped() {
        numberOfDevelopedStates++;
    }

	public void increaseDeveloped(int n) {
        numberOfDevelopedStates = numberOfDevelopedStates + n;
    }

	public String statistics() {
        return "Number of visited states (created nodes) " + numberOfVisitedStates + "\n" +
                "Number of developed nodes " + numberOfDevelopedStates + "\n";
    }

}
