package volvo;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Sumit Deo
 * @Date 6/30/21
 * @Project Leetcode
 * @Comments
 */
public class EURExchangeService implements ExchangeService{
    @Override
    public Optional<BigDecimal> rate(String currency) {
        return Optional.empty();
    }
}
