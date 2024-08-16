package org.kakarla.OrchestratingPrecisionRealtime.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Card_table")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NonNull
public class CardInfo {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    private int zipCode;

    private String firstName;

    private String lastName;

    private int firstSixNumbers;

    private int lastFourNumbers;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String StreetName;

    private int cvv;

}
