package java8feature.Chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class TradeMain {
    
    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brain", "Cambridge");

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(raoul, 2011, 300),
            new Transaction(brian, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

    public static void main (String[] args) {

        List<Transaction> transactions1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transactions1);

        List<String> traders = transactions.stream()
                .map(t -> t.getTrader())
                .map(trader -> trader.getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(traders);

        List<Trader> traders1 = transactions.stream()
                .map(t -> t.getTrader())
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(Comparator.comparing(trader -> trader.getName()))
                .collect(Collectors.toList());
        System.out.println(traders1);

        //返回所有交易员的姓名字符串，按字母排序
        String trade_names = transactions.stream()
                .map(t -> t.getTrader())
                .map(trader -> trader.getName())
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(trade_names);

        //改进方案, 字符串连接，会导致性能底下
        String trade_names1 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println(trade_names1);

        //有没有交易员是在米兰工作的
        List<Trader> traders2 = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(t -> "Milan".equals(t.getCity()))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(traders2);
        //改进
        boolean flag = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println(flag);



        Optional<Integer> valueCount = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(t -> t.getValue())
                .reduce(Integer::sum);
        System.out.println(valueCount);

        Optional<Integer> max = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);
        System.out.println(max);

        Optional<Integer> min = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min);
        System.out.println(min);

        Optional<Transaction> t1 = transactions.stream()
                .filter(t -> min.get().equals(t.getValue()))
                .findFirst();
        System.out.println(t1);
    }
}
