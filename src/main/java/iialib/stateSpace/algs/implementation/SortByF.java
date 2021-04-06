package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;

import java.util.Comparator;

class SortByF<S extends IState<O>, O extends IOperatorWithCost<S>> implements Comparator<SSNode<S, O>> {
    @Override
    public int compare(SSNode<S, O> o1, SSNode<S, O> o2) {
        double test = o1.getF() - o2.getF();
        if (test > .000000001) {
            return 1;
        } else if (test < -.000000001) {
            return -1;
        } else return 0;
    }
}