package com.example.azdigitalumbrellacbarintegration.dao.entity;

import com.example.azdigitalumbrellacbarintegration.model.enums.Status;
import com.example.azdigitalumbrellacbarintegration.model.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "rates")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nominal;
    private String name;
    private BigDecimal value;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Type type;


            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                RateEntity that = (RateEntity) o;
                return Objects.equals(id, that.id);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id);
            }
}
