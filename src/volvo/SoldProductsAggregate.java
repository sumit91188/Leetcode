package volvo;

import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 6/30/21
 * @Project Leetcode
 * @Comments
 */

@Value
public class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;
}
