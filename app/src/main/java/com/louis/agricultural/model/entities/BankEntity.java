package com.louis.agricultural.model.entities;

import java.util.List;

public class BankEntity extends BaseEntity
{
  private List<ResultBean> result;

  public List<ResultBean> getResult()
  {
    return this.result;
  }

  public void setResult(List<ResultBean> paramList)
  {
    this.result = paramList;
  }

  public static class ResultBean
  {
    private String bankid;
    private String bankname;

    public String getBankid()
    {
      return this.bankid;
    }

    public String getBankname()
    {
      return this.bankname;
    }

    public void setBankid(String paramString)
    {
      this.bankid = paramString;
    }

    public void setBankname(String paramString)
    {
      this.bankname = paramString;
    }
  }
}