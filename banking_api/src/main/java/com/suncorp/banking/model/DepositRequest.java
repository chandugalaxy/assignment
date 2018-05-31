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
 * DepositRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-29T21:05:55.345Z")

public class DepositRequest   {
  @JsonProperty("accountNumber")
  private Integer accountNumber = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("depositorName")
  private String depositorName = null;

  public DepositRequest accountNumber(Integer accountNumber) {
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

  public DepositRequest amount(BigDecimal amount) {
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

  public DepositRequest depositorName(String depositorName) {
    this.depositorName = depositorName;
    return this;
  }

  /**
   * Get depositorName
   * @return depositorName
  **/
  @ApiModelProperty(value = "")


  public String getDepositorName() {
    return depositorName;
  }

  public void setDepositorName(String depositorName) {
    this.depositorName = depositorName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DepositRequest depositRequest = (DepositRequest) o;
    return Objects.equals(this.accountNumber, depositRequest.accountNumber) &&
        Objects.equals(this.amount, depositRequest.amount) &&
        Objects.equals(this.depositorName, depositRequest.depositorName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, amount, depositorName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepositRequest {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    depositorName: ").append(toIndentedString(depositorName)).append("\n");
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

