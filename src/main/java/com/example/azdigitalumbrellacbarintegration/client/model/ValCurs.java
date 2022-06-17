package com.example.azdigitalumbrellacbarintegration.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ValCurs implements Serializable {
    
    @XmlAttribute(name = "Date")
    public String date;
    
    @XmlAttribute(name = "Name")
    public String name;
    
    @XmlAttribute(name = "Description")
    public String description;

    public List<ValType> valType;
}
