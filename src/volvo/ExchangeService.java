package volvo;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Sumit Deo
 * @Date 6/30/21
 * @Project Leetcode
 * @Comments
 */
public interface ExchangeService {
    Optional<BigDecimal> rate(String currency);
}
