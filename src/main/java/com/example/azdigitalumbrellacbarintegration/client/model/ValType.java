package com.example.azdigitalumbrellacbarintegration.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ValType")
@Data
public class ValType  {

    @XmlAttribute(name = "Type")
    private String type;

    private List<Valute> valute;
}
