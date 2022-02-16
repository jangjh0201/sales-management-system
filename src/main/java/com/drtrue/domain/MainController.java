package com.drtrue.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

// 홈화면
  @RequestMapping("/")
  public String home(){
    return "index";
  }

// 일일데이터 입력
  @RequestMapping("/postValue")
  public String postValue(){
    return "postValue";
  }
  @RequestMapping("/postFile")
  public String postFile(){
    return "postFile";
  }

// 일일데이터 조회
  @RequestMapping("/valueTable_B2C")
  public String valueTable_B2C(){
    return "valueTable_B2C";
  }
  @RequestMapping("/valueTable_B2B")
  public String valueTable_B2B(){
    return "valueTable_B2B";
  }

// 가격정보
  @RequestMapping("/priceByStore_B2C")
  public String priceByStore_B2C(){
    return "priceByStore_B2C";
  }
  @RequestMapping("/discountByProduct_B2C")
  public String discountByProduct_B2C(){
    return "discountByProduct_B2C";
  }
  @RequestMapping("/purchaseByStore_B2C")
  public String purchaseByStore_B2C(){
    return "purchaseByStore_B2C";
  }
  @RequestMapping("/purchaseByStore_B2B")
  public String purchaseByStore_B2B(){
    return "purchaseByStore_B2B";
  }

// 일일보고서
  @RequestMapping("/dailyReport_B2C")
  public String dailyReport_B2C(){
    return "dailyReport_B2C";
  }
  @RequestMapping("/dailyReport_B2B")
  public String dailyReport_B2B(){
    return "dailyReport_B2B";
  }

// 대시보드
  @RequestMapping("/salesTrend")
  public String salesTrend(){
    return "salesTrend";
  }
  @RequestMapping("/productPreference")
  public String productPreference(){
    return "productPreference";
  }
  @RequestMapping("/salesByStore")
  public String salesByStore(){
    return "salesByStore";
  }


  

}
