package com.challenge.topic.rest.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topic {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "titulo")
    @Column(name = "titulo")
    @NotBlank(message = "el titulo es obligatorio.")
    private String titulo;
    @JsonProperty(value = "mensaje")
    @Column(name = "mensaje")
    @NotBlank(message = "el mensaje es obligatorio.")
    private String mensaje;
    @JsonProperty(value = "fecha de creacion")
    @Column(name = "fecha_creacion")
    //@NotBlank(message = "la fecha de creación es obligatoria.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date fecha_creacion;
    @JsonProperty(value = "estatus")
    @Column(name = "estatus")
    @NotBlank(message = "el estatus es obligatorio.")
    private String estatus;
    @JsonProperty(value = "autor")
    @Column(name = "autor")
    @NotBlank(message = "el autor es obligatorio.")
    private String autor;
    @JsonProperty(value = "curso")
    @Column(name = "curso")
    @NotBlank(message = "el curso es obligatorio.")
    private String curso;

}
