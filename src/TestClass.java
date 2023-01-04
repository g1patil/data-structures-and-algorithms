import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


import java.time.*;
import java.util.stream.Collectors;

public class TestClass {

    static class Payment {
        private final String paymentId;
        private final Instant timestamp;
        private final String hashedCardNumber;

        public Payment(String paymentId, Instant timestamp, String hashedCardNumber) {
            this.paymentId = paymentId;
            this.timestamp = timestamp;
            this.hashedCardNumber = hashedCardNumber;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public Instant getTimestamp() {
            return timestamp;
        }

        public String getHashedCardNumber() {
            return hashedCardNumber;
        }
    }

    static class VelocityProviderImpl implements VelocityProvider {
        List<Payment> payments = new ArrayList();

        public int getCardUsageCount(Payment payment, Duration duration){
            return payments.stream().filter( p -> p.hashedCardNumber == payment.hashedCardNumber &&
                    p.timestamp.isAfter(Instant.now().minus(duration))
            ).collect(Collectors.toList()).size();
        }
        public void registerPayment(Payment payment){

            payments.add(payment);
        }
    }


    interface VelocityProvider {

        /**
         * This method is called during the payment risk assessment.
         *
         * It returns how many times the card in the Payment has been seen in the last minutes/seconds/hours as
         * defined in the {@code duration} parameter at the time the payment is being processed.
         *
         * @param payment  The payment being processed
         * @param duration The interval to count
         * @return The number of times the card was used in the interval defined in duration.
         */
        int getCardUsageCount(Payment payment, Duration duration);


        /**
         * After the payment is processed this method is called.
         *
         * @param payment The payment that has been processed.
         */
        void registerPayment(Payment payment);

        /**
         * @return Instance of a Velocity provider
         */
        static VelocityProvider getProvider() {
            return new VelocityProviderImpl();
        }
    }

    public static void main(String args[]) throws Exception {
        final VelocityProvider velocityProvider = VelocityProvider.getProvider();

        try (final Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                final String assoc = scanner.next();
                final String[] split = assoc.split(":");

                final String operation = split[0];

                if (split.length == 3 && "register".equals(operation)) {
                    final long timestamp = Long.parseLong(split[1]);
                    final String hashedCardNumber = split[2];
                    final Payment payment = new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(timestamp), hashedCardNumber);

                    velocityProvider.registerPayment(payment);
                } else if (split.length == 4 &&  "get".equals(operation)) {
                    final long queryTime = Long.parseLong(split[1]);
                    final String hashedCardNumber = split[2];
                    final long durationInSeconds = Long.parseLong(split[3]);
                    System.out.println(velocityProvider.getCardUsageCount(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(queryTime), hashedCardNumber), Duration.ofSeconds(durationInSeconds)));
                } else {
                    throw new RuntimeException("Invalid test input");
                }
            }
        }
    }
}