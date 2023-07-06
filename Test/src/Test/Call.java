package Test;

public class Call {
    public static void main(String[] args) {
        Calculator calculator = new SubCalc();
        Integer result = calculator.calc(18,6);
        System.out.println("계산 결과는 ("+result+") 입니다.");
    }
}
