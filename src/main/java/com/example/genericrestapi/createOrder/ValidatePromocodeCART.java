//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.31 at 10:57:13 AM IST 
//


package com.example.genericrestapi.createOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="P_City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_PROMOCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_DEVICEID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_PTNTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_MOBILENO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_TEST_CD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_TEST_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_T_AMNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_T_GROSS_AMNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_T_DISC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_T_OFR_CD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_GROSS_AMNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_DISC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_PROMO_DISC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_OTHR_CHRG_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_OTHR_CHRG_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_GRNT_TOTAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="P_RND_AMNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="grouptyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strVldTk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pCity",
    "ppromocode",
    "pdeviceid",
    "pptntcd",
    "pmobileno",
    "ptestcd",
    "ptestid",
    "ptamnt",
    "ptgrossamnt",
    "ptdisc",
    "ptofrcd",
    "pgrossamnt",
    "pdisc",
    "ppromodisc",
    "pothrchrg1",
    "pothrchrg2",
    "pgrnttotal",
    "prndamnt",
    "grouptyp",
    "source",
    "strVldTk"
})
@XmlRootElement(name = "ValidatePromocode_CART")
public class ValidatePromocodeCART {

    @XmlElement(name = "P_City")
    protected String pCity;
    @XmlElement(name = "P_PROMOCODE")
    protected String ppromocode;
    @XmlElement(name = "P_DEVICEID")
    protected String pdeviceid;
    @XmlElement(name = "P_PTNTCD")
    protected String pptntcd;
    @XmlElement(name = "P_MOBILENO")
    protected String pmobileno;
    @XmlElement(name = "P_TEST_CD")
    protected String ptestcd;
    @XmlElement(name = "P_TEST_ID")
    protected String ptestid;
    @XmlElement(name = "P_T_AMNT")
    protected String ptamnt;
    @XmlElement(name = "P_T_GROSS_AMNT")
    protected String ptgrossamnt;
    @XmlElement(name = "P_T_DISC")
    protected String ptdisc;
    @XmlElement(name = "P_T_OFR_CD")
    protected String ptofrcd;
    @XmlElement(name = "P_GROSS_AMNT")
    protected String pgrossamnt;
    @XmlElement(name = "P_DISC")
    protected String pdisc;
    @XmlElement(name = "P_PROMO_DISC")
    protected String ppromodisc;
    @XmlElement(name = "P_OTHR_CHRG_1")
    protected String pothrchrg1;
    @XmlElement(name = "P_OTHR_CHRG_2")
    protected String pothrchrg2;
    @XmlElement(name = "P_GRNT_TOTAL")
    protected String pgrnttotal;
    @XmlElement(name = "P_RND_AMNT")
    protected String prndamnt;
    protected String grouptyp;
    protected String source;
    protected String strVldTk;

    /**
     * Gets the value of the pCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCity() {
        return pCity;
    }

    /**
     * Sets the value of the pCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCity(String value) {
        this.pCity = value;
    }

    /**
     * Gets the value of the ppromocode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPPROMOCODE() {
        return ppromocode;
    }

    /**
     * Sets the value of the ppromocode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPPROMOCODE(String value) {
        this.ppromocode = value;
    }

    /**
     * Gets the value of the pdeviceid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDEVICEID() {
        return pdeviceid;
    }

    /**
     * Sets the value of the pdeviceid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDEVICEID(String value) {
        this.pdeviceid = value;
    }

    /**
     * Gets the value of the pptntcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPPTNTCD() {
        return pptntcd;
    }

    /**
     * Sets the value of the pptntcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPPTNTCD(String value) {
        this.pptntcd = value;
    }

    /**
     * Gets the value of the pmobileno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMOBILENO() {
        return pmobileno;
    }

    /**
     * Sets the value of the pmobileno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMOBILENO(String value) {
        this.pmobileno = value;
    }

    /**
     * Gets the value of the ptestcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTESTCD() {
        return ptestcd;
    }

    /**
     * Sets the value of the ptestcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTESTCD(String value) {
        this.ptestcd = value;
    }

    /**
     * Gets the value of the ptestid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTESTID() {
        return ptestid;
    }

    /**
     * Sets the value of the ptestid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTESTID(String value) {
        this.ptestid = value;
    }

    /**
     * Gets the value of the ptamnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTAMNT() {
        return ptamnt;
    }

    /**
     * Sets the value of the ptamnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTAMNT(String value) {
        this.ptamnt = value;
    }

    /**
     * Gets the value of the ptgrossamnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTGROSSAMNT() {
        return ptgrossamnt;
    }

    /**
     * Sets the value of the ptgrossamnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTGROSSAMNT(String value) {
        this.ptgrossamnt = value;
    }

    /**
     * Gets the value of the ptdisc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTDISC() {
        return ptdisc;
    }

    /**
     * Sets the value of the ptdisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTDISC(String value) {
        this.ptdisc = value;
    }

    /**
     * Gets the value of the ptofrcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTOFRCD() {
        return ptofrcd;
    }

    /**
     * Sets the value of the ptofrcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTOFRCD(String value) {
        this.ptofrcd = value;
    }

    /**
     * Gets the value of the pgrossamnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPGROSSAMNT() {
        return pgrossamnt;
    }

    /**
     * Sets the value of the pgrossamnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPGROSSAMNT(String value) {
        this.pgrossamnt = value;
    }

    /**
     * Gets the value of the pdisc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDISC() {
        return pdisc;
    }

    /**
     * Sets the value of the pdisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDISC(String value) {
        this.pdisc = value;
    }

    /**
     * Gets the value of the ppromodisc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPPROMODISC() {
        return ppromodisc;
    }

    /**
     * Sets the value of the ppromodisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPPROMODISC(String value) {
        this.ppromodisc = value;
    }

    /**
     * Gets the value of the pothrchrg1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOTHRCHRG1() {
        return pothrchrg1;
    }

    /**
     * Sets the value of the pothrchrg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOTHRCHRG1(String value) {
        this.pothrchrg1 = value;
    }

    /**
     * Gets the value of the pothrchrg2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOTHRCHRG2() {
        return pothrchrg2;
    }

    /**
     * Sets the value of the pothrchrg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOTHRCHRG2(String value) {
        this.pothrchrg2 = value;
    }

    /**
     * Gets the value of the pgrnttotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPGRNTTOTAL() {
        return pgrnttotal;
    }

    /**
     * Sets the value of the pgrnttotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPGRNTTOTAL(String value) {
        this.pgrnttotal = value;
    }

    /**
     * Gets the value of the prndamnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRNDAMNT() {
        return prndamnt;
    }

    /**
     * Sets the value of the prndamnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRNDAMNT(String value) {
        this.prndamnt = value;
    }

    /**
     * Gets the value of the grouptyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrouptyp() {
        return grouptyp;
    }

    /**
     * Sets the value of the grouptyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrouptyp(String value) {
        this.grouptyp = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the strVldTk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrVldTk() {
        return strVldTk;
    }

    /**
     * Sets the value of the strVldTk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrVldTk(String value) {
        this.strVldTk = value;
    }

}
