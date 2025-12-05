package everoutproject.payment.paymentsimulation;

import java.math.BigDecimal;

public class PaymentRequest {
    private BigDecimal price;

    public PaymentRequest() {}

    public PaymentRequest(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
