public class StatisticsDriver {
    public static void main(String[] args) {
        IncomeStatisticsV2 _test = new IncomeStatisticsV2();

        boolean result = _test.readData();
        System.out.println(result);
    }
}
