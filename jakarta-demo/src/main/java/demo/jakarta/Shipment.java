package demo.jakarta;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

/**
 * A parcel shipment in a Jakarta project. The annotations are the rules; a validator reports
 * violations, so the constructor accepts any value and does not throw.
 */
public class Shipment {

    /** Price per kilogram before any discount, in the shop's currency. */
    static final double PRICE_PER_KG = 2.5;

    @Positive private final double weightKg;
    @Min(1) @Max(30) private final int deliveryDays;
    @Min(0) @Max(100) private final int discountPercent;

    public Shipment(double weightKg, int deliveryDays, int discountPercent) {
        this.weightKg = weightKg;
        this.deliveryDays = deliveryDays;
        this.discountPercent = discountPercent;
    }

    public double getWeightKg() { return weightKg; }

    public int getDeliveryDays() { return deliveryDays; }

    public int getDiscountPercent() { return discountPercent; }

    /** Cost after the discount: weight times the price per kilogram, less the discount percentage. */
    public double shippingCost() {
        double base = weightKg * PRICE_PER_KG;
        return base * (100 - discountPercent) / 100.0;
    }

    /** An express shipment arrives within two days. */
    public boolean isExpress() { return deliveryDays <= 2; }
}
