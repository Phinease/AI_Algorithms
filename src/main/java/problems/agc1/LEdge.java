package problems.agc1;

import iialib.stateSpace.model.IOperatorWithCost;

import java.util.Arrays;
import java.util.List;

public enum LEdge implements IOperatorWithCost<LNode> {
    AB(LNode.A, LNode.B, 2),
    AC(LNode.A, LNode.C, 3),
    AE(LNode.A, LNode.E, 7),
    BA(LNode.B, LNode.A, 2),
    BL(LNode.B, LNode.L, 6),
    CA(LNode.C, LNode.A, 3),
    CD(LNode.C, LNode.D, 7),
    CF(LNode.C, LNode.F, 5),
    CL(LNode.C, LNode.L, 2),
    DC(LNode.D, LNode.C, 7),
    DE(LNode.D, LNode.E, 9),
    DG(LNode.D, LNode.G, 6),
    DJ(LNode.D, LNode.J, 4),
    EA(LNode.E, LNode.A, 7),
    ED(LNode.E, LNode.D, 9),
    EF(LNode.E, LNode.F, 2),
    FC(LNode.F, LNode.C, 5),
    FE(LNode.F, LNode.E, 2),
    GD(LNode.G, LNode.D, 6),
    GH(LNode.G, LNode.H, 4),
    GS(LNode.G, LNode.S, 1),
    GT(LNode.G, LNode.T, 16),
    GU(LNode.G, LNode.U, 14),
    HG(LNode.H, LNode.G, 4),
    HI(LNode.H, LNode.I, 2),
    IH(LNode.I, LNode.H, 2),
    IN(LNode.I, LNode.N, 3),
    IO(LNode.I, LNode.O, 4),
    IP(LNode.I, LNode.P, 6),
    IQ(LNode.I, LNode.Q, 5),
    IS(LNode.I, LNode.S, 9),
    JD(LNode.J, LNode.D, 4),
    JL(LNode.J, LNode.L, 2),
    KL(LNode.K, LNode.L, 5),
    KN(LNode.K, LNode.N, 2),
    KS(LNode.K, LNode.S, 1),
    LB(LNode.L, LNode.B, 6),
    LC(LNode.L, LNode.C, 2),
    LJ(LNode.L, LNode.J, 2),
    LK(LNode.L, LNode.K, 5),
    LM(LNode.L, LNode.M, 4),
    ML(LNode.M, LNode.L, 4),
    MR(LNode.M, LNode.L, 23),
    NI(LNode.N, LNode.I, 3),
    NK(LNode.N, LNode.K, 2),
    NO(LNode.N, LNode.O, 8),
    NR(LNode.N, LNode.R, 11),
    OI(LNode.O, LNode.I, 4),
    ON(LNode.O, LNode.N, 8),
    OQ(LNode.O, LNode.Q, 2),
    OR(LNode.O, LNode.R, 3),
    PI(LNode.P, LNode.I, 6),
    QI(LNode.Q, LNode.I, 5),
    QO(LNode.Q, LNode.O, 2),
    RM(LNode.R, LNode.M, 23),
    RN(LNode.R, LNode.N, 11),
    RO(LNode.R, LNode.O, 3),
    SG(LNode.S, LNode.G, 1),
    SI(LNode.S, LNode.I, 9),
    SK(LNode.S, LNode.K, 1),
    TG(LNode.T, LNode.G, 16),
    TU(LNode.T, LNode.U, 14);


    // ------------ List with all operators -------------------
    public static final List<LEdge> ALL_OPS =
            Arrays.asList(LEdge.values());
    // ------------ Attributes -------------------

    LNode origin;
    LNode destination;
	float cost;


    // ------------ Constructor -------------------
    // nb for enums it has to be private
	LEdge(LNode origin, LNode destination, float cost) {
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
    }

    // ------------ Methods form IOperator -------------------
    @Override
    public String getName() {
        return "" + origin + "to" + destination;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public boolean isApplicable(LNode s) {
        return origin.equals(s);
    }

    @Override
    public LNode successor(LNode s) {
        return destination;
    }

    @Override
    public String toString() {
        return this.getName() + "(" + this.cost + ")";
    }


}
