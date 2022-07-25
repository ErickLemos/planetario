package com.ericklemos.planetario.entitys;

import com.ericklemos.planetario.geografia.Regiao;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class GeografiaEntity {

    @Id
    private String id;

    @DocumentReference
    private String planeta;
    private List<Regiao> regioes;

}
