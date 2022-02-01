package guru.sfg.beer.order.service.domain;

public enum OrderStatus {
    NEW, VALIDATE, VALIDATION_EXCEPTION, ALLOCATED, ALLOCATION_EXCEPTION,
    PENDING_INVENTORY, PICKED_UP, DELIVERED, DELIVERY_EXCEPTION, CANCELLED
}