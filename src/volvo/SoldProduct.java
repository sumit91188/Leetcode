package volvo;

import lombok.Value;

import java.math.BigDecimal;

/**
 * @author Sumit Deo
 * @Date 6/30/21
 * @Project Leetcode
 * @Comments
 */

@Value
public class SoldProduct {
    String name;
    BigDecimal price;
    String currency;
}
