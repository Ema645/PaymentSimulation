package everoutproject.payment.paymentsimulation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class paymentController {
    @PostMapping("/api/payment")
    public ResponseEntity<?> processPayment(@RequestBody PaymentRequest request) {
        System.out.println("Payment request received: " + request.getPrice()+ " EUR");

        // 90% success rate, 10% failure rate
        if (Math.random() < 0.9) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "Payment successful"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("status", "error", "message", "Payment failed"));
        }
    }
}
