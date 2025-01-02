package com.example.stock.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    @Version
    private Long version;

    public void decrease(Long quantity) {
        if (this.quantity - quantity < 0) throw new RuntimeException("재고는 0개 미만이 될 수 없습니다.");
        this.quantity -= quantity;
    }
}
