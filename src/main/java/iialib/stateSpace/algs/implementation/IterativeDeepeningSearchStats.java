package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.AHeuristicSearchAlgorithmStats;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.algs.SolutionWithCost;
import iialib.stateSpace.model.IHeuristic;
import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

import java.util.ArrayList;
import java.util.Iterator;

public class IterativeDeepeningSearchStats<S extends IState<O>, O extends IOperatorWithCost<S>>
        extends AHeuristicSearchAlgorithmStats<S, O> {

    // ----------------- Static attributes -----------------
    private static final String DESCRIPTION = "IDA*";

    // ----------------- attributes -----------------
    private final int maxIter;
    private double borne;
    private double newBorne;

    // -----------------  Constructors -----------------
    public IterativeDeepeningSearchStats(int maxIter) {
        super();
        this.maxIter = maxIter;
    }

    // ----------------- Methods from IHeuristicSearchAlgorithm -----------------
    @Override
    public Solution<S, O> solve(Problem<S> p, IHeuristic<S> h) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Solving problem: " + p);
        System.out.println("with algorithm: " + DESCRIPTION + " and heuristic " + h);
        System.out.println("-----------------------------------------------------");

        SolutionWithCost<S, O> sol = null;
        S state = p.getInitialState();
        SSNode<S, O> node = new SSNode<>(state, null, null);
        node.setG(0);
        node.setF(h.apply(state));
        borne = h.apply(state);
        boolean success = false;
        boolean stop = false;
        int count = 0;

        while (!stop && !success && count < maxIter) {
            newBorne = Double.MAX_VALUE;
            ArrayList<S> dejaVue = new ArrayList<>();
            sol = rProfHeuristiqueBornnee(node, dejaVue, p, h);

            if (sol == null) {
                if (newBorne > borne) borne = newBorne;
                else stop = true;
            } else success = true;

            count++;
        }

        System.out.println("-----------------------------------------------------");
        System.out.println((sol != null) ? "Solution : " + sol + "\nCost : " + sol.cost() : "FAILURE !");
        System.out.println(statistics());
        System.out.println("-----------------------------------------------------");
        return sol;
    }

    private SolutionWithCost<S, O> rProfHeuristiqueBornnee(SSNode<S, O> node, ArrayList<S> dejaDev, Problem<S> p, IHeuristic<S> h) {
        if (node.getF() > borne && node.getF() < newBorne) {
            newBorne = node.getF();
            return null;
        }

        S state = node.getState();
        if (p.isTerminal(state)) return new SolutionWithCost<>(node.getState(), null);
        if (dejaDev.contains(state)) return null;

        dejaDev.add(state);
        Iterator<O> it = state.applicableOperators();
        while (it.hasNext()) {
            O operator = it.next();
            S successorState = operator.successor(state);

            SSNode<S, O> successor = new SSNode<>(successorState, operator, node);
            successor.setG(node.getG() + operator.getCost());
            successor.setF(successor.getG() + h.apply(successorState));

            SolutionWithCost<S, O> rest = rProfHeuristiqueBornnee(successor, new ArrayList<>(dejaDev), p, h);
            if (rest != null) return new SolutionWithCost<>(state, operator, rest);
        }

        return null;
    }
}
