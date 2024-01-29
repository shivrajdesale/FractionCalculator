package com.shiv.calculator.model;

/**
 * public class FractionalExpression
 * class to represent fraction expression with operands and operator
 * @author Shivraj Desale
 */
public class FractionalExpression {
    private final Operator operator;
    private final FractionalNumber leftOperand;
    private final FractionalNumber rightOperand;

    /**
     * Constructor for class  {@link FractionalExpression}
     * @param operator {@link Operator}
     *        - operator to perform operation on operands
     * @param leftOperand {@link FractionalNumber}
     *        - Left Operand to perform operation
     * @param rightOperand {@link FractionalNumber}
     *        - Right Operand to perform operation
     */
    public FractionalExpression(Operator operator, FractionalNumber leftOperand, FractionalNumber rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    /**
     * @return operator {@link Operator}
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @return leftOperand {@link FractionalNumber}
     */
    public FractionalNumber getLeftOperand() {
        return leftOperand;
    }

    /**
     * @return rightOperand {@link FractionalNumber}
     */
    public FractionalNumber getRightOperand() {
        return rightOperand;
    }
}
