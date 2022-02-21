var clients = [
  { "hightLevel": 3, "midLevel": 1, "lowLevel": 2, "store": 2, "price": 12800},
  { "hightLevel": 1, "midLevel": 1, "lowLevel": 3, "store": 2, "price": 12800},
];

var highLevels = [
  { Name: "", Id: 0 },
  { Name: "과일청", Id: 1 },
  { Name: "토망고", Id: 2 },
  { Name: "스테비아", Id: 3 }
];

var stores = [
  { Name: "", Id: 0 },
  { Name: "자사몰", Id: 1 },
  { Name: "네이버", Id: 2 },
  { Name: "카카오", Id: 3 }
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
      { name: "hightLevel", type: "select", title:"대분류", width: 50, items: highLevels, valueField: "Id", textField: "Name" },
      { name: "midLevel", type: "select", title:"중분류", width: 50, items: highLevels, valueField: "Id", textField: "Name" },
      { name: "lowLevel", type: "select", title:"소분류", width: 50, items: highLevels, valueField: "Id", textField: "Name" },
      { name: "store", type: "select", title:"매출처", width: 50, items: stores, valueField: "Id", textField: "Name" },
      { name: "price", type: "number", title: "가격", width: 50 },
      { type: "control" }
  ]
});