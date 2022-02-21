var clients = [
  { "orderDate": "2022-02-21", "product_B2B": 2, "store": 1, "count": 100, "sales": 2000000, "tradeDetails": true, "taxInvoice": false, "report": false, "arrivalDate": "2022-02-10"},
  { "orderDate": "2022-02-18", "product_B2B": 1, "store": 2, "count": 50, "sales": 1000000, "tradeDetails": false, "taxInvoice": false, "report": false, "arrivalDate": "2022-02-10"},
];

var products_B2B = [
  { Name: "", Id: 0 },
  { Name: "구연산나트륨", Id: 1 },
  { Name: "수크랄로스", Id: 2 },
  { Name: "아스파탐", Id: 3 }
];

var stores = [
  { Name: "", Id: 0 },
  { Name: "바이오드림", Id: 1 },
  { Name: "우듬지팜", Id: 2 },
];

$("#jsGrid").jsGrid({
  width: "100%",
  height: "650px",
  inserting: true,
  editing: true,
  sorting: true,
  paging: true,
  pageSize: 10,
  pageButtonCount: 10,
  pageIndex: 1,

  onItemEditing: function(args) {
      console.log(args.itemIndex);
      var test = $("#jsGrid").jsGrid("option", "data")[args.itemIndex];
      console.log(test);
  },

  controller:{
      loadData: function(filter) {
          return $.ajax({
              type: "GET",
              url: "/items",
              data: filter
          });
      },
  },

  data: clients,

  fields: [
      { name: "orderDate", type: "text", title:"주문일", width: 70, validate: "required" },
      { name: "product_B2B", type: "select", title:"매입상품", width: 50, items: products_B2B, valueField: "Id", textField: "Name" },
      { name: "store", type: "select", title:"판매처", width: 50, items: stores, valueField: "Id", textField: "Name" },
      { name: "count", type: "number", title:"수량", width: 50 },
      { name: "sales", type: "number", title:"매출액", width: 50 },
      { name: "tradeDetails ", type: "checkbox", title: "거래명세서", width: 50, sorting: false },
      { name: "taxInvoice", type: "checkbox", title: "세금계산서", width: 50, sorting: false },
      { name: "report", type: "checkbox", title: "성적서", width: 50, sorting: false },
      { name: "arrivalDate", type: "text", title:"도착일", width: 70},
      { type: "control" }
  ]
});