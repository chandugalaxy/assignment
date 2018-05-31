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
 * WithdrawlRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-29T21:05:55.345Z")

public class WithdrawlRequest   {
  @JsonProperty("accountNumber")
  private Integer accountNumber = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("borrowerName")
  private String borrowerName = null;

  public WithdrawlRequest accountNumber(Integer accountNumber) {
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

  public WithdrawlRequest amount(BigDecimal amount) {
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

  public WithdrawlRequest borrowerName(String borrowerName) {
    this.borrowerName = borrowerName;
    return this;
  }

  /**
   * Get borrowerName
   * @return borrowerName
  **/
  @ApiModelProperty(value = "")


  public String getBorrowerName() {
    return borrowerName;
  }

  public void setBorrowerName(String borrowerName) {
    this.borrowerName = borrowerName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WithdrawlRequest withdrawlRequest = (WithdrawlRequest) o;
    return Objects.equals(this.accountNumber, withdrawlRequest.accountNumber) &&
        Objects.equals(this.amount, withdrawlRequest.amount) &&
        Objects.equals(this.borrowerName, withdrawlRequest.borrowerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, amount, borrowerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WithdrawlRequest {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    borrowerName: ").append(toIndentedString(borrowerName)).append("\n");
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

