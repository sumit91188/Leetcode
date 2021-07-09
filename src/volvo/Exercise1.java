package volvo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sumit Deo
 * @Date 6/30/21
 * @Project Leetcode
 * @Comments
 */
public class Exercise1 {
    public static void main(String[] args) {
        SoldProduct soldProduct1 = new SoldProduct("p1", new BigDecimal(100), "USD");
        SoldProduct soldProduct2 = new SoldProduct("p2", new BigDecimal(200), "INR");

        List<SoldProduct> soldProducts = new ArrayList<>();
        soldProducts.add(soldProduct1);
        soldProducts.add(soldProduct2);

        EURExchangeService eurExchangeService = new EURExchangeService();
        SoldProductsAggregator soldProductsAggregator = new SoldProductsAggregator(eurExchangeService);
        soldProductsAggregator.aggregate(soldProducts.stream());
    }

    private static class SoldProductsAggregator {
        private final EURExchangeService exchangeService;

        SoldProductsAggregator(EURExchangeService EURExchangeService) {
            this.exchangeService = EURExchangeService;
        }

        SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
            if (products == null) {
                products = new ArrayList<SoldProduct>().stream();
            }

            List<SimpleSoldProduct> simpleSoldProducts = new ArrayList<>();
            BigDecimal totalPrice = new BigDecimal(0);
            for (SoldProduct soldProduct: products.collect(Collectors.toList())) {
                Optional<BigDecimal> optionalExchangeRate = exchangeService.rate(soldProduct.getCurrency());
                BigDecimal exchangeRate;

                if (!optionalExchangeRate.isPresent()) {
                    continue;
                }

                exchangeRate = optionalExchangeRate.get();
                if (exchangeRate.signum() < 1) {
                    continue;
                }

                SimpleSoldProduct simpleSoldProduct = new SimpleSoldProduct(soldProduct.getName(), exchangeRate.multiply(soldProduct.getPrice()));
                simpleSoldProducts.add(simpleSoldProduct);
                totalPrice = totalPrice.add(simpleSoldProduct.getPrice());
            }

            return new SoldProductsAggregate(simpleSoldProducts, totalPrice);
        }

    }
}
