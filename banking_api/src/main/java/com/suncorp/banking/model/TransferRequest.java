package com.suncorp.banking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TransferRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-29T21:05:55.345Z")

public class TransferRequest   {
  @JsonProperty("accountNumber")
  private Integer accountNumber = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("beneficiaryAccountNumber")
  private Integer beneficiaryAccountNumber = null;

  public TransferRequest accountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(value = "")


  public Integer getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
  }

  public TransferRequest amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public TransferRequest beneficiaryAccountNumber(Integer beneficiaryAccountNumber) {
    this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    return this;
  }

  /**
   * Get beneficiaryAccountNumber
   * @return beneficiaryAccountNumber
  **/
  @ApiModelProperty(value = "")


  public Integer getBeneficiaryAccountNumber() {
    return beneficiaryAccountNumber;
  }

  public void setBeneficiaryAccountNumber(Integer beneficiaryAccountNumber) {
    this.beneficiaryAccountNumber = beneficiaryAccountNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferRequest transferRequest = (TransferRequest) o;
    return Objects.equals(this.accountNumber, transferRequest.accountNumber) &&
        Objects.equals(this.amount, transferRequest.amount) &&
        Objects.equals(this.beneficiaryAccountNumber, transferRequest.beneficiaryAccountNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, amount, beneficiaryAccountNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferRequest {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    beneficiaryAccountNumber: ").append(toIndentedString(beneficiaryAccountNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

