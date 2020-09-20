//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.20 at 04:13:11 PM IDT 
//


package generatedClasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}SDM-offer" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="operator" default="IRRELEVANT">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="ONE-OF"/>
 *             &lt;enumeration value="ALL-OR-NOTHING"/>
 *             &lt;enumeration value="IRRELEVANT"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sdmOffer"
})
@XmlRootElement(name = "then-you-get")
public class ThenYouGet {

    @XmlElement(name = "SDM-offer", required = true)
    protected List<SDMOffer> sdmOffer;
    @XmlAttribute(name = "operator")
    protected String operator;

    /**
     * Gets the value of the sdmOffer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sdmOffer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSDMOffer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SDMOffer }
     * 
     * 
     */
    public List<SDMOffer> getSDMOffer() {
        if (sdmOffer == null) {
            sdmOffer = new ArrayList<SDMOffer>();
        }
        return this.sdmOffer;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        if (operator == null) {
            return "IRRELEVANT";
        } else {
            return operator;
        }
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

}
