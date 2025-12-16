package model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {
    private final Map<Rank,Integer> results = new EnumMap<>(Rank.class);

    public LottoResult() {
        initialize();
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            results.put(rank,0);
        }
    }

    public void add(Rank rank){
        results.put(rank, results.getOrDefault(rank,0)+1);
    }

    public int getCount(Rank rank){
        return results.get(rank);
    }
    public int getTotalPrize(){
        int totalPrize =0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize+=rank.getPrize()*count;
        }
        return totalPrize;
    }

    public double calculateProfitRate(PurchaseAmount amount){
        return (double) getTotalPrize()/amount.getAmount();
    }

    public Map<Rank, Integer> getResults() {
        return Map.copyOf(results);//외부 수정 방지
    }
}
