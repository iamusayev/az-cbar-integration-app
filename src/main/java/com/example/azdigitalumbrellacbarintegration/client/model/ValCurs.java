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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ValCurs implements Serializable {
@XmlAttribute(name = "Date")
    public String LocalDate;
    @XmlAttribute(name = "Name")
    public String Name;
    @XmlAttribute(name = "Description")
    public String Description;

    public List<ValType> ValType;
}
