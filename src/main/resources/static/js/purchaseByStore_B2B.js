var clients = [
  { "product_B2B": 2, "store": 1, "purchase": 2000000},
  { "product_B2B": 1, "store": 2, "purchase": 1000000},
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
      { name: "product_B2B", type: "select", title:"매입상품", width: 50, items: products_B2B, valueField: "Id", textField: "Name" },
      { name: "store", type: "select", title:"매출처", width: 50, items: stores, valueField: "Id", textField: "Name" },
      { name: "purchase", type: "number", title:"매입액", width: 50 },
      { type: "control" }
  ]
});