package com.drtrue.domain;

import java.util.ArrayList;
import java.util.List;

import com.drtrue.global.aop.annotations.PerformanceAOPAnnotation;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

  // 홈화면
  @PerformanceAOPAnnotation
  @RequestMapping("/")
  public String home(Model model) {
    model.addAttribute("pageTitle", "Home");
    return "index";
  }

  // 일일데이터 입력
  @PerformanceAOPAnnotation
  @RequestMapping("/postValue_B2C")
  public String postValue_B2C(Model model) {
    model.addAttribute("pageTitle", "B2C 일일데이터 입력");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "B2C사업의 일일 매출 데이터 입력");
    model.addAttribute("jsGrid", "postValue_B2C");
    return "postValue_B2C";
  }

  @PerformanceAOPAnnotation
  @RequestMapping("/postValue_B2B")
  public String postValue_B2B(Model model) {
    model.addAttribute("pageTitle", "B2B 일일데이터 입력");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "B2B사업의 일일 매출 데이터 입력");
    model.addAttribute("jsGrid", "postValue_B2B");
    return "postValue_B2B";
  }

  @PerformanceAOPAnnotation
  @RequestMapping("/postFile")
  public String postFile(Model model) {
    model.addAttribute("pageTitle", "일일데이터 파일 업로드");
    return "postFile";
  }

  // 일일데이터 조회
  @PerformanceAOPAnnotation
  @RequestMapping("/valueTable_B2C")
  public String valueTable_B2C(Model model) {
    model.addAttribute("pageTitle", "B2C 일일데이터 조회");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "B2C사업의 일일 매출데이터입니다. Excel, PDF 등의 양식으로 다운받을 수 있습니다.");
    model.addAttribute("jsGrid", "postValue_B2C");
    return "valueTable_B2C";
  }

  @PerformanceAOPAnnotation
  @RequestMapping("/valueTable_B2B")
  public String valueTable_B2B(Model model) {
    model.addAttribute("pageTitle", "B2B 일일데이터 조회");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "B2B사업의 일일 매출데이터입니다. Excel, PDF 등의 양식으로 다운받을 수 있습니다.");
    model.addAttribute("jsGrid", "postValue_B2B");
    return "valueTable_B2B";
  }

  @PerformanceAOPAnnotation
  @RequestMapping("/dailyReport_sample")
  public String dailyReport_sample(Model model) {
    model.addAttribute("pageTitle", "B2B 일일데이터 sample");
    model.addAttribute("unit", "천");
    return "dailyReport_sample";
  }

  // 가격정보
  @PerformanceAOPAnnotation
  @RequestMapping("/priceByStore_B2C")
  public String priceByStore_B2C(Model model) {
    model.addAttribute("pageTitle", "판매처별 제품가격");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "");
    model.addAttribute("jsGrid", "priceByStore_B2C");
    return "priceByStore_B2C";
  }

  @PerformanceAOPAnnotation
  @RequestMapping("/discountByProduct_B2C")
  public String discountByProduct_B2C(Model model) {
    model.addAttribute("pageTitle", "제품별 할인정보");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "");
    model.addAttribute("jsGrid", "discountByProduct_B2C");
    return "discountByProduct_B2C";
  }

  @RequestMapping("/purchaseByStore_B2C")
  public String purchaseByStore_B2C(Model model) {
    model.addAttribute("pageTitle", "매출처별 원가&판관비 계산요소");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "");
    model.addAttribute("jsGrid", "purchaseByStore_B2C");
    return "purchaseByStore_B2C";
  }

  @RequestMapping("/purchaseByStore_B2B")
  public String purchaseByStore_B2B(Model model) {
    model.addAttribute("pageTitle", "매출처별 매입액");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "");
    model.addAttribute("jsGrid", "purchaseByStore_B2B");
    return "purchaseByStore_B2B";
  }

  // 일일보고서
  @RequestMapping("/dailyReport_B2C")
  public String dailyReport_B2C(Model model) {
    model.addAttribute("pageTitle", "B2C 일일보고서");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "B2C사업의 일일 매출보고서입니다. Excel, PDF 등의 양식으로 다운받을 수 있습니다.");
    model.addAttribute("jsGrid", "postValue_B2C");
    return "dailyReport_B2C";
  }

  @RequestMapping("/dailyReport_B2B")
  public String dailyReport_B2B(Model model) {
    model.addAttribute("pageTitle", "B2B 일일보고서");
    model.addAttribute("unit", "천");
    model.addAttribute("msg", "B2B사업의 일일 매출보고서입니다. Excel, PDF 등의 양식으로 다운받을 수 있습니다.");
    model.addAttribute("jsGrid", "postValue_B2B");
    return "dailyReport_B2B";
  }

  // 대시보드
  @RequestMapping("/salesTrend")
  public String salesTrend(Model model) {
    model.addAttribute("pageTitle", "기간별 판매추이");
    model.addAttribute("unit", "천");
    model.addAttribute("graphTitle", "별 판매추이");
    List<String> periodUnit = new ArrayList<>();
    periodUnit.add("일");
    periodUnit.add("주");
    periodUnit.add("월");
    periodUnit.add("분기");
    periodUnit.add("연");
    model.addAttribute("periodUnit", periodUnit);

    return "salesTrend";
  }

  @RequestMapping("/productPreference")
  public String productPreference(Model model) {
    model.addAttribute("pageTitle", "제품별 선호현황");
    model.addAttribute("unit", "천");
    return "productPreference";
  }

  @RequestMapping("/salesByStore")
  public String salesByStore(Model model) {
    model.addAttribute("pageTitle", "매출처별 매출현황");
    model.addAttribute("unit", "천");
    return "salesByStore";
  }

}
