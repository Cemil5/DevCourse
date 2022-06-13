package com.example.lessons.b_05_streams.tasks;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TransactionTest {

    public static void main(String[] args) {

        //1- Find all transactions in 2011 and sort by value

        List<Transaction> transactions = TransactionData.getAll().stream()  // my solution
                .filter(a -> a.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("transactions = " + transactions);


        System.out.println("******Task-1************");
        TransactionData.getAll().stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);


        //2- What are all the unique cities where the traders work?
        System.out.println("******Task-2************");
        // my solution
        List<String> listOfUniqueCities = TransactionData.getAll().stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("listOfUniqueCities = " + listOfUniqueCities);

        System.out.println("******************");
        TransactionData.getAll().stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        //3- Find all traders from Cambridge and sort them by name
        System.out.println("******Task-3************");
        // my solution
        List<Trader> traderList = TransactionData.getAll().stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(transaction -> transaction.getTrader())
                .collect(Collectors.toList());

        // my solution after intellij recommendations and adding distinct after checking results
        List<Trader> traderList2 = TransactionData.getAll().stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("traderList2 = " + traderList2);

        System.out.println("******************");

        TransactionData.getAll().stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);


        //4- Return a string of all trader's names sorted alphabetically
        System.out.println("******Task-4************");

        // my solution after checking results
        String traderNames = TransactionData.getAll().stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce((name1, name2) -> name1 + " " + name2).get();
        System.out.println("traderNames = " + traderNames);


        System.out.println("******************");

        String result = TransactionData.getAll().stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2 + " ");

        System.out.println(result);

        //5- Are any traders based in Milan?
        System.out.println("******Task-5************");
        boolean isMilanBased = TransactionData.getAll().stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan"));
        System.out.println("isMilanBased = " + isMilanBased);

        System.out.println("******************");
        boolean milanBased = TransactionData.getAll().stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);


        //6- Print the values of all transactions from the traders living in Cambridge
        System.out.println("******Task-6************");
        // my solution
        List<Integer> transactionsOfCambridge = TransactionData.getAll().stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(transaction -> transaction.getValue())
                .collect(Collectors.toList());
        System.out.println("transactionsOfCambridge = " + transactionsOfCambridge);

        // my solution after intellij recommendation
        List<Integer> transactionsOfCambridge1 = TransactionData.getAll().stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println("transactionsOfCambridge = " + transactionsOfCambridge);

        System.out.println("******************");
        TransactionData.getAll().stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        //7 - What is the highest value of all the transactions
        System.out.println("******Task-7************");
        // my solution
        Integer highestValue = TransactionData.getAll().stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max).get();

        // my solution after intellij recommendation
        Integer highestValue2 = TransactionData.getAll().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max).get();
        System.out.println("highestValue2 = " + highestValue2);

        System.out.println("******************");
        Optional<Integer> high = TransactionData.getAll().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(high.get());

        //8-Find the transaction with the smallest value
        System.out.println("******Task-8************");
        Transaction minValue = TransactionData.getAll().stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2).get();
        System.out.println("minValue = " + minValue);


        System.out.println("*****************");
        Optional<Transaction> smvalue = TransactionData.getAll().stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        System.out.println(smvalue.get());

        Optional<Transaction> smallestValue = TransactionData.getAll().stream()
                .min(comparing(Transaction::getValue));

        System.out.println(smallestValue.get());


    }
}
