package com.vektorel.kutuphane.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedBookRQ {
    private String token;
    private Long rentABookId;
}
