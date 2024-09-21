package com.group10.koiauction.model.request;

import com.group10.koiauction.entity.KoiFish;
import com.group10.koiauction.entity.Variety;
import com.group10.koiauction.entity.enums.KoiSexEnum;
import com.group10.koiauction.entity.enums.KoiStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class KoiFishRequest {


    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name should not exceed 100 characters")

    private String name;

    @NotBlank(message = "Breeder is required")

    private String breeder;

    @Enumerated(EnumType.STRING) // For enum fields

    private KoiSexEnum sex;

    @NotBlank(message = "Variety is required")

    private String variety;

    @NotNull(message = "Size in cm is required")
    @Min(value = 1, message = "Size must be greater than 0")

    private Double sizeCm;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be a past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bornIn;

    @Lob // For large data like image URLs or binary data

    private String image_url;

    @Column(name = "description")
    private String description;



    @NotNull(message = "Estimated value is required")
    @Min(value = 0, message = "Estimated value must be a positive number")

    private Double estimatedValue;


    Set<Long> varietiesID;
}