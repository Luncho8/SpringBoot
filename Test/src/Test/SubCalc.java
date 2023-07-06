package Test;

public class SubCalc implements Calculator{
    @Override
    public Integer calc(Integer x, Integer y) {
        return x-y;
    }
}
