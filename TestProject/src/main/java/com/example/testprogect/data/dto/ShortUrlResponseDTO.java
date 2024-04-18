package com.example.testprogect.data.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShortUrlResponseDTO {

    private static final long serialVersionUID = -214490344996507077L;

    @Id
    private String orgUrl;

    private String shortUrl;
}
