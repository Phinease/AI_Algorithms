package iialib.stateSpace.model;

public interface IHeuristic<S extends IState<?>> {

    double apply(S state);

    @Override
    String toString();    //Useful for description
}
